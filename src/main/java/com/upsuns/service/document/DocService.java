package com.upsuns.service.document;

import com.upsuns.po.document.Document;
import com.upsuns.po.user.User;

/**
 * Created by KinderRiven on 2017/2/28.
 */
public interface DocService {

    //upload file
    public void uploadFile(Document document, User user) throws Exception;

}
