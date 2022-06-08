package com.example.Let.sShopping.models.bindings;

import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {

    @Length(min = 3, message = "Username must be between 3 and 20 characters")
    private String username;

    @Length(min = 3, message = "Password must be between 3 and 20 characters")
    private String password;


    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
