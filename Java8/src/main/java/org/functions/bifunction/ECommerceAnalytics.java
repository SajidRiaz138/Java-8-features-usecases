package org.functions.bifunction;

import org.common.Item;
import org.common.Order;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

public class ECommerceAnalytics
{
    public static void main(String[] args)
    {
        List<Order> orders = getOrders();

        List<Item> items = getItems();

        // Calculate total items sold using ToIntBiFunction
        ToIntBiFunction<Integer, Integer> totalItemsSold = Integer::max;
        int totalItems = items.stream()
                .mapToInt(item -> totalItemsSold.applyAsInt(0, item.getQuantity()))
                .sum();
        System.out.println("Total Items Sold: " + totalItems);

        // Calculate total revenue using ToLongBiFunction
        ToLongBiFunction<Double, Integer> totalRevenue = (price, quantity) -> (long) (price * quantity);
        long revenue = items.stream()
                .mapToLong(item -> totalRevenue.applyAsLong(item.getPrice(), item.getQuantity()))
                .sum();
        System.out.println("Total Revenue: $" + revenue);

        // Calculate average order value using ToDoubleBiFunction
        ToDoubleBiFunction<Double, Integer> averageOrderValue = (orderValue, itemCount) -> orderValue / itemCount;
        double totalOrderValue = orders.stream()
                .mapToDouble(Order::getOrderValue)
                .sum();

        int totalOrderItems = orders.stream()
                .mapToInt(Order::getItemCount)
                .sum();
        double averageOrder = averageOrderValue.applyAsDouble(totalOrderValue, totalOrderItems);
        System.out.println("Average Order Value: $" + averageOrder);

        // Calculate maximum order value
        double maxOrderValue = orders.stream()
                .mapToDouble(Order::getOrderValue)
                .max()
                .orElse(0.0);
        System.out.println("Maximum Order Value: $" + maxOrderValue);

        // Calculate minimum order value
        double minOrderValue = orders.stream()
                .mapToDouble(Order::getOrderValue)
                .min()
                .orElse(0.0);
        System.out.println("Minimum Order Value: $" + minOrderValue);
    }

    private static List<Order> getOrders()
    {
        return Arrays.asList(
                new Order(100.0, 3),
                new Order(200.0, 5),
                new Order(150.0, 2),
                new Order(50.0, 1),
                new Order(250.0, 4));
    }

    private static List<Item> getItems()
    {
        return Arrays.asList(
                new Item(20.0, 3),
                new Item(15.0, 5),
                new Item(30.0, 2),
                new Item(25.0, 6),
                new Item(10.0, 4));
    }
}
