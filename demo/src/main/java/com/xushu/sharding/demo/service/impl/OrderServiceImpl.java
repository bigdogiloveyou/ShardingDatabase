package com.xushu.sharding.demo.service.impl;

import com.xushu.sharding.demo.entity.OrderExt;
import com.xushu.sharding.demo.entity.OrderInfo;
import com.xushu.sharding.demo.mappper.OrderExtMapper;
import com.xushu.sharding.demo.mappper.OrderInfoMapper;
import com.xushu.sharding.demo.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author xushu
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private OrderExtMapper orderExtMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(OrderInfo orderInfo, OrderExt orderExt) {
        orderInfoMapper.insert(orderInfo.getOrderId(), orderInfo);
//        System.out.println(1/0);
        orderExtMapper.insert(orderExt.getOrderId(), orderExt);
    }
}
