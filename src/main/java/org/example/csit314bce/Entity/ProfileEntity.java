package org.example.csit314bce.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProfileEntity {
    Long profileID;
    String profileName;
    String profileDescription;
    boolean isEnabled;
    private DataSource dataSource;

    public ProfileEntity() {
    }

    @Autowired
    public ProfileEntity(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String createProfile(ProfileEntity profile) {
        String sql = "INSERT INTO profile (profileName, profileDescription, isEnabled) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, profile.getProfileName());
            statement.setString(2, profile.getProfileDescription());
            statement.setBoolean(3, true);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0 ? "Profile created successfully." : "Failed to create profile.";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while creating profile.";
        }
    }

    public List<ProfileEntity> fetchAllProfile() {
        List<ProfileEntity> profiles = new ArrayList<>();
        String sql = "SELECT profileID, profileName, profileDescription, isEnabled FROM profile";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                ProfileEntity profile = new ProfileEntity(dataSource);
                profile.setProfileName(rs.getString("profileName"));
                profile.setProfileDescription(rs.getString("profileDescription"));
                profile.setEnabled(rs.getBoolean("isEnabled"));
                profiles.add(profile);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profiles;
    }

    public List<ProfileEntity> searchProfileByName(String profileName) {
        List<ProfileEntity> profiles = new ArrayList<>();
        String sql = "SELECT profileID, profileName, profileDescription, isEnabled FROM profile WHERE profileName LIKE ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Use wildcard search for partial matching
            statement.setString(1, "%" + profileName + "%");

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    ProfileEntity profile = new ProfileEntity(dataSource);
                    profile.setProfileName(rs.getString("profileName"));
                    profile.setProfileDescription(rs.getString("profileDescription"));
                    profile.setEnabled(rs.getBoolean("isEnabled"));
                    profiles.add(profile);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profiles;
    }

    public String suspendProfile(String profileName, int value) {
        String sql = "UPDATE profile SET isEnabled = ? WHERE profileName = ?";
        boolean isEnabled = (value == 1);

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters for the UPDATE statement
            statement.setBoolean(1, isEnabled);
            statement.setString(2, profileName);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Profile " + profileName + " has been " + (isEnabled ? "enabled" : "suspended") + " successfully.";
            } else {
                return "Profile " + profileName + " not found or could not be updated.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while updating profile status.";
        }
    }

    public String updateProfile(String oldProfileName, ProfileEntity updatedProfileEntity) {
        String sql = "UPDATE profile SET profileName = ?, profileDescription = ? WHERE profileName = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters for the UPDATE statement
            statement.setString(1, updatedProfileEntity.getProfileName());
            statement.setString(2, updatedProfileEntity.getProfileDescription());
            statement.setString(3, oldProfileName);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Profile " + oldProfileName + " has been updated successfully.";
            } else {
                return "Profile " + oldProfileName + " not found or could not be updated.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while updating profile.";
        }
    }
}
