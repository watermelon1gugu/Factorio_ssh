package com.ScuSoftware.Factorio.service;

import com.ScuSoftware.Factorio.model.User;

public interface UserService {

     void print(int a);


     User getUserByEmail(String email);

     int register(User user);
}
