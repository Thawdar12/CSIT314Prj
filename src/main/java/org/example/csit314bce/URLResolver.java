package org.example.csit314bce;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class URLResolver {
    @GetMapping({"/", "/InfinityNetwork/login"})
    public String home() {
        return "/InfinityNetwork/Login"; // Resolve to src/main/resources/templates/InfinityNetwork/Login.html
    }

    @GetMapping("/InfinityNetwork/admin/dashboard")
    public String dashboard() {
        return "InfinityNetwork/admin/dashboard"; // Resolve to src/main/resources/templates/InfinityNetwork/admin/dashboard.html
    }

    @GetMapping("/InfinityNetwork/admin/profiles")
    public String viewProfiles() {
        return "InfinityNetwork/admin/profiles";
    }

    @GetMapping("InfinityNetwork/admin/create")
    public String createUser() {
        return "InfinityNetwork/admin/create";
    }

    @GetMapping("InfinityNetwork/admin/update")
    public String updateUser(@RequestParam String username, Model model) {
        System.out.println(username);
        // Pass data to the page
        model.addAttribute("username", username);
        return "InfinityNetwork/admin/update";
    }

    @GetMapping("InfinityNetwork/admin/createProfile")
    public String createProfile() {
        return "InfinityNetwork/admin/createProfile";
    }

    @GetMapping("InfinityNetwork/admin/updateProfile")
    public String updateProfile(@RequestParam String profileName, Model model) {
        System.out.println(profileName);
        // Pass data to the page
        model.addAttribute("profileName", profileName);
        return "InfinityNetwork/admin/updateProfileUI";
    }

    // AGENT

    @GetMapping("InfinityNetwork/agent/dashboard")
    public String agentDashboard() {
        return "InfinityNetwork/agent/dashboard";
    }

    @GetMapping("InfinityNetwork/agent/listings")
    public String agentListings() {
        return "InfinityNetwork/agent/listings";
    }

    @GetMapping("InfinityNetwork/agent/create")
    public String agentCreateListing() {
        return "InfinityNetwork/agent/create";
    }

    @GetMapping("InfinityNetwork/agent/reviews")
    public String agentReviews() {
        return "InfinityNetwork/agent/reviews";
    }

    @GetMapping("InfinityNetwork/agent/edit")
    public String editAccountInfo() {
        return "InfinityNetwork/agent/edit";
    }

    @GetMapping("InfinityNetwork/agent/update")
    public String updateListing(@RequestParam String carPlateNumber, Model model) {
        System.out.println(carPlateNumber);
        // Pass data to the page
        model.addAttribute("carPlateNumber", carPlateNumber);
        return "InfinityNetwork/agent/update";
    }

    @GetMapping("InfinityNetwork/agent/account")
    public String account() {
        return "InfinityNetwork/agent/account";
    }
}
