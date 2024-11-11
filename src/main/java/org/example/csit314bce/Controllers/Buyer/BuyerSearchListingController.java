package org.example.csit314bce.Controllers.Buyer;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyerSearchListingController {

    private final CarListingEntity carListingEntity;

    public BuyerSearchListingController(CarListingEntity carListingEntity) {
        this.carListingEntity = carListingEntity;
    }

    @GetMapping(value = "/InfinityNetwork/buyer/searchListing")
    public List<CarListingEntity> adminSearchUser(@RequestParam String criteria,
                                                  @RequestParam String value,
                                                  @RequestParam String username) {
        //Biz logic, if any

        //Pass info to Entity
        List<CarListingEntity> result = this.carListingEntity.searchListing(criteria, value, username);

        //Get back from Entity class
        return result;
    }
}
