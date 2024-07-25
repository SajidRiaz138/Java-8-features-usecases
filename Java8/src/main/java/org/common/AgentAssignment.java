package org.common;

public class AgentAssignment
{
    private final String ticketId;
    private final String agentName;

    public AgentAssignment(String ticketId, String agentName)
    {
        this.ticketId = ticketId;
        this.agentName = agentName;
    }

    public String getTicketId()
    {
        return ticketId;
    }

    public String getAgentName()
    {
        return agentName;
    }
}
