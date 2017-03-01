package com.upsuns.po.document;

import javax.print.Doc;

/*
 * Created by KinderRiven on 2017/2/28.
 */
public class Document {

    private Integer id;         //doc_id
    private String  name;       //doc_name
    private String  path;       //doc_path
    private Integer size;       //doc_size
    private String  type;       //doc_type
    private String  summary;    //doc_summary
    private Integer collect;    //num_collect
    private Integer download;   //num_download
    private Integer uid;        //uid

    public Document(){};

    public Document(String name, String path){
        this.name = name;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
