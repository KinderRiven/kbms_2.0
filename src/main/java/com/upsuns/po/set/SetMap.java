package com.upsuns.po.set;

/*
 * Created by KinderRiven on 2017/4/8.
 */
public class SetMap {

    private Integer id;
    private Integer setId;
    private Integer nodeId;
    private Long time;
    private String note;

    public SetMap(){};

    public SetMap(Integer setId, Integer nodeId, Long time, String note){
        this.setId = setId;
        this.nodeId = nodeId;
        this.time = time;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
