package com.xushu.sharding.plugin.strategy;

import com.xushu.sharding.plugin.Sharding;
import com.xushu.sharding.plugin.ShardingContext;
import com.xushu.sharding.plugin.bean.ShardingDataSourceInfo;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 带分库的分表策略，使用分库插件时，分表插件必须继承该类
 *
 */
public abstract class AbstractShardingStrategyWithDataBase implements ShardingTableStrategy {

    private static Map<String, ShardingDataSourceInfo> shardingDataSourceInfoMap = Maps.newHashMap();

    public static void setShardingDataSourceInfoMap(Map<String, ShardingDataSourceInfo> shardingDataSourceInfoMap) {
        AbstractShardingStrategyWithDataBase.shardingDataSourceInfoMap = shardingDataSourceInfoMap;
    }

    // 这边做的不是特别好，分库分表职责没有分开
    @Override
    public String getTargetTableName(Sharding sharding, String shardingKey) {
        // 确定库名
        ShardingDataSourceInfo shardingDataSourceInfo = shardingDataSourceInfoMap.get(sharding.databaseName());
        if (shardingDataSourceInfo != null) {
            int databaseNum = shardingDataSourceInfo.getShardingDataBaseStrategy().calculate(shardingDataSourceInfo.getShardingCount(), shardingKey);

            // 设置上下文的数据库
            ShardingContext.setShardingDatabase(sharding.databaseName() + ShardingContext.getMasterSalve() + databaseNum);
        }

        // 确定表名
        Integer tableSuffix = calculateTableSuffix(sharding, shardingDataSourceInfo.getShardingCount(), shardingKey);
        return getTableName(sharding.tableName(), tableSuffix);
    }

    private String getTableName(String tableName, Integer shardingKey) {
        return tableName + UNDERLINE + shardingKey;
    }

}
