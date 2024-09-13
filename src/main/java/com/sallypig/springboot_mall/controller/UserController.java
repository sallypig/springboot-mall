package com.sallypig.springboot_mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sallypig.springboot_mall.dto.UserLoginRequest;
import com.sallypig.springboot_mall.dto.UserRegisterRequest;
import com.sallypig.springboot_mall.model.User;
import com.sallypig.springboot_mall.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<User> postMethodName(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        Integer userId = userService.register(userRegisterRequest);

        User user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(user);

        // 架構似createProduct
    }

    @PostMapping("/user/login")
    public ResponseEntity<User> postMethodName(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        User user = userService.login(userLoginRequest);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(user);
    }

}
