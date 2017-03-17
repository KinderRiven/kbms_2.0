package com.upsuns.service.document;

import com.upsuns.po.document.Document;
import com.upsuns.po.node.Node;
import com.upsuns.po.user.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/*
 * Created by KinderRiven on 2017/2/28.
 */
public interface DocService {

    //upload node
    public Document uploadFile(MultipartFile file, String savePath,
                           String username, String password, Integer curId) throws Exception;


    public List<Document> solrQueryDocument(String query) throws Exception;

    public Document getDocument(Integer id) throws Exception;
}
