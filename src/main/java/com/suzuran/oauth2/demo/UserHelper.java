package com.suzuran.oauth2.demo;

import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

public class UserHelper extends User {
    private String id;
    private String username;
    private String email;

    public UserHelper(UserEntity userEntity) {
        super(userEntity.getUsername(), userEntity.getPassword(), new ArrayList<>());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserHelper{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
