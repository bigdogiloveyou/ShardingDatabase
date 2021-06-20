package com.xushu.sharding.plugin.strategy;

import com.xushu.sharding.plugin.Sharding;

/**
 * 分表策略
 *
 */
public interface ShardingTableStrategy {

    String UNDERLINE = "_";

    /**
     * 获取分表位的实际表名
     *
     * @param sharding    Sharding信息
     * @param shardingKey 分库分表 key
     * @return 带分表位的实际表名
     */
    String getTargetTableName(Sharding sharding, String shardingKey);

    /**
     * 计算分表
     *
     * @param sharding      Sharding信息
     * @param shardingCount 库数量
     * @param shardingKey   分库分表 key
     * @return 计算分表
     */
    Integer calculateTableSuffix(Sharding sharding, Integer shardingCount, String shardingKey);
}
