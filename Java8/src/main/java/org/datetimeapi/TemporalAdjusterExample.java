package org.datetimeapi;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

public class TemporalAdjusterExample
{
    public static void main(String[] args)
    {
        demonstrateTemporalAdjusters();
    }

    public static void demonstrateTemporalAdjusters()
    {
        LocalDate currentDate = LocalDate.now();
        System.out.println("The current date is: " + currentDate);

        // Get the first day of the next month
        LocalDate firstDayOfNextMonth = currentDate.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("First day of next month: " + firstDayOfNextMonth);

        // Get the next Saturday
        LocalDate nextSaturday = currentDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("Next Saturday: " + nextSaturday);

        // Get the first day of the current month
        LocalDate firstDayOfMonth = currentDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("First day of current month: " + firstDayOfMonth);

        // Get the last day of the current month
        LocalDate lastDayOfMonth = currentDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Last day of current month: " + lastDayOfMonth);
    }
}
