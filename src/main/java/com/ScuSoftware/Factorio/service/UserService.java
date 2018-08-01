package com.ScuSoftware.Factorio.service;

import com.ScuSoftware.Factorio.model.Member;
import com.ScuSoftware.Factorio.model.User;

public interface UserService {

     User getUserByID(int id);

     int register(User user) throws InterruptedException;

     int register(User user,Member member) ;

     User login(String email,String password);

     User getUserByEmail(String email);

     User auth(String accessToken);
}
