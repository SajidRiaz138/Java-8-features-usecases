package org.datetimeapi;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeWithZone
{
    public static void main(String[] args)
    {

        displayTimeAndDateWithZone();

    }

    public static void displayTimeAndDateWithZone()
    {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedCurrentDate = date.format(formatter);

        System.out.println("formatted current Date and" + " Time : " + formattedCurrentDate);
        ZonedDateTime currentZone = ZonedDateTime.now();
        System.out.println("the current zone is " + currentZone.getZone());
        ZoneId tokyo = ZoneId.of("America/New_York");
        ZonedDateTime tokyoZone = currentZone.withZoneSameInstant(tokyo);
        System.out.println("America/New_York time zone is " + tokyoZone);
        String formatedDateTime = tokyoZone.format(formatter);
        System.out.println("formatted time zone " + formatedDateTime);
    }
}
