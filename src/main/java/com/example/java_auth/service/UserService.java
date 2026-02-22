package com.example.java_auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.java_auth.repository.User;
import com.example.java_auth.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    public User createUser(String name, String password) {
        if (password.isBlank()) {
            throw new IllegalStateException("invalid password");
        }

        if (name.isBlank()) {
            throw new IllegalStateException("invalid name");
        }

        Optional<User> optUser = userRepository.findByName(name);
        if (optUser.isPresent()) {
            throw new IllegalStateException("user with name " + name + " already exists");
        }

        String hashed = passwordEncoder.encode(password);
        User user = new User(name, hashed);
        user.setScore(0);

        userRepository.save(user);
        return user;
    }
}
