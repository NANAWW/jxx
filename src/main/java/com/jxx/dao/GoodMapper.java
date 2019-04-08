package com.jxx.dao;

import com.jxx.entity.Good;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer id);

    List<Good> selectByKey(String key);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}