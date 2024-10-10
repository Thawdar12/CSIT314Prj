package com.infinitynetwork.csit314.CarListings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.infinitynetwork.csit314.AppUsers.AppUser;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class CarListings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long listingID;

    @Column(nullable = false, unique = true)
    private String carPlateNumber;

    @Column(nullable = false)
    private String carBrand;

    @Column(nullable = false)
    private String carModel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ListingStatus listingStatus;

    // Establish Many-to-One relationship with AppUser
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userID", nullable = false)
    private AppUser listedBy;

    @Column(nullable = false)
    private String millage;

    @Column(nullable = false)
    private String manufacturedYear;

    // New Field: Price
    @Column(nullable = false)
    private Double price;

    @Column(columnDefinition = "TEXT")
    private String photo;

    @Column(nullable = false, columnDefinition = "DATETIME(3)")
    private LocalDateTime created_at;

    @Column(nullable = false, columnDefinition = "DATETIME(3)")
    private LocalDateTime updated_at;

    // Constructors
    public CarListings() {
    }

    public CarListings(String carPlateNumber, String carBrand, String carModel,
                       ListingStatus listingStatus, AppUser listedBy) {
        this.carPlateNumber = carPlateNumber;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.listingStatus = listingStatus;
        this.listedBy = listedBy;
        this.created_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        this.updated_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    // Getters and Setters

    public Long getListingID() {
        return listingID;
    }

    public void setListingID(Long listingID) {
        this.listingID = listingID;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
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

    public ListingStatus getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(ListingStatus listingStatus) {
        this.listingStatus = listingStatus;
    }

    public AppUser getListedBy() {
        return listedBy;
    }

    public void setListedBy(AppUser listedBy) {
        this.listedBy = listedBy;
    }

    public String getMillage() {
        return millage;
    }

    public void setMillage(String millage) {
        this.millage = millage;
    }

    public String getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(String manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        updated_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }
}
