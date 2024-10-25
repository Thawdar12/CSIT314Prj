package org.example.csit314bce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class URLResolver {
    @GetMapping({"/", "/InfinityNetwork/home"})
    public String home() {
        return "/InfinityNetwork/Home"; // Resolve to src/main/resources/templates/InfinityNetwork/Home.html
    }

    @GetMapping("/InfinityNetwork/admin/dashboard")
    public String dashboard() {
        return "InfinityNetwork/admin/dashboard"; // Resolve to src/main/resources/templates/InfinityNetwork/admin/dashboard.html
    }
}
