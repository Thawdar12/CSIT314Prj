package org.example.csit314bce.Controllers;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserIDByUsernameController {
    private final UserEntity userEntity;

    public GetUserIDByUsernameController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @GetMapping("/InfinityNetwork/user/getID")
    public String getUserID(@RequestParam String username) {
        return this.userEntity.getID(username);
    }
}
