package com.upsuns.po.document;

import javax.print.Doc;

/*
 * Created by KinderRiven on 2017/2/28.
 */
public class Document {

    private String docName;     //doc_name

    private String docPath;     //doc_path

    private Integer docId;      //doc_id

    public Document(){};

    public Document(String docName, String docPath){
        this.docName = docName;
        this.docPath = docPath;
    }

    public String getDocName() {
        return docName;
    }

    public String getDocPath() {
        return docPath;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }
}
