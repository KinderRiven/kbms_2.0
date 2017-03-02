package com.upsuns.service.node;

import com.upsuns.po.document.Document;
import com.upsuns.po.node.Node;
import com.upsuns.po.user.User;

import java.util.List;

/* Created by KinderRiven on 2017/3/1.*/

public interface NodeService {

    //通过node节点获取节点信息
    public List<Node> getFolderList(User user, Integer nid) throws Exception;

    //获得用户的根目录
    public Node getRootNode(User user) throws Exception;

    //获得上级目录ID
    public Integer getPreNodeId(Integer nid) throws Exception;
}
