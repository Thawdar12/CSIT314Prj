package org.example.csit314bce.Controllers.Buyer;

import org.example.csit314bce.Entity.CarListingEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerRecordViewController {

    private final CarListingEntity carListingEntity;

    public BuyerRecordViewController(CarListingEntity carListingEntity) {
        this.carListingEntity = carListingEntity;
    }

    @PostMapping(value = "/InfinityNetwork/buyer/recordView", consumes = "application/json")
    public String buyerRecordView(@RequestBody String carPlateNumber) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.carListingEntity.recordView(carPlateNumber);

        //Get back from Entity class
        return result;
    }
}