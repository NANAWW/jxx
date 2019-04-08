package com.jxx.control.impl;

import com.jxx.control.UserControl;
import com.jxx.entity.Address;
import com.jxx.service.AddressService;
import com.jxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserControlImpl implements UserControl {

    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;

    @RequestMapping(value = "insertUser", method = RequestMethod.GET)
    @Override
    public int insertUser(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password) {
        return userService.insertUser(username, password);
    }

    @RequestMapping(value = "insertAddress", method = RequestMethod.GET)
    @Override
    @Transactional
    public void insertAddress(@RequestParam(value = "uid") int uid,
                              @RequestParam(value = "address") String address) {
        Address _address = addressService.insertAddress(address);
        userService.insertAddress(uid, _address.getId());
    }

    @RequestMapping(value = "updateAddress", method = RequestMethod.GET)
    @Override
    @Transactional
    public void updateAddress(@RequestParam(value = "uid") int uid,
                              @RequestParam(value = "old_address") String old_address,
                              @RequestParam(value = "new_address") String new_address) {
        deleteAddress(uid, old_address);
        insertAddress(uid, new_address);
    }

    @Override
    public void deleteAddress(@RequestParam(value = "uid") int uid,
                              @RequestParam(value = "address") String address) {
        Address _address = addressService.selectByAddress(address);
        userService.deleteAddress(uid, _address.getId());
    }

    @RequestMapping(value = "setPrimaryAddress", method = RequestMethod.GET)
    @Override
    public void setPrimaryAddress(@RequestParam(value = "uid") int uid,
                                  @RequestParam(value = "address") String address) {
        Address _address = addressService.selectByAddress(address);
        userService.updatePrimaryAddress(uid, _address.getId());
    }


}
