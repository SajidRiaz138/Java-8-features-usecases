package org.streams.reduceoperation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class EcommerceSalesAnalysis
{
    public static void main(String[] args)
    {
        List<Customer> customers = getCustomers();

        // Calculate total revenue
        double totalRevenue = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .mapToDouble(Order::getTotalPrice)
                .sum();

        System.out.println("Total Revenue: $" + totalRevenue);

        // Find the customer with the highest spending
        Optional<Customer> highestSpender = customers.stream()
                .reduce((c1, c2) -> c1.getTotalSpent() > c2.getTotalSpent() ? c1 : c2);

        highestSpender.ifPresent(customer -> System.out
                .println("Highest Spender: " + customer.getName() + " with total spent $" + customer.getTotalSpent()));

        // Aggregate product sales
        Map<String, Double> productSales = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toMap(
                        Product::getName,
                        Product::getPrice,
                        Double::sum));

        System.out.println("Product Sales:");
        productSales.forEach((product, sales) -> System.out.println(product + ": $" + sales));
    }

    private static List<Customer> getCustomers()
    {
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Phone", 800.00);
        Product product3 = new Product("Headphones", 150.00);
        Product product4 = new Product("Monitor", 300.00);

        Order order1 = new Order(1, Arrays.asList(product1, product2));
        Order order2 = new Order(2, Collections.singletonList(product3));
        Order order3 = new Order(3, Arrays.asList(product4, product2));
        Order order4 = new Order(4, Arrays.asList(product1, product3, product4));

        Customer customer1 = new Customer("Alice", Arrays.asList(order1, order2));
        Customer customer2 = new Customer("Bob", Collections.singletonList(order3));
        Customer customer3 = new Customer("Charlie", Collections.singletonList(order4));

        return Arrays.asList(customer1, customer2, customer3);
    }
}

@AllArgsConstructor
@Getter
@ToString
class Product
{
    private final String name;
    private final double price;
}

@AllArgsConstructor
@Getter
@ToString
class Order
{
    private final int orderId;
    private List<Product> products;

    public double getTotalPrice()
    {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}

@AllArgsConstructor
@Getter
@ToString
class Customer
{
    private final String name;
    private final List<Order> orders;

    public double getTotalSpent()
    {
        return orders.stream()
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }
}
