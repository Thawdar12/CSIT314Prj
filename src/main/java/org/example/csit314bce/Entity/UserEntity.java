package org.example.csit314bce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserEntity {
    private String username;
    private String email;
    private Boolean enabled = true;
    private String password;
    private String userType;
    private String phoneNumber;
    private double averageRating;
    private String created_At;
    private String updated_At;
    private DataSource dataSource;

    public UserEntity() {
    }

    public UserEntity(String username, String email, Boolean enabled, String password, String userType, String phoneNumber, double averageRating, String created_At, String updated_At) {
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
        this.averageRating = averageRating;
        this.created_At = created_At;
        this.updated_At = updated_At;
    }

    @Autowired
    public UserEntity(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String getCreated_At() {
        return created_At;
    }

    public void setCreated_At(String created_At) {
        this.created_At = created_At;
    }

    public String getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(String updated_At) {
        this.updated_At = updated_At;
    }

    //Functions
    public Boolean userLogIn(UserEntity userEntity) {
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        String userType = userEntity.getUserType();

        // SQL query to verify user credentials and check if the profile is enabled
        String sql = "SELECT u.*, p.isEnabled AS profileEnabled " +
                "FROM user u " +
                "JOIN profile p ON u.userType = p.profileName " +
                "WHERE u.username = ? AND u.password = ? AND u.userType = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters to prevent SQL injection
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, userType);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next() && resultSet.getBoolean("enabled") && resultSet.getBoolean("profileEnabled")) {
                // Credentials are correct and both user and profile are enabled
                System.out.println("Entity: Login successful");
                return true;
            } else {
                // Credentials are incorrect or user/profile is not enabled
                System.out.println("Entity: Invalid username, password, user type, or profile is disabled");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String createUser(UserEntity userEntity) {
        username = userEntity.getUsername();
        email = userEntity.getEmail();
        enabled = true;
        password = userEntity.getPassword();
        userType = userEntity.getUserType();
        phoneNumber = userEntity.getPhoneNumber();
        averageRating = 0;
        created_At = String.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        updated_At = String.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));

        //SQL statement to create user with value provide
        String sql = "INSERT INTO user (username, email, enabled, password, userType, phoneNumber, averageRating, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters for the PreparedStatement
            statement.setString(1, this.username);
            statement.setString(2, this.email);
            statement.setBoolean(3, this.enabled);
            statement.setString(4, this.password);
            statement.setString(5, this.userType);
            statement.setString(6, this.phoneNumber);
            statement.setDouble(7, this.averageRating);
            statement.setString(8, this.created_At);
            statement.setString(9, this.updated_At);

            // Execute the INSERT statement
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted == 1) {
                System.out.println("Entity: A new user was inserted successfully!");
                return "success";
            } else {
                System.out.println("Entity: User insertion failed.");
                return "failure";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }

    @JsonIgnore
    public List<UserEntity> fetchAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        String sql = "SELECT username, email, enabled, password, userType, phoneNumber, averageRating, created_at, updated_at FROM user";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                UserEntity user = new UserEntity();
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setEnabled(rs.getBoolean("enabled"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("userType"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setAverageRating(rs.getDouble("averageRating"));
                user.setCreated_At(rs.getString("created_at"));
                user.setUpdated_At(rs.getString("updated_at"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public String updateUser(UserEntity userEntity, String originalUsername) {
        username = userEntity.getUsername();
        email = userEntity.getEmail();
        enabled = userEntity.getEnabled();
        password = userEntity.getPassword();
        userType = userEntity.getUserType();
        phoneNumber = userEntity.getPhoneNumber();
        updated_At = String.valueOf(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));

        // SQL statement to update user based on originalUsername, including username update
        String sql = "UPDATE user SET username = ?, email = ?, enabled = ?, password = ?, userType = ?, phoneNumber = ?, updated_at = ? WHERE username = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the new values
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setBoolean(3, enabled);
            statement.setString(4, password);
            statement.setString(5, userType);
            statement.setString(6, phoneNumber);
            statement.setString(7, updated_At);
            statement.setString(8, originalUsername);

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated == 1) {
                System.out.println("Entity: User updated successfully!");
                return "success";
            } else {
                System.out.println("Entity: User update failed. User may not exist.");
                return "User update failed. User may not exist.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }

    public String suspendUser(String username, int value) {
        String sql = "";

        if (value == 0) {
            sql = "UPDATE user SET enabled = false WHERE username = ?";
        } else if (value == 1) {
            sql = "UPDATE user SET enabled = true WHERE username = ?";
        } else {
            return "Invalid value provided. Use 0 to disable or 1 to enable the user.";
        }

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated == 1) {
                return "success";
            } else {
                return "User not found.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @JsonIgnore
    public List<UserEntity> searchUser(String criteria, String value) {
        List<UserEntity> users = new ArrayList<>();

        // Define allowed columns to prevent SQL injection
        List<String> allowedCriteria = Arrays.asList("username", "email", "userType", "phoneNumber");

        if (!allowedCriteria.contains(criteria)) {
            System.out.println("Invalid search criteria: " + criteria);
            return users; // Returns an empty list if criteria is invalid
        }

        // SQL query using the validated criteria
        String sql = "SELECT username, email, enabled, password, userType, phoneNumber, averageRating, created_at, updated_at " +
                "FROM user WHERE " + criteria + " LIKE ?";

        String likeValue = "%" + value + "%";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            //Wildcards search for partial matching
            statement.setString(1, likeValue);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                UserEntity user = new UserEntity();
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setEnabled(rs.getBoolean("enabled"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("userType"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setAverageRating(rs.getDouble("averageRating"));
                user.setCreated_At(rs.getString("created_at"));
                user.setUpdated_At(rs.getString("updated_at"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public String getID(String username) {
        String id = null;
        String sql = "SELECT userID FROM user WHERE username = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the exact username parameter
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();

            // If user is found, retrieve the ID
            if (rs.next()) {
                id = rs.getString("userID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
