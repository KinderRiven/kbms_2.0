package com.upsuns.service.node;

import com.upsuns.mapper.document.DocMapper;
import com.upsuns.mapper.node.NodeMapper;
import com.upsuns.mapper.user.UserMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.node.Node;
import com.upsuns.po.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by KinderRiven on 2017/3/1.
 */
public class NodeServiceImpl implements  NodeService{

    @Autowired
    private NodeMapper nodeMapper;
    @Autowired
    private DocMapper docMapper;
    @Autowired
    private UserMapper userMapper;

    public List<Node> getFolderList(String username, String password, Integer nid) throws Exception{

        User user = userMapper.selectByUserName(username);
        List<Node> nodeList = nodeMapper.selectNodeByPre(user.getId(), nid);
        return nodeList;
    }

    public Integer getPreNodeId(Integer nid) throws Exception{

        Node node = nodeMapper.selectNodeById(nid);
        Integer pre = node.getPre();
        return pre;
    }

    public Node getRootNode(String username, String password) throws Exception{

        User user = userMapper.selectByUserName(username);
        Node node = nodeMapper.selectRootNode(user.getId());
        return node;
    }

    public boolean buildFolder(String username, String password, String name, Integer cid) throws Exception{

        User user = userMapper.selectByUserName(username);

        Node node = new Node();
        node.setName(name);
        node.setPre(cid);
        node.setBuildTime(new Date().getTime());
        node.setType("folder");
        node.setModifyTime(new Date().getTime());
        node.setUid(user.getId());
        nodeMapper.insertNode(node);
        return true;
    }
}
