package org.common;

import java.util.Collections;
import java.util.List;

public class Flight
{
    private final String flightNumber;
    private final List<Booking> bookings;

    public Flight(String flightNumber, List<Booking> bookings)
    {
        this.flightNumber = flightNumber;
        this.bookings = bookings;
    }

    public String getFlightNumber()
    {
        return flightNumber;
    }

    public List<Booking> getBookings()
    {
        return Collections.unmodifiableList(bookings);
    }
}
