package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminUpdateProfileController {
    private final UserEntity userEntity;

    public AdminUpdateProfileController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @PostMapping(value = "/InfinityNetwork/admin/updateProfile")
    String adminUpdateProfile(@RequestParam String oldProfileName,
                              @RequestParam String newProfileName) {
        //Biz logic, if any

        //Pass info to Entity
        String result = userEntity.updateProfile(oldProfileName, newProfileName);

        //Get back from Entity
        return result;
    }
}
