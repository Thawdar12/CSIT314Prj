package com.infinitynetwork.csit314.Controller;

import com.infinitynetwork.csit314.AppUsers.AppUser;
import com.infinitynetwork.csit314.AppUsers.AppUserRepository;
import com.infinitynetwork.csit314.AppUsers.AppUserService;
import com.infinitynetwork.csit314.AppUsers.UpdateUserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@RequestMapping("/InfinityNetwork/admin")
public class AdminController {
    private final AppUserService appUserService;
    private final AppUserRepository appUserRepository;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String currentDateTime = now.format(formatter);

    public AdminController(AppUserService appUserService, AppUserRepository appUserRepository) {
        this.appUserService = appUserService;
        this.appUserRepository = appUserRepository;
    }

    // This resolves to 'templates/InfinityNetwork/admin/dashboard.html'
    @GetMapping("/dashboard")
    public String adminDashboard(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size,
                                 Model model, Authentication auth, HttpSession session) {
        //Get the username from the authentication object
        String username = auth.getName();

        //Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = now.format(formatter);

        //Store information in the session
        session.setAttribute("username", username);
        session.setAttribute("currentDateTime", currentDateTime);

        //Fetch user data
        Page<AppUser> userPage = appUserService.findAllUsers(page, size);

        //Get the total number of pages
        int totalPages = userPage.getTotalPages();

        //Adjust the page index if necessary
        if (totalPages > 0 && page >= totalPages) {
            page = totalPages - 1;
            // Re-fetch the user data for the adjusted page
            userPage = appUserService.findAllUsers(page, size);
        }

        // Add attributes to the model
        model.addAttribute("userPage", userPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);

        return "InfinityNetwork/admin/dashboard";
    }

    //Endpoint for createUser
    @PostMapping(value = "/createUser", consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody AppUser user) throws Exception {
        appUserService.registerUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    //Endpoint for search user
    @GetMapping("/searchUser")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchUser(@RequestParam String type, @RequestParam String value) {
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
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Build a list of maps with selected fields
        List<Map<String, Object>> userList = new ArrayList<>();
        for (AppUser user : users) {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("userID", user.getUserID());
            userMap.put("username", user.getUsername());
            userMap.put("email", user.getEmail());
            userMap.put("locked", user.getLocked());
            userMap.put("userType", user.getUserType());
            userMap.put("phoneNumber", user.getPhoneNumber());
            userMap.put("created_at", user.getCreated_at());
            userMap.put("updated_at", user.getUpdated_at());
            userList.add(userMap);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("users", userList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Get user via userID, this is different from search as generally it should show userID,
    //to prevent anyone try to change the userID.
    @GetMapping("/getUserById")
    public ResponseEntity<?> getUserById(@RequestParam Long id) {
        Optional<AppUser> optionalUser = appUserRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        AppUser user = optionalUser.get();

        // Build a map with selected fields
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userID", user.getUserID());
        userMap.put("username", user.getUsername());
        userMap.put("email", user.getEmail());
        userMap.put("locked", user.getLocked());
        userMap.put("userType", user.getUserType().name());
        userMap.put("phoneNumber", user.getPhoneNumber());

        return new ResponseEntity<>(userMap, HttpStatus.OK);
    }

    //End point for updateUser
    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserDTO userDTO) {
        try {
            appUserService.updateUser(userDTO);
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Log the full stack trace
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Endpoint for delete user
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam Long id) {
        try {
            appUserService.deleteUser(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
