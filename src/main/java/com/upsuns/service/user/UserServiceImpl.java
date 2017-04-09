package com.upsuns.service.user;

import com.upsuns.function.CropperUtils;
import com.upsuns.function.TextUtils;
import com.upsuns.mapper.node.NodeMapper;
import com.upsuns.mapper.user.UserMapper;
import com.upsuns.po.node.Node;
import com.upsuns.po.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

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
    public void register(String username, String password, String nickname) throws Exception{

        User user = new User(username, password, nickname);
        user.setRegister(new Date().getTime());

        //add user
        userMapper.insertUser(user);

        //create user node root
        Node root = new Node();
        root.setUid(user.getId());
        root.setType("root");
        root.setName("根目录");
        nodeMapper.insertNode(root);

        //create user favorite folder
        Node favorite = new Node();
        favorite.setUid(user.getId());
        favorite.setType("folder");
        favorite.setName("我最喜欢的");
        nodeMapper.insertNode(favorite);

        //build link
        nodeMapper.buildPreLink(user.getId(), favorite.getId(), root.getId());

    }

    public boolean uploadUserImage(MultipartFile file, String json, String saveRoot, String username)
            throws Exception{

        CropperUtils cropperUtils = new CropperUtils();
        cropperUtils.parseJson(json);
        User user = userMapper.selectByUserName(username);

        String type = TextUtils.getFileSuffix(file.getOriginalFilename());
        if(user == null) return false;

        String savePath = saveRoot + user.getId() + "." + type;
        File saveFile = new File(savePath);
        file.transferTo(saveFile);

        return true;
    }
}
