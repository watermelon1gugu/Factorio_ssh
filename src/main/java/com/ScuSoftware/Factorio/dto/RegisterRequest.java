package com.ScuSoftware.Factorio.dto;

import com.ScuSoftware.Factorio.model.Member;
import com.ScuSoftware.Factorio.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;



public class RegisterRequest {
    private String nickName;
    private String email;
    private String password;
    private String checkCode;
    private String studentID;
    private String name;
    private String passWordAgain;
    private boolean isMember;
    private boolean sex;

    public void print(){
        System.out.println(nickName);
        System.out.println(email);
        System.out.println(password);
        System.out.println(checkCode);
        System.out.println(studentID);
        System.out.println(name);
        System.out.println(sex);
        System.out.println(isMember);
    }

    public String getPassWordAgain() {
        return passWordAgain;
    }

    public void setPassWordAgain(String passWordAgain) {
        this.passWordAgain = passWordAgain;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public boolean isSex() {
        return sex;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setisMember(boolean member) {
        isMember = member;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public boolean isMan() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
    public Member formatToMember(){
        if(isMember) {
            Member member = new Member();
            member.setName(this.name);
            member.setSex(this.sex);
            member.setStudentId(this.studentID);
            return member;
        }else return null;
    }
}
