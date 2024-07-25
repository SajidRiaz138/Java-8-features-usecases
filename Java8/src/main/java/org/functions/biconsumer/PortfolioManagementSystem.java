package org.functions.biconsumer;

import org.common.Investment;
import org.common.Transaction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.logging.Logger;

public class PortfolioManagementSystem
{

    private static final Logger logger = Logger.getLogger(PortfolioManagementSystem.class.getName());
    private static final Map<String, Investment> portfolio = new HashMap<>();

    public static void main(String[] args)
    {
        // Initialize portfolio
        portfolio.put("AAPL", new Investment("AAPL", 50, 150.0));
        portfolio.put("GOOGL", new Investment("GOOGL", 20, 2800.0));
        portfolio.put("AMZN", new Investment("AMZN", 10, 3400.0));

        // Sample transactions
        List<Transaction> transactions = Arrays.asList(
                new Transaction("AAPL", 7500),
                new Transaction("GOOGL", 56000),
                new Transaction("AMZN", 34000));

        // Sample updates for shares
        List<ObjIntConsumer<Investment>> shareUpdates = Arrays.asList(
                (investment, shares) -> investment.updateShares(investment.getNumberOfShares() + shares),
                (investment, shares) -> investment.updateShares(investment.getNumberOfShares() - shares));

        // ObjIntConsumer to update shares
        ObjIntConsumer<Investment> updateShares = Investment::updateShares;

        // ObjLongConsumer to log transactions
        ObjLongConsumer<Transaction> logTransaction = (transaction, amount) -> logger.info(
                "Transaction for " + transaction.getTickerSymbol() + ": $" + amount);

        // ObjDoubleConsumer to calculate portfolio value
        ObjDoubleConsumer<Investment> calculateValue = (investment, value) ->
        {
            double totalValue = investment.getNumberOfShares() * investment.getSharePrice();
            logger.info("Total value of " + investment.getTickerSymbol() + " is $" + totalValue);
        };

        // Process share updates
        portfolio.forEach((ticker, investment) ->
        {
            for (ObjIntConsumer<Investment> update : shareUpdates)
            {
                update.accept(investment, 10);
            }
        });

        // Process each transaction
        transactions.forEach(transaction ->
        {
            logTransaction.accept(transaction, transaction.getTransactionAmount());
        });

        // Calculate and log the value of the portfolio
        portfolio.forEach((ticker, investment) ->
        {
            calculateValue.accept(investment, investment.calculateValue());
        });

        // Generate portfolio report
        generatePortfolioReport();
    }

    private static void generatePortfolioReport()
    {
        System.out.println("Portfolio Report:");
        portfolio.forEach((ticker, investment) ->
        {
            System.out.println("Ticker: " + investment.getTickerSymbol() + ", Shares: " + investment.getNumberOfShares()
                    + ", Share Price: $" + investment.getSharePrice() + ", Total Value: $" + investment.calculateValue());
        });
    }
}
