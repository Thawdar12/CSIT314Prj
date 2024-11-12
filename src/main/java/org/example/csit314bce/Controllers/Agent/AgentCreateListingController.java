package org.example.csit314bce.Controllers.Agent;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AgentCreateListingController {
    private final CarListingEntity carListingEntity;

    public AgentCreateListingController(CarListingEntity carListingEntity) {
        this.carListingEntity = carListingEntity;
    }

    @PostMapping(value = "/InfinityNetwork/agent/createListing", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String agentCreateListing(
            @RequestPart("listing") CarListingEntity listing,
            @RequestPart(value = "photo", required = false) MultipartFile photo) {
        //Biz logic, if any

        //Pass data to Entity
        String result = carListingEntity.createListing(photo, listing);

        // Call the createListing method
        return result;
    }
}
