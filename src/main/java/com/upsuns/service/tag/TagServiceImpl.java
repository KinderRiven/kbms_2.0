package com.upsuns.service.tag;

import com.upsuns.algorithm.automation.MatchInfo;
import com.upsuns.algorithm.automation.WordTable;
import com.upsuns.mapper.tag.DocTagMapper;
import com.upsuns.mapper.tag.TagMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.tag.DocTag;
import com.upsuns.po.tag.Tag;
import com.upsuns.queue.ServerQueueManager;
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

    public void parseTags(Document document) throws Exception{}
}
