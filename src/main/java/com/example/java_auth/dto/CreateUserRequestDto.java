package com.example.java_auth.dto;

public class CreateUserRequestDto {
    String name; 
    String password;

    public CreateUserRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
}
