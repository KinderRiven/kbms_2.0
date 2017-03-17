package com.upsuns.po.tag;

/*
 * Created by KinderRiven on 2017/3/7.
 */
public class DocTag {

    private Integer id;
    private Integer tagId;
    private Integer docId;
    private String  tagName;

    public DocTag(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public DocTag(Integer docId, String tagName, Integer tagId){
        this.docId = docId;
        this.tagName = tagName;
        this.tagId = tagId;
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
