package org.functions.supplier.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Order
{
    private final String orderId;
    private final List<Product> products;
    private final double totalAmount;

    public Order(String orderId, List<Product> products)
    {
        this.orderId = orderId;
        this.products = products;
        this.totalAmount = products.stream().mapToDouble(Product::getPrice).sum();
    }
}
