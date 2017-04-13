package com.upsuns.mapper.hash;

import com.upsuns.po.hash.HashCode;

import java.util.List;

/**
 * Created by KinderRiven on 2017/4/13.
 */
public interface HashCodeMapper {

    public void insertHashCode(HashCode hashCode) throws Exception;

    public List<HashCode> selectAllHashCode() throws Exception;

    public HashCode selectHashCodeByDocId(Integer docId) throws Exception;
}
