package org.datetimeapi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Duration;
import java.time.Period;

public class DateTimeUtilities
{

    public static void calculatePeriod()
    {
        LocalDate currentDate = LocalDate.now();
        LocalDate pastDate = LocalDate.of(2014, Month.DECEMBER, 12);

        Period periodGap = Period.between(pastDate, currentDate);
        System.out.println("The gap between the dates is a period of " + periodGap.getYears() + " years, " +
                periodGap.getMonths() + " months, and " + periodGap.getDays() + " days.");
    }

    public static void calculateDuration()
    {
        LocalTime currentTime = LocalTime.now();
        System.out.println("The current time is " + currentTime);

        Duration fiveHours = Duration.ofHours(5);

        LocalTime timeAfterFiveHours = currentTime.plus(fiveHours);
        System.out.println("After adding five hours, the time is " + timeAfterFiveHours);

        Duration durationGap = Duration.between(currentTime, timeAfterFiveHours);
        System.out.println("The duration gap between the current time and the time after five hours is " +
                durationGap.toHours() + " hours, " + durationGap.toMinutes() + " minutes.");
    }

    public static void main(String[] args)
    {
        calculatePeriod();
        calculateDuration();
    }
}
