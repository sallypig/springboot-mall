package com.sallypig.springboot_mall.service;

import com.sallypig.springboot_mall.dto.UserLoginRequest;
import com.sallypig.springboot_mall.dto.UserRegisterRequest;
import com.sallypig.springboot_mall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
