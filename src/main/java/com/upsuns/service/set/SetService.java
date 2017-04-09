package com.upsuns.service.set;

import com.upsuns.po.set.BookSet;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by KinderRiven on 2017/4/7.
 */
public interface SetService {

    public void createBookSet(String name, String description, String username) throws Exception;

    public List<BookSet> getBookSetByUserName(String username) throws Exception;

    public List<BookSet> getBookSetByUserId(Integer uid) throws Exception;

    public BookSet getBookSetById(Integer id) throws Exception;

    public boolean uploadSetImage(MultipartFile file, String json, String saveRoot) throws Exception;
}
