package com.jxx.control.impl;

import com.jxx.control.OrderControl;
import com.jxx.entity.Order;
import com.jxx.entity.User;
import com.jxx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "order")
public class OrderControlImpl implements OrderControl {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "insertOrder", method = RequestMethod.POST)
    @Override
    public User insertOrder(@RequestParam("uid") int uid,
                            @RequestParam("gid") int gid,
                            @RequestParam("aid") int aid,
                            @RequestParam("amount") int amount) {
        return orderService.insertOrder(uid, gid, aid, amount);
    }

    @RequestMapping(value = "deleteOrder", method = RequestMethod.POST)
    @Override
    public User deleteOrder(@RequestParam("uid") int uid, @RequestParam("oid") int oid) {
        return orderService.deleteOrder(uid, oid);
    }
}
