package org.functions.predicate.usecases;

import org.functions.predicate.entity.InvestmentPortfolio;

import java.util.List;

public class RiskManagementUtils
{

    // Evaluates whether an investment portfolio is high-risk
    public static boolean isHighRiskPortfolio(InvestmentPortfolio portfolio)
    {
        double highRiskThreshold = 0.7;
        return portfolio.getInvestments()
                .stream()
                .anyMatch(investment -> investment.getRiskLevel() > highRiskThreshold);
    }

    // Determines if the number of transactions exceeds a specified threshold
    public static boolean exceedsTransactionThreshold(int transactionCount)
    {
        int threshold = 100;
        return transactionCount > threshold;
    }

    // Checks if a transaction amount is above a certain limit
    public static boolean isTransactionAmountAboveLimit(long amount)
    {
        long limit = 1000000; // Example limit: $1,000,000
        return amount > limit;
    }

    // Assesses if the interest rate is within an acceptable range
    public static boolean isInterestRateAcceptable(double rate)
    {
        double minRate = 1.0;
        double maxRate = 5.0;
        return rate >= minRate && rate <= maxRate;
    }
}
