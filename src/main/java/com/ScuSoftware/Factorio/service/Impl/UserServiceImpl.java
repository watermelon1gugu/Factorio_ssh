package com.ScuSoftware.Factorio.service.Impl;

import com.ScuSoftware.Factorio.dao.MemberMapper;
import com.ScuSoftware.Factorio.dao.UserMapper;
import com.ScuSoftware.Factorio.model.Member;
import com.ScuSoftware.Factorio.model.User;
import com.ScuSoftware.Factorio.model.UserExample;
import com.ScuSoftware.Factorio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private MemberMapper memberMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper,MemberMapper memberMapper){
        this.userMapper = userMapper;
        this.memberMapper = memberMapper;
    }
    @Override
    public User getUserByID(int id) {
/*        UserExample userExample = new UserExample();
        UserExample.Criteria cri = userExample.createCriteria();
        if (null != username) {
            cri.andUserNameEqualTo(username);
        }
        List<User> userList = userMapper.selectByExample(userExample);
      //  return userList.get(0);*/
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int register(User user)  {
            return userMapper.insert(user);
    }

    @Override
    public int register(User user, Member member) {
        if(member!=null) {
            user.setStudentId(member.getStudentId());
            return memberMapper.insert(member) * userMapper.insert(user);
        }else return register(user);
    }

    @Override
    public User login(String email, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria cri = userExample.createCriteria();
        if(null != email && null != password){
            cri.andEmailEqualTo(email);
            cri.andPasswordEqualTo(password);
        }
        List<User> list = userMapper.selectByExample(userExample);
        return list.size()==1?list.get(0):null;
    }

    @Override
    public User getUserByEmail(String email) {
        UserExample userExample = new UserExample();
        UserExample.Criteria cri = userExample.createCriteria();
        if (null != email) {
            cri.andEmailEqualTo(email);
        }
       return userMapper.selectByExample(userExample).get(0);
    }
}
