package com.upsuns.po.document;

import org.apache.solr.client.solrj.beans.Field;

import javax.print.Doc;
import java.util.Date;

/*
 * Created by KinderRiven on 2017/2/28.
 */
public class Document {

    @Field
    private Integer id;         //doc_id
    @Field
    private String  name;       //doc_name
    @Field
    private String  content;    //doc_content

    private String  path;       //doc_path
    private Integer size;       //doc_size
    private String  type;       //doc_type
    private String  summary;    //doc_summary
    private Integer collect;    //num_collect
    private Integer download;   //num_download
    private Integer uid;        //uid
    private Long upload;        //time_upload
    private Long modify;        //time_modify

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Document(){
        this.upload = new Date().getTime();
        this.modify = new Date().getTime();
    };

    public Document(String name, String path){
        this.name = name;
        this.path = path;
        this.upload = new Date().getTime();
        this.modify = new Date().getTime();
    }

    public Long getUpload() {
        return upload;
    }

    public void setUpload(Long upload) {
        this.upload = upload;
    }

    public Long getModify() {
        return modify;
    }

    public void setModify(Long modify) {
        this.modify = modify;
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
