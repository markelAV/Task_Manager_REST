package com.example.controllers;

import com.example.models.User;
import com.example.services.AuthorizationService;
import com.example.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task-api/user")
public class UserController {
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        AuthorizationService authorizationService = new AuthorizationService();
        if (user != null) {
            String token = authorizationService.login(user);
            if (token != null) {
                //Todo set Token
                return new ResponseEntity(token, HttpStatus.OK);
            } else {
                return new ResponseEntity("Invalid credentials", HttpStatus.OK);
            }
        }
        return new ResponseEntity("Error: Invalid parameter of request", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody User user) {
        UserService userService = new UserService();
        if (user != null) {
            String idUser = userService.addUser(user);
            if (idUser != null) {
                //Todo set Token
                return new ResponseEntity(user.getId(), HttpStatus.OK);
            } else {
                return new ResponseEntity("Error created", HttpStatus.OK);
            }
        }
        return new ResponseEntity("Error: Invalid parameter of request", HttpStatus.BAD_REQUEST);

    }
}
