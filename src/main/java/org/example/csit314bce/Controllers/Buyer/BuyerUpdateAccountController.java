package org.example.csit314bce.Controllers.Buyer;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BuyerUpdateAccountController {

    private final UserEntity userEntity;

    public BuyerUpdateAccountController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @PostMapping(value = "/InfinityNetwork/buyer/updateUser", consumes = "application/json")
    public String agentUpdateAccount(
            @RequestBody UserEntity user,
            @RequestParam String originalUsername) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.userEntity.updateUser(user, originalUsername);

        //Get back from Entity class
        return result;
    }
}
