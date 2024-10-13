package com.infinitynetwork.csit314.AppUsers;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    //Store user entry to database
    @Transactional
    public void registerUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    //Load a user by username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    //return User Object by username
    public AppUser getUsersByUserName(String userName) {
        AppUser user = appUserRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("User not found: " + userName));
        return user;
    }

    //Get all users with pagination
    public Page<AppUser> findAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return appUserRepository.findAll(pageable);
    }

    //Update user info, via DTO
    public void updateUser(UpdateUserDTO userDTO) throws Exception {
        if (userDTO.getUserID() == null) {
            throw new Exception("User ID is null");
        }

        Optional<AppUser> optionalUser = appUserRepository.findById(userDTO.getUserID());
        if (!optionalUser.isPresent()) {
            throw new Exception("User not found");
        }

        //This is for retrieve current using info before update
        AppUser existingUser = optionalUser.get();

        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());

        if (userDTO.getLocked() != null) {
            existingUser.setLocked(userDTO.getLocked());
        }

        if (userDTO.getLocked() != null) {
            existingUser.setEnabled(!userDTO.getLocked());
        }

        if (userDTO.getUserType() != null) {
            existingUser.setUserType(UserType.valueOf(userDTO.getUserType()));
        }
        
        existingUser.setPhoneNumber(userDTO.getPhoneNumber());
        existingUser.setUpdated_at(LocalDateTime.now());

        appUserRepository.save(existingUser);
    }

    //Delete user entry
    public void deleteUser(Long id) throws Exception {
        Optional<AppUser> optionalUser = appUserRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new Exception("Listing not found");
        }
        appUserRepository.deleteById(id);
    }

    @Transactional
    public void changePassword(ChangePasswordDTO passwordDTO) throws Exception {
        if (passwordDTO.getUserID() == null || passwordDTO.getCurrentPassword() == null || passwordDTO.getNewPassword() == null) {
            throw new Exception("Missing required fields");
        }

        AppUser user = appUserRepository.findById(passwordDTO.getUserID())
                .orElseThrow(() -> new Exception("User not found"));

        // Verify current password
        if (!passwordEncoder.matches(passwordDTO.getCurrentPassword(), user.getPassword())) {
            throw new Exception("Current password is incorrect");
        }

        // Encode and set the new password
        user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
        appUserRepository.save(user);
    }
}
