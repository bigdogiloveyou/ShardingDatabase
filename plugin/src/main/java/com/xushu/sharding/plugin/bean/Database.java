package com.xushu.sharding.plugin.bean;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import java.util.Map;

/**
 * 分库配置，从配置文件中解析
 */
public class Database {

    /**
     * 分库策略
     */
    private String shardingStrategy = "";

    /**
     * 分库数量
     */
    private Integer shardingCount;

    /**
     * key：分库位
     * value：分库对应的dataSource配置
     */
    private Map<String, Map<Integer, DataSourceProperties>> dataSource;

    public String getShardingStrategy() {
        return shardingStrategy;
    }

    public void setShardingStrategy(String shardingStrategy) {
        this.shardingStrategy = shardingStrategy;
    }

    public Integer getShardingCount() {
        return shardingCount;
    }

    public void setShardingCount(Integer shardingCount) {
        this.shardingCount = shardingCount;
    }

    public Map<String, Map<Integer, DataSourceProperties>> getDataSource() {
        return dataSource;
    }

    public void setDataSource(Map<String, Map<Integer, DataSourceProperties>> dataSource) {
        this.dataSource = dataSource;
    }
}
