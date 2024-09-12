package com.sallypig.springboot_mall.dao;

import com.sallypig.springboot_mall.dto.UserRegisterRequest;
import com.sallypig.springboot_mall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
