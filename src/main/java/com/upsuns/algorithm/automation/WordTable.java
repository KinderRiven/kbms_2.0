package com.upsuns.algorithm.automation;

import java.util.*;

/* Created by KinderRiven on 2017/3/13. */
public final class WordTable {

    private final Node root;


    private WordTable(Collection<? extends CharSequence> words, NodeMaker maker) {
        Node root = buildTrie(words, maker);
        setFailNode(root);
        this.root = root;
    }

    public static WordTable compile(Collection<? extends CharSequence> words) {
        if (words == null || words.isEmpty())
            throw new IllegalArgumentException();
        final NodeMaker maker;
        if (isAscii(words))
            maker = new NodeMaker() {
                @Override
                public Node make(Node parent, char value) {
                    return new AsciiNode(parent, value);
                }

                @Override
                public Node makeRoot() {
                    return new AsciiNode();
                }
            };
        else maker = new NodeMaker() {
            @Override
            public Node make(Node parent, char value) {
                return new MapNode(parent, value);
            }

            @Override
            public Node makeRoot() {
                return new MapNode();
            }
        };
        return new WordTable(words, maker);
    }

    private static boolean isAscii(Collection<? extends CharSequence> words) {
        for (CharSequence word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                int c = (int) word.charAt(i);
                if (c < 32 || c > 126)
                    return false;
            }
        }
        return true;
    }

    private static Node buildTrie(Collection<? extends CharSequence> sequences, NodeMaker maker) {
        Node root = maker.makeRoot();
        for (CharSequence sequence : sequences) {
            int len = sequence.length();
            Node current = root;
            for (int i = 0; i < len; i++) {
                char c = sequence.charAt(i);
                Node node = current.childOf(c);
                if (node == null) {
                    node = maker.make(current, c);
                    current.add(node);
                }
                current = node;
                if (i == len - 1)
                    node.setExists(true);
            }
        }
        return root;
    }

    private static void setFailNode(final Node root) {
        root.setFail(null);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            Node temp;
            for (Node child : parent.children()) {
                if (parent.isRoot())
                    child.setFail(root);
                else {
                    temp = parent.fail();
                    while (temp != null) {
                        Node node = temp.childOf(child.value());
                        if (node != null) {
                            child.setFail(node);
                            break;
                        }
                        temp = temp.fail();
                    }
                    if (temp == null)
                        child.setFail(root);
                }
                queue.add(child);
            }
        }
    }


    public boolean findAnyIn(CharSequence cs) {
        int len = cs.length();
        Node node = root;
        for (int i = 0; i < len; i++) {
            Node next = node.childOf(cs.charAt(i));
            if (next == null) {
                next = node.fail();
                if (next == null) {
                    node = root;
                    continue;
                }
            }
            if (next.exists())
                return true;
        }

        return false;
    }

    public List<MatchInfo> search(CharSequence cs) {
        if (cs == null || cs.length() == 0)
            return Collections.emptyList();
        List<MatchInfo> result = new ArrayList<MatchInfo>();
        int len = cs.length();
        Node node = root;
        for (int i = 0; i < len; i++) {
            Node next = node.childOf(cs.charAt(i));
            if (next == null) {
                next = node.fail();
                if (next == null) {
                    node = root;
                    continue;
                }
            }
            if (next.exists()) {
                MatchInfo info = new MatchInfo(i, next);
                result.add(info);
                node = root;
                continue;
            }
            node = next;
        }
        return result;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
