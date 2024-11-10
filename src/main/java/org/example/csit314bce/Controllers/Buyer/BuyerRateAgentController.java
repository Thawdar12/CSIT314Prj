package org.example.csit314bce.Controllers.Buyer;

import org.example.csit314bce.Entity.ReviewEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerRateAgentController {
    private final ReviewEntity reviewEntity;

    public BuyerRateAgentController(ReviewEntity reviewEntity) {
        this.reviewEntity = reviewEntity;
    }

    @PostMapping(value = "/InfinityNetwork/buyer/rateAgent", consumes = "application/json")
    public String buyerRateAgent(@RequestBody ReviewEntity review) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.reviewEntity.rateAgent(review);

        //Get back from Entity class
        return result;
    }
}
