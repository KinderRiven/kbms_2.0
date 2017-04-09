package com.upsuns.service.set;

import com.upsuns.mapper.node.NodeMapper;
import com.upsuns.mapper.set.SetMapMapper;
import com.upsuns.mapper.user.UserMapper;
import com.upsuns.po.node.Node;
import com.upsuns.po.set.SetMap;
import com.upsuns.po.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Created by KinderRiven on 2017/4/8.*/
public class SetMapServiceImpl implements SetMapService{

    @Autowired
    private SetMapMapper setMapMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NodeMapper nodeMapper;

    public void addNodeToSet(Integer nodeId, Integer setId, String username) throws Exception{

        User user = userMapper.selectByUserName(username);

        if(user != null) {

            SetMap setMap = new SetMap();
            setMap.setNodeId(nodeId);
            setMap.setSetId(setId);
            Long time = new Date().getTime();
            setMap.setTime(time);
            setMapMapper.insertSetMap(setMap);
        }
    }

    public List<Node> getNodeFromSet(Integer setId) throws Exception{

        List<SetMap> setMaps = setMapMapper.selectMapBySetId(setId);
        List<Node> nodes = new ArrayList<Node>();

        for(SetMap setMap : setMaps){

            Integer nodeId = setMap.getNodeId();
            Node node = nodeMapper.selectNodeById(nodeId);
            nodes.add(node);
        }

        return nodes;
    }
}
