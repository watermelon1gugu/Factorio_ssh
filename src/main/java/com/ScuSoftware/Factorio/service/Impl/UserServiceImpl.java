package com.ScuSoftware.Factorio.service.Impl;

import com.ScuSoftware.Factorio.dao.UserMapper;
import com.ScuSoftware.Factorio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void print(int a) {
        System.out.println(userMapper.selectByPrimaryKey(1).getUsername());

    }
}
