package org.example.csit314bce.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class FavoriteEntity {
    Long favoriteID;
    String carPlateNumber;
    String favoriteBy;
    String sellerUsername;
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

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    //crete
    //retrieve
    //delete
    //retrieve number
}
