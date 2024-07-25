package org.datetimeapi;

import java.time.LocalDate;

public class TradingDayManager
{

    public static void main(String[] args)
    {
        LocalDate currentDate = LocalDate.now();

        // Calculate the next trading day
        LocalDate nextTradingDay = currentDate.with(FinancialTemporalAdjusters.nextTradingDay());
        System.out.println("Next trading day is on: " + nextTradingDay);

        // Calculate the end of the current quarter
        LocalDate endOfQuarter = currentDate.with(FinancialTemporalAdjusters.endOfQuarter());
        System.out.println("End of current quarter: " + endOfQuarter);

        // Calculate the last trading day of the current month
        LocalDate lastTradingDayOfMonth = currentDate.with(FinancialTemporalAdjusters.lastTradingDayOfMonth());
        System.out.println("Last trading day of the current month: " + lastTradingDayOfMonth);
    }
}
