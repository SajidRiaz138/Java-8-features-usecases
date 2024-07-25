package org.functions.function.usecases;

import org.functions.function.entity.CustomerRating;
import org.functions.function.entity.InventoryStats;
import org.functions.function.entity.ProductSales;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class ECommerceAnalyticsSystem
{
    public static void main(String[] args)
    {
        // Sample data
        List<ProductSales> productSalesList = Arrays.asList(
                new ProductSales("P001", 100, 15000.0),
                new ProductSales("P002", 50, 8000.0),
                new ProductSales("P003", 200, 30000.0));

        List<CustomerRating> customerRatingsList = Arrays.asList(
                new CustomerRating("C001", 4.5),
                new CustomerRating("C002", 3.8),
                new CustomerRating("C003", 4.9));

        List<InventoryStats> inventoryStatsList = Arrays.asList(
                new InventoryStats("P001", 500, 1627852800L), // Unix timestamp for example
                new InventoryStats("P002", 300, 1627939200L),
                new InventoryStats("P003", 100, 1628025600L));

        // IntFunction<R> to create an array of products based on the number of units sold
        IntFunction<ProductSales[]> createProductArray = ProductSales[]::new;
        ProductSales[] productArray = createProductArray.apply(3);
        System.arraycopy(productSalesList.toArray(), 0, productArray, 0, 3);
        System.out.println("Product Array: " + Arrays.toString(productArray));

        // IntToDoubleFunction to calculate average revenue per unit sold
        IntToDoubleFunction averageRevenuePerUnit = unitsSold -> productSalesList.stream()
                .filter(ps -> ps.getUnitsSold() == unitsSold)
                .mapToDouble(ProductSales::getTotalRevenue)
                .average()
                .orElse(0.0);
        double avgRevenue = averageRevenuePerUnit.applyAsDouble(100);
        System.out.println("Average Revenue per Unit Sold for 100 units: " + avgRevenue);

        // LongFunction<R> to get product sales by restock date
        LongFunction<ProductSales> getProductByRestockDate = restockDate -> inventoryStatsList.stream()
                .filter(stats -> stats.getRestockDate() == restockDate)
                .map(stats -> productSalesList.stream()
                        .filter(ps -> ps.getProductId().equals(stats.getProductId()))
                        .findFirst()
                        .orElse(null))
                .findFirst()
                .orElse(null);
        ProductSales productByRestockDate = getProductByRestockDate.apply(1627852800L);
        System.out.println("Product Sales by Restock Date: " + productByRestockDate);

        // IntToLongFunction to calculate total restock date in days
        IntToLongFunction totalRestockDays = quantity -> inventoryStatsList.stream()
                .filter(stats -> stats.getQuantity() == quantity)
                .mapToLong(InventoryStats::getRestockDate)
                .sum();
        long totalDays = totalRestockDays.applyAsLong(500);
        System.out.println("Total Restock Days for Quantity 500: " + totalDays);

        // LongToDoubleFunction to calculate average rating by restock date
        LongToDoubleFunction averageRatingByRestockDate = restockDate -> customerRatingsList.stream()
                .filter(rating -> inventoryStatsList.stream()
                        .anyMatch(stats -> stats.getRestockDate() == restockDate && stats.getProductId().equals(rating.getCustomerId())))
                .mapToDouble(CustomerRating::getRating)
                .average()
                .orElse(0.0);
        double avgRating = averageRatingByRestockDate.applyAsDouble(1627852800L);
        System.out.println("Average Rating by Restock Date: " + avgRating);

        // LongToIntFunction to calculate total quantity by restock date
        LongToIntFunction totalQuantityByRestockDate = restockDate -> inventoryStatsList.stream()
                .filter(stats -> stats.getRestockDate() == restockDate)
                .mapToInt(InventoryStats::getQuantity)
                .sum();
        int totalQuantity = totalQuantityByRestockDate.applyAsInt(1627852800L);
        System.out.println("Total Quantity by Restock Date: " + totalQuantity);

        // DoubleFunction<R> to get customer rating by rating value
        DoubleFunction<CustomerRating> getCustomerByRating = rating -> customerRatingsList.stream()
                .filter(cr -> cr.getRating() == rating)
                .findFirst()
                .orElse(null);
        CustomerRating customerByRating = getCustomerByRating.apply(4.5);
        System.out.println("Customer by Rating: " + customerByRating);

        // ToIntFunction<T> to get units sold by product
        ToIntFunction<ProductSales> getUnitsSold = ProductSales::getUnitsSold;
        int unitsSold = getUnitsSold.applyAsInt(productSalesList.get(0));
        System.out.println("Units Sold for Product P001: " + unitsSold);

        // ToDoubleFunction<T> to get total revenue by product
        ToDoubleFunction<ProductSales> getTotalRevenue = ProductSales::getTotalRevenue;
        double totalRevenue = getTotalRevenue.applyAsDouble(productSalesList.get(0));
        System.out.println("Total Revenue for Product P001: " + totalRevenue);

        // ToLongFunction<T> to get restock date by inventory stats
        ToLongFunction<InventoryStats> getRestockDate = InventoryStats::getRestockDate;
        long restockDate = getRestockDate.applyAsLong(inventoryStatsList.get(0));
        System.out.println("Restock Date for Product P001: " + restockDate);
    }
}
