package com.infinitynetwork.csit314.Security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // Get the user's authorities (roles)
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Redirect based on role
        String redirectUrl = null;

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                redirectUrl = "/InfinityNetwork/admin/dashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_AGENT")) {
                redirectUrl = "/agent/dashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_BUYER")) {
                redirectUrl = "/buyer/dashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_SELLER")) {
                redirectUrl = "/seller/dashboard";
                break;
            }
        }

        // Default redirect URL if no roles match
        if (redirectUrl == null) {
            redirectUrl = "/404";
        }
        response.sendRedirect(redirectUrl);
    }
}
