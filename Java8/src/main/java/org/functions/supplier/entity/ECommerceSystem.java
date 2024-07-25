package org.functions.supplier.entity;

import org.functions.supplier.ECommerceUtils;
import static org.functions.supplier.Common.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ECommerceSystem
{
    public static void main(String[] args)
    {
        // Supplier for product recommendations
        Supplier<List<Product>> productRecommendationsSupplier = ECommerceUtils::generateProductRecommendations;

        // Supplier for order summary
        Supplier<Order> orderSummarySupplier = ECommerceUtils::createOrderSummary;

        // Supplier for customer details
        Supplier<Customer> customerDetailsSupplier = ECommerceUtils::fetchCustomerDetails;

        // Retrieve and print product recommendations
        List<Product> productRecommendations = productRecommendationsSupplier.get();
        System.out.println("Product Recommendations: " + productRecommendations);

        // Retrieve and print order summary
        Order orderSummary = orderSummarySupplier.get();
        System.out.println("Order Summary: " + orderSummary);

        // Retrieve and print customer details
        Customer customerDetails = customerDetailsSupplier.get();
        System.out.println("Customer Details: " + customerDetails);

        // Example of lazy initialization
        Supplier<Order> lazyOrderSummarySupplier = () ->
        {
            System.out.println("Creating order summary...");
            return ECommerceUtils.createOrderSummary();
        };

        // Order summary is not created until get() is called
        System.out.println("Lazy Order Summary (before get):");
        Order lazyOrderSummary = lazyOrderSummarySupplier.get();
        System.out.println("Lazy Order Summary (after get): " + lazyOrderSummary);

        // Example of caching
        Supplier<Customer> cachedCustomerDetailsSupplier = createCachedSupplier(ECommerceUtils::fetchCustomerDetails);
        Customer cachedCustomer1 = cachedCustomerDetailsSupplier.get();
        Customer cachedCustomer2 = cachedCustomerDetailsSupplier.get();

        System.out.println("Cached Customer Details (first call): " + cachedCustomer1);
        System.out.println("Cached Customer Details (second call): " + cachedCustomer2);

        // Example of dynamic update
        Supplier<List<Product>> dynamicProductRecommendationsSupplier = createDynamicSupplier(
                ECommerceUtils::generateProductRecommendations,
                () -> Arrays.asList(
                        new Product("P007", "Smartwatch", 200.0),
                        new Product("P008", "Fitness Tracker", 100.0)));

        System.out.println("Dynamic Product Recommendations (first call): " + dynamicProductRecommendationsSupplier.get());
        System.out.println("Dynamic Product Recommendations (second call): " + dynamicProductRecommendationsSupplier.get());
    }
}
