package com.jxx.service;

import com.jxx.entity.Address;

public interface AddressService {

    Address insertAddress(String address);

    Address selectByAddress(String address);

}
