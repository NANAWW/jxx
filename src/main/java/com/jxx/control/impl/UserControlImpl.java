package com.jxx.control.impl;

import com.jxx.control.UserControl;
import com.jxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserControlImpl implements UserControl {

    @Autowired
    UserService userService;

    @RequestMapping(value = "insertUser", method = RequestMethod.GET)
    @Override
    public int insertUser(@RequestParam(value = "username", required = true) String username,
                          @RequestParam(value = "password", required = true) String password) {
        return userService.insertUser(username, password);
    }

    @RequestMapping(value = "insertAddress", method = RequestMethod.GET)
    @Override
    public void insertAddress(@RequestParam(value = "uid", required = true) int uid,
                              @RequestParam(value = "address", required = true) String address) {
        userService.insertAddress(uid, address);
    }


}
