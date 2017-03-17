package com.upsuns.algorithm.automation;

/* Created by KinderRiven on 2017/3/13. */
abstract class AbstractNode implements Node {

    private static final char EMPTY = '\0';
    private final char value;
    private final Node parent;
    private boolean exists;
    private Node fail;


    public AbstractNode(Node parent, char value) {
        this.parent = parent;
        this.value = value;
        this.exists = false;
        this.fail = null;

    }

    public AbstractNode() {
        this(null, EMPTY);
    }


    private static String tab(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append('\t');
        }
        return builder.toString();
    }

    private static String toString(Node node, int depth) {
        StringBuilder builder = new StringBuilder();
        String tab = tab(depth);
        Node fail = node.fail();
        Node parent = node.parent();
        builder
                .append(tab)
                .append('<')
                .append(node.value())
                .append(" exists=\"")
                .append(node.exists())
                .append('"')
                .append(" parent=\"")
                .append(parent == null ? "null" : parent.value())
                .append('"')
                .append(" fail=\"")
                .append(fail == null ? "null" : fail.value())
                .append("\">\r\n");
        for (Node child : node.children())
            builder.append(toString(child, depth + 1));
        builder
                .append(tab)
                .append("</")
                .append(node.value())
                .append(">\r\n");

        return builder.toString();
    }

    @Override
    public char value() {
        return value;
    }

    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public boolean isRoot() {
        return value == EMPTY;
    }

    @Override
    public Node parent() {
        return parent;
    }

    @Override
    public Node fail() {
        return fail;
    }

    @Override
    public void setFail(Node node) {
        this.fail = node;
    }

    @Override
    public void setExists(boolean exists) {
        this.exists = exists;
    }

    @Override
    public String toString() {
        return toString(this, 0);
    }
}
