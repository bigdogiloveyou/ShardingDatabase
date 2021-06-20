package com.xushu.sharding.plugin.strategy.database;

/**
 * 分库策略
 *
 */
public interface ShardingDataBaseStrategy {

    /**
     * 计算获取对应分库序号
     *
     * @param sharingDataBaseCount    分库数量
     * @param shardingKey             分表key
     * @return 分库序号
     */
    Integer calculate(int sharingDataBaseCount, String shardingKey);
}
