package com.sallypig.springboot_mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sallypig.springboot_mall.dao.UserDao;
import com.sallypig.springboot_mall.dto.UserRegisterRequest;
import com.sallypig.springboot_mall.model.User;
import com.sallypig.springboot_mall.service.UserService;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

}
