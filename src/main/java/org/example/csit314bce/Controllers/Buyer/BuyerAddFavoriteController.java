package org.example.csit314bce.Controllers.Buyer;

import org.example.csit314bce.Entity.FavoriteEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerAddFavoriteController {
    private final FavoriteEntity favoriteEntity;

    public BuyerAddFavoriteController(FavoriteEntity favoriteEntity) {
        this.favoriteEntity = favoriteEntity;
    }

    @PostMapping(value = "/InfinityNetwork/buyer/addFavorite",
            consumes = "application/json")
    public String buyerAddFavorite(@RequestBody FavoriteEntity favoriteEntity) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.favoriteEntity.addFavorite(favoriteEntity);

        //Get back from Entity class
        return result;
    }
}
