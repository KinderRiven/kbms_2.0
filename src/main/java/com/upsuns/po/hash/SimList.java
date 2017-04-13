package com.upsuns.po.hash;

/* Created by KinderRiven on 2017/4/13. */
public class SimList {

    private Integer id;
    private Integer docId;
    private Integer simId;
    private Integer dist;
    private Long time;

    public SimList(){};

    public SimList(Integer docId, Integer simId, Integer dist, Long time){
        this.docId = docId;
        this.simId = simId;
        this.dist = dist;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getSimId() {
        return simId;
    }

    public void setSimId(Integer simId) {
        this.simId = simId;
    }

    public Integer getDist() {
        return dist;
    }

    public void setDist(Integer dist) {
        this.dist = dist;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
