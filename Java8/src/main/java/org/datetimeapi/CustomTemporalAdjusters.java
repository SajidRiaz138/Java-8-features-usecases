package org.datetimeapi;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

public class CustomTemporalAdjusters
{
    public static TemporalAdjuster lastFridayOfMonth()
    {
        return TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY);
    }

    public static TemporalAdjuster lastWorkingDayOfMonth()
    {
        return TemporalAdjusters.ofDateAdjuster(date ->
        {
            LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
            while (lastDay.getDayOfWeek() == DayOfWeek.SATURDAY || lastDay.getDayOfWeek() == DayOfWeek.SUNDAY)
            {
                lastDay = lastDay.minusDays(1);
            }
            return lastDay;
        });
    }

    public static TemporalAdjuster firstWorkingDayOfMonth()
    {
        return TemporalAdjusters.ofDateAdjuster(date ->
        {
            LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
            while (firstDay.getDayOfWeek() == DayOfWeek.SATURDAY || firstDay.getDayOfWeek() == DayOfWeek.SUNDAY)
            {
                firstDay = firstDay.plusDays(1);
            }
            return firstDay;
        });
    }
}
