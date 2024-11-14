package org.example.csit314bce.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FavoriteEntity {
    Long favoriteID;
    String favoriteFor;
    String favoriteBy;
    String sellerUsername;
    LocalDateTime created_at;
    private DataSource dataSource;

    public FavoriteEntity() {
    }

    @Autowired
    public FavoriteEntity(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getFavoriteBy() {

        return favoriteBy;
    }

    public void setFavoriteBy(String favoriteBy) {
        this.favoriteBy = favoriteBy;
    }

    public String getFavoriteFor() {
        return favoriteFor;
    }

    public void setFavoriteFor(String favoriteFor) {
        this.favoriteFor = favoriteFor;
    }

    public String getSellerUsername() {

        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {

        this.sellerUsername = sellerUsername;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }


    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    // Method to add a favorite entry
    public String addFavorite(FavoriteEntity favoriteEntity) {
        this.created_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

        String insertSql = "INSERT INTO favorite (favoriteFor, favoriteBy, sellerUsername, created_at) VALUES (?, ?, ?, ?)";
        String updateSql = "UPDATE carlistings SET favoriteCount = favoriteCount + 1 WHERE carPlateNumber = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertStmt = connection.prepareStatement(insertSql);
             PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {

            // Set parameters for the INSERT statement
            insertStmt.setString(1, favoriteEntity.getFavoriteFor());
            insertStmt.setString(2, favoriteEntity.getFavoriteBy());
            insertStmt.setString(3, favoriteEntity.getSellerUsername());
            insertStmt.setTimestamp(4, Timestamp.valueOf(this.created_at));

            // Execute the INSERT statement
            int rowsInserted = insertStmt.executeUpdate();

            if (rowsInserted == 1) {
                // Set parameter for the UPDATE statement
                updateStmt.setString(1, favoriteEntity.getFavoriteFor());

                // Execute the UPDATE statement
                int rowsUpdated = updateStmt.executeUpdate();

                if (rowsUpdated == 1) {
                    System.out.println("Favorite added and favorite count updated successfully!");
                    return "success";
                } else {
                    System.out.println("Favorite added, but failed to update favorite count.");
                    return "partial_success";
                }
            } else {
                System.out.println("Failed to add favorite.");
                return "failure";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }



    // Method to remove a favorite entry
    // favoriteFor = carPlateNumber, favoriteBy = username
    public String removeFavorite(String favoriteBy, String favoriteFor) {
        String deleteSql = "DELETE FROM favorite WHERE favoriteFor = ? AND favoriteBy = ?";
        String updateSql = "UPDATE carlistings SET favoriteCount = favoriteCount - 1 WHERE carPlateNumber = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement deleteStmt = connection.prepareStatement(deleteSql);
             PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {

            // Set parameters for the DELETE statement
            deleteStmt.setString(1, favoriteFor);
            deleteStmt.setString(2, favoriteBy);

            // Execute the DELETE statement
            int rowsDeleted = deleteStmt.executeUpdate();

            if (rowsDeleted == 1) {
                // Set parameter for the UPDATE statement
                updateStmt.setString(1, favoriteFor);

                // Execute the UPDATE statement
                int rowsUpdated = updateStmt.executeUpdate();

                if (rowsUpdated == 1) {
                    System.out.println("Favorite removed and favorite count updated successfully!");
                    return "success";
                } else {
                    System.out.println("Favorite removed, but failed to update favorite count.");
                    return "partial_success";
                }
            } else {
                System.out.println("No favorite found to remove.");
                return "not found";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }


    // Fetch Favorite List of a user
    public List<CarListingEntity> fetchAllFavoriteListings(String favoriteBy) {
        List<CarListingEntity> favoriteListings = new ArrayList<>();

        String sql = "SELECT c.* FROM carlistings c " +
                "JOIN favorite f ON c.carPlateNumber = f.favoriteFor " +
                "WHERE f.favoriteBy = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the favoriteBy parameter in the SQL query
            statement.setString(1, favoriteBy);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    CarListingEntity listing = new CarListingEntity();
                    listing.setCarBrand(rs.getString("carBrand"));
                    listing.setCarModel(rs.getString("carModel"));
                    listing.setCarPlateNumber(rs.getString("carPlateNumber"));
                    listing.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                    listing.setListingStatus(rs.getString("listingStatus"));
                    listing.setManufacturedYear(rs.getInt("manufacturedYear"));
                    listing.setMillage(rs.getDouble("millage"));
                    listing.setPhoto(rs.getString("photo"));
                    listing.setPrice(rs.getDouble("price"));
                    listing.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
                    listing.setListedBy(rs.getString("listedBy"));
                    listing.setSellerUsername(rs.getString("sellerUsername"));
                    listing.setViewCount(rs.getInt("viewCount"));
                    listing.setFavoriteCount(rs.getInt("favoriteCount"));
                    favoriteListings.add(listing);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return favoriteListings;
    }



    // get fav count for seller's listing
    public List<CarListingEntity> fetchFavoriteCountForSellerListings(String sellerUsername) {
        List<CarListingEntity> sellerFavoriteListings = new ArrayList<>();

        String sql = "SELECT * FROM carlistings WHERE sellerUsername = ? ";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, sellerUsername);  // Set the sellerUsername parameter

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    CarListingEntity listing = new CarListingEntity();
                    listing.setCarBrand(rs.getString("carBrand"));
                    listing.setCarModel(rs.getString("carModel"));
                    listing.setCarPlateNumber(rs.getString("carPlateNumber"));
                    listing.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                    listing.setListingStatus(rs.getString("listingStatus"));
                    listing.setManufacturedYear(rs.getInt("manufacturedYear"));
                    listing.setMillage(rs.getDouble("millage"));
                    listing.setPhoto(rs.getString("photo"));
                    listing.setPrice(rs.getDouble("price"));
                    listing.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
                    listing.setListedBy(rs.getString("listedBy"));
                    listing.setSellerUsername(rs.getString("sellerUsername"));
                    listing.setViewCount(rs.getInt("viewCount"));
                    listing.setFavoriteCount(rs.getInt("favoriteCount"));
                    sellerFavoriteListings.add(listing);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sellerFavoriteListings;
    }


}
