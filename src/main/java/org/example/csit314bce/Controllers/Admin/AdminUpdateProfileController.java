package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.ProfileEntity;
import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminUpdateProfileController {
    private final ProfileEntity profileEntity;

    public AdminUpdateProfileController(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

    @PostMapping(value = "/InfinityNetwork/admin/updateProfile")
    String adminUpdateProfile(@RequestParam String oldProfileName,
                              @RequestBody ProfileEntity updatedProfileEntity) {
        //Biz logic, if any

        //Pass info to Entity
        String result = profileEntity.updateProfile(oldProfileName, updatedProfileEntity);

        //Get back from Entity
        return result;
    }
}
