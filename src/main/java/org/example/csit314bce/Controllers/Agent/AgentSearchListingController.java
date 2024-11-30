package org.example.csit314bce.Controllers.Agent;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentSearchListingController {
    private final CarListingEntity carListingEntity;

    public AgentSearchListingController(CarListingEntity carListingEntity) {
        this.carListingEntity = carListingEntity;
    }

    @GetMapping(value = "/InfinityNetwork/agent/searchListing")
    public List<CarListingEntity> agentSearchListing(@RequestParam String criteria,
                                                  @RequestParam String value,
                                                     @RequestParam String username) {
        //Biz logic, if any

        //Pass info to Entity
        List<CarListingEntity> result = this.carListingEntity.searchListing(criteria, value, username);

        //Get back from Entity class
        return result;
    }

}


