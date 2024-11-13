package org.example.csit314bce.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

                //Insert the review into the review table
                String insertSql = "INSERT INTO review (comment, createdAt, rating, reviewFor, reviewBy) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
                    insertStmt.setString(1, review.getComment());
                    insertStmt.setTimestamp(2, Timestamp.valueOf(createdAt));
                    insertStmt.setDouble(3, review.getRating());
                    insertStmt.setString(4, review.getReviewFor());
                    insertStmt.setString(5, review.getReviewBy());

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

    public List<ReviewEntity> fetchRating(String username) {
        List<ReviewEntity> reviews = new ArrayList<>();
        // SQL query to fetch reviews for the given agentUserID
        String sql = "SELECT comment, rating, reviewFor, reviewBy, createdAt FROM review WHERE reviewFor = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the agentUserID parameter
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ReviewEntity review = new ReviewEntity();
                review.setComment(rs.getString("comment"));
                review.setRating(rs.getDouble("rating"));
                review.setReviewFor(rs.getString("reviewFor"));
                review.setReviewBy(rs.getString("reviewBy"));
                review.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                reviews.add(review);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }
}
