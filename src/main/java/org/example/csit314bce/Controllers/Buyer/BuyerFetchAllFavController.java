package org.example.csit314bce.Controllers.Buyer;

import org.example.csit314bce.Entity.CarListingEntity;
import org.example.csit314bce.Entity.FavoriteEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyerFetchAllFavController {
    private final FavoriteEntity favoriteEntity;

    public BuyerFetchAllFavController(FavoriteEntity favoriteEntity){
        this.favoriteEntity = favoriteEntity;
    }

    @GetMapping("/InfinityNetwork/buyer/fetchAllFavoriteListings")
    public List<CarListingEntity> buyerFetchAllFavorites(@RequestParam String username) {
        //Biz logic, if any

        //Pass data to controller
        List<CarListingEntity> result = this.favoriteEntity.fetchAllFavoriteListings(username);

        //Get back from Controller
        return result;
    }




}
