package com.upsuns.service.hash;

import com.upsuns.po.document.Document;

import java.util.List;

/**
 * Created by KinderRiven on 2017/4/13.
 */
public interface HashService {

    public void updateSimList(Integer docId) throws Exception;

    public List<Document> getSimDocList(Integer docId) throws Exception;
}
