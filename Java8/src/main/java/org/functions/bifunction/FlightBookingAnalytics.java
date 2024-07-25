package org.functions.bifunction;

import org.common.Booking;
import org.common.Flight;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

public class FlightBookingAnalytics
{

    public static void main(String[] args)
    {
        List<Flight> flights = Arrays.asList(
                new Flight("AA101", Arrays.asList(new Booking(3, 200.0), new Booking(2, 250.0))),
                new Flight("BA202", Arrays.asList(new Booking(1, 300.0), new Booking(4, 150.0))),
                new Flight("CA303", Arrays.asList(new Booking(2, 400.0), new Booking(3, 350.0))),
                new Flight("DA404", Arrays.asList(new Booking(5, 120.0), new Booking(2, 220.0))));

        // Calculate total flights
        int totalFlights = flights.size();
        System.out.println("Total Flights: " + totalFlights);

        // Calculate total seats booked using ToIntBiFunction
        ToIntBiFunction<Integer, Integer> totalSeatsBooked = Integer::sum;
        int totalSeats = flights.stream()
                .flatMap(flight -> flight.getBookings().stream())
                .mapToInt(booking -> totalSeatsBooked.applyAsInt(0, booking.getNumberOfSeats()))
                .sum();
        System.out.println("Total Seats Booked: " + totalSeats); // Output: Total Seats Booked: 22

        // Calculate total revenue using ToLongBiFunction
        ToLongBiFunction<Double, Integer> totalRevenue = (price, seats) -> (long) (price * seats);
        double revenue = flights.stream()
                .flatMap(flight -> flight.getBookings().stream())
                .mapToLong(booking -> totalRevenue.applyAsLong(booking.getTicketPrice(), booking.getNumberOfSeats()))
                .sum();
        System.out.println("Total Revenue: $" + revenue); // Output: Total Revenue: $5650

        // Calculate average ticket price using ToDoubleBiFunction
        ToDoubleBiFunction<Double, Integer> averageTicketPrice = (totalPrice, totalSeat) -> totalPrice / totalSeat;
        double totalTicketPrice = flights.stream()
                .flatMap(flight -> flight.getBookings().stream())
                .mapToDouble(booking -> booking.getTicketPrice() * booking.getNumberOfSeats())
                .sum();
        double averagePrice = averageTicketPrice.applyAsDouble(totalTicketPrice, totalSeats);
        System.out.println("Average Ticket Price: $" + averagePrice); // Output: Average Ticket Price: $256.82

        // Calculate maximum ticket price
        double maxTicketPrice = flights.stream()
                .flatMap(flight -> flight.getBookings().stream())
                .mapToDouble(Booking::getTicketPrice)
                .max()
                .orElse(0.0);
        System.out.println("Maximum Ticket Price: $" + maxTicketPrice); // Output: Maximum Ticket Price: $400.0

        // Calculate minimum ticket price
        double minTicketPrice = flights.stream()
                .flatMap(flight -> flight.getBookings().stream())
                .mapToDouble(Booking::getTicketPrice)
                .min()
                .orElse(0.0);
        System.out.println("Minimum Ticket Price: $" + minTicketPrice); // Output: Minimum Ticket Price: $120.0

        // Calculate average revenue per flight
        ToDoubleBiFunction<Double, Integer> averageRevenuePerFlight =
                (totalRevenueValue, totalFlightCount) -> totalRevenueValue / totalFlightCount;
        double averageRevenue = averageRevenuePerFlight.applyAsDouble(revenue, totalFlights);
        System.out.println("Average Revenue per Flight: $" + averageRevenue); // Output: Average Revenue per Flight: $1412.5
    }
}
