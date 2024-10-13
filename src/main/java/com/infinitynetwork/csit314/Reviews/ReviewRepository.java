package com.infinitynetwork.csit314.Reviews;

import com.infinitynetwork.csit314.AppUsers.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByReviewedUser(AppUser reviewedUser);
}
