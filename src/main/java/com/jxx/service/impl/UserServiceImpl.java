package com.jxx.service.impl;

import com.jxx.dao.AddressMapper;
import com.jxx.dao.UserMapper;
import com.jxx.entity.Address;
import com.jxx.entity.User;
import com.jxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    AddressMapper addressMapper;

    @Override
    public int insertUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userMapper.insertSelective(user);
    }

    @Transactional
    @Override
    public void insertAddress(int uid, String address) {
        Address _address = new Address();
        _address.setAddress(address);
        try {
            Address a;
            if ((a = addressMapper.selectByAddress(address)) == null) {
                addressMapper.insertSelective(_address);
            } else {
                _address = a;
            }
        } catch (Exception e) {
            throw new RuntimeException("can't insert address");
        }
        try {
            User user = new User();
            user.setId(uid);
            user.setAidP(_address.getId());
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            throw new RuntimeException("can't insert username");
        }
    }

}
