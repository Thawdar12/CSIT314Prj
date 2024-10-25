package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminFetchAllProfileController {
    private final UserEntity userEntity;

    public AdminFetchAllProfileController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @GetMapping("/InfinityNetwork/admin/fetchAllProfile")
    public List<String> adminFetchAllProfile() {
        //Biz logic, if any

        //Pass into to Entity
        List<String> result = userEntity.fetchALlProfile();

        //Get back from Entity
        return result;
    }
}
