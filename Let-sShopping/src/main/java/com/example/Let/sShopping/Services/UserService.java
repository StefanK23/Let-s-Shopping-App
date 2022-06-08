package com.example.Let.sShopping.Services;

import com.example.Let.sShopping.models.serviceModels.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUser(String username);

    void login(UserServiceModel userServiceModel);

    void logout();
}
