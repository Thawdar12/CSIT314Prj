package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminSearchUserController {
    private final UserEntity userEntity;

    public AdminSearchUserController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @GetMapping(value = "/InfinityNetwork/admin/searchUser")
    public List<UserEntity> adminSearchUser(@RequestParam String criteria,
                                            @RequestParam String value) {
        //Biz logic, if any

        //Pass info to Entity
        List<UserEntity> result = this.userEntity.searchUser(criteria, value);

        //Get back from Entity class
        return result;
    }
}
