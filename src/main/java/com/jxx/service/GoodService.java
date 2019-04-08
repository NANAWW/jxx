package com.jxx.service;

import com.jxx.entity.Good;

import java.util.List;

public interface GoodService {

    List<Good> selectByKey(String key);

}
