package org.example.csit314bce.Controllers;

import org.example.csit314bce.Entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
    private final UserEntity userEntity;

    public UserLoginController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @GetMapping(value = "/login", consumes = "application/json")
    public boolean userLogin(@RequestBody UserEntity userEntity) {
        // Biz logic, if any

        // Pass info to Entity
        boolean result = this.userEntity.userLogIn(userEntity);

        // Get back from Entity class
        if (result) {
            System.out.println("Controller: Login Successful");
            return true;
        } else {
            System.out.println("Controller: Login Failed");
            return false;
        }
    }
}
