package com.jxx.service.impl;

import com.google.gson.Gson;
import com.jxx.dao.AddressMapper;
import com.jxx.dao.UserMapper;
import com.jxx.entity.User;
import com.jxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Gson gson;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;

    @Transactional
    @Override
    public User insertUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insertSelective(user);
        return user;
    }

}
