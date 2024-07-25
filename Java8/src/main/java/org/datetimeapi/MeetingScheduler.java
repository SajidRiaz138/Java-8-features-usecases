package org.datetimeapi;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class MeetingScheduler
{
    public static void main(String[] args)
    {
        List<Event> events = getEvents();
        events.forEach(event -> System.out.println(event.getName() + " duration: " + event.getDuration().toMinutes() + " minutes"));

        // Adjust times to a different time zone
        ZoneId zoneId = ZoneId.of("America/New_York");
        events.forEach(event -> System.out.println(event.getName() + " starts at " + event.getStartInZone(zoneId) + " in New York"));

        // Find overlapping events
        LocalDateTime rangeStart = LocalDateTime.of(2023, 7, 23, 10, 0);
        LocalDateTime rangeEnd = LocalDateTime.of(2023, 7, 23, 12, 0);
        System.out.println("Events overlapping with the range " + rangeStart + " to " + rangeEnd + ":");
        events.stream()
                .filter(event -> event.getStart().isBefore(rangeEnd) && event.getEnd().isAfter(rangeStart))
                .forEach(System.out::println);
    }

    private static List<Event> getEvents()
    {
        return Arrays.asList(new Event("Opening Keynote", "2023-07-23 09:00", "2023-07-23 10:30"),
                new Event("Java 8 Workshop", "2023-07-23 11:00", "2023-07-23 12:30"),
                new Event("Lunch Break", "2023-07-23 12:30", "2023-07-23 13:30"),
                new Event("Microservices Architecture", "2023-07-23 14:00", "2023-07-23 15:30"));
    }
}
