package com.example.java_auth.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.java_auth.repository.User;
import com.example.java_auth.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserInfoByName(String name) {
        Optional<User> optUser = userRepository.findByName(name);
        if (optUser.isEmpty()) {
            throw new IllegalStateException("user with name " + name + " not found");
        }

        User user = optUser.get();
        return user;
    }
}
