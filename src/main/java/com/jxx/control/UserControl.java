package com.jxx.control;

public interface UserControl {

    int insertUser(String username, String password);

    void insertAddress(int uid, String address);

    void updateAddress(int uid, String old_address,String new_address);

    void deleteAddress(int uid, String address);

    void setPrimaryAddress(int uid, String address);

}
