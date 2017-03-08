package com.upsuns.po.tag;

/**
 * Created by KinderRiven on 2017/3/7.
 */
public class DocTag {

    private Integer docId;
    private String  tagName;

    public DocTag(){};

    public DocTag(Integer docId, String tagName){
        this.docId = docId;
        this.tagName = tagName;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
