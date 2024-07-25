package org.datetimeapi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChronoUnitExample
{
    public static void main(String[] args)
    {
        demonstrateChronoUnits();
    }

    public static void demonstrateChronoUnits()
    {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date is: " + currentDate);

        // Adding 2 years to the current date
        LocalDate dateAfterTwoYears = currentDate.plus(2, ChronoUnit.YEARS);
        System.out.println("Date after two years: " + dateAfterTwoYears);

        // Adding 1 month to the current date
        LocalDate dateAfterOneMonth = currentDate.plus(1, ChronoUnit.MONTHS);
        System.out.println("Date after one month: " + dateAfterOneMonth);

        // Adding 1 week to the current date
        LocalDate dateAfterOneWeek = currentDate.plus(1, ChronoUnit.WEEKS);
        System.out.println("Date after one week: " + dateAfterOneWeek);

        // Adding 2 decades to the current date
        LocalDate dateAfterTwoDecades = currentDate.plus(2, ChronoUnit.DECADES);
        System.out.println("Date after two decades: " + dateAfterTwoDecades);
    }
}
