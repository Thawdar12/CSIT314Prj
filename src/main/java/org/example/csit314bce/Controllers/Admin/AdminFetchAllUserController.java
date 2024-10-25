package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminFetchAllUserController {
    private final UserEntity userEntity;

    public AdminFetchAllUserController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @GetMapping("/InfinityNetwork/admin/fetchAllUser")
    public List<UserEntity> adminFetchAllUser() {
        //Biz logic, if any

        //Request Entity to return all user
        List<UserEntity> result = this.userEntity.fetchAllUsers();

        //Get back from Entity class
        return result;
    }
}
