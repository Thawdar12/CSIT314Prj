package com.infinitynetwork.csit314.Controller;

import com.infinitynetwork.csit314.AppUsers.*;
import com.infinitynetwork.csit314.CarListings.*;
import com.infinitynetwork.csit314.Reviews.Review;
import com.infinitynetwork.csit314.Reviews.ReviewRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controller for handling agent-related operations such as managing car listings,
 * updating user information, and handling reviews.
 */
@Controller
@RequestMapping("/InfinityNetwork/agent")
public class AgentController {

    private final AppUserService appUserService;
    private final AppUserRepository appUserRepository;
    private final CarListingService carListingService;
    private final CarListingsRepository carListingsRepository;
    private final ReviewRepository reviewRepository;

    // Directory where uploaded photos will be saved
    private final String uploadDir = "src/main/resources/static/carImg";

    public AgentController(AppUserService appUserService,
                           AppUserRepository appUserRepository,
                           CarListingService carListingService,
                           CarListingsRepository carListingsRepository,
                           ReviewRepository reviewRepository) {
        this.appUserService = appUserService;
        this.appUserRepository = appUserRepository;
        this.carListingService = carListingService;
        this.carListingsRepository = carListingsRepository;
        this.reviewRepository = reviewRepository;
    }

    /**
     * Displays the agent dashboard with paginated car listings.
     *
     * @param page    Current page number.
     * @param size    Number of listings per page.
     * @param model   Model to pass data to the view.
     * @param auth    Authentication object containing user details.
     * @param session HTTP session to store user information.
     * @return View name for the agent dashboard.
     */
    @GetMapping("/dashboard")
    public String agentDashboard(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model,
            Authentication auth,
            HttpSession session) {

        String username = auth.getName();

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        String currentDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Store information in the session
        session.setAttribute("username", username);
        session.setAttribute("currentDateTime", currentDateTime);

        // Fetch user data
        AppUser user = appUserService.getUsersByUserName(username);
        session.setAttribute("userID", user.getUserID().toString());

        // Fetch paginated car listings
        Page<CarListings> carListingsPage = carListingService.findAllListings(page, size);
        int totalPages = carListingsPage.getTotalPages();

        // Adjust the page index if necessary
        if (totalPages > 0 && page >= totalPages) {
            page = totalPages - 1;
            carListingsPage = carListingService.findAllListings(page, size);
        }

        // Add attributes to the model
        model.addAttribute("listingPage", carListingsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);

        return "InfinityNetwork/agent/dashboard"; // Resolves to 'templates/InfinityNetwork/admin/dashboard.html'
    }

