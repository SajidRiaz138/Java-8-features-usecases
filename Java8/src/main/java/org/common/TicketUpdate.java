package org.common;

public class TicketUpdate
{
    private final String ticketId;
    private final String newStatus;

    public TicketUpdate(String ticketId, String newStatus)
    {
        this.ticketId = ticketId;
        this.newStatus = newStatus;
    }

    public String getTicketId()
    {
        return ticketId;
    }

    public String getNewStatus()
    {
        return newStatus;
    }
}
