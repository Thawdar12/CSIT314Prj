package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminUpdateUserController {
    private final UserEntity userEntity;

    public AdminUpdateUserController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @PostMapping(value = "/InfinityNetwork/admin/updateUser", consumes = "application/json")
    public String adminUpdateUser(
            @RequestBody UserEntity user,
            @RequestParam String originalUsername) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.userEntity.updateUser(user, originalUsername);

        //Get back from Entity class
        return result;
    }
}
