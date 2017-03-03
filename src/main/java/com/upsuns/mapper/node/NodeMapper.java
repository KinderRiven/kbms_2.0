package com.upsuns.mapper.node;

/* Created by KinderRiven on 2017/3/1. */

import com.upsuns.po.node.Node;

import java.util.List;

public interface NodeMapper {

    //inset node
    public void insertNode(Node node) throws Exception;

    //build next-link
    public void buildNextLink(Integer uid, Integer from, Integer to) throws Exception;

    //build pre-link
    public void buildPreLink(Integer uid, Integer from, Integer to) throws Exception;

    //select node by pre
    public List<Node> selectNodeByPre(Integer uid, Integer pre) throws Exception;

    //select root node
    public Node selectRootNode(Integer uid) throws Exception;

    //
    public Node selectNodeById(Integer id) throws Exception;

}
