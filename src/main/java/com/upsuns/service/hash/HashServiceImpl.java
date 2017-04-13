package com.upsuns.service.hash;

import com.upsuns.algorithm.simhash.SimHash;
import com.upsuns.mapper.document.DocMapper;
import com.upsuns.mapper.hash.HashCodeMapper;
import com.upsuns.mapper.hash.SimListMapper;
import com.upsuns.po.document.Document;
import com.upsuns.po.hash.HashCode;
import com.upsuns.po.hash.SimList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/* Created by KinderRiven on 2017/4/13. */
public class HashServiceImpl implements HashService{

    @Autowired
    private HashCodeMapper hashCodeMapper;

    @Autowired
    private SimListMapper simListMapper;

    @Autowired
    private DocMapper docMapper;

    public void updateSimList(Integer docId) throws Exception{

        List<HashCode> hashCodes = hashCodeMapper.selectAllHashCode();
        HashCode code = hashCodeMapper.selectHashCodeByDocId(docId);

        for(HashCode hashCode : hashCodes){
            Integer hamming = SimHash.hmSize(code.getHashCode(), hashCode.getHashCode());
            System.out.println(hamming);
        }
    }

    public List<Document> getSimDocList(Integer docId) throws Exception{

        List<SimList> simLists = simListMapper.selectSimListByDocId(docId);
        List<Document> docs = new ArrayList<Document>();

        for(SimList simList : simLists){
            Document doc = docMapper.selectDocByDocId(simList.getSimId());
            docs.add(doc);
        }
        return docs;
    }
}
