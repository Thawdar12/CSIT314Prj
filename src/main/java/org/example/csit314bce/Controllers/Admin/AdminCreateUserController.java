package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminCreateUserController {
    private final UserEntity userEntity;

    public AdminCreateUserController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @PostMapping(value = "/InfinityNetwork/admin/createUser", consumes = "application/json")
    public String adminCreateUser(@RequestBody UserEntity user) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.userEntity.createUser(user);

        //Get back from Entity class
        return result;
    }
}
