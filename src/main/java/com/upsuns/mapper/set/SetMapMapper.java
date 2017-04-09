package com.upsuns.mapper.set;

import com.upsuns.po.set.SetMap;

import java.util.List;

/* Created by KinderRiven on 2017/4/8. */
public interface SetMapMapper {

    public void insertSetMap(SetMap setMap) throws Exception;

    public List<SetMap> selectMapBySetId(Integer setId) throws Exception;
}
