package com.sallypig.springboot_mall.dto;

import jakarta.validation.constraints.NotBlank;

public class UserRegisterRequest {

    @NotBlank //不能是空字串
    private String email;

    @NotBlank
    private String password;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
