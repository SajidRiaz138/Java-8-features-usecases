package org.datetimeapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@ToString
public class Event
{
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    public Event(String name, String start, String end)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.name = name;
        this.start = LocalDateTime.parse(start, formatter);
        this.end = LocalDateTime.parse(end, formatter);
    }

    public Duration getDuration()
    {
        return Duration.between(start, end);
    }

    public ZonedDateTime getStartInZone(ZoneId zone)
    {
        return start.atZone(zone);
    }

    public ZonedDateTime getEndInZone(ZoneId zone)
    {
        return end.atZone(zone);
    }
}
