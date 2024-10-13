package com.infinitynetwork.csit314.Controller;

import com.infinitynetwork.csit314.AppUsers.AppUser;
import com.infinitynetwork.csit314.AppUsers.AppUserRepository;
import com.infinitynetwork.csit314.AppUsers.AppUserService;
import com.infinitynetwork.csit314.AppUsers.UpdateUserDTO;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controller for handling admin-related operations such as managing users.
 */
@Controller
@RequestMapping("/InfinityNetwork/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    // DateTime formatter pattern
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final AppUserService appUserService;
    private final AppUserRepository appUserRepository;

    public AdminController(AppUserService appUserService, AppUserRepository appUserRepository) {
        this.appUserService = appUserService;
        this.appUserRepository = appUserRepository;
    }

    /**
     * Displays the admin dashboard with paginated user listings.
     *
     * @param page    Current page number.
     * @param size    Number of users per page.
     * @param model   Model to pass data to the view.
     * @param auth    Authentication object containing user details.
     * @param session HTTP session to store admin information.
     * @return View name for the admin dashboard.
     */
    @GetMapping("/dashboard")
    public String adminDashboard(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model,
            Authentication auth,
            HttpSession session) {

        String username = auth.getName();

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        String currentDateTime = now.format(FORMATTER);

        // Store information in the session
        session.setAttribute("username", username);
        session.setAttribute("currentDateTime", currentDateTime);

        // Fetch paginated user data
        Page<AppUser> userPage = appUserService.findAllUsers(page, size);
        int totalPages = userPage.getTotalPages();

        // Adjust the page index if necessary
        if (totalPages > 0 && page >= totalPages) {
            page = totalPages - 1;
            userPage = appUserService.findAllUsers(page, size);
        }

        // Add attributes to the model
        model.addAttribute("userPage", userPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);

        return "InfinityNetwork/admin/dashboard"; // Resolves to 'templates/InfinityNetwork/admin/dashboard.html'
    }

    /**
     * Creates a new user.
     *
     * @param user AppUser object containing user details.
     * @return ResponseEntity with success or error message.
     */
    @PostMapping(value = "/createUser", consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody AppUser user) {
        try {
            appUserService.registerUser(user);
            logger.info("User registered successfully: {}", user.getUsername());
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error registering user: {}", e.getMessage());
            return new ResponseEntity<>("Failed to register user: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Searches for users based on type and value.
     *
     * @param type  The field to search by (e.g., username, email).
     * @param value The value to search for.
     * @return ResponseEntity containing matching users or error status.
     */
    @GetMapping("/searchUser")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchUser(
            @RequestParam String type,
            @RequestParam String value) {
        List<AppUser> users;

        switch (type) {
            case "username":
                users = appUserRepository.findByUsernameContainingIgnoreCase(value);
                break;
            case "email":
                users = appUserRepository.findByEmailContainingIgnoreCase(value);
                break;
            case "phoneNumber":
                users = appUserRepository.findByPhoneNumberContaining(value);
                break;
            default:
                logger.warn("Invalid search type: {}", type);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Map<String, Object>> userList = users.stream()
                .map(this::mapAppUserToMap)
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("users", userList);

        logger.info("Search results for type '{}', value '{}': {} users found", type, value, userList.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id ID of the user.
     * @return ResponseEntity containing user details or error message.
     */
    @GetMapping("/getUserById")
    public ResponseEntity<?> getUserById(@RequestParam Long id) {
        Optional<AppUser> optionalUser = appUserRepository.findById(id);
        if (optionalUser.isEmpty()) {
            logger.warn("User not found with ID: {}", id);
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        AppUser user = optionalUser.get();
        Map<String, Object> userMap = mapAppUserToMap(user);

        logger.info("Retrieved user by ID {}: {}", id, user.getUsername());

        return new ResponseEntity<>(userMap, HttpStatus.OK);
    }

    /**
     * Updates an existing user.
     *
     * @param userDTO DTO containing updated user details.
     * @return ResponseEntity with success or error message.
     */
    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserDTO userDTO) {
        try {
            appUserService.updateUser(userDTO);
            logger.info("User updated successfully: {}", userDTO.getUsername());
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error updating user: {}", e.getMessage());
            return new ResponseEntity<>("Failed to update user: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id ID of the user to delete.
     * @return ResponseEntity with success or error message.
     */
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam Long id) {
        try {
            appUserService.deleteUser(id);
            logger.info("User deleted successfully with ID: {}", id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error deleting user with ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>("Failed to delete user: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Maps an AppUser object to a Map<String, Object>.
     *
     * @param user AppUser object.
     * @return Map representation of the user.
     */
    private Map<String, Object> mapAppUserToMap(AppUser user) {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userID", user.getUserID());
        userMap.put("username", user.getUsername());
        userMap.put("email", user.getEmail());
        userMap.put("locked", user.getLocked());
        userMap.put("userType", user.getUserType().name());
        userMap.put("phoneNumber", user.getPhoneNumber());
        userMap.put("created_at", user.getCreated_at());
        userMap.put("updated_at", user.getUpdated_at());
        return userMap;
    }
}
