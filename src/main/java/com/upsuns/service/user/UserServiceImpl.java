package com.upsuns.service.user;

import com.upsuns.mapper.user.UserMapper;
import com.upsuns.po.user.User;
import com.upsuns.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Created by KinderRiven on 2017/2/26.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //user login
    public User login(String username, String password) throws Exception{

        User user = userMapper.selectByUserName(username);
        return user;

    }

    //user register
    public void register(User user) throws Exception{
        userMapper.insertUser(user);
    }
}
