package org.example.csit314bce.Controllers.Seller;

import org.example.csit314bce.Entity.CarListingEntity;
import org.example.csit314bce.Entity.FavoriteEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SellerFetchFavoritedNumberController {

    private final FavoriteEntity favoriteEntity;

    public SellerFetchFavoritedNumberController(FavoriteEntity favoriteEntity){
        this.favoriteEntity = favoriteEntity;
    }

    @GetMapping("/InfinityNetwork/seller/fetchFavoriteCountForSellerListings")
    public List<CarListingEntity> fetchFavoriteCountForSellerListings(@RequestParam String username) {
        //Biz logic, if any

        //Pass data to controller
        List<CarListingEntity> result = this.favoriteEntity.fetchFavoriteCountForSellerListings(username);

        //Get back from Controller
        return result;
    }




}