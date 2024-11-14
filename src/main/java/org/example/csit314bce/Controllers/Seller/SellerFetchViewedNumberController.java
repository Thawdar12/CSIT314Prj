package org.example.csit314bce.Controllers.Seller;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SellerFetchViewedNumberController {

    private final CarListingEntity carListingEntity;

    public SellerFetchViewedNumberController(CarListingEntity carListingEntity) {
        this.carListingEntity = carListingEntity;
    }

    @GetMapping(value = "/InfinityNetwork/seller/fetchViewCountForSellerListings")
    public Map<String, Integer> sellerFetchViewedNumber(
            @RequestParam String username) {
        //Biz logic, if any

        //Pass info to Entity
        Map<String, Integer> result = this.carListingEntity.fetchViewCountForSellerListings(username);

        //Get back from Entity class
        return result;
    }
}