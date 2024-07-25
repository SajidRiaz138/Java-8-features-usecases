package org.datetimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalDateTimeExamples
{
    private static final Logger LOG = Logger.getLogger(LocalDateTimeExamples.class.getName());

    public static void main(String[] args)
    {
        displayLocalDateTime();
    }

    private static void displayLocalDateTime()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        LocalDate date = LocalDate.now();
        LOG.log(Level.INFO, "Current date is {0}", date);

        LocalTime time = LocalTime.now();
        LOG.log(Level.INFO, "Current time is {0}", time);

        LocalDateTime currentDateAndTime = LocalDateTime.now();
        LOG.log(Level.INFO, "current date and time is {0}", currentDateAndTime);

        String formatedDateTime = currentDateAndTime.format(formatter);
        LOG.log(Level.INFO, "formated current date and time is {0}", formatedDateTime);

        Month month = currentDateAndTime.getMonth();
        int day = currentDateAndTime.getDayOfMonth();
        int seconds = currentDateAndTime.getSecond();
        LOG.log(Level.INFO, "Month :  {0}  day :  {1}  seconds : {2}", new Object[] { month, day, seconds });

        LocalDate specifiedDate = LocalDate.of(2024, 1, 26);
        LOG.log(Level.INFO, "Specified date {0}", specifiedDate);

        LocalDateTime modifyDateTime = currentDateAndTime.withDayOfMonth(24).withYear(2018);
        LOG.log(Level.INFO, "Modify currentDateTIme {0}", modifyDateTime);
    }
}
