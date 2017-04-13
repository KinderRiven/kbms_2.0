package com.upsuns.service.set;

import com.upsuns.function.CropperUtils;
import com.upsuns.function.TextUtils;
import com.upsuns.mapper.set.BookSetMapper;
import com.upsuns.mapper.user.UserMapper;
import com.upsuns.po.set.BookSet;
import com.upsuns.po.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by KinderRiven on 2017/4/7.
 */
public class SetServiceImpl implements SetService{

    @Autowired
    BookSetMapper bookSetMapper;

    @Autowired
    UserMapper userMapper;

    public void createBookSet(String name, String description, String username) throws Exception{

        User user = userMapper.selectByUserName(username);

        if(user != null) {
            BookSet bookSet = new BookSet(name, description, user.getId());
            bookSetMapper.insertBookSet(bookSet);
        }
    }

    public List<BookSet> getBookSetByUserName(String username) throws Exception{

        User user = userMapper.selectByUserName(username);
        if(user != null) {
            return bookSetMapper.selectBookSetByUserId(user.getId());
        }
        else
            return null;
    }

    public List<BookSet> getBookSetByUserId(Integer uid) throws Exception{
        return bookSetMapper.selectBookSetByUserId(uid);
    }

    public BookSet getBookSetById(Integer id) throws Exception{
        return bookSetMapper.selectBookSetById(id);
    }

    public boolean uploadSetImage(MultipartFile file, String json, String saveRoot) throws Exception{

        CropperUtils cropperUtils = new CropperUtils();
        cropperUtils.parseJson(json);

        String type = TextUtils.getFileSuffix(file.getOriginalFilename());

        String savePath = saveRoot + cropperUtils.getSid() + ".jpg";
        cropperUtils.readUsingImageReader(file.getInputStream(), savePath);
        //File saveFile = new File(savePath);
        //file.transferTo(saveFile);

        return true;
    }
}

