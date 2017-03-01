package com.upsuns.service.node;

import com.upsuns.mapper.document.DocMapper;
import com.upsuns.mapper.node.NodeMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.node.Node;
import com.upsuns.po.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KinderRiven on 2017/3/1.
 */
public class NodeServiceImpl implements  NodeService{

    @Autowired
    private NodeMapper nodeMapper;
    @Autowired
    private DocMapper docMapper;

    public List<Document> getFolderList(User user, Integer nid) throws Exception{

        List<Document> docList = new ArrayList<Document>();
        List<Node> nodeList = nodeMapper.selectNodeByPre(user.getId(), nid);

        for(Node node : nodeList){
            if(node.getFid() != null && node.getFid() != -1) {
                Document doc = docMapper.selectDocByDocId(node.getFid());
                if(doc != null){
                    docList.add(doc);
                }
            }
        }
        return docList;
    }

    public Node getRootNode(User user) throws Exception{

        Node node = nodeMapper.selectRootNode(user.getId());
        return node;
    }
}
