package com.upsuns.queue;

/*
 * Created by KinderRiven on 2017/3/15.
 */

import com.upsuns.po.document.Document;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.print.Doc;

public class ServerQueueManager {

    @Autowired
    private TagServerQueue tagServerQueue;  //进行标签提取的任务列表

    public ServerQueueManager(){};

    private boolean isRunning = false;

    public void addTagServer(Document document){
        tagServerQueue.addServer(document);
    }

    @PostConstruct
    public void start(){

        if(isRunning == false) {
            System.out.println("启动队列");
            tagServerQueue.start();
            isRunning = true;
        } else{
            System.out.println("关闭队列");
            tagServerQueue.setRunning(false);
            isRunning = false;
        }
    }

    public TagServerQueue getTagServerQueue() {
        return tagServerQueue;
    }

    public void setTagServerQueue(TagServerQueue tagServerQueue) {
        this.tagServerQueue = tagServerQueue;
    }
}
