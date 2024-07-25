package org.functions.operator;

import org.common.Product;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class RetailManagementSystem
{
    public static void main(String[] args)
    {
        // Sample data
        List<Product> productList1 = Arrays.asList(
                new Product("Laptop", 10, 1500.0),
                new Product("Smartphone", 20, 800.0),
                new Product("Tablet", 15, 600.0));

        List<Product> productList2 = Arrays.asList(
                new Product("Laptop", 5, 1400.0), // Cheaper price
                new Product("Smartwatch", 30, 300.0),
                new Product("Tablet", 10, 650.0) // Higher price
        );

        // BinaryOperator to apply discounts (final price)
        BinaryOperator<Double> applyDiscount = (basePrice, discount) -> basePrice - (basePrice * discount);

        double basePrice = 1000.0;
        double discount = 0.1;
        double finalPrice = applyDiscount.apply(basePrice, discount);
        System.out.println("Final Price after discount: $" + finalPrice); // Output: Final Price after discount: $900.0

        // BinaryOperator to compare product prices (cheaper product)
        BinaryOperator<Product> cheaperProduct = (prod1, prod2) -> prod1.getPrice() <= prod2.getPrice() ? prod1 : prod2;

        Product product1 = new Product("Laptop", 10, 1500.0);
        Product product2 = new Product("Laptop", 5, 1400.0);
        Product cheaper = cheaperProduct.apply(product1, product2);
        System.out.println("Cheaper Product: " + cheaper); // Output: Cheaper Product: Product{name='Laptop', quantity=5, price=1400.0}

        // BinaryOperator to merge two product lists, resolving conflicts by taking the lower price
        BinaryOperator<Map<String, Product>> mergeProductLists = (list1, list2) ->
        {
            Map<String, Product> merged = new HashMap<>(list1);
            list2.forEach((name, product) -> merged.merge(name, product,
                    (p1, p2) -> new Product(p1.getName(), p1.getQuantity() + p2.getQuantity(), Math.min(p1.getPrice(), p2.getPrice()))));
            return merged;
        };

        Map<String, Product> productList1Map = productList1.stream()
                .collect(Collectors.toMap(Product::getName, prod -> prod));
        Map<String, Product> productList2Map = productList2.stream()
                .collect(Collectors.toMap(Product::getName, prod -> prod));

        Map<String, Product> mergedProductList = mergeProductLists.apply(productList1Map, productList2Map);

        System.out.println("Merged Product List:");
        mergedProductList.values().forEach(System.out::println);
    }
}
