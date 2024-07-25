package org.common;

public class Order
{
    private final double orderValue;
    private final int itemCount;

    public Order(final double orderValue, final int itemCount)
    {
        this.orderValue = orderValue;
        this.itemCount = itemCount;
    }

    public double getOrderValue()
    {
        return orderValue;
    }

    public int getItemCount()
    {
        return itemCount;
    }
}
