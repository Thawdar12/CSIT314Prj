//this config file handle redirect request before login
//as we don't want all user to access certain page without login

package com.infinitynetwork.csit314.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // CSRF is disabled for development environment
                .formLogin(httpForm -> {
                    httpForm
                            .loginPage("/InfinityNetwork/Home").permitAll()  // dedicated login page
                            .loginProcessingUrl("/login")           // Endpoint for login processing
                            .successHandler(new CustomAuthenticationSuccessHandler())  // Redirect on successful login
                            .failureUrl("/InfinityNetwork/404");   // Redirect on login failure, this is for testing, to be change later
                })
                .logout(logout -> {
                    logout
                            .logoutUrl("/logout")   // URL to trigger logout
                            .logoutSuccessUrl("/InfinityNetwork/Home")        // Redirect on successful logout
                            .invalidateHttpSession(true)             // Invalidate the HTTP session
                            .deleteCookies("JSESSIONID") // Delete cookies
                            .permitAll();                            // Allow all to access logout URL
                })
                .authorizeHttpRequests(registry -> {
                    registry
                            .requestMatchers("/assets/**", "/css/**", "/js/**", "/images/**").permitAll()
                            .requestMatchers("/", "/InfinityNetwork/Home", "/debug/**", "/error").permitAll()
                            .anyRequest().authenticated();
                });
        return http.build();
    }
}
