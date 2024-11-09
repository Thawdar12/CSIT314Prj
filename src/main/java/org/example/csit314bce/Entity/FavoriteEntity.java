package org.example.csit314bce.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class FavoriteEntity {
    Long favoriteID;
    String favoriteBy; //username
    String carPlateNumber;
    private DataSource dataSource;

    public FavoriteEntity() {
    }

    @Autowired
    public FavoriteEntity(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
