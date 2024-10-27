package org.example.csit314bce.Controllers.Agent;

import org.example.csit314bce.Entity.ReviewEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgentFetchRatingController {
    private final ReviewEntity reviewEntity;

    public AgentFetchRatingController(ReviewEntity reviewEntity) {
        this.reviewEntity = reviewEntity;
    }

    @GetMapping("/InfinityNetwork/agent/fetchRating")
    public List<ReviewEntity> AgentFetchRating(@RequestParam int agentUserID) {
        //Biz logic, if any

        //Pass data to Entity
        List<ReviewEntity> result = this.reviewEntity.fetchRating(agentUserID);

        //Get Back from Entity
        return result;
    }
}
