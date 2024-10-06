//This file handles all redirect request
//which means if you JUST want to make something clickable
//and redirect to another page
//do it here.

package com.infinitynetwork.csit314.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping({"/", "/InfinityNetwork/Home"})
    public String getHomePage() {
        return "InfinityNetwork/Home"; // This resolves to 'templates/InfinityNetwork/Home.html'
    }
}
