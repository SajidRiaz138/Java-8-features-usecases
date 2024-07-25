package org.common;

import java.util.Objects;

public class FinancialInvestment
{
    private final String tickerSymbol;
    private final double value;

    public FinancialInvestment(String tickerSymbol, double value)
    {
        this.tickerSymbol = tickerSymbol;
        this.value = value;
    }

    public String getTickerSymbol()
    {
        return tickerSymbol;
    }

    public double getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "FinancialInvestment{" +
                "tickerSymbol='" + tickerSymbol + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancialInvestment that = (FinancialInvestment) o;
        return Double.compare(that.value, value) == 0 && Objects.equals(tickerSymbol, that.tickerSymbol);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(tickerSymbol, value);
    }
}
