package org.example.csit314bce.Controllers.Buyer;

import org.example.csit314bce.Entity.FavouriteEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BuyerRemoveFavController {
    private final FavouriteEntity favouriteEntity;

    public BuyerRemoveFavController(FavouriteEntity favouriteEntity) {
        this.favouriteEntity = favouriteEntity;
    }

    @PostMapping(value = "/InfinityNetwork/buyer/removeFavorite",
            consumes = "application/json")
    public String removeFavourite(@RequestBody long userID,
                               @RequestBody long listingID) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.favouriteEntity.removeFavorite(userID, listingID);

        //Get back from Entity class
        return result;
    }
}
