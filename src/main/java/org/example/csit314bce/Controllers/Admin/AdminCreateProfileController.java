package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminCreateProfileController {
    private final UserEntity userEntity;

    public AdminCreateProfileController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @PostMapping(value = "/InfinityNetwork/admin/createProfile")
    public String createProfile(@RequestParam String profileName) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.userEntity.createProfile(profileName);

        //Get back from Entity
        return result;
    }
}
