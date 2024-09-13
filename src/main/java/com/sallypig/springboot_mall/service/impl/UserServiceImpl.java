package com.sallypig.springboot_mall.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.sallypig.springboot_mall.dao.UserDao;
import com.sallypig.springboot_mall.dto.UserLoginRequest;
import com.sallypig.springboot_mall.dto.UserRegisterRequest;
import com.sallypig.springboot_mall.model.User;
import com.sallypig.springboot_mall.service.UserService;

@Component
public class UserServiceImpl implements UserService {

    private final static org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override //因為還有做檢查等 命名register 非createUser
    public Integer register(UserRegisterRequest userRegisterRequest) {
        // 檢查註冊的 email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if (user != null) {
            log.warn("該 email {} 已被註冊過", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        }

        // 創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());

        if (user == null) {
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        }

        if (userLoginRequest.getPassword().equals(user.getPassword())) {
            return user;
        } else {
            log.warn("該 email {} 的密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        }
    }

}
