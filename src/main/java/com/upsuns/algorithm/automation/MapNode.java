package com.upsuns.algorithm.automation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KinderRiven on 2017/3/13.
 */
final class MapNode extends AbstractNode implements Node {

    private final Map<Character, Node> children;

    public MapNode() {
        super();
        this.children = new HashMap<Character, Node>();
    }

    public MapNode(Node parent, char value) {
        super(parent, value);
        this.children = new HashMap<Character, Node>();
    }

    @Override
    public Node childOf(char c) {
        return children.get(c);
    }

    @Override
    public void add(Node child) {
        children.put(child.value(), child);
    }

    @Override
    public List<Node> children() {
        List<Node> nodes = new ArrayList<Node>();
        nodes.addAll(children.values());
        return nodes;
    }
}