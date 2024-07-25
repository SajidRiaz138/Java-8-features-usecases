package org.common;

import java.util.Objects;

public class Product
{
    private final String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price)
    {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public void reduceQuantity(int amount)
    {
        this.quantity -= amount;
    }

    public void increaseQuantity(int amount)
    {
        this.quantity += amount;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                quantity == product.quantity &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, quantity, price);
    }
}
