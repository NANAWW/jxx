package com.jxx.control;

import com.jxx.entity.User;

public interface OrderControl {

    User insertOrder(int uid, int gid, int aid, int amount);

    User deleteOrder(int uid,int oid);

}
