package com.jxx.service;

import com.jxx.entity.User;


public interface UserService {

    int insertUser(String username, String password);

    User insertAddress(int uid, int aid);

    User deleteAddress(int uid, int aid);

    User updatePrimaryAddress(int uid, int aid);

}
