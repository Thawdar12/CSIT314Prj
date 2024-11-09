package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.ProfileEntity;
import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminCreateProfileController {
    private final ProfileEntity profileEntity;

    public AdminCreateProfileController(ProfileEntity profileEntity) {
        this.profileEntity  = profileEntity;
    }

    @PostMapping(value = "/InfinityNetwork/admin/createProfile", consumes = "application/json")
    public String createProfile(@RequestBody ProfileEntity profile) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.profileEntity.createProfile(profile);

        //Get back from Entity
        return result;
    }
}
