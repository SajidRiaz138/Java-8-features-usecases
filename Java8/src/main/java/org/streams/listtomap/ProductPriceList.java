package org.streams.listtomap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class ProductPriceList
{
    public static void main(String[] args)
    {
        List<Product> products = Arrays.asList(
                new Product("Apple", 0.99),
                new Product("Banana", 0.59),
                new Product("Cherry", 1.99));

        Map<String, Double> productPrices = products.stream()
                .collect(Collectors.toMap(
                        Product::getProductId,
                        Product::getPrice,
                        (e1, e2) -> e1,
                        HashMap::new));

        System.out.println(productPrices);
    }
}

@AllArgsConstructor
@Getter
@ToString
class Product
{
    private String productId;
    private double price;

}
