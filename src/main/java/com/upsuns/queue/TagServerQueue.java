package com.upsuns.queue;

import com.upsuns.algorithm.automation.MatchInfo;
import com.upsuns.algorithm.automation.WordTable;
import com.upsuns.algorithm.simhash.SimHash;
import com.upsuns.mapper.document.DocMapper;
import com.upsuns.mapper.hash.HashCodeMapper;
import com.upsuns.mapper.hash.SimListMapper;
import com.upsuns.mapper.tag.DocTagMapper;
import com.upsuns.mapper.tag.TagMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.hash.HashCode;
import com.upsuns.po.hash.SimList;
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

    @Autowired
    private HashCodeMapper hashCodeMapper;

    @Autowired
    private SimListMapper simListMapper;

    private BlockingQueue<Document> queue;

    //标签存储映射
    private List<String> tagNames;
    private Map<String, Integer> tagMap;    //出现次数
    private Map<String, Integer> weightMap; //标签名称和权值的映射

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

    //初始化队列
    //建立AC自动机树
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

    public void parseTag(Document document) throws Exception{

        WordTable table = WordTable.compile(tagNames);
        List<MatchInfo> info = table.search(document.getContent());
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> keys = new ArrayList<String>();
        List<Integer> weights = new ArrayList<Integer>();

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
                keys.add(word);
                weights.add(weight);
                docTagMapper.insertDocTag(new DocTag(document.getId(), word, tagMap.get(word)));
            }
        }
        String codes = SimHash.simHash(keys, weights);
        hashCodeMapper.insertHashCode(new HashCode(document.getId(), codes));
        System.out.println(info);
        System.out.println(codes);
    }

    public void parseSim(Document document) throws Exception{

        List<HashCode> hashCodes = hashCodeMapper.selectAllHashCode();
        HashCode code = hashCodeMapper.selectHashCodeByDocId(document.getId());

        for(HashCode hashCode : hashCodes) {
            Integer hamming = SimHash.hmSize(code.getHashCode(), hashCode.getHashCode());
            if(hamming <= 3 && !code.getDocId().equals(hashCode.getDocId())){
                SimList simList = new SimList(
                        code.getDocId(), hashCode.getDocId(), hamming, new Date().getTime());
                simListMapper.insertSimList(simList);
            }
        }
    }

    public void run(){

        try{
            init();
            System.out.println("标签处理队列开始");
            while(isRunning){
                Document document = queue.take();
                parseTag(document);
                parseSim(document);
            }
            System.out.println("标签处理队列完成");
        } catch (Exception e){}
    }

    public void addServer(Document document){
        queue.add(document);
    }
}
