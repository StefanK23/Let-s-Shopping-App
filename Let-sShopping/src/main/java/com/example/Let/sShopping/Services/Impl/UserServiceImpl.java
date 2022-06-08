package com.example.Let.sShopping.Services.Impl;

import com.example.Let.sShopping.CurrentUser;
import com.example.Let.sShopping.Repositories.UserRepository;
import com.example.Let.sShopping.Services.UserService;
import com.example.Let.sShopping.models.entities.UserEntity;
import com.example.Let.sShopping.models.serviceModels.UserServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapperl, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapperl;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);
        userRepository.save(userEntity);

    }

    @Override
    public UserServiceModel findUser(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        return user.map(u -> modelMapper.map(u, UserServiceModel.class)).orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId()).setUsername(userServiceModel.getUsername());
    }

    @Override
    public void logout() {
        currentUser.setId(null).setUsername(null);
    }
}