    /**
     * Creates a new car listing.
     *
     * @param carListing CarListings object containing listing details.
     * @param photo      Optional photo of the car.
     * @return ResponseEntity with success or error message.
     */
    @PostMapping(value = "/createListing", consumes = {"multipart/form-data"}, produces = "application/json")
    public ResponseEntity<String> createListing(
            @RequestPart("carListing") CarListings carListing,
            @RequestPart(value = "photo", required = false) MultipartFile photo) {
        try {
            AppUser seller = appUserRepository.getReferenceById(carListing.getSeller().getUserID());
            carListing.setSeller(seller);
            carListingService.registerListing(carListing, photo, uploadDir);
            return new ResponseEntity<>("Listing registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create listing: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Retrieves a car listing by its ID.
     *
     * @param id ID of the car listing.
     * @return ResponseEntity containing listing details or error message.
     */
    @GetMapping("/getListingById")
    public ResponseEntity<?> getListingById(@RequestParam("id") Long id) {
        Optional<CarListings> optionalCarListing = carListingsRepository.findById(id);
        if (!optionalCarListing.isPresent()) {
            return new ResponseEntity<>("Listing not found", HttpStatus.NOT_FOUND);
        }

        CarListings carListing = optionalCarListing.get();
        Map<String, Object> listingMap = mapCarListingToMap(carListing);

        return new ResponseEntity<>(listingMap, HttpStatus.OK);
    }

    /**
     * Updates an existing car listing.
     *
     * @param updateListingDTO DTO containing updated listing details.
     * @param photo            Optional new photo of the car.
     * @return ResponseEntity with success or error message.
     */
    @PutMapping(value = "/updateListing", consumes = {"multipart/form-data"})
    public ResponseEntity<?> updateListing(
            @RequestPart("carListing") UpdateListingDTO updateListingDTO,
            @RequestPart(value = "photo", required = false) MultipartFile photo) {
        try {
            updateListingDTO.setPhoto(photo); // Set the photo in DTO if provided
            carListingService.updateListing(updateListingDTO);
            return new ResponseEntity<>("Listing updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            return new ResponseEntity<>("Failed to update listing: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deletes a car listing by its ID.
     *
     * @param id ID of the car listing to delete.
     * @return ResponseEntity with success or error message.
     */
    @DeleteMapping("/deleteListing")
    public ResponseEntity<?> deleteListing(@RequestParam Long id) {
        try {
            carListingService.deleteListing(id);
            return new ResponseEntity<>("Listing deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Searches for car listings based on type and value.
     *
     * @param type  The field to search by (e.g., carPlateNumber, carBrand).
     * @param value The value to search for.
     * @return ResponseEntity containing matching listings or error status.
     */
    @GetMapping("/searchListing")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchListing(
            @RequestParam String type,
            @RequestParam String value) {
        List<CarListings> carListings;

        switch (type) {
            case "carPlateNumber":
                carListings = carListingsRepository.findByCarPlateNumberIgnoreCase(value);
                break;
            case "carBrand":
                carListings = carListingsRepository.findByCarBrandIgnoreCase(value);
                break;
            case "carModel":
                carListings = carListingsRepository.findByCarModelIgnoreCase(value);
                break;
            case "listingStatus":
                ListingStatus status = ListingStatus.fromString(value);
                carListings = carListingsRepository.findByListingStatus(status);
                break;
            default:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Map<String, Object>> carsList = carListings.stream()
                .map(this::mapCarListingToMap)
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("listings", carsList);
        System.out.println("Listings: " + carsList); // Consider using a logger instead

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Retrieves user information by user ID.
     *
     * @param id ID of the user.
     * @return ResponseEntity containing user details or error message.
     */
    @GetMapping("/getUserById")
    public ResponseEntity<?> getUserById(@RequestParam Long id) {
        Optional<AppUser> optionalUser = appUserRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        AppUser user = optionalUser.get();
        Map<String, Object> userMap = mapUserToMap(user);

        return new ResponseEntity<>(userMap, HttpStatus.OK);
    }

    /**
     * Updates user information.
     *
     * @param updateUserDTO DTO containing updated user details.
     * @param bindingResult BindingResult for validation.
     * @return ResponseEntity with success or error message.
     */
    @PutMapping("/updateUserInfo")
    public ResponseEntity<?> updateUserInfo(
            @RequestBody UpdateUserDTO updateUserDTO,
            BindingResult bindingResult) {
        try {
            appUserService.updateUser(updateUserDTO);
            return ResponseEntity.ok().body(Map.of("message", "User information updated successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    /**
     * Changes the password of the current user.
     *
     * @param changePasswordDTO DTO containing old and new passwords.
     * @return ResponseEntity with success or error message.
     */
    @PutMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        try {
            appUserService.changePassword(changePasswordDTO);
            return ResponseEntity.ok().body(Map.of("message", "Password changed successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    /**
     * Retrieves reviews for the current user.
     *
     * @param principal Principal object containing user details.
     * @return ResponseEntity containing average rating and list of reviews.
     */
    @GetMapping("/getUserReviews")
    public ResponseEntity<Map<String, Object>> getUserReviews(Principal principal) {
        // Get current user
        AppUser currentUser = appUserRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch reviews
        List<Review> reviews = reviewRepository.findByReviewedUser(currentUser);

        // Calculate average rating
        double averageRating = reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);

        // Prepare response
        Map<String, Object> response = new HashMap<>();
        response.put("averageRating", averageRating);
        response.put("reviews", reviews.stream()
                .map(this::mapReviewToMap)
                .collect(Collectors.toList()));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/searchSellerByUsername")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchSellerByUsername(@RequestParam String value) {
        List<AppUser> sellers = appUserRepository.findByUsernameIgnoreCase(value);

        List<Map<String, Object>> sellerList = sellers.stream()
                .map(user -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("userID", user.getUserID());
                    map.put("username", user.getUsername());
                    return map;
                })
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("sellers", sellerList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Maps a CarListings object to a Map<String, Object>.
     *
     * @param carListing CarListings object.
     * @return Map representation of the car listing.
     */
    private Map<String, Object> mapCarListingToMap(CarListings carListing) {
        Map<String, Object> carMap = new HashMap<>();
        carMap.put("listingID", carListing.getListingID());
        carMap.put("carPlateNumber", carListing.getCarPlateNumber());
        carMap.put("carBrand", carListing.getCarBrand());
        carMap.put("carModel", carListing.getCarModel());
        carMap.put("listingStatus", carListing.getListingStatus().name());
        carMap.put("millage", carListing.getMillage());
        carMap.put("manufacturedYear", carListing.getManufacturedYear());
        carMap.put("price", carListing.getPrice());
        carMap.put("photo", carListing.getPhoto());
        carMap.put("createdAt", carListing.getCreated_at());
        carMap.put("updatedAt", carListing.getUpdated_at());
        carMap.put("listedBy", carListing.getListedBy().getUsername());
        return carMap;
    }

    /**
     * Maps an AppUser object to a Map<String, Object>.
     *
     * @param user AppUser object.
     * @return Map representation of the user.
     */
    private Map<String, Object> mapUserToMap(AppUser user) {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userID", user.getUserID());
        userMap.put("username", user.getUsername());
        userMap.put("email", user.getEmail());
        userMap.put("locked", user.getLocked());
        userMap.put("userType", user.getUserType().name());
        userMap.put("phoneNumber", user.getPhoneNumber());
        return userMap;
    }

    /**
     * Maps a Review object to a Map<String, Object>.
     *
     * @param review Review object.
     * @return Map representation of the review.
     */
    private Map<String, Object> mapReviewToMap(Review review) {
        Map<String, Object> reviewMap = new HashMap<>();
        reviewMap.put("comment", review.getComment());
        reviewMap.put("rating", review.getRating());
        reviewMap.put("reviewer", review.getReviewer().getUsername());
        reviewMap.put("createdAt", review.getCreatedAt());
        return reviewMap;
    }
}
