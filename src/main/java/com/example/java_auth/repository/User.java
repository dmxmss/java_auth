package com.example.java_auth.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name;
    private Integer score;
    private String hashedPassword;

    public User(Long id, String name, Integer score, String hashedPassword) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.hashedPassword = hashedPassword;
    }

    public User(String name, String hashedPassword) {
        this.name = name;
        this.hashedPassword = hashedPassword;
    }

    public User() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
