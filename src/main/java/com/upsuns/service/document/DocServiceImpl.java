package com.upsuns.service.document;

import com.upsuns.mapper.document.DocMapper;
import com.upsuns.mapper.node.NodeMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.node.Node;
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

    @Autowired
    private NodeMapper nodeMapper;

    //upload node
    public void uploadFile(MultipartFile file, Document document, User user, Node node) throws Exception{
        //save node
        File saveFile = new File(document.getPath());
        file.transferTo(saveFile);

        //read node
        //String fileText = TextUtils.getTextUtils().getFileText(document.getPath());
        //System.out.println(fileText);

        //add document info
        docMapper.insertDoc(document);

        //add node
        node.setFid(document.getId());
        nodeMapper.insertNode(node);

    }
}
