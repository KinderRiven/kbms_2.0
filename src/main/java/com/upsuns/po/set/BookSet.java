package com.upsuns.po.set;

/*
 * Created by KinderRiven on 2017/4/7.
 */
public class BookSet {

    private Integer id;
    private Integer uid;
    private String  description;
    private String  name;
    private Integer collect;

    public BookSet(){};

    public BookSet(String name, String description, Integer uid){

        this.name = name;
        this.description = description;
        this.uid = uid;
        this.collect = 0;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }
}
