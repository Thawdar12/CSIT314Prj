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
public class FavouriteEntity {
    private DataSource dataSource;
    private long favFor;
    private long favBy;
    private LocalDateTime createdAt;

    public FavouriteEntity() {}

    @Autowired
    public FavouriteEntity(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Getters and Setters
    public long getFavFor() {
        return favFor;
    }

    public void setFavFor(long favFor) {
        this.favFor = favFor;
    }

    public long getFavBy() {
        return favBy;
    }

    public void setFavBy(long favBy) {
        this.favBy = favBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Method to add a favorite entry
    public String addFavorite(FavouriteEntity favourite) {
        createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

        String insertSql = "INSERT INTO favourite (favFor, favBy, created_at) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {

            insertStmt.setLong(1, favourite.getFavFor());
            insertStmt.setLong(2, favourite.getFavBy());
            insertStmt.setTimestamp(3, Timestamp.valueOf(favourite.getCreatedAt()));

            int rowsInserted = insertStmt.executeUpdate();

            if (rowsInserted == 1) {
                System.out.println("Favorite added successfully!");

                updateFavouriteCountForListing(favourite.getFavFor());

                return "success";
            } else {
                System.out.println("Failed to add favorite.");
                return "failure";
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }


    // Method for updating the Favourite Count
    public void updateFavouriteCountForListing(long listingID) {
        String sqlUpdate = "UPDATE carlistings SET favorite = (SELECT COUNT(*) FROM favourite WHERE favFor = ?) WHERE listingID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlUpdate)) {

            statement.setLong(1, listingID);
            statement.setLong(2, listingID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Method to remove a favorite entry
    public String removeFavorite(long favFor, long favBy) {
        String deleteSql = "DELETE FROM favourite WHERE favFor = ? AND favBy = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement deleteStmt = connection.prepareStatement(deleteSql)) {

            deleteStmt.setLong(1, favFor);
            deleteStmt.setLong(2, favBy);

            int rowsDeleted = deleteStmt.executeUpdate();

            if (rowsDeleted == 1) {
                System.out.println("Favorite removed successfully!");

                updateFavouriteCountForListing(favFor);

                return "success";
            } else {
                System.out.println("No favorite found to remove.");
                return "not found";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }

    // Method to get favorite count for a specific listing
//    public int getFavoriteCountForListing(long listingID) {
//        String sql = "SELECT COUNT(*) AS favorite_count FROM favourite WHERE favFor = ?";
//        int favoriteCount = 0;
//
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setLong(1, listingID);
//
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                favoriteCount = rs.getInt("favorite_count");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return favoriteCount;
//    }


//    public Map<Long, Integer> getFavoriteCountForAllListings() {
//        String sql = "SELECT favFor AS listingID, COUNT(*) AS favorite_count FROM favourite GROUP BY favFor";
//        Map<Long, Integer> favoriteCounts = new HashMap<>();
//
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql);
//             ResultSet rs = statement.executeQuery()) {
//
//            while (rs.next()) {
//                long listingID = rs.getLong("listingID");
//                int favoriteCount = rs.getInt("favorite_count");
//                favoriteCounts.put(listingID, favoriteCount);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return favoriteCounts;
//    }

    // Method to fetch all Buyer's favorites data
    public List<FavouriteEntity> fetchBuyerFavorites(long favBy) {
        List<FavouriteEntity> favorites = new ArrayList<>();

        String sql = "SELECT favFor, favBy, created_at FROM favourite WHERE favBy = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, favBy);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                FavouriteEntity favorite = new FavouriteEntity();
                favorite.setFavFor(rs.getLong("favFor"));
                favorite.setFavBy(rs.getLong("favBy"));
                favorite.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                favorites.add(favorite);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return favorites;
    }

    // Method to fetch all favorites data for a specific listing
    public List<FavouriteEntity> fetchFavoritesOfListing(long listingID) {
        List<FavouriteEntity> favorites = new ArrayList<>();
        String sql = "SELECT favFor, favBy, created_at FROM favourite WHERE favFor = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, listingID);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                FavouriteEntity favorite = new FavouriteEntity();
                favorite.setFavFor(rs.getLong("favFor"));
                favorite.setFavBy(rs.getLong("favBy"));
                favorite.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                favorites.add(favorite);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return favorites;
    }

}
