package com.jxx.service.impl;

import com.jxx.dao.ShopMapper;
import com.jxx.entity.Shop;
import com.jxx.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Shop findByPrimaryKey(Integer id) {
        return shopMapper.selectByPrimaryKey(id);
    }
}
