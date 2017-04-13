package com.upsuns.po.hash;

/* Created by KinderRiven on 2017/4/13. */

public class HashCode {

    private Integer docId;
    private String hashCode;

    public HashCode(){};

    public HashCode(Integer docId, String hashCode){
        this.docId = docId;
        this.hashCode = hashCode;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }
}
