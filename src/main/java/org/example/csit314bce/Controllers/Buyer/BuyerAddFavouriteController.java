package org.example.csit314bce.Controllers.Buyer;
import org.example.csit314bce.Entity.CarListingEntity;
import org.example.csit314bce.Entity.FavouriteEntity;
import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerAddFavouriteController {
    private final FavouriteEntity favouriteEntity;

    public BuyerAddFavouriteController(FavouriteEntity favouriteEntity) {
        this.favouriteEntity = favouriteEntity;
    }

    @PostMapping(value = "/InfinityNetwork/buyer/addFavorite",
            consumes = "application/json")
    public String addFavourite(@RequestBody FavouriteEntity favouriteEntity) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.favouriteEntity.addFavorite(favouriteEntity);

        //Get back from Entity class
        return result;
    }
}
