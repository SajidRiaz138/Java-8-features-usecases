package org.common;

public class Transaction
{
    private final String tickerSymbol;
    private final long transactionAmount;

    public Transaction(String tickerSymbol, long transactionAmount)
    {
        this.tickerSymbol = tickerSymbol;
        this.transactionAmount = transactionAmount;
    }

    public String getTickerSymbol()
    {
        return tickerSymbol;
    }

    public long getTransactionAmount()
    {
        return transactionAmount;
    }
}
