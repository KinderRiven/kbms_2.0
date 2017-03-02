package com.upsuns.service.document;

import com.upsuns.function.TextUtils;
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
    public void uploadFile(MultipartFile file, String savePath, User user, Integer curId)
            throws Exception{

        //save node
        Document document = new Document(file.getOriginalFilename(), savePath);
        String type = TextUtils.getTextUtils().getFileSuffix(document.getName());
        if(type != null)
            document.setType(type);
        else
            document.setType("file");
        File saveFile = new File(document.getPath());
        file.transferTo(saveFile);

        //read node
        //String fileText = TextUtils.getTextUtils().getFileText(document.getPath());
        //System.out.println(fileText);

        //add document info
        docMapper.insertDoc(document);

        //add node
        //new node
        Node node = new Node();
        node.setUid(user.getId());
        if(type != null)
            node.setType(type);
        else
            node.setType("file");
        node.setPre(curId);
        node.setFileId(document.getId());
        node.setName(document.getName());
        nodeMapper.insertNode(node);

    }
}
