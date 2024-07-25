package org.functions.supplier;

import static org.functions.supplier.Common.createCachedSupplier;
import static org.functions.supplier.Common.createDynamicSupplier;
import org.common.Configuration;

import java.util.function.Supplier;

public class ConfigurationManagementSystem
{

    public static void main(String[] args)
    {
        // Supplier for default configuration
        Supplier<Configuration> defaultConfigSupplier = ConfigurationUtils::generateDefaultConfig;

        // Supplier for database configuration
        Supplier<Configuration> databaseConfigSupplier = ConfigurationUtils::generateDatabaseConfig;

        // Supplier for cache configuration
        Supplier<Configuration> cacheConfigSupplier = ConfigurationUtils::generateCacheConfig;

        // Retrieve and print default configuration
        Configuration defaultConfig = defaultConfigSupplier.get();
        System.out.println("Default Configuration: " + defaultConfig);

        // Retrieve and print database configuration
        Configuration databaseConfig = databaseConfigSupplier.get();
        System.out.println("Database Configuration: " + databaseConfig);

        // Retrieve and print cache configuration
        Configuration cacheConfig = cacheConfigSupplier.get();
        System.out.println("Cache Configuration: " + cacheConfig);

        // Example of lazy initialization
        Supplier<Configuration> lazyDatabaseConfigSupplier = () ->
        {
            System.out.println("Generating database configuration...");
            return ConfigurationUtils.generateDatabaseConfig();
        };

        // Configuration is not generated until get() is called
        System.out.println("Lazy Database Configuration (before get):");
        Configuration lazyDatabaseConfig = lazyDatabaseConfigSupplier.get();
        System.out.println("Lazy Database Configuration (after get): " + lazyDatabaseConfig);

        // Example of caching
        Supplier<Configuration> cachedConfigSupplier = createCachedSupplier(ConfigurationUtils::generateDefaultConfig);
        Configuration cachedConfig1 = cachedConfigSupplier.get();
        Configuration cachedConfig2 = cachedConfigSupplier.get();

        System.out.println("Cached Configuration (first call): " + cachedConfig1);
        System.out.println("Cached Configuration (second call): " + cachedConfig2);

        // Example of dynamic update
        Supplier<Configuration> dynamicConfigSupplier = createDynamicSupplier(
                ConfigurationUtils::generateDefaultConfig,
                ConfigurationUtils::generateCacheConfig);

        System.out.println("Dynamic Configuration (first call): " + dynamicConfigSupplier.get());
        System.out.println("Dynamic Configuration (second call): " + dynamicConfigSupplier.get());
    }
}
