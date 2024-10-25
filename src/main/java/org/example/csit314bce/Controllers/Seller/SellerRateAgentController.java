package org.example.csit314bce.Controllers.Seller;

import org.example.csit314bce.Entity.ReviewEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerRateAgentController {
    private final ReviewEntity reviewEntity;

    public SellerRateAgentController(ReviewEntity reviewEntity) {
        this.reviewEntity = reviewEntity;
    }

    @PostMapping(value = "/InfinityNetwork/seller/rateAgent", consumes = "application/json")
    public String sellerRateAgent(@RequestBody ReviewEntity review) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.reviewEntity.rateAgent(review);

        //Get back from Entity class
        return result;
    }
}
