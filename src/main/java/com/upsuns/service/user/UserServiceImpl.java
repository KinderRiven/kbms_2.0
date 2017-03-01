package com.upsuns.service.user;

import com.upsuns.mapper.node.NodeMapper;
import com.upsuns.mapper.user.UserMapper;
import com.upsuns.po.node.Node;
import com.upsuns.po.user.User;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Created by KinderRiven on 2017/2/26.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NodeMapper nodeMapper;

    //user login
    public User login(String username, String password) throws Exception{
        User user = userMapper.selectByUserName(username);
        return user;
    }

    //user register
    public void register(User user) throws Exception{

        //add user
        userMapper.insertUser(user);

        //create user node root
        Node root = new Node();
        root.setUid(user.getId());
        root.setType("root");
        root.setFname("根目录");
        nodeMapper.insertNode(root);

        //create user favorite folder
        Node favorite = new Node();
        favorite.setUid(user.getId());
        favorite.setType("folder");
        favorite.setFname("我最喜欢的");
        nodeMapper.insertNode(favorite);

        //build link
        nodeMapper.buildNextLink(user.getId(), root.getId(), favorite.getId());
        nodeMapper.buildPreLink(user.getId(), favorite.getId(), root.getId());

    }
}
