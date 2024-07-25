package org.functions.supplier;

import org.common.Configuration;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationUtils
{

    // Generates a default configuration
    public static Configuration generateDefaultConfig()
    {
        Map<String, String> properties = new HashMap<>();
        properties.put("timeout", "30");
        properties.put("maxConnections", "100");
        properties.put("enableLogging", "true");
        return new Configuration("default", properties);
    }

    // Generates a database configuration
    public static Configuration generateDatabaseConfig()
    {
        Map<String, String> properties = new HashMap<>();
        properties.put("url", "jdbc:mysql://localhost:3306/mydb");
        properties.put("username", "root");
        properties.put("password", "password");
        return new Configuration("database", properties);
    }

    // Generates a cache configuration
    public static Configuration generateCacheConfig()
    {
        Map<String, String> properties = new HashMap<>();
        properties.put("cacheSize", "1000");
        properties.put("cacheTimeout", "60");
        return new Configuration("cache", properties);
    }
}
