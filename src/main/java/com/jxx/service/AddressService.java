package com.jxx.service;

import com.jxx.entity.Address;
import com.jxx.entity.User;

public interface AddressService {

    Address selectByAddress(String address);

    Address insertAddress(String address);

    User insertAddress(int uid, int aid);

    User insertAddress(int uid, String address);

    User deleteAddress(int uid, int aid);

    User updatePrimaryAddress(int uid, int aid);

    User updateAddress(int uid, String old_address,String new_address);

}
