package com.jxx.control.impl;

import com.google.gson.Gson;
import com.jxx.control.HomeControl;
import com.jxx.entity.Good;
import com.jxx.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "home")
public class HomeControlImpl implements HomeControl {

    @Autowired
    GoodService goodService;

    @RequestMapping(value = "searchByKey", method = RequestMethod.GET)
    public List<Good> searchByKey(@RequestParam("key") String key) {
        return goodService.selectByKey(key);
    }

}
