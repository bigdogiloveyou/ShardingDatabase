package com.xushu.sharding.plugin.strategy;

import com.xushu.sharding.plugin.Sharding;

/**
 *  hash 分表策略，key / databaseCount % tableCount
 *
 */
public class HashShardingStrategyWithDataBase extends AbstractShardingStrategyWithDataBase {

    @Override
    public Integer calculateTableSuffix(Sharding sharding, Integer shardingCount, String shardingKey) {
        return Math.abs(shardingKey.hashCode()) / shardingCount % sharding.count();
    }

}
