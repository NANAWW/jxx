package com.jxx.control.impl;

import com.jxx.control.AddressControl;
import com.jxx.entity.Address;
import com.jxx.entity.User;
import com.jxx.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "address")
public class AddressControlImpl implements AddressControl {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "insertAddress", method = RequestMethod.GET)
    @Override
    public User insertAddress(@RequestParam("uid") int uid,
                              @RequestParam("address") String address) {
        return addressService.insertAddress(uid, address);
    }

    @RequestMapping(value = "updateAddress", method = RequestMethod.GET)
    @Override
    public User updateAddress(@RequestParam("uid") int uid,
                              @RequestParam("old_address") String old_address,
                              @RequestParam("new_address") String new_address) {
        return addressService.updateAddress(uid, old_address, new_address);
    }

    @RequestMapping(value = "deleteAddress", method = RequestMethod.GET)
    @Override
    public User deleteAddress(@RequestParam("uid") int uid,
                              @RequestParam("address") String address) {
        Address _address = addressService.selectByAddress(address);
        return addressService.deleteAddress(uid, _address.getId());
    }

    @RequestMapping(value = "setPrimaryAddress", method = RequestMethod.GET)
    @Override
    public User setPrimaryAddress(@RequestParam("uid") int uid,
                                  @RequestParam("address") String address) {
        Address _address = addressService.selectByAddress(address);
        return addressService.updatePrimaryAddress(uid, _address.getId());
    }
}
