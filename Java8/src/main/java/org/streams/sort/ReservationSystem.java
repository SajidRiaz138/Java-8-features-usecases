package org.streams.sort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationSystem
{
    public static void main(String[] args)
    {
        List<Reservation> reservations = getReservations();

        // Sort reservations by check-in date
        List<Reservation> sortedByCheckInDate = reservations.stream()
                .sorted(Comparator.comparing(Reservation::getCheckInDate))
                .collect(Collectors.toList());
        System.out.println("Reservations sorted by check-in date:");
        sortedByCheckInDate.forEach(System.out::println);

        // Sort reservations by customer name
        List<Reservation> sortedByCustomerName = reservations.stream()
                .sorted(Comparator.comparing(reservation -> reservation.getCustomer().getName()))
                .collect(Collectors.toList());
        System.out.println("\nReservations sorted by customer name:");
        sortedByCustomerName.forEach(System.out::println);

        // Sort reservations by room type
        List<Reservation> sortedByRoomType = reservations.stream()
                .sorted(Comparator.comparing(reservation -> reservation.getRoom().getType()))
                .collect(Collectors.toList());
        System.out.println("\nReservations sorted by room type:");
        sortedByRoomType.forEach(System.out::println);

        // Sort reservations by total bill
        List<Reservation> sortedByTotalBill = reservations.stream()
                .sorted(Comparator.comparing(Reservation::getTotalBill))
                .collect(Collectors.toList());
        System.out.println("\nReservations sorted by total bill:");
        sortedByTotalBill.forEach(System.out::println);
    }

    private static List<Reservation> getReservations()
    {
        Room singleRoom = new Room("Single", 100.00);
        Room doubleRoom = new Room("Double", 150.00);
        Room suiteRoom = new Room("Suite", 300.00);

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        Customer customer3 = new Customer("Charlie");

        Reservation reservation1 = new Reservation(1, customer1, singleRoom, LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 5));
        Reservation reservation2 = new Reservation(2, customer2, suiteRoom, LocalDate.of(2023, 7, 2), LocalDate.of(2023, 7, 6));
        Reservation reservation3 = new Reservation(3, customer3, doubleRoom, LocalDate.of(2023, 7, 3), LocalDate.of(2023, 7, 4));
        Reservation reservation4 = new Reservation(4, customer1, suiteRoom, LocalDate.of(2023, 7, 4), LocalDate.of(2023, 7, 7));
        Reservation reservation5 = new Reservation(5, customer2, singleRoom, LocalDate.of(2023, 7, 1), LocalDate.of(2023, 7, 3));

        List<Reservation> reservations = Arrays.asList(reservation1, reservation2, reservation3, reservation4, reservation5);
        return reservations;
    }
}

@AllArgsConstructor
@Getter
@ToString
class Room
{
    private final String type;
    private final double pricePerNight;
}

@AllArgsConstructor
@Getter
class Reservation
{
    private final int reservationId;
    private final Customer customer;
    private final Room room;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;

    public double getTotalBill()
    {
        return room.getPricePerNight() * (checkOutDate.toEpochDay() - checkInDate.toEpochDay());
    }

    @Override
    public String toString()
    {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", customer=" + customer.getName() +
                ", room=" + room.getType() +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", totalBill=" + getTotalBill() +
                '}';
    }
}

@AllArgsConstructor
@Getter
@ToString
class Customer
{
    private final String name;
}
