package com.infinitynetwork.csit314.Controller;

import com.infinitynetwork.csit314.AppUsers.*;
import com.infinitynetwork.csit314.CarListings.CarListingService;
import com.infinitynetwork.csit314.CarListings.CarListings;
import com.infinitynetwork.csit314.CarListings.CarListingsRepository;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Controller for handling seller-related operations such as managing car listings,
 * updating user information, and handling reviews.
 */
@Controller
@RequestMapping("/InfinityNetwork/seller")
public class SellerController {

    private final AppUserService appUserService;
    private final AppUserRepository appUserRepository;
    private final CarListingService carListingService;
    private final CarListingsRepository carListingsRepository;
    private final ReviewRepository reviewRepository;

    // Directory where uploaded photos will be saved
    private final String uploadDir = "src/main/resources/static/carImg";

    public SellerController(AppUserService appUserService,
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
     * Displays the seller dashboard with paginated car listings.
     *
     * @param page    Current page number.
     * @param size    Number of listings per page.
     * @param model   Model to pass data to the view.
     * @param auth    Authentication object containing user details.
     * @param session HTTP session to store user information.
     * @return View name for the seller dashboard.
     */
    @GetMapping("/dashboard")
    public String sellerDashboard(
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
        Page<CarListings> carListingsPage = carListingService.findAllListingsBySellerID(user.getUserID(), page, size);
        int totalPages = carListingsPage.getTotalPages();

        // Adjust the page index if necessary
        if (totalPages > 0 && page >= totalPages) {
            page = totalPages - 1;
            carListingsPage = carListingService.findAllListingsBySellerID(user.getUserID(), page, size);
        }

        // Add attributes to the model
        model.addAttribute("listingPage", carListingsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);

        return "InfinityNetwork/seller/dashboard"; // Resolves to 'templates/InfinityNetwork/admin/dashboard.html'
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

    @PostMapping("/submitReview")
    public ResponseEntity<Map<String, Object>> submitReview(@RequestBody Map<String, Object> payload, Authentication auth) {
        try {
            // Extract data from payload
            Long reviewerId = Long.parseLong(payload.get("userID").toString());
            String username = payload.get("username").toString();
            String comments = payload.get("comments").toString();
            int rating = Integer.parseInt(payload.get("rating").toString());

            // Validate rating (assuming rating should be between 1 and 5)
            if (rating < 1 || rating > 5) {
                Map<String, Object> response = new HashMap<>();
                response.put("error", "Rating must be between 1 and 5");
                return ResponseEntity.badRequest().body(response);
            }

            // Find the reviewed user by username
            Optional<AppUser> optionalReviewedUser = appUserRepository.findByUsername(username);
            if (!optionalReviewedUser.isPresent()) {
                Map<String, Object> response = new HashMap<>();
                response.put("error", "User being reviewed not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            AppUser reviewedUser = optionalReviewedUser.get();

            // Get the authenticated user (reviewer)
            AppUser reviewer = appUserService.getUsersByUserName(auth.getName());

            if (!reviewer.getUserID().equals(reviewerId)) {
                Map<String, Object> response = new HashMap<>();
                response.put("error", "User ID does not match authenticated user");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            // Prevent users from reviewing themselves
            if (reviewer.getUserID().equals(reviewedUser.getUserID())) {
                Map<String, Object> response = new HashMap<>();
                response.put("error", "Users cannot review themselves");
                return ResponseEntity.badRequest().body(response);
            }

            // Create the review
            Review review = new Review();
            review.setReviewer(reviewer);
            review.setReviewedUser(reviewedUser);
            review.setRating(rating);
            review.setComment(comments);
            review.setCreatedAt(LocalDateTime.now());

            // Save the review
            reviewRepository.save(review);

            // Get all reviews for the reviewed user
            List<Review> reviews = reviewRepository.findByReviewedUser(reviewedUser);

            // Compute the average rating
            double averageRating = reviews.stream()
                    .mapToInt(Review::getRating)
                    .average()
                    .orElse(0.0);

            // Update the reviewed user's averageRating
            reviewedUser.setAverageRating(averageRating);

            // Save the updated user
            appUserRepository.save(reviewedUser);

            // Return success response
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Review submitted successfully");
            response.put("averageRating", averageRating);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // Handle exceptions
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Invalid input data");
            return ResponseEntity.badRequest().body(response);
        }
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
}