package org.datetimeapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class EventScheduler
{
    private Clock clock;
    private List<ScheduledEvent> events;

    public EventScheduler(Clock clock)
    {
        this.clock = clock;
        this.events = new ArrayList<>();
    }

    public static void main(String[] args)
    {
        // Create a fixed clock for testing purposes
        Clock fixedClock = Clock.fixed(Instant.parse("2023-07-23T10:15:30Z"), ZoneOffset.UTC);
        EventScheduler scheduler = new EventScheduler(fixedClock);

        // Schedule events in different time zones
        scheduler.scheduleEvent("Meeting", LocalDateTime.of(2023, 7, 24, 9, 0), ZoneId.of("America/New_York"));
        scheduler.scheduleEvent("Conference", LocalDateTime.of(2023, 7, 25, 11, 0), ZoneId.of("Europe/London"));
        scheduler.scheduleEvent("Webinar", LocalDateTime.of(2023, 7, 26, 15, 0), ZoneId.of("Asia/Tokyo"));

        // Print current time
        System.out.println("Current time (fixed for testing): " + scheduler.getCurrentTime());

        // Print events in different time zones
        System.out.println("Events in UTC:");
        scheduler.printEventsInTimeZone(ZoneId.of("UTC"));

        System.out.println("Events in America/Los_Angeles:");
        scheduler.printEventsInTimeZone(ZoneId.of("America/Los_Angeles"));

        System.out.println("Events in Asia/Kolkata:");
        scheduler.printEventsInTimeZone(ZoneId.of("Asia/Kolkata"));
    }

    private void scheduleEvent(String name, LocalDateTime dateTime, ZoneId timeZone)
    {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, timeZone);
        ScheduledEvent event = new ScheduledEvent(name, zonedDateTime, timeZone);
        events.add(event);
    }

    private ZonedDateTime getCurrentTime()
    {
        return ZonedDateTime.now(clock);
    }

    private void printEventsInTimeZone(ZoneId targetZone)
    {
        for (ScheduledEvent event : events)
        {
            System.out.println(event.getName() + " scheduled at " + event.getScheduledTime() +
                    " (" + event.getTimeZone() + ") is " + event.getTimeInZone(targetZone) + " in " + targetZone);
        }
    }
}

@ToString
@Getter
@AllArgsConstructor
class ScheduledEvent
{
    private final String name;
    private final ZonedDateTime scheduledTime;
    private final ZoneId timeZone;

    public ZonedDateTime getTimeInZone(ZoneId targetZone)
    {
        return scheduledTime.withZoneSameInstant(targetZone);
    }
}
