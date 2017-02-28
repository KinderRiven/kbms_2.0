package com.upsuns.service.user;

import com.upsuns.po.user.User;

/**
 * Created by KinderRiven on 2017/2/26.
 */
public interface UserService {

    public User login(String userName, String password) throws Exception;

    public void register(User user) throws Exception;
}
