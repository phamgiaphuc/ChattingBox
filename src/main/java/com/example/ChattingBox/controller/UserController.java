package com.example.ChattingBox.controller;

import com.example.ChattingBox.models.UserModel;
import com.example.ChattingBox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/chatting-box/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/testing")
    public List<UserModel> testingRoute() {
        return userService.testingRoute();
    }

    @PostMapping(path = "/register")
    public void registerNewUserAccount(@RequestBody UserModel newUser) {
        userService.addNewUser(newUser);
    }
}
