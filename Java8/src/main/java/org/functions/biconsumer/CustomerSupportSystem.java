package org.functions.biconsumer;

import org.common.AgentAssignment;
import org.common.SupportTicket;
import org.common.TicketUpdate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

public class CustomerSupportSystem
{

    private static final Logger logger = Logger.getLogger(CustomerSupportSystem.class.getName());
    private static final Map<String, SupportTicket> ticketSystem = new HashMap<>();

    public static void main(String[] args)
    {
        // Initialize support tickets
        ticketSystem.put("T001", new SupportTicket("T001", "John Doe", "Open"));
        ticketSystem.put("T002", new SupportTicket("T002", "Jane Smith", "Open"));
        ticketSystem.put("T003", new SupportTicket("T003", "Alice Johnson", "Open"));

        // Sample ticket updates
        List<TicketUpdate> updates = Arrays.asList(
                new TicketUpdate("T001", "Resolved"),
                new TicketUpdate("T002", "In Progress"),
                new TicketUpdate("T003", "Closed"));

        // Sample agent assignments
        List<AgentAssignment> assignments = Arrays.asList(
                new AgentAssignment("T001", "Agent A"),
                new AgentAssignment("T002", "Agent B"),
                new AgentAssignment("T003", "Agent C"));

        // BiConsumer to update ticket status
        BiConsumer<SupportTicket, String> updateTicketStatus = (ticket, newStatus) -> ticket.setStatus(newStatus);

        // BiConsumer to send notification
        BiConsumer<String, String> sendNotification =
                (ticketId, newStatus) -> logger.info("Ticket " + ticketId + " status updated to " + newStatus);

        // BiConsumer to assign ticket to agent
        BiConsumer<SupportTicket, String> assignAgent = (ticket, agent) -> ticket.assignAgent(agent);

        // BiConsumer to log agent assignment
        BiConsumer<String, String> logAssignment = (ticketId, agent) -> logger.info("Ticket " + ticketId + " assigned to " + agent);

        // Process each ticket update
        updates.forEach(update ->
        {
            SupportTicket ticket = ticketSystem.get(update.getTicketId());
            if (ticket != null)
            {
                updateTicketStatus.accept(ticket, update.getNewStatus());
                sendNotification.accept(update.getTicketId(), update.getNewStatus());
            }
        });

        // Process each agent assignment
        assignments.forEach(assignment ->
        {
            SupportTicket ticket = ticketSystem.get(assignment.getTicketId());
            if (ticket != null)
            {
                assignAgent.accept(ticket, assignment.getAgentName());
                logAssignment.accept(assignment.getTicketId(), assignment.getAgentName());
            }
        });

        // Generate ticket report
        generateTicketReport();

        // Calculate average resolution time for resolved tickets
        double averageResolutionTime = calculateAverageResolutionTime();
        System.out.println("Average Resolution Time: " + averageResolutionTime + " minutes");
    }

    private static void generateTicketReport()
    {
        System.out.println("Ticket Report:");
        ticketSystem.forEach((id, ticket) ->
        {
            System.out.println("Ticket ID: " + ticket.getTicketId() + ", Customer: " + ticket.getCustomerName()
                    + ", Status: " + ticket.getStatus() + ", Assigned Agent: " + ticket.getAssignedAgent()
                    + ", Resolution Time: " + ticket.getResolutionTimeMinutes() + " minutes");
        });
    }

    private static double calculateAverageResolutionTime()
    {
        return ticketSystem.values()
                .stream()
                .filter(ticket -> "Resolved".equals(ticket.getStatus()) || "Closed".equals(ticket.getStatus()))
                .mapToLong(SupportTicket::getResolutionTimeMinutes)
                .average()
                .orElse(0.0);
    }
}
