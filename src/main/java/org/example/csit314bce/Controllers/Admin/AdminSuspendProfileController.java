package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.ProfileEntity;
import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminSuspendProfileController {
    private final ProfileEntity profileEntity;

    public AdminSuspendProfileController(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

    @PostMapping("/InfinityNetwork/admin/suspendUserProfile")
    public String adminDeleteProfile(@RequestParam String profileName,
                                     @RequestParam int value) {
        //Biz logic, if any

        //Pass info to Entity
        String result = profileEntity.suspendProfile(profileName, value);

        //Get back from Entity
        return result;
    }
}
