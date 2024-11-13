package org.example.csit314bce.Controllers.Seller;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SellerFetchViewedNumberController {

    private final CarListingEntity carListingEntity;

    public SellerFetchViewedNumberController(CarListingEntity carListingEntity) {
        this.carListingEntity = carListingEntity;
    }

    @PostMapping(value = "/InfinityNetwork/seller/fetchViewCountForSellerListings",
            consumes = "application/json")
    public Map<String, Integer> sellerFetchViewedNumber(
            @RequestBody String carPlateNumber) {
        //Biz logic, if any

        //Pass info to Entity
        Map<String, Integer> result = this.carListingEntity.fetchViewCountForSellerListings(carPlateNumber);

        //Get back from Entity class
        return result;
    }
}