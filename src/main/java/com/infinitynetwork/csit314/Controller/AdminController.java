package com.infinitynetwork.csit314.Controller;

import com.infinitynetwork.csit314.AppUsers.AppUser;
import com.infinitynetwork.csit314.AppUsers.AppUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/InfinityNetwork/admin")
public class AdminController {
    private final AppUserService appUserService;
    // Get the current date and time
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String currentDateTime = now.format(formatter);

    public AdminController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/dashboard")
    public String adminDashboard(Model model, Authentication auth, HttpSession session) {
        // Get the username from the authentication object
        String username = auth.getName(); // Assuming you have the user's username from security context

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = now.format(formatter);

        // Store information in the session
        session.setAttribute("username", username);
        session.setAttribute("currentDateTime", currentDateTime);

        return "InfinityNetwork/admin/dashboard"; // This resolves to 'templates/InfinityNetwork/admin/dashboard.html'
    }

    //Method to serve fragment
    @GetMapping("/fragments/manage-user-account")
    public String UserAccountFragment(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size, Model model) {
        List<AppUser> users = appUserService.findAllUsers(page, size);
        model.addAttribute("users", users);
        return "fragments/manage-user-accounts :: functionContent"; // Return the fragment
    }

    @GetMapping("/fragments/manage-user-profile")
    public String UserProfileFragment() {
        return "fragments/manage-user-profile :: functionContent"; // Return the fragment
    }

    @PostMapping(value = "/createUser", consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody AppUser user) throws Exception {
        appUserService.registerUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
