package com.infinitynetwork.csit314.AppUsers;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDetails loadUserByUsernameAndDomain(String username, String domainGroup) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        String userRole = user.getUserType().name().toLowerCase(); // e.g., "admin", "agent", etc.

        if (!userRole.equals(domainGroup.toLowerCase())) {
            throw new BadCredentialsException("Invalid domain group selected.");
        }

        return user;
    }


    @Transactional
    public void registerUser(AppUser appUser) {
        //Encode the user's password
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    // Method to get all users with pagination
    public Page<AppUser> findAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return appUserRepository.findAll(pageable);
    }

    public void updateUser(UpdateUserDTO userDTO) throws Exception {
        if (userDTO.getUserID() == null) {
            throw new Exception("User ID is null");
        }

        Optional<AppUser> optionalUser = appUserRepository.findById(userDTO.getUserID());
        if (!optionalUser.isPresent()) {
            throw new Exception("User not found");
        }

        AppUser existingUser = optionalUser.get();

        // Update fields
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setLocked(userDTO.getLocked());
        existingUser.setUserType(UserType.valueOf(userDTO.getUserType()));
        existingUser.setPhoneNumber(userDTO.getPhoneNumber());
        existingUser.setUpdated_at(LocalDateTime.now());

        appUserRepository.save(existingUser);
    }

    public void deleteUser(Long id) throws Exception {
        Optional<AppUser> optionalUser = appUserRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new Exception("User not found");
        }

        appUserRepository.deleteById(id);
    }


}
