package com.upsuns.mapper.set;

import com.upsuns.po.set.BookSet;

import java.util.List;

/*
 * Created by KinderRiven on 2017/4/7.
 */
public interface BookSetMapper {

    public void insertBookSet(BookSet set) throws Exception;

    public List<BookSet> selectBookSetByUserId(Integer uid) throws Exception;

    public BookSet selectBookSetById(Integer id) throws Exception;
}
