package org.example.csit314bce.Controllers.Agent;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AgentUpdateCarListingController {
    private final CarListingEntity carListingEntity;

    public AgentUpdateCarListingController(CarListingEntity carListingEntity) {
        this.carListingEntity = carListingEntity;
    }

    @PostMapping(value = "/InfinityNetwork/agent/updateListing", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String agentUpdateListing(
            @RequestPart("listing") CarListingEntity listing,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestParam String originalCarPlateNumber) {
        //Biz logic, if any

        //Pass data to Entity
        String result = carListingEntity.updateListing(photo, listing, originalCarPlateNumber);

        // Call the createListing method
        return result;
    }
}
