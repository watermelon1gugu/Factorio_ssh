package com.ScuSoftware.Factorio.service;

import com.ScuSoftware.Factorio.model.User;

public interface UserService {

     User getUserByID(int id);

     int register(User user);
}
