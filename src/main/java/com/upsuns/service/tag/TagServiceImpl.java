package com.upsuns.service.tag;

import com.upsuns.algorithm.automation.MatchInfo;
import com.upsuns.algorithm.automation.WordTable;
import com.upsuns.mapper.tag.DocTagMapper;
import com.upsuns.mapper.tag.TagMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.tag.DocTag;
import com.upsuns.po.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Created by KinderRiven on 2017/3/13.
 */
public class TagServiceImpl implements TagService{

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private DocTagMapper docTagMapper;

    public void parseTags(Document document) throws Exception{

        List<String> names = tagMapper.selectAllTagsName();

        //AC自动机
        WordTable table = WordTable.compile(names);
        List<MatchInfo> info = table.search(document.getContent());
        Set<String> set = new HashSet<String>();

        for(MatchInfo each : info){
            set.add(each.getWord());
        }
        for(String word : set){
            DocTag docTag = new DocTag(document.getId(), word);
            docTagMapper.insertDocTag(docTag);
        }
    }
}
