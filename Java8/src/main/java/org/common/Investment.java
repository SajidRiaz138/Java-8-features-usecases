package org.common;

public class Investment
{
    private final String tickerSymbol;
    private int numberOfShares;
    private double sharePrice;

    public Investment(String tickerSymbol, int numberOfShares, double sharePrice)
    {
        this.tickerSymbol = tickerSymbol;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public String getTickerSymbol()
    {
        return tickerSymbol;
    }

    public int getNumberOfShares()
    {
        return numberOfShares;
    }

    public double getSharePrice()
    {
        return sharePrice;
    }

    public void updateShares(int numberOfShares)
    {
        this.numberOfShares = numberOfShares;
    }

    public double calculateValue()
    {
        return numberOfShares * sharePrice;
    }
}
