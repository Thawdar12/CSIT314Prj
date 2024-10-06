package com.infinitynetwork.csit314.Security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        org.springframework.security.core.AuthenticationException exception)
            throws IOException, ServletException {
        // Check if the exception is due to the account being disabled (locked)
        if (exception instanceof DisabledException) {
            // Redirect to Home page with error message
            response.sendRedirect("/InfinityNetwork/Home?error=locked");
        } else {
            // Handle other exceptions (bad credentials, etc.)
            response.sendRedirect("/InfinityNetwork/Home?error=badCredentials");
        }
    }
}