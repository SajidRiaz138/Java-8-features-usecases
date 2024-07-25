package org.streams.reduceoperation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class HotelBookingSystemAnalysis
{
    public static void main(String[] args)
    {
        List<User> customers = getUsers();

        // Calculate total revenue
        double totalRevenue = customers.stream()
                .flatMap(customer -> customer.getBookings().stream())
                .mapToDouble(Booking::getTotalPrice)
                .sum();

        System.out.println("Total Revenue: $" + totalRevenue);

        // Find the customer with the highest spending
        Optional<User> highestSpender = customers.stream()
                .reduce((c1, c2) -> c1.getTotalSpent() > c2.getTotalSpent() ? c1 : c2);

        highestSpender.ifPresent(customer -> System.out
                .println("Highest Spender: " + customer.getName() + " with total spent $" + customer.getTotalSpent()));

        // Aggregate room bookings by type
        Map<String, Long> roomBookings = customers.stream()
                .flatMap(customer -> customer.getBookings().stream())
                .map(Booking::getRoom)
                .collect(Collectors.groupingBy(Room::getType, Collectors.counting()));

        System.out.println("Room Bookings:");
        roomBookings.forEach((roomType, count) -> System.out.println(roomType + ": " + count + " bookings"));

        // Aggregate total nights booked by room type
        Map<String, Integer> nightsBooked = customers.stream()
                .flatMap(customer -> customer.getBookings().stream())
                .collect(Collectors.toMap(
                        booking -> booking.getRoom().getType(),
                        Booking::getNights,
                        Integer::sum));

        System.out.println("Total Nights Booked by Room Type:");
        nightsBooked.forEach((roomType, nights) -> System.out.println(roomType + ": " + nights + " nights"));
    }

    private static List<User> getUsers()
    {
        Room singleRoom = new Room("Single", 100.00);
        Room doubleRoom = new Room("Double", 150.00);
        Room suiteRoom = new Room("Suite", 300.00);

        Booking booking1 = new Booking(1, singleRoom, 3);
        Booking booking2 = new Booking(2, doubleRoom, 2);
        Booking booking3 = new Booking(3, suiteRoom, 5);
        Booking booking4 = new Booking(4, doubleRoom, 4);
        Booking booking5 = new Booking(5, singleRoom, 1);

        User customer1 = new User("Alice", Arrays.asList(booking1, booking2));
        User customer2 = new User("Bob", Collections.singletonList(booking3));
        User customer3 = new User("Charlie", Arrays.asList(booking4, booking5));

        return Arrays.asList(customer1, customer2, customer3);
    }
}

@Getter
@AllArgsConstructor
@ToString
class Room
{
    private final String type;
    private final double pricePerNight;

}

@Getter
@AllArgsConstructor
@ToString
class Booking
{
    private final int bookingId;
    private final Room room;
    private final int nights;

    public double getTotalPrice()
    {
        return room.getPricePerNight() * nights;
    }
}

@Getter
@AllArgsConstructor
@ToString
class User
{
    private final String name;
    private final List<Booking> bookings;

    public double getTotalSpent()
    {
        return bookings.stream()
                .mapToDouble(Booking::getTotalPrice)
                .sum();
    }
}
