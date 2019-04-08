package com.jxx.service;

public interface UserService {

    int insertUser(String username, String password);

    void insertAddress(int uid, String address);

}
