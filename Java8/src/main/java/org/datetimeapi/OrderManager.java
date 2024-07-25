package org.datetimeapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderManager
{
    public static void main(String[] args)
    {
        List<Order> orders = Arrays.asList(new Order("1001", "2023-07-23 09:00", "America/Los_Angeles"),
                new Order("1002", "2023-07-23 12:00", "Europe/London"),
                new Order("1003", "2023-07-23 15:00", "Asia/Tokyo"));


        LocalDateTime startPeriod = LocalDateTime.of(2023, 7, 23, 0, 0);
        LocalDateTime endPeriod = LocalDateTime.of(2023, 7, 23, 23, 59);
        Predicate<Order> filterOrders = (order) -> !order.getOrderDate().isBefore(startPeriod)
                && !order.getOrderDate().isAfter(endPeriod);

        List<Order> ordersInPeriod = orders.stream()
                .filter(filterOrders)
                .collect(Collectors.toList());

        // Step 2: Calculate and print the estimated delivery dates for each order
        orders.forEach(order ->
        {
            ZonedDateTime estimatedDeliveryDate = Shipping.calculateEstimatedDeliveryDate(order);
            System.out.println("Order " + order.getOrderId() + " estimated delivery date: " + estimatedDeliveryDate);
        });

        System.out.println("Orders placed on July 23, 2023:");
        ordersInPeriod.forEach(System.out::println);
    }
}

@Getter
@AllArgsConstructor
@ToString
class Order
{
    private String orderId;
    private LocalDateTime orderDate;
    private String customerTimeZone;

    public Order(String orderId, String orderDate, String customerTimeZone)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.orderId = orderId;
        this.orderDate = LocalDateTime.parse(orderDate, formatter);
        this.customerTimeZone = customerTimeZone;
    }

    public ZonedDateTime getOrderDateInCustomerZone()
    {
        ZoneId zoneId = ZoneId.of(customerTimeZone);
        return orderDate.atZone(zoneId);
    }

    public ZonedDateTime getOrderDateInWarehouseZone(ZoneId warehouseZone)
    {
        return getOrderDateInCustomerZone().withZoneSameInstant(warehouseZone);
    }
}

class Shipping
{
    private static final ZoneId WAREHOUSE_ZONE = ZoneId.of("America/New_York");
    private static final int SHIPPING_DAYS = 5;

    public static ZonedDateTime calculateEstimatedDeliveryDate(Order order)
    {
        ZonedDateTime orderDateInWarehouseZone = order.getOrderDateInWarehouseZone(WAREHOUSE_ZONE);
        return orderDateInWarehouseZone.plusDays(SHIPPING_DAYS);
    }
}
