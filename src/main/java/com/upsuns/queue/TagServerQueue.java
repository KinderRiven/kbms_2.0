package com.upsuns.queue;

import com.upsuns.algorithm.automation.MatchInfo;
import com.upsuns.algorithm.automation.WordTable;
import com.upsuns.mapper.document.DocMapper;
import com.upsuns.mapper.tag.DocTagMapper;
import com.upsuns.mapper.tag.TagMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.tag.DocTag;
import com.upsuns.po.tag.Tag;
import com.upsuns.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * Created by KinderRiven on 2017/3/15.
 */
public class TagServerQueue extends Thread{


    @Autowired
    private DocTagMapper docTagMapper;

    @Autowired
    private TagMapper tagMapper;

    private BlockingQueue<Document> queue;

    //标签存储映射
    private List<String> tagNames;
    private Map<String, Integer> tagMap;
    private Map<String, Integer> weightMap;

    private boolean isRunning;

    public TagServerQueue(){
        queue = new LinkedBlockingQueue<Document>();
        isRunning = true;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void init() throws Exception{

        List<Tag> tags = tagMapper.selectAllTags();
        tagNames = new ArrayList<String>();
        tagMap = new HashMap<String, Integer>();
        weightMap = new HashMap<String, Integer>();

        for(Tag tag : tags){
            tagNames.add(tag.getName());
            tagMap.put(tag.getName(), tag.getId());
            weightMap.put(tag.getName(), tag.getWeight());
        }
    }

    public  void parseTags(Document document) throws Exception{

        WordTable table = WordTable.compile(tagNames);
        List<MatchInfo> info = table.search(document.getContent());
        Map<String, Integer> map = new HashMap<String, Integer>();
        System.out.println(info);

        for(MatchInfo each : info){

            String key = each.getWord();
            Integer value = map.get(key);

            if(value == null) {map.put(key, 1);}
            else{
                value = value + 1;
                map.put(key, value);
            }
        }

        for(String word : map.keySet()){

            Integer value = map.get(word);
            Integer weight = weightMap.get(word);

            //出现次数 * 权值 >= 5
            if(value * weight >= 5) {
                System.out.println(word + ":" + value.toString() + "-" + weight.toString());
                DocTag docTag = new DocTag(document.getId(), word, tagMap.get(word));
                docTagMapper.insertDocTag(docTag);
            }
        }
    }

    public void run(){

        try{
            init();
            System.out.println("标签处理队列开始");
            while(isRunning){
                Document document = queue.take();
                parseTags(document);
            }
            System.out.println("标签处理队列完成");
        } catch (Exception e){}
    }

    public void addServer(Document document){
        queue.add(document);
    }
}
