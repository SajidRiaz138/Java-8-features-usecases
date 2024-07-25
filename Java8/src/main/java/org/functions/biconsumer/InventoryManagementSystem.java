package org.functions.biconsumer;

import org.common.Product;
import org.common.Sale;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

public class InventoryManagementSystem
{

    private static final Logger logger = Logger.getLogger(InventoryManagementSystem.class.getName());
    private static final Map<String, Product> inventory = new HashMap<>();

    public static void main(String[] args)
    {
        // Initialize inventory
        inventory.put("Laptop", new Product("Laptop", 50, 1000.0));
        inventory.put("Smartphone", new Product("Smartphone", 100, 500.0));
        inventory.put("Tablet", new Product("Tablet", 30, 300.0));

        // Sample sales data
        List<Sale> sales = Arrays.asList(
                new Sale("Laptop", 10),
                new Sale("Smartphone", 25),
                new Sale("Tablet", 5));

        // BiConsumer to update inventory
        BiConsumer<Product, Integer> updateInventory = (product, quantitySold) -> product.reduceQuantity(quantitySold);

        // BiConsumer to log sales
        BiConsumer<String, Integer> logSales =
                (productName, quantitySold) -> logger.info("Sold " + quantitySold + " units of " + productName);

        // Process each sale
        sales.forEach(sale ->
        {
            Product product = inventory.get(sale.getProductName());
            if (product != null)
            {
                updateInventory.accept(product, sale.getQuantitySold());
                logSales.accept(sale.getProductName(), sale.getQuantitySold());
            }
        });

        // Generate sales report
        generateSalesReport();
    }

    private static void generateSalesReport()
    {
        System.out.println("Sales Report:");
        inventory.forEach((name, product) ->
        {
            System.out.println("Product: " + product.getName() + ", Remaining Quantity: " + product.getQuantity());
        });
    }
}
