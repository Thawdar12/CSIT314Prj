package org.example.csit314bce.Controllers.Buyer;

import org.example.csit314bce.Entity.CarListingEntity;
import org.example.csit314bce.Entity.FavoriteEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerDeleteFavoriteController {

    private final FavoriteEntity favoriteEntity;

    public BuyerDeleteFavoriteController(FavoriteEntity favoriteEntity) {
        this.favoriteEntity = favoriteEntity;
    }

    @PostMapping(value = "/InfinityNetwork/buyer/removeFavorite")
    public String buyerRemoveFavorite(@RequestParam String username,
                                  @RequestParam String carPlateNumber) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.favoriteEntity.removeFavorite(username, carPlateNumber);

        //Get back from Entity class
        return result;
    }
}

