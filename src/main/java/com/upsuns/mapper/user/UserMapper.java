package com.upsuns.mapper.user;

import com.upsuns.po.user.User;

/*
 * Created by KinderRiven on 2017/2/26.
 */
public interface UserMapper {

    //select user by user_id
    public User selectByUserId(int userId) throws Exception;

    //select user by user_name
    public User selectByUserName(String userName) throws Exception;

    //insert user
    public void insertUser(User user) throws Exception;
}
