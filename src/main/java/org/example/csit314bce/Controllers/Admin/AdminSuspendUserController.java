package org.example.csit314bce.Controllers.Admin;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminSuspendUserController {
    private final UserEntity userEntity;

    public AdminSuspendUserController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @PostMapping(value = "/InfinityNetwork/admin/suspendUser")
    public String adminSuspendUser(
            @RequestParam String username,
            @RequestParam int value) {
        //Biz logic, if any

        //Pass info to Entity
        String result = this.userEntity.suspendUser(username, value);

        //Get back from Entity class
        return result;
    }
}
