package com.xushu.sharding.demo.mappper;

import com.xushu.sharding.demo.entity.OrderInfo;
import com.xushu.sharding.plugin.Sharding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author xushu
 */
@Mapper
@Repository
@Sharding(sharding = true, databaseName = "test", tableName = "order_info", strategy = "cn.blogxin.sharding.plugin.strategy.HashShardingStrategyWithDataBase", count = 10)
public interface OrderInfoMapper {

//    List<OrderInfo> getAll();

    OrderInfo query(String orderId);

    OrderInfo query2(@Param("orderId") String orderId, @Param("status") int status);

    void insert(@Param("orderId") String orderId, @Param("orderInfo") OrderInfo orderInfo);

    void update(OrderInfo orderInfo);

    void delete(String orderId);

}
