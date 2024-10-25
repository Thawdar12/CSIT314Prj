package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminDeleteProfileController {
    private final UserEntity userEntity;

    public AdminDeleteProfileController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @PostMapping("/InfinityNetwork/admin/deleteProfile")
    public String adminDeleteProfile(@RequestParam String profileName) {
        //Biz logic, if any

        //Pass info to Entity
        String result = userEntity.deleteProfile(profileName);

        //Get back from Entity
        return result;
    }
}
