package org.common;

import java.util.Map;
import java.util.Objects;

public class Configuration
{
    private final String configName;
    private final Map<String, String> properties;

    public Configuration(String configName, Map<String, String> properties)
    {
        this.configName = configName;
        this.properties = properties;
    }

    public String getConfigName()
    {
        return configName;
    }

    public Map<String, String> getProperties()
    {
        return properties;
    }

    @Override
    public String toString()
    {
        return "Configuration{" +
                "configName='" + configName + '\'' +
                ", properties=" + properties +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(configName, that.configName) &&
                Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(configName, properties);
    }
}
