package org.functions.supplier;

import org.functions.supplier.entity.Customer;
import org.functions.supplier.entity.Order;
import org.functions.supplier.entity.Product;

import java.util.Arrays;
import java.util.List;

public class ECommerceUtils
{

    // Generates product recommendations
    public static List<Product> generateProductRecommendations()
    {
        return Arrays.asList(
                new Product("P001", "Laptop", 1500.0),
                new Product("P002", "Smartphone", 800.0),
                new Product("P003", "Tablet", 600.0));
    }

    // Creates an order summary
    public static Order createOrderSummary()
    {
        List<Product> products = Arrays.asList(
                new Product("P004", "Headphones", 150.0),
                new Product("P005", "Keyboard", 100.0),
                new Product("P006", "Mouse", 50.0));
        return new Order("O001", products);
    }

    // Fetches customer details
    public static Customer fetchCustomerDetails()
    {
        return new Customer("C001", "John Doe", "john.doe@example.com");
    }
}
