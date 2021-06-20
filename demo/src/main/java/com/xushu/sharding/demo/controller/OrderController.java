package com.xushu.sharding.demo.controller;

import com.xushu.sharding.demo.entity.Order;
import com.xushu.sharding.demo.entity.OrderInfo;
import com.xushu.sharding.demo.mappper.OrderInfoMapper;
import com.xushu.sharding.demo.service.OrderService;
import com.xushu.sharding.plugin.ShardingContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xushu
 */
@RestController
public class OrderController {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Resource
    private OrderService orderService;

    @RequestMapping("/query")
    public OrderInfo query(String orderId) {
        ShardingContext.forceSlave();
        OrderInfo query = orderInfoMapper.query(orderId);
        ShardingContext.clear();
        return query;
    }

    @RequestMapping("/query2")
    public OrderInfo query2(String orderId, int status) {
        return orderInfoMapper.query2(orderId, status);
    }

    @RequestMapping("/insert")
    public void insert(OrderInfo orderInfo) {
        orderInfoMapper.insert(orderInfo.getOrderId(), orderInfo);
    }

    @RequestMapping(value = "update")
    public void update(OrderInfo orderInfo) {
        ShardingContext.setShardingTable("0");
        orderInfoMapper.update(orderInfo);
        ShardingContext.clear();
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") String orderId) {
        orderInfoMapper.delete(orderId);
    }


    @RequestMapping("/insertAll")
    public void insert(@RequestBody Order order) {
        orderService.insert(order.getOrderInfo(), order.getOrderExt());
    }
}
