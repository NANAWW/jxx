package com.jxx.control;

import com.jxx.entity.User;

public interface AddressControl {

    User insertAddress(int uid, String address);

    User updateAddress(int uid, String old_address,String new_address);

    User deleteAddress(int uid, String address);

    User setPrimaryAddress(int uid, String address);

}
