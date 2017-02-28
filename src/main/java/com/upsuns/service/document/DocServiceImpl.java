package com.upsuns.service.document;

import com.upsuns.mapper.document.DocMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.user.User;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Created by KinderRiven on 2017/2/28.
 */
public class DocServiceImpl implements DocService{

    @Autowired
    private DocMapper docMapper;

    //upload file
    public void uploadFile(Document document, User user) throws Exception{
            docMapper.insertDoc(document);
    }
}
