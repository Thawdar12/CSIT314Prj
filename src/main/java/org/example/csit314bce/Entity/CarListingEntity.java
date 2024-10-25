package org.example.csit314bce.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarListingEntity {
    private String carBrand;
    private String carModel;
    private String carPlateNumber;
    private LocalDateTime created_at;
    private String listingStatus;
    private int manufacturedYear;
    private double millage;
    private String photo;
    private double price;
    private LocalDateTime updated_at;
    private String listedBy;
    private String sellerID;
    private DataSource dataSource;

    public CarListingEntity() {
    }

    @Autowired
    public CarListingEntity(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(String listingStatus) {
        this.listingStatus = listingStatus;
    }

    public int getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(int manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public double getMillage() {
        return millage;
    }

    public void setMillage(double millage) {
        this.millage = millage;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getListedBy() {
        return listedBy;
    }

    public void setListedBy(String listedBy) {
        this.listedBy = listedBy;
    }

    public String getSellerID() {
        return sellerID;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    //Functions
    public List<CarListingEntity> fetchAllListing() {
        List<CarListingEntity> listings = new ArrayList<>();
        String sql = "SELECT * FROM carlistings";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                CarListingEntity listing = new CarListingEntity();
                listing.setCarBrand(rs.getString("carBrand"));
                listing.setCarModel(rs.getString("carModel"));
                listing.setCarPlateNumber(rs.getString("carPlateNumber"));
                listing.setCreated_at(rs.getTimestamp("createdAt").toLocalDateTime());
                listing.setListingStatus(rs.getString("listingStatus"));
                listing.setManufacturedYear(rs.getInt("manufacturedYear"));
                listing.setMillage(rs.getDouble("millage"));
                listing.setPhoto(rs.getString("photo"));
                listing.setPrice(rs.getDouble("price"));
                listing.setUpdated_at(rs.getTimestamp("updated_at").toLocalDateTime());
                listing.setListedBy(rs.getString("listedBy"));
                listing.setSellerID(rs.getString("sellerID"));
                listings.add(listing);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listings;
    }
}
