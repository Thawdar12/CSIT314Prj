package com.infinitynetwork.csit314.Security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // Retrieve the 'domainGroup' parameter from the login form
        String domainGroup = request.getParameter("domainGroup");

        if (domainGroup == null || domainGroup.isEmpty()) {
            // If 'domainGroup' is not provided, redirect to home with an error
            response.sendRedirect("/InfinityNetwork/Home?error=invalidDomainGroup");
            return;
        }

        // Construct the required role based on 'domainGroup' (e.g., 'ROLE_ADMIN')
        String requiredRole = "ROLE_" + domainGroup.toUpperCase();

        // Check if the authenticated user has the required role
        boolean hasRole = authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(requiredRole));

        if (hasRole) {
            // Redirect to the appropriate dashboard based on 'domainGroup'
            String redirectUrl = "/InfinityNetwork/" + domainGroup + "/dashboard";
            response.sendRedirect(redirectUrl);
        } else {
            // If the user does not have the required role, redirect to home with an error
            response.sendRedirect("/InfinityNetwork/Home?error=invalidDomainGroup");
        }
    }
}
