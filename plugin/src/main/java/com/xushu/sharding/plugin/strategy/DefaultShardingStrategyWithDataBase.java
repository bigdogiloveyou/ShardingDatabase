package com.xushu.sharding.plugin.strategy;

import com.xushu.sharding.plugin.Sharding;

/**
 * 使用分表因子shardingKey直接作为分表位
 *
 * @author xushu
 */
public class DefaultShardingStrategyWithDataBase extends AbstractShardingStrategyWithDataBase {

    @Override
    public Integer calculateTableSuffix(Sharding sharding, Integer shardingCount, String shardingKey) {
        return Integer.valueOf(shardingKey);
    }

}
