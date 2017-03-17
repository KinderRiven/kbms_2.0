package com.upsuns.mapper.tag;

import com.upsuns.po.tag.DocTag;

import java.util.List;

/**
 * Created by KinderRiven on 2017/3/7.
 */
public interface DocTagMapper {

    public void insertDocTag(DocTag docTag) throws Exception;

    public List<DocTag> selectTagsByDocId(Integer docId) throws Exception;

    public List<String> selectTagNameByDocId(Integer docId) throws Exception;
}
