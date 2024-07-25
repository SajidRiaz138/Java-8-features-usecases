package org.functions.predicate.usecases;

import org.functions.predicate.entity.Investment;
import org.functions.predicate.entity.InvestmentPortfolio;
import org.functions.predicate.entity.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FinancialRiskManagementSystem
{

    public static void main(String[] args)
    {
        List<Investment> investments = Arrays.asList(
                new Investment("INV001", "Stock", 50000.0, 0.6),
                new Investment("INV002", "Bond", 20000.0, 0.3),
                new Investment("INV003", "Real Estate", 100000.0, 0.8));

        // Sample investment portfolio
        InvestmentPortfolio portfolio = new InvestmentPortfolio("PORT123", investments, 170000.0);

        // Sample transaction
        Transaction transaction = new Transaction("TXN001", 1500000L);

        // Predicate<T> to evaluate whether an investment portfolio is high-risk
        Predicate<InvestmentPortfolio> highRiskPortfolioPredicate = RiskManagementUtils::isHighRiskPortfolio;
        boolean isHighRisk = highRiskPortfolioPredicate.test(portfolio);
        System.out.println("Is High-Risk Portfolio: " + isHighRisk);

        // IntPredicate to determine if the number of transactions exceeds a specified threshold
        IntPredicate exceedsTransactionThreshold = RiskManagementUtils::exceedsTransactionThreshold;
        boolean exceedsThreshold = exceedsTransactionThreshold.test(120);
        System.out.println("Exceeds Transaction Threshold: " + exceedsThreshold);

        // LongPredicate to check if a transaction amount is above a certain limit
        LongPredicate transactionAmountAboveLimit = RiskManagementUtils::isTransactionAmountAboveLimit;
        boolean isAboveLimit = transactionAmountAboveLimit.test(transaction.getAmount());
        System.out.println("Transaction Amount Above Limit: " + isAboveLimit);

        // DoublePredicate to assess if the interest rate is within an acceptable range
        DoublePredicate interestRateAcceptable = RiskManagementUtils::isInterestRateAcceptable;
        boolean isAcceptableRate = interestRateAcceptable.test(3.5);
        System.out.println("Interest Rate Acceptable: " + isAcceptableRate);
    }
}
