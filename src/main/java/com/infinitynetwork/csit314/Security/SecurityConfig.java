package com.infinitynetwork.csit314.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    // 1. Define the AuthenticationProvider using DaoAuthenticationProvider
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    // 2. Define the AuthenticationManager Bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // 3. Define the Custom Authentication Success Handler
    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public CustomAuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    // 4. Configure the Security Filter Chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for development (Enable in production)
                .csrf(AbstractHttpConfigurer::disable)

                // Set the custom AuthenticationProvider
                .authenticationProvider(authenticationProvider())

                // Configure form login
                .formLogin(form -> form
                        .loginPage("/InfinityNetwork/Home").permitAll() // Custom login page
                        .loginProcessingUrl("/login") // URL to submit the username and password
                        .successHandler(customAuthenticationSuccessHandler()) // Custom success handler
                        .failureHandler(customAuthenticationFailureHandler())  // Use the custom failure handler
                )

                // Configure logout
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL to trigger logout
                        .logoutSuccessUrl("/InfinityNetwork/Home") // Redirect after logout
                        .invalidateHttpSession(true) // Invalidate session
                        .deleteCookies("JSESSIONID") // Delete session cookies
                        .permitAll()
                )

                // Define URL authorization rules
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/assets/**", "/css/**", "/js/**", "/images/**").permitAll() // Public resources
                        .requestMatchers("/", "/InfinityNetwork/Home", "/debug/**", "/error").permitAll() // Public pages
                        .requestMatchers("/InfinityNetwork/admin/**").hasRole("ADMIN") // Admin pages
                        .requestMatchers("/InfinityNetwork/agent/**").hasRole("AGENT") // Agent pages
                        .requestMatchers("/InfinityNetwork/buyer/**").hasRole("BUYER") // Buyer pages
                        .requestMatchers("/InfinityNetwork/seller/**").hasRole("SELLER") // Seller pages
                        .anyRequest().authenticated() // All other requests require authentication
                )

                // Handle unauthorized access
                .exceptionHandling(handling -> handling
                        .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/InfinityNetwork/Home")) // Redirect to login page
                );

        return http.build();
    }
}
