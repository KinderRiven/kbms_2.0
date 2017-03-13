package com.upsuns.algorithm.automation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KinderRiven on 2017/3/13.
 */
final class AsciiNode extends AbstractNode implements Node {


    private static final char FROM = 32;
    private static final char TO = 126;
    private final Node[] children;


    public AsciiNode() {
        super();
        this.children = new Node[TO - FROM + 1];
    }

    public AsciiNode(Node parent, char value) {
        super(parent, value);
        this.children = new Node[TO - FROM + 1];
    }

    @Override
    public Node childOf(char c) {
        if (c >= FROM && c <= TO)
            return children[(int) c - FROM];
        else return null;
    }

    @Override
    public void add(Node child) {
        int index = (int) child.value();
        children[index - FROM] = child;
    }

    @Override
    public List<Node> children() {
        List<Node> nodes = new ArrayList<Node>();
        for (Node child : children)
            if (child != null)
                nodes.add(child);
        return nodes;
    }
}