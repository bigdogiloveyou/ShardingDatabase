package com.xushu.sharding.plugin;

import com.xushu.sharding.plugin.bean.Database;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author xushu
 */
@Configuration
@ConfigurationProperties(prefix = "sharding")
public class ShardingProperties {

    private Map<String, Database> databases;

    public Map<String, Database> getDatabases() {
        return databases;
    }

    public void setDatabases(Map<String, Database> databases) {
        this.databases = databases;
    }

}
