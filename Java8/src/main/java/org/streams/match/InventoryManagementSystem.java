package org.streams.match;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class InventoryManagementSystem
{
    public static void main(String[] args)
    {
        Inventory inventory = getInventory();

        // Check if any product is out of stock
        boolean anyOutOfStock = inventory.getCategories()
                .stream()
                .flatMap(category -> category.getProducts().stream())
                .anyMatch(product -> product.getQuantity() == 0);

        System.out.println("Any product out of stock: " + anyOutOfStock);

        // Check if all products in Electronics category are available
        boolean allElectronicsAvailable = inventory.getCategories()
                .stream()
                .filter(category -> category.getName().equals("Electronics"))
                .flatMap(category -> category.getProducts().stream())
                .allMatch(Product::isAvailable);

        System.out.println("All Electronics products available: " + allElectronicsAvailable);

        // Check if no product exceeds a certain price
        double priceThreshold = 1500.00;
        boolean noProductExceedsPrice = inventory.getCategories()
                .stream()
                .flatMap(category -> category.getProducts().stream())
                .noneMatch(product -> product.isExpensive(priceThreshold));

        System.out.println("No product exceeds price of $" + priceThreshold + ": " + noProductExceedsPrice);
    }

    private static Inventory getInventory()
    {
        Product product1 = new Product("Laptop", "Electronics", 1200.00, 5);
        Product product2 = new Product("Phone", "Electronics", 800.00, 0);
        Product product3 = new Product("Headphones", "Electronics", 150.00, 10);
        Product product4 = new Product("Monitor", "Electronics", 300.00, 2);
        Product product5 = new Product("Fridge", "Appliances", 1000.00, 3);
        Product product6 = new Product("Oven", "Appliances", 500.00, 1);
        Product product7 = new Product("Microwave", "Appliances", 200.00, 0);

        Category category1 = new Category("Electronics", Arrays.asList(product1, product2, product3, product4));
        Category category2 = new Category("Appliances", Arrays.asList(product5, product6, product7));

        return new Inventory(Arrays.asList(category1, category2));
    }
}

@Getter
@AllArgsConstructor
class Product
{
    private final String name;
    private final String category;
    private final double price;
    private final int quantity;

    public boolean isAvailable()
    {
        return quantity > 0;
    }

    public boolean isExpensive(double priceThreshold)
    {
        return price > priceThreshold;
    }
}

@AllArgsConstructor
@Getter
class Category
{
    private final String name;
    private final List<Product> products;
}

@AllArgsConstructor
@Getter
class Inventory
{
    private final List<Category> categories;
}
