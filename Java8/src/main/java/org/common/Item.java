package org.common;

public class Item
{
    private final double price;
    private final int quantity;

    public Item(final double price, final int quantity)
    {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }
}
