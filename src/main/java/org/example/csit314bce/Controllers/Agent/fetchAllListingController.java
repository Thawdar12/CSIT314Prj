package org.example.csit314bce.Controllers.Agent;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class fetchAllListingController {
    private final CarListingEntity carListing;

    public fetchAllListingController(CarListingEntity carListing) {
        this.carListing = carListing;
    }

    @GetMapping("/InfinityNetwork/agent/fetchAllListing")
    public List<CarListingEntity> fetchAllListings() {
        //Biz logic, if any

        //Pass data to controller
        List<CarListingEntity> result = this.carListing.fetchAllListing();

        //Get back from Controller
        return result;
    }
}
