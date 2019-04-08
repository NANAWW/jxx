package com.jxx.service.impl;

import com.jxx.dao.GoodMapper;
import com.jxx.entity.Good;
import com.jxx.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    GoodMapper goodMapper;

    @Override
    public List<Good> selectByKey(String key) {
        return goodMapper.selectByKey(key);
    }
}
