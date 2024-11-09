package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.ProfileEntity;
import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminSearchProfileController {
    private final ProfileEntity profileEntity;

    public AdminSearchProfileController(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

    @GetMapping("/InfinityNetwork/admin/searchProfile")
    public List<ProfileEntity> adminSearchProfile(@RequestParam String profileName) {
        //Biz logic, if any

        //Pass info to Entity
        List<ProfileEntity> result = profileEntity.searchProfileByName(profileName);
        //Get back from Entity

        return result;
    }
}
