package org.datetimeapi;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FinancialTemporalAdjusters
{

    private static final Set<LocalDate> HOLIDAYS;

    static
    {
        Set<LocalDate> holidays = new HashSet<>();
        holidays.add(LocalDate.of(2023, 1, 1)); // New Year's Day
        holidays.add(LocalDate.of(2023, 12, 25)); // Christmas
        // Add more holidays as needed
        HOLIDAYS = Collections.unmodifiableSet(holidays);
    }

    public static TemporalAdjuster nextTradingDay()
    {
        return TemporalAdjusters.ofDateAdjuster(date ->
        {
            LocalDate nextDay = date.plusDays(1);
            while (nextDay.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    nextDay.getDayOfWeek() == DayOfWeek.SUNDAY ||
                    HOLIDAYS.contains(nextDay))
            {
                nextDay = nextDay.plusDays(1);
            }
            return nextDay;
        });
    }

    public static TemporalAdjuster endOfQuarter()
    {
        return TemporalAdjusters.ofDateAdjuster(date ->
        {
            int month = date.getMonthValue();
            int endMonth = ((month - 1) / 3 + 1) * 3;
            return LocalDate.of(date.getYear(), endMonth, 1)
                    .with(TemporalAdjusters.lastDayOfMonth());
        });
    }

    public static TemporalAdjuster lastTradingDayOfMonth()
    {
        return TemporalAdjusters.ofDateAdjuster(date ->
        {
            LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
            while (lastDay.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    lastDay.getDayOfWeek() == DayOfWeek.SUNDAY ||
                    HOLIDAYS.contains(lastDay))
            {
                lastDay = lastDay.minusDays(1);
            }
            return lastDay;
        });
    }
}
