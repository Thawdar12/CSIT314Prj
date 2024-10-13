package com.infinitynetwork.csit314.Reviews;

import com.infinitynetwork.csit314.AppUsers.AppUser;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reviewer_id", nullable = false)
    private AppUser reviewer;

    @ManyToOne
    @JoinColumn(name = "reviewed_user_id", nullable = false)
    private AppUser reviewedUser;

    @Column(nullable = false)
    private int rating; // 0-5

    @Column(length = 1000)
    private String comment;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Review() {
    }

    public Review(AppUser reviewer, AppUser reviewedUser, String comment, int rating) {
        this.reviewer = reviewer;
        this.reviewedUser = reviewedUser;
        this.comment = comment;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public AppUser getReviewer() {
        return reviewer;
    }

    public void setReviewer(AppUser reviewer) {
        this.reviewer = reviewer;
    }

    public AppUser getReviewedUser() {
        return reviewedUser;
    }

    public void setReviewedUser(AppUser reviewedUser) {
        this.reviewedUser = reviewedUser;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }
}
