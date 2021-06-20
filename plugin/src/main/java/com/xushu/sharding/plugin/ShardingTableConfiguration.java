package com.xushu.sharding.plugin;

import com.xushu.sharding.plugin.interceptor.ShardingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 加载分表插件
 *
 * @author xushu
 */
@Configuration
public class ShardingTableConfiguration {

    @Bean
    public ShardingInterceptor shardingInterceptor() {
        return new ShardingInterceptor();
    }
}
