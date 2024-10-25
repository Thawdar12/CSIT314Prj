package org.example.csit314bce.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class ReviewEntity {
    private DataSource dataSource;
    private String comment;
    private double rating;
    private String reviewFor;
    private String reviewBy;
    private LocalDateTime createdAt;

    public ReviewEntity() {
    }

    @Autowired
    public ReviewEntity(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReviewFor() {
        return reviewFor;
    }

    public void setReviewFor(String reviewFor) {
        this.reviewFor = reviewFor;
    }

    public String getReviewBy() {
        return reviewBy;
    }

    public void setReviewBy(String reviewBy) {
        this.reviewBy = reviewBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    //Functions
    public String rateAgent(ReviewEntity review) {
        createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

        //Search userID of reviewFor by username
        long reviewForId;
        String selectForSql = "SELECT userID FROM user WHERE username = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmtFor = connection.prepareStatement(selectForSql)) {

            stmtFor.setString(1, review.getReviewFor());
            ResultSet rsFor = stmtFor.executeQuery();

            if (rsFor.next()) {
                reviewForId = rsFor.getLong("userID");
            } else {
                return "error: reviewFor username not found";
            }

            //search userID of reviewBy by username
            long reviewById;
            String selectBySql = "SELECT userID FROM user WHERE username = ?";
            try (PreparedStatement stmtBy = connection.prepareStatement(selectBySql)) {
                stmtBy.setString(1, review.getReviewBy());
                ResultSet rsBy = stmtBy.executeQuery();

                if (rsBy.next()) {
                    reviewById = rsBy.getLong("userID");
                } else {
                    return "error: reviewBy username not found";
                }

                // Step 4: Insert the review into the review table
                String insertSql = "INSERT INTO review (comment, createdAt, rating, reviewFor, reviewBy) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
                    insertStmt.setString(1, review.getComment());
                    insertStmt.setTimestamp(2, Timestamp.valueOf(createdAt));
                    insertStmt.setDouble(3, review.getRating());
                    insertStmt.setLong(4, reviewForId);
                    insertStmt.setLong(5, reviewById);

                    int rowsInserted = insertStmt.executeUpdate();

                    if (rowsInserted == 1) {
                        System.out.println("Review added successfully!");
                        return "success";
                    } else {
                        System.out.println("Failed to add review.");
                        return "failure";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }
}
