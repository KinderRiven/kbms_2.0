package com.upsuns.mapper.hash;

import com.upsuns.po.hash.SimList;

import java.util.List;

/**
 * Created by KinderRiven on 2017/4/13.
 */
public interface SimListMapper {

    public void insertSimList(SimList simList) throws Exception;

    public void deleteSimListByDocId(Integer docId) throws Exception;

    public List<SimList> selectSimListByDocId(Integer docId) throws Exception;
}
