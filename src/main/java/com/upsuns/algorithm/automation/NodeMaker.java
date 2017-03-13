package com.upsuns.algorithm.automation;

/**
 * Created by KinderRiven on 2017/3/13.
 */
public interface NodeMaker {

    Node make(Node parent, char value);

    Node makeRoot();
}
