package org.example.csit314bce.Controllers.Agent;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentDeleteListingController {
    private final CarListingEntity carListingEntity;

    public AgentDeleteListingController(CarListingEntity carListingEntity) {
        this.carListingEntity = carListingEntity;
    }

    @PostMapping(value = "/InfinityNetwork/agent/deleteListing")
    String AgentDeleteListing(@RequestParam String carPlateNumber) {
        //Biz logic, if any

        //Pass data to Entity
        String result = this.carListingEntity.deleteListing(carPlateNumber);
        //Get back from Entity
        return result;
    }
}
