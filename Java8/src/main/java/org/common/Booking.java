package org.common;

public class Booking
{
    private final int numberOfSeats;
    private final double ticketPrice;

    public Booking(int numberOfSeats, double ticketPrice)
    {
        this.numberOfSeats = numberOfSeats;
        this.ticketPrice = ticketPrice;
    }

    public int getNumberOfSeats()
    {
        return numberOfSeats;
    }

    public double getTicketPrice()
    {
        return ticketPrice;
    }
}
