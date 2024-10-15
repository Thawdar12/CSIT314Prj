package com.infinitynetwork.csit314.Controller;

import com.infinitynetwork.csit314.AppUsers.AppUserRepository;
import com.infinitynetwork.csit314.AppUsers.AppUserService;
import com.infinitynetwork.csit314.CarListings.CarListingService;
import com.infinitynetwork.csit314.CarListings.CarListings;
import com.infinitynetwork.csit314.CarListings.CarListingsRepository;
import com.infinitynetwork.csit314.CarListings.UpdateListingDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/InfinityNetwork/buyer")
public class BuyerController {
    private final AppUserService appUserService;
    private final AppUserRepository appUserRepository;
    private final CarListingService carListingService;
    private final CarListingsRepository carListingsRepository;
    // Directory where uploaded photos will be saved
    private final String uploadDir = "src/main/resources/static/carImg";

    public BuyerController(AppUserService appUserService, AppUserRepository appUserRepository,
                           CarListingService carListingService, CarListingsRepository carListingsRepository) {
        this.appUserService = appUserService;
        this.appUserRepository = appUserRepository;
        this.carListingService = carListingService;
        this.carListingsRepository = carListingsRepository;
    }

    @GetMapping("/dashboard")
    public String buyerDashboard(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size,
                                 Model model, Authentication auth, HttpSession session) {
        String username = auth.getName();
        //Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = now.format(formatter);

        //Store information in the session
        session.setAttribute("username", username);
        session.setAttribute("currentDateTime", currentDateTime);
        //Fetch user data
        Page<CarListings> carListingsPage = carListingService.findAllListings(page, size);

        //Get the total number of pages
        int totalPages = carListingsPage.getTotalPages();

        //Adjust the page index if necessary
        if (totalPages > 0 && page >= totalPages) {
            page = totalPages - 1;
            // Re-fetch the user data for the adjusted page
            carListingsPage = carListingService.findAllListings(page, size);
        }

        //Add attributes to the model
        model.addAttribute("listingPage", carListingsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);

        return "InfinityNetwork/buyer/dashboard"; // This resolves to 'templates/InfinityNetwork/admin/dashboard.html'
    }

    @GetMapping("/getListingById")
    public ResponseEntity<?> getListingById(@RequestParam("id") Long id) {
        Optional<CarListings> optionalCarListing = carListingsRepository.findById(id);
        if (!optionalCarListing.isPresent()) {
            return new ResponseEntity<>("Listing not found", HttpStatus.NOT_FOUND);
        }

        CarListings carListing = optionalCarListing.get();

        Map<String, Object> listingMap = new HashMap<>();
        listingMap.put("listingID", carListing.getListingID());
        listingMap.put("carPlateNumber", carListing.getCarPlateNumber());
        listingMap.put("carBrand", carListing.getCarBrand());
        listingMap.put("carModel", carListing.getCarModel());
        listingMap.put("listingStatus", carListing.getListingStatus().name());
        listingMap.put("millage", carListing.getMillage());
        listingMap.put("manufacturedYear", carListing.getManufacturedYear());
        listingMap.put("price", carListing.getPrice());
        listingMap.put("photo", carListing.getPhoto());
        listingMap.put("createdAt", carListing.getCreated_at());
        listingMap.put("updatedAt", carListing.getUpdated_at());
        listingMap.put("listedBy", carListing.getListedBy().getUsername());

        return new ResponseEntity<>(listingMap, HttpStatus.OK);
    }

//    @PutMapping(value = "/updateListing", consumes = {"multipart/form-data"})
//    public ResponseEntity<?> updateListing(
//            @RequestPart("carListing") UpdateListingDTO updateListingDTO,
//            @RequestPart(value = "photo", required = false) MultipartFile photo) {
//        try {
//            updateListingDTO.setPhoto(photo); // Set the photo in DTO if needed
//            carListingService.updateListing(updateListingDTO);
//            return new ResponseEntity<>("Listing updated successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Failed to update listing: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @DeleteMapping("/deleteListing")
//    public ResponseEntity<?> deleteListing(@RequestParam Long id) {
//        try {
//            carListingService.deleteListing(id);
//            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace(); // Log the error
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
}
