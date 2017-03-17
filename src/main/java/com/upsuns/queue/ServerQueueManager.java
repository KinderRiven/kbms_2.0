package com.upsuns.queue;

/*
 * Created by KinderRiven on 2017/3/15.
 */

import com.upsuns.po.document.Document;
import org.springframework.beans.factory.annotation.Autowired;

import javax.print.Doc;

public class ServerQueueManager {

    @Autowired
    private TagServerQueue tagServerQueue;  //进行标签提取的任务列表

    public ServerQueueManager(){};

    public void addTagServer(Document document){
        tagServerQueue.addServer(document);
    }

    public void start(){

        tagServerQueue.start();

    }

    public TagServerQueue getTagServerQueue() {
        return tagServerQueue;
    }

    public void setTagServerQueue(TagServerQueue tagServerQueue) {
        this.tagServerQueue = tagServerQueue;
    }

}
