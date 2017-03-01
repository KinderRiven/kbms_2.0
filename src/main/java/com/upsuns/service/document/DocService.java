package com.upsuns.service.document;

import com.upsuns.po.document.Document;
import com.upsuns.po.node.Node;
import com.upsuns.po.user.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by KinderRiven on 2017/2/28.
 */
public interface DocService {

    //upload node
    public void uploadFile(MultipartFile file, Document document, User user, Node node) throws Exception;

}
