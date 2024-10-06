package com.infinitynetwork.csit314.AppUsers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;

@Entity
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long userID;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private Boolean enabled = true;

    @Column(nullable = false)
    private Boolean locked = false;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    @Column(nullable = false, unique = true, length = 20)
    private String phoneNumber;

    @Column(nullable = false, columnDefinition = "DATETIME(3)")
    private LocalDateTime created_at;

    @Column(nullable = false, columnDefinition = "DATETIME(3)")
    private LocalDateTime updated_at;

    //Constructors
    public AppUser() {
    } //Minimum Constructor

    public AppUser(String username, String email, String password, String phoneNumber, UserType userType) {
        this.username = username;
        this.email = email;
        this.enabled = true;
        this.locked = false;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.created_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        this.updated_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (userType != null) {
            String roleName = "ROLE_" + userType.name();
            return List.of(new SimpleGrantedAuthority(roleName));
        } else {
            // Handle the case where userType is null, but it shouldn't be null in creating case, there is always a value
            return List.of();
        }
    }


    //Getter and Setter
    public Long getUserID() {
        return userID;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        updated_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }
}


