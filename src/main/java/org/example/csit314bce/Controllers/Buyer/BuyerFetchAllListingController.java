package org.example.csit314bce.Controllers.Buyer;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyerFetchAllListingController {

    private final CarListingEntity carListing;

    public BuyerFetchAllListingController(CarListingEntity carListing) {
        this.carListing = carListing;
    }

    @GetMapping("/InfinityNetwork/buyer/fetchAllListing")
    public List<CarListingEntity> fetchAllListings() {
        //Biz logic, if any

        //Pass data to controller
        List<CarListingEntity> result = this.carListing.fetchAllListing();

        //Get back from Controller
        return result;
    }
}

