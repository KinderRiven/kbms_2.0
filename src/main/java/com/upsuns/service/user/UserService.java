package com.upsuns.service.user;

import com.upsuns.po.user.User;
import org.springframework.web.multipart.MultipartFile;

/*
 * Created by KinderRiven on 2017/2/26.
 */
public interface UserService {

    public User login(String username, String password) throws Exception;

    public void register(String username, String password, String nickname) throws Exception;

    public boolean uploadUserImage(MultipartFile file, String json, String saveRoot, String username) throws Exception;
}
