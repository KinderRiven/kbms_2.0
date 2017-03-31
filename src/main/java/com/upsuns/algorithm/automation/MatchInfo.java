package com.upsuns.algorithm.automation;

/**
 * Created by KinderRiven on 2017/3/13.
 */
public final class MatchInfo {

    private final int index;
    private final String word;

    public MatchInfo(int index, String word) {
        this.index = index;
        this.word = word;
    }

    public MatchInfo(int index, Node node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            if (!node.isRoot())
                builder.append(node.value());
            node = node.parent();
        }
        String word = builder.reverse().toString();
        this.index = index + 1 - word.length();
        this.word = word;
    }

    public int getIndex() {
        return index;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return index + ":" + word;
    }
}