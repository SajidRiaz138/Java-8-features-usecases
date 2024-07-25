package org.streams.flatmap;

import java.util.*;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class FlatMap
{
    public static void main(String[] args)
    {
        List<String> authorNames = getAuthors(getBooks());
        authorNames.forEach(System.out::println);
        Map<String, List<Product>> categoryProductMap = getCategoryProductMap();

        List<Product> discountedProducts = getDiscountedProducts(categoryProductMap);
        discountedProducts.forEach(System.out::println);

        List<Order> orders = getOrders();
        List<Item> discountedItems = getDiscountedItems(orders);
        discountedItems.forEach(System.out::println);
    }

    private static List<Item> getDiscountedItems(List<Order> orders)
    {
        return orders.stream()
                .flatMap(order -> order.getItems().stream())
                .peek(item -> item.applyDiscount(0.1))
                .collect(Collectors.toList());
    }

    private static List<Order> getOrders()
    {
        return Arrays.asList(
                new Order(1, Arrays.asList(new Item("Laptop", 1000.00), new Item("Mouse", 25.00))),
                new Order(2, Arrays.asList(new Item("Keyboard", 75.00), new Item("Monitor", 300.00))),
                new Order(3, Arrays.asList(new Item("Tablet", 200.00), new Item("Charger", 20.00))));
    }

    private static Map<String, List<Product>> getCategoryProductMap()
    {
        Map<String, List<Product>> categoryProductMap = new HashMap<>();
        categoryProductMap.put("Electronics", Arrays.asList(new Product("Laptop", 1000.00), new Product("Smartphone", 500.00)));
        categoryProductMap.put("Furniture", Arrays.asList(new Product("Chair", 150.00), new Product("Table", 300.00)));
        categoryProductMap.put("Books", Arrays.asList(new Product("Java Programming", 45.00), new Product("Data Structures", 60.00)));
        return categoryProductMap;
    }

    private static List<Product> getDiscountedProducts(Map<String, List<Product>> categoryProductMap)
    {
        return categoryProductMap.values()
                .stream()
                .flatMap(Collection::stream)
                .peek(product -> product.applyDiscount(0.1))
                .collect(Collectors.toList());
    }

    private static List<Book> getBooks()
    {
        return Arrays.asList(
                new Book("Java Programming", Arrays.asList(new Author("Author1"), new Author("Author2"))),
                new Book("Data Structures", Arrays.asList(new Author("Author3"), new Author("Author4"))),
                new Book("Algorithms", Arrays.asList(new Author("Author5"), new Author("Author6"))));
    }

    private static List<String> getAuthors(List<Book> books)
    {
        return books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .map(Author::getName)
                .collect(Collectors.toList());
    }
}

@Getter
@ToString
class Product
{
    private final String productId;
    private final double price;
    private double discount;

    public Product(final String productId, final double price)
    {
        this.price = price;
        this.discount = 0d;
        this.productId = productId;
    }

    public void applyDiscount(double discountRate)
    {
        this.discount = price * discountRate;
    }
}

@Getter
@ToString
class Item
{
    private final String name;
    private final double price;
    private double discount;

    public Item(String name, double price)
    {
        this.name = name;
        this.price = price;
        this.discount = 0.0;
    }

    public void applyDiscount(double discountRate)
    {
        this.discount = price * discountRate;
    }
}

@Getter
@AllArgsConstructor
@ToString
class Order
{
    private int orderId;
    private List<Item> items;
}

@Getter
@ToString
@AllArgsConstructor
class Book
{
    private final String title;
    private final List<Author> authors;
}

@Getter
@ToString
@AllArgsConstructor
class Author
{
    private final String name;
}
