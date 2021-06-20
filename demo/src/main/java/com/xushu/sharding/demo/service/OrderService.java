package com.xushu.sharding.demo.service;

import com.xushu.sharding.demo.entity.OrderExt;
import com.xushu.sharding.demo.entity.OrderInfo;

/**
 * @author xushu
 */
public interface OrderService {

    void insert(OrderInfo orderInfo, OrderExt orderExt);
}
