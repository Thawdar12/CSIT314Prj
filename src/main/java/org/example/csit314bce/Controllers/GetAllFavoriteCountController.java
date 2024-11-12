package org.example.csit314bce.Controllers;

import org.example.csit314bce.Entity.FavoriteEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetAllFavoriteCountController {
    private final FavoriteEntity favoriteEntity;

    public GetAllFavoriteCountController(FavoriteEntity favoriteEntity) {
        this.favoriteEntity = favoriteEntity;
    }

    @GetMapping("/InfinityNetwork/user/getFavoriteCountForAllListings")
    public Map<String, Integer> getAllFavoriteCount() {
        //Biz logic, if any

        //Pass data to controller
        Map<String, Integer> result = this.favoriteEntity.getFavoriteCountForAllListings();

        //Get back from Controller
        return result;
    }
}

