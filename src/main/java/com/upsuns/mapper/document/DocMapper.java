package com.upsuns.mapper.document;

import com.upsuns.po.document.Document;

/**
 * Created by KinderRiven on 2017/2/28.
 */
public interface DocMapper {

    public void insertDoc(Document document) throws Exception;

    public Document selectDocByDocId(Integer id) throws Exception;
}
