package com.upsuns.algorithm.automation;

import java.util.List;

/*Created by KinderRiven on 2017/3/13. */
interface Node {

    char value();

    boolean exists();

    boolean isRoot();

    Node parent();

    Node childOf(char c);

    Node fail();

    void setFail(Node node);

    void setExists(boolean exists);

    void add(Node child);

    List<Node> children();
}