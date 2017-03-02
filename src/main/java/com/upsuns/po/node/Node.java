package com.upsuns.po.node;

import java.util.Date;

/* Created by KinderRiven on 2017/3/1. */
public class Node {

    private Integer id;         //node_id
    private Integer uid;        //node_uid
    private String  name;       //folder_name
    private String  type;       //node_type
    private Integer next;       //node_next
    private Integer pre;        //node_pre
    private Integer fileId;     //file_id
    private String  info;       //node_info
    private Long    buildTime;  //time_build
    private Long    modifyTime; //time_modify

    public Node(){
        this.buildTime = new Date().getTime();
        this.modifyTime = new Date().getTime();
        this.next = -1;
        this.pre = -1;
        this.fileId = -1;
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getPre() {
        return pre;
    }

    public void setPre(Integer pre) {
        this.pre = pre;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Long buildTime) {
        this.buildTime = buildTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }
}
