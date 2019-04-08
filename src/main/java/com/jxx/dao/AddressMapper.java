package com.jxx.dao;

import com.jxx.entity.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    Address selectByAddress(String address);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}