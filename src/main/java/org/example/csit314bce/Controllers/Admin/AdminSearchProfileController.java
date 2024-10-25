package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminSearchProfileController {
    private final UserEntity userEntity;

    public AdminSearchProfileController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String adminSearchProfile() {
        //Biz logic, if any

        //Pass info to Entity

        //Get back from Entity

        return null;
    }
}
