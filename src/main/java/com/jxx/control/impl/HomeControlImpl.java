package com.jxx.control.impl;

import com.google.gson.Gson;
import com.jxx.control.HomeControl;
import com.jxx.entity.Good;
import com.jxx.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "home")
public class HomeControlImpl implements HomeControl {

    @Autowired
    Gson gson;
    @Autowired
    GoodService goodService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "searchByKey", method = RequestMethod.POST)
    public List<Good> searchByKey(@RequestParam("key") String key) {
        return goodService.selectByKey(key);
    }

}
