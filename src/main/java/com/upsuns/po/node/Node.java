package com.upsuns.po.node;

import java.util.Date;

/* Created by KinderRiven on 2017/3/1. */
public class Node {

    private Integer id;         //node_id
    private Integer uid;        //node_uid
    private String  type;       //node_type
    private Integer next;       //node_next
    private Integer pre;        //node_pre
    private Integer fid;        //file_id
    private String  fname;      //folder_name
    private String  info;       //node_info
    private Long    build;      //time_build
    private Long    modify;     //time_modify

    public Node(){
        this.build = new Date().getTime();
        this.modify = new Date().getTime();
        this.next = -1;
        this.fid = -1;
    };

    public Node(Integer uid, String type, Integer fid, String fname, String info, Long build, Long modify){
        this.uid = uid;
        this.type = type;
        this.fid = fid;
        this.fname = fname;
        this.info = info;
        this.build = build;
        this.modify = modify;
    }

    public Long getBuild() {
        return build;
    }

    public void setBuild(Long build) {
        this.build = build;
    }

    public Long getModify() {
        return modify;
    }

    public void setModify(Long modify) {
        this.modify = modify;
    }

    public Integer getPre() {
        return pre;
    }

    public void setPre(Integer pre) {
        this.pre = pre;
    }

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

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
