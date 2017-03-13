package com.upsuns.mapper.tag;

import com.upsuns.po.tag.Tag;

import java.util.List;

/**
 * Created by KinderRiven on 2017/3/13.
 */
public interface TagMapper {

    public List<String> selectAllTagsName() throws Exception;
}
