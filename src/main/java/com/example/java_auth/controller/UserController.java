package com.example.java_auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_auth.dto.CreateUserRequestDto;
import com.example.java_auth.dto.UserDto;
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
    public UserDto getUserInfo(@PathVariable String name) {
        
        return userService.getUserInfoByName(name);
    }

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserRequestDto user) {
        return userService.createUser(user.getName(), user.getPassword());
    }
}
