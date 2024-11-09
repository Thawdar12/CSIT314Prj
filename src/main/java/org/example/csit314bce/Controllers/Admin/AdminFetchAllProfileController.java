package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.ProfileEntity;
import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminFetchAllProfileController {
    private final ProfileEntity profileEntity;

    public AdminFetchAllProfileController(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

    @GetMapping("/InfinityNetwork/admin/fetchAllProfile")
    public List<ProfileEntity> adminFetchAllProfile() {
        //Biz logic, if any

        //Pass into to Entity
        List<ProfileEntity> result = profileEntity.fetchAllProfile();

        //Get back from Entity
        return result;
    }
}
