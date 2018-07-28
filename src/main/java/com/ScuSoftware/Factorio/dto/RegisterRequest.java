package com.ScuSoftware.Factorio.dto;

import com.ScuSoftware.Factorio.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class RegisterRequest {
    private String nickName;

    private String email;

    private String password;

    private String checkCode;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
    public User formatToUser(){
        User user = new User();
        user.setEmail(this.email);
        user.setNickName(this.nickName);
        user.setPassword(this.password);
        user.setEnable(true);
        user.setIsRoot(false);
        return user;
    }
}
