package org.datetimeapi;

import java.time.LocalDate;

public class PayrollScheduler
{

    public static void main(String[] args)
    {
        LocalDate currentDate = LocalDate.now();

        // Calculate the next payday
        LocalDate nextPayday = currentDate.with(CustomTemporalAdjusters.lastFridayOfMonth());
        System.out.println("Next payday is on: " + nextPayday);

        // Calculate the last working day of the month
        LocalDate lastWorkingDay = currentDate.with(CustomTemporalAdjusters.lastWorkingDayOfMonth());
        System.out.println("Last working day of the month is: " + lastWorkingDay);

        // Calculate the first working day of the next month
        LocalDate firstWorkingDay = currentDate.plusMonths(1).with(CustomTemporalAdjusters.firstWorkingDayOfMonth());
        System.out.println("First working day of the next month is: " + firstWorkingDay);
    }
}
