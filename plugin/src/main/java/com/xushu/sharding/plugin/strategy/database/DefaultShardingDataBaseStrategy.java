package com.xushu.sharding.plugin.strategy.database;

/**
 * 默认分库策略，将分表从小到大均匀分配至各分库中
 * 比如：
 * 2个库，10个表
 * 0-4表在0库，5-9表在1库
 *
 */
public class DefaultShardingDataBaseStrategy implements ShardingDataBaseStrategy {

    @Override
    public Integer calculate(int sharingDataBaseCount, String shardingKey) {
        return Math.abs(shardingKey.hashCode() % sharingDataBaseCount);
    }
}
