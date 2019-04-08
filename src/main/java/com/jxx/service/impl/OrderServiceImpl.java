package com.jxx.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jxx.dao.OrderMapper;
import com.jxx.dao.UserMapper;
import com.jxx.entity.Order;
import com.jxx.entity.User;
import com.jxx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private Gson gson;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;

    @Transactional
    @Override
    public User insertOrder(int uid, int gid, int aid, int amount) {
        Order order = new Order();
        order.setUid(uid);
        order.setGid(gid);
        order.setAid(aid);
        order.setAmount(amount);
        orderMapper.insertSelective(order);
        if (order.getId() == null) {
            throw new RuntimeException("can't insert order");
        } else {
            return insertOrder(uid, order.getId());
        }
    }

    @Transactional
    @Override
    public User insertOrder(int uid, int oid) {
        try {
            User user = userMapper.selectByPrimaryKey(uid);
            Type setType = new TypeToken<Set<Integer>>() {
            }.getType();
            Set<Integer> oids = gson.fromJson(user.getOids(), setType);
            if (oids == null) {
                oids = new HashSet<>();
            }
            oids.add(oid);
            return updateOrders(uid, oids);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("can't parse json");
        }
    }

    @Transactional
    @Override
    public User deleteOrder(int uid, int oid) {
        try {
            User user = userMapper.selectByPrimaryKey(uid);
            Type setType = new TypeToken<Set<Integer>>() {
            }.getType();
            Set<Integer> oids = gson.fromJson(user.getOids(), setType);
            if (oids == null) {
                throw new RuntimeException("can't find orders");
            }
            oids.remove(oid);
            return updateOrders(uid, oids);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("can't parse json");
        }
    }

    @Transactional
    public User updateOrders(int uid, Set<Integer> oids) {
        try {
            User user = new User();
            user.setId(uid);
            user.setOids(gson.toJson(oids));
            userMapper.updateByPrimaryKeySelective(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException("can't save orders");
        }
    }
}
