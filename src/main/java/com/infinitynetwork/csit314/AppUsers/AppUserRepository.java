package com.infinitynetwork.csit314.AppUsers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);

    Optional<AppUser> findByPhoneNumber(String phoneNumber);

    Page<AppUser> findAll(Pageable pageable);

    List<AppUser> findByUsernameContainingIgnoreCase(String username);

    List<AppUser> findByEmailContainingIgnoreCase(String email);

    List<AppUser> findByPhoneNumberContaining(String phoneNumber);
}
