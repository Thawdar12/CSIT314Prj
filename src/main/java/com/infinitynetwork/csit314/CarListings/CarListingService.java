package com.infinitynetwork.csit314.CarListings;

import com.infinitynetwork.csit314.AppUsers.AppUser;
import com.infinitynetwork.csit314.AppUsers.AppUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarListingService {
    private final CarListingsRepository carListingsRepository;
    private final AppUserRepository appUserRepository;
    private final String uploadDir = "src/main/resources/static/carImg"; // Adjust as needed

    public CarListingService(CarListingsRepository carListingsRepository, AppUserRepository appUserRepository) {
        this.carListingsRepository = carListingsRepository;
        this.appUserRepository = appUserRepository;
    }

    //Register for a listing
    @Transactional
    public void registerListing(CarListings carListing, MultipartFile photo, String uploadDir) throws Exception {
        //Set default listingStatus to 'OPEN'
        if (carListing.getListingStatus() == null) {
            carListing.setListingStatus(ListingStatus.OPEN);
        }

        //Set listedBy based on the authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        AppUser user = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("User not found: " + username));
        carListing.setListedBy(user);

        //Handle photo upload
        if (photo != null && !photo.isEmpty()) {
            String originalFilename = StringUtils.cleanPath(photo.getOriginalFilename());
            String fileExtension = StringUtils.getFilenameExtension(originalFilename);
            String uniqueFileName = UUID.randomUUID().toString() + "." + fileExtension;

            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            //Store the relative path in to database, it's actually saving the path to that photo but not the actual photo
            Path filePath = uploadPath.resolve(uniqueFileName);
            try {
                Files.copy(photo.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                carListing.setPhoto("/carImg/" + uniqueFileName);
            } catch (IOException e) {
                throw new Exception("Could not save the photo: " + e.getMessage());
            }
        }
        carListingsRepository.save(carListing);
    }

    //Update the listing, via DTO
    @Transactional
    public void updateListing(UpdateListingDTO updateListingDTO) throws Exception {
        // Fetch existing listing
        CarListings existingListing = carListingsRepository.findById(updateListingDTO.getListingID())
                .orElseThrow(() -> new Exception("Listing not found."));

        // Update fields from DTO
        existingListing.setCarPlateNumber(updateListingDTO.getCarPlateNumber());
        existingListing.setCarBrand(updateListingDTO.getCarBrand());
        existingListing.setCarModel(updateListingDTO.getCarModel());
        existingListing.setMillage(updateListingDTO.getMillage());
        existingListing.setManufacturedYear(updateListingDTO.getManufacturedYear());
        existingListing.setListingStatus(ListingStatus.valueOf(updateListingDTO.getListingStatus()));
        existingListing.setPrice(updateListingDTO.getPrice());

        // Handle photo update if provided
        MultipartFile photo = updateListingDTO.getPhoto();
        if (photo != null && !photo.isEmpty()) {
            String photoPath = handlePhotoUpload(photo);
            existingListing.setPhoto(photoPath);
        }

        existingListing.setUpdated_at(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        carListingsRepository.save(existingListing);
    }

    //Get all CarListing with pagination
    public Page<CarListings> findAllListings(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return carListingsRepository.findAll(pageable);
    }

    public Page<CarListings> findAllListingsBySellerID(Long sellerID, int page, int size) {
        AppUser seller = appUserRepository.findById(sellerID)
                .orElseThrow(() -> new RuntimeException("Seller not found"));
        Pageable pageable = PageRequest.of(page, size);
        return carListingsRepository.findBySeller(seller, pageable);
    }

    //Handle photo in DTO object
    private String handlePhotoUpload(MultipartFile photoFile) throws Exception {
        //Clean the file name
        String originalFilename = StringUtils.cleanPath(photoFile.getOriginalFilename());

        //Extract file extension
        String fileExtension = StringUtils.getFilenameExtension(originalFilename);
        if (fileExtension == null || fileExtension.isEmpty()) {
            throw new Exception("Invalid photo file.");
        }

        //Generate a unique file name to prevent conflicts
        String uniqueFileName = UUID.randomUUID().toString() + "." + fileExtension;

        //Create the upload directory if it doesn't exist
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        //Resolve the target file path
        Path filePath = uploadPath.resolve(uniqueFileName);

        try {
            // Copy the file to the target location (Replacing existing file with the same name)
            Files.copy(photoFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new Exception("Could not store the photo. Please try again.", e);
        }

        // Return the relative path to the stored photo
        return "/carImg/" + uniqueFileName;
    }

    //Delete listing
    public void deleteListing(Long id) throws Exception {
        Optional<CarListings> optionalCarListing = carListingsRepository.findById(id);
        if (!optionalCarListing.isPresent()) {
            throw new Exception("User not found");
        }
        carListingsRepository.deleteById(id);
    }
}
