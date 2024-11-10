package org.example.csit314bce.Controllers.Buyer;

import org.example.csit314bce.Entity.CarListingEntity;
import org.example.csit314bce.Entity.FavouriteEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyerFetchAllFavController {
    private final FavouriteEntity favouriteEntity;

    public BuyerFetchAllFavController(FavouriteEntity favouriteEntity){
        this.favouriteEntity = favouriteEntity;
    }

    @GetMapping("/InfinityNetwork/buyer/fetchBuyerFavorites")
    public List<FavouriteEntity> fetchAllFavourites(@RequestParam long BuyerID) {
        //Biz logic, if any

        //Pass data to controller
        List<FavouriteEntity> result = this.favouriteEntity.fetchBuyerFavorites(BuyerID);

        //Get back from Controller
        return result;
    }
}
