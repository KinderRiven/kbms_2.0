package com.upsuns.service.set;

import com.upsuns.po.node.Node;
import com.upsuns.po.set.SetMap;

import java.util.List;

/**
 * Created by KinderRiven on 2017/4/8.
 */
public interface SetMapService {

    public void addNodeToSet(Integer nodeId, Integer setId, String username) throws Exception;

    public List<Node> getNodeFromSet(Integer setId) throws Exception;
}
