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
import java.util.stream.Collectors;

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
        username = userEntity.getUsername();
        password = userEntity.getPassword();
        userType = userEntity.getUserType();

        // SQL query to verify user credentials
        String sql = "SELECT * FROM user WHERE username = ? AND password = ? AND userType = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters to prevent SQL injection
            statement.setString(1, this.username);
            statement.setString(2, this.password);
            statement.setString(3, this.userType);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next() && resultSet.getBoolean("enabled")) {
                // Credentials are correct
                System.out.println("Entity: Login successful");
                return true;
            } else {
                // Credentials are incorrect
                System.out.println("Entity: Invalid username, password, or user type");
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

    public String createProfile(String profileName) {
        List<String> enumValues = new ArrayList<>();
        String selectEnumSql = "SHOW COLUMNS FROM user LIKE 'userType'";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStmt = connection.prepareStatement(selectEnumSql);
             ResultSet rs = selectStmt.executeQuery()) {

            if (rs.next()) {
                String enumDefinition = rs.getString("Type");
                // Extract values between parentheses
                enumDefinition = enumDefinition.substring(enumDefinition.indexOf('(') + 1, enumDefinition.lastIndexOf(')'));
                String[] values = enumDefinition.split(",");
                for (String value : values) {
                    enumValues.add(value.trim().replace("'", ""));
                }
            }

            // Check if profile already exists
            if (enumValues.contains(profileName)) {
                return "Profile already exists.";
            }

            // Add new profile
            enumValues.add(profileName);

            // Construct new ENUM definition
            StringBuilder newEnum = new StringBuilder("enum(");
            for (int i = 0; i < enumValues.size(); i++) {
                newEnum.append("'").append(enumValues.get(i)).append("'");
                if (i < enumValues.size() - 1) {
                    newEnum.append(",");
                }
            }
            newEnum.append(")");

            // Alter table to update ENUM
            String alterSql = "ALTER TABLE user MODIFY userType " + newEnum.toString();

            try (PreparedStatement alterStmt = connection.prepareStatement(alterSql)) {
                alterStmt.executeUpdate();
                System.out.println("Profile '" + profileName + "' added successfully!");
                return "success";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }

    @JsonIgnore
    public List<String> fetchALlProfile() {
        List<String> profiles = new ArrayList<>();
        String sql = "SHOW COLUMNS FROM user LIKE 'userType'";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            if (rs.next()) {
                String enumDefinition = rs.getString("Type");
                // Extract values between parentheses
                enumDefinition = enumDefinition.substring(enumDefinition.indexOf('(') + 1, enumDefinition.lastIndexOf(')'));
                String[] values = enumDefinition.split(",");
                for (String value : values) {
                    profiles.add(value.trim().replace("'", ""));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profiles;
    }

    public String updateProfile(String oldProfileName, String newProfileName) {
        List<String> enumValues = new ArrayList<>();
        String selectEnumSql = "SHOW COLUMNS FROM user LIKE 'userType'";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStmt = connection.prepareStatement(selectEnumSql);
             ResultSet rs = selectStmt.executeQuery()) {

            if (rs.next()) {
                String enumDefinition = rs.getString("Type");
                enumDefinition = enumDefinition.substring(enumDefinition.indexOf('(') + 1, enumDefinition.lastIndexOf(')'));
                String[] values = enumDefinition.split(",");
                for (String value : values) {
                    enumValues.add(value.trim().replace("'", ""));
                }
            }

            if (!enumValues.contains(oldProfileName)) {
                return "Old profile name does not exist.";
            }

            if (enumValues.contains(newProfileName)) {
                return "New profile name already exists.";
            }

            enumValues = enumValues.stream()
                    .map(val -> val.equals(oldProfileName) ? newProfileName : val)
                    .collect(Collectors.toList());

            // Build new ENUM definition
            StringBuilder newEnum = new StringBuilder("enum(");
            for (int i = 0; i < enumValues.size(); i++) {
                newEnum.append("'").append(enumValues.get(i)).append("'");
                if (i < enumValues.size() - 1) {
                    newEnum.append(",");
                }
            }
            newEnum.append(")");

            // Alter table to update ENUM
            String alterSql = "ALTER TABLE user MODIFY userType " + newEnum.toString();

            try (PreparedStatement alterStmt = connection.prepareStatement(alterSql)) {
                alterStmt.executeUpdate();
                System.out.println("Profile '" + oldProfileName + "' updated to '" + newProfileName + "' successfully!");
                return "success";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }

    public String suspendProfile(String profileName, int value) {
        boolean isEnabled = (value == 1);
        // SQL statement to update the enabled status
        String sql = "UPDATE user SET enabled = ? WHERE userType = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the parameters
            statement.setBoolean(1, isEnabled);
            statement.setString(2, profileName);

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                String action = isEnabled ? "unsuspended" : "suspended";
                System.out.println("Successfully " + action + " " + rowsUpdated + " user(s) with profile: " + profileName);
                return "success";
            } else {
                System.out.println("No users found with profile: " + profileName);
                return "failure: No users found with the specified profile.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
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