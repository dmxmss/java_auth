package com.example.java_auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_auth.repository.User;
import com.example.java_auth.service.UserService;

@RestController
@RequestMapping(path = "api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{name}")
    public User getUserInfo(String name) {
        
        return userService.getUserInfoByName(name);
    }

    @PostMapping
    public User createUser(@RequestBody String name, @RequestBody String password) {
        return userService.createUser(name, password);
    }
}
