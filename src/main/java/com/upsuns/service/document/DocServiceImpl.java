package com.upsuns.service.document;

import com.upsuns.mapper.document.DocMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/*
 * Created by KinderRiven on 2017/2/28.
 */
public class DocServiceImpl implements DocService{

    @Autowired
    private DocMapper docMapper;

    //upload file
    public void uploadFile(MultipartFile file, Document document, User user) throws Exception{
        //save file
        File saveFile = new File(document.getPath());
        file.transferTo(saveFile);

        //read file

        //mysql solver
        docMapper.insertDoc(document);
    }
}
