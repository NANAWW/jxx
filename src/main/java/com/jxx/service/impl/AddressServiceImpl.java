package com.jxx.service.impl;

import com.jxx.dao.AddressMapper;
import com.jxx.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

}
