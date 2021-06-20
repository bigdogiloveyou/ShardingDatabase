package com.xushu.sharding.demo.entity;

/**
 * @author xushu
 */
public class Order {

    private OrderInfo orderInfo;
    private OrderExt orderExt;

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public OrderExt getOrderExt() {
        return orderExt;
    }

    public void setOrderExt(OrderExt orderExt) {
        this.orderExt = orderExt;
    }
}
