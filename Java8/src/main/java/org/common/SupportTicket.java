package org.common;

import java.time.Duration;
import java.time.LocalDateTime;

public class SupportTicket
{
    private final String ticketId;
    private final String customerName;
    private String status;
    private String assignedAgent;
    private LocalDateTime creationTime;
    private LocalDateTime resolutionTime;

    public SupportTicket(String ticketId, String customerName, String status)
    {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.status = status;
        this.creationTime = LocalDateTime.now();
    }

    public String getTicketId()
    {
        return ticketId;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public String getStatus()
    {
        return status;
    }

    public String getAssignedAgent()
    {
        return assignedAgent;
    }

    public LocalDateTime getCreationTime()
    {
        return creationTime;
    }

    public LocalDateTime getResolutionTime()
    {
        return resolutionTime;
    }

    public void setStatus(String status)
    {
        this.status = status;
        if ("Resolved".equals(status) || "Closed".equals(status))
        {
            this.resolutionTime = LocalDateTime.now();
        }
    }

    public void assignAgent(String agent)
    {
        this.assignedAgent = agent;
    }

    public long getResolutionTimeMinutes()
    {
        if (resolutionTime != null)
        {
            return Duration.between(creationTime, resolutionTime).toMinutes();
        }
        return 0;
    }
}
