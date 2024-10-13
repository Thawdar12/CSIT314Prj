package com.infinitynetwork.csit314.Reviews;

import com.infinitynetwork.csit314.AppUsers.AppUser;
import com.infinitynetwork.csit314.AppUsers.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    private final AppUserRepository appUserRepository;

    public ReviewService(ReviewRepository reviewRepository, AppUserRepository appUserRepository) {
        this.reviewRepository = reviewRepository;
        this.appUserRepository = appUserRepository;
    }

    public void addReview(Long reviewedUserId, Long reviewerId, int rating, String comment) {
        AppUser reviewer = appUserRepository.findById(reviewerId).orElseThrow();
        AppUser reviewedUser = appUserRepository.findById(reviewedUserId).orElseThrow();

        Review review = new Review();
        review.setReviewer(reviewer);
        review.setReviewedUser(reviewedUser);
        review.setRating(rating);
        review.setComment(comment);

        reviewRepository.save(review);

        // Update averageRating
        List<Review> reviews = reviewRepository.findByReviewedUser(reviewedUser);
        double avg = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);
        reviewedUser.setAverageRating(avg);
        appUserRepository.save(reviewedUser);
    }
}
