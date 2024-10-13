package com.infinitynetwork.csit314;

import com.infinitynetwork.csit314.AppUsers.AppUser;
import com.infinitynetwork.csit314.AppUsers.AppUserRepository;
import com.infinitynetwork.csit314.AppUsers.AppUserService;
import com.infinitynetwork.csit314.AppUsers.UserType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Csit314Application implements CommandLineRunner {

    private final AppUserRepository appUserRepository;

    private final AppUserService appUserService;

    public Csit314Application(AppUserRepository appUserRepository, AppUserService appUserService) {
        this.appUserRepository = appUserRepository;
        this.appUserService = appUserService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Csit314Application.class, args);
    }

    @Override
    public void run(String... args) {
        // Insert the very first admin user
        String username = "admin";
        appUserRepository.findByUsername(username).ifPresentOrElse(
                user -> System.out.println("User 'admin' already exists."),
                () -> {
                    System.out.println("User 'admin' not found. Registering new user...");
                    try {
                        // Create a new user
                        AppUser newUser = new AppUser("admin", "admin@admin.com", "admin", "12345678", UserType.ADMIN);
                        // Register user through the service
                        appUserService.registerUser(newUser);
                        System.out.println("User 'admin' successfully registered.");
                    } catch (Exception e) {
                        System.err.println("Error registering user 'admin': " + e.getMessage());
                        e.printStackTrace();
                    }
                }
        );
    }
}
