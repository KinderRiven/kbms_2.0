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

    private boolean isRunning;

    public TagServerQueue(){
        queue = new LinkedBlockingQueue<Document>();
        isRunning = true;
    }

    public void init() throws Exception{

        List<Tag> tags = tagMapper.selectAllTags();
        tagNames = new ArrayList<String>();
        tagMap = new HashMap<String, Integer>();

        for(Tag tag : tags){
            tagNames.add(tag.getName());
            tagMap.put(tag.getName(), tag.getId());
        }
    }

    public  void parseTags(Document document) throws Exception{

        WordTable table = WordTable.compile(tagNames);
        List<MatchInfo> info = table.search(document.getContent());
        Set<String> set = new HashSet<String>();

        for(MatchInfo each : info){
            set.add(each.getWord());
        }

        for(String word : set){
            DocTag docTag = new DocTag(document.getId(), word, tagMap.get(word));
            docTagMapper.insertDocTag(docTag);
        }
    }

    public void run(){

        try{
            init();
            System.out.println("标签处理队列开始");
            while(isRunning){

                Document document = queue.take();
                //处理
                //System.out.println("开始处理");
                parseTags(document);
                //System.out.println("处理完成");

            }
            System.out.println("标签处理队列完成");
        } catch (Exception e){}
    }

    public void addServer(Document document){
        queue.add(document);
    }
}
