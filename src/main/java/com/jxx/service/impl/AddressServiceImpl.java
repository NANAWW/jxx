package com.jxx.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jxx.dao.AddressMapper;
import com.jxx.dao.UserMapper;
import com.jxx.entity.Address;
import com.jxx.entity.User;
import com.jxx.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private Gson gson;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    AddressMapper addressMapper;

    @Override
    public Address selectByAddress(String address) {
        return addressMapper.selectByAddress(address);
    }

    @Transactional
    @Override
    public Address insertAddress(String address) {
        try {
            Address a;
            if ((a = addressMapper.selectByAddress(address)) == null) {
                Address _address = new Address();
                _address.setAddress(address);
                addressMapper.insertSelective(_address);
                return _address;
            } else {
                return a;
            }
        } catch (Exception e) {
            throw new RuntimeException("can't insert address");
        }
    }

    @Transactional
    @Override
    public User insertAddress(int uid, int aid) {
        try {
            User user = userMapper.selectByPrimaryKey(uid);
            Type setType = new TypeToken<Set<Integer>>() {
            }.getType();
            Set<Integer> aids = gson.fromJson(user.getAids(), setType);
            if (aids == null) {
                aids = new HashSet<>();
            }
            aids.add(aid);
            return updateAddresses(uid, aids);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("can't parse json");
        }
    }

    @Transactional
    @Override
    public User insertAddress(int uid, String address) {
        Address _address = insertAddress(address);
        return insertAddress(uid, _address.getId());
    }

    @Transactional
    @Override
    public User deleteAddress(int uid, int aid) {
        try {
            User user = userMapper.selectByPrimaryKey(uid);
            Type setType = new TypeToken<Set<Integer>>() {
            }.getType();
            Set<Integer> aids = gson.fromJson(user.getAids(), setType);
            if (aids == null) {
                throw new RuntimeException("can't find addresses");
            }
            aids.remove(aid);
            return updateAddresses(uid, aids);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("can't parse json");
        }
    }

    @Transactional
    public User updateAddresses(int uid, Set<Integer> aids) {
        try {
            User user = new User();
            user.setId(uid);
            user.setAids(gson.toJson(aids));
            userMapper.updateByPrimaryKeySelective(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException("can't save addresses");
        }
    }

    @Transactional
    @Override
    public User updatePrimaryAddress(int uid, int aid) {
        try {
            User user = new User();
            user.setId(uid);
            user.setAidP(aid);
            userMapper.updateByPrimaryKeySelective(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException("can't save primary address");
        }
    }

    @Transactional
    @Override
    public User updateAddress(int uid, String old_address, String new_address) {
        Address _address = selectByAddress(old_address);
        deleteAddress(uid, _address.getId());
        return insertAddress(uid, new_address);
    }
}
