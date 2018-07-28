package com.ScuSoftware.Factorio.service.Impl;

import com.ScuSoftware.Factorio.dao.UserMapper;
import com.ScuSoftware.Factorio.model.User;
import com.ScuSoftware.Factorio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void print(int a) {
       /* User user = userMapper.selectByPrimaryKey(a);
        if(user!=null)
        System.out.println(user.getUserName());
        else System.out.println("有问题");*/

    }

    @Override
    public User getUserByEmail(String email) {
/*        UserExample userExample = new UserExample();
        UserExample.Criteria cri = userExample.createCriteria();
        if (null != username) {
            cri.andUserNameEqualTo(username);
        }
        List<User> userList = userMapper.selectByExample(userExample);
      //  return userList.get(0);*/
        return userMapper.selectByPrimaryKey(email);
    }

    @Override
    public int register(User user) {
        return userMapper.insert(user);
    }
}
