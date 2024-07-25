package org.common;

public class SensitiveData
{
    private final String id;
    private String value;

    public SensitiveData(String id, String value)
    {
        this.id = id;
        this.value = value;
    }

    public String getId()
    {
        return id;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "SensitiveData{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
