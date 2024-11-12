package org.example.csit314bce.Controllers.Agent;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentFetchAllListingController {
    private final CarListingEntity carListing;

    public AgentFetchAllListingController(CarListingEntity carListing) {
        this.carListing = carListing;
    }

    @GetMapping("/InfinityNetwork/agent/fetchAllListing")
    public List<CarListingEntity> agentFetchAllListings(@RequestParam String username) {
        //Biz logic, if any

        //Pass data to controller
        List<CarListingEntity> result = this.carListing.fetchAllListing(username);

        //Get back from Controller
        return result;
    }
}
