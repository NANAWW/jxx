package com.jxx.control;

import com.jxx.entity.Good;

import java.util.List;

public interface HomeControl {

    List<Good> searchByKey(String key);

}
