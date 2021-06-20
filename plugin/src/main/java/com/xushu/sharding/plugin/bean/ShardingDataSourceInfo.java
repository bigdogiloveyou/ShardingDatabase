package com.xushu.sharding.plugin.bean;

import com.xushu.sharding.plugin.strategy.database.ShardingDataBaseStrategy;

/**
 * 给 mybatis 插件使用的
 */
public class ShardingDataSourceInfo {

    /**
     * 分库策略
     */
    private ShardingDataBaseStrategy shardingDataBaseStrategy;

    /**
     * 分库数量
     */
    private Integer shardingCount;

    public ShardingDataBaseStrategy getShardingDataBaseStrategy() {
        return shardingDataBaseStrategy;
    }

    public void setShardingDataBaseStrategy(ShardingDataBaseStrategy shardingDataBaseStrategy) {
        this.shardingDataBaseStrategy = shardingDataBaseStrategy;
    }

    public Integer getShardingCount() {
        return shardingCount;
    }

    public void setShardingCount(Integer shardingCount) {
        this.shardingCount = shardingCount;
    }
}
