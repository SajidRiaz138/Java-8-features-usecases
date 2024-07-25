package org.functions.operator;

import org.common.FinancialInvestment;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class FinancialPortfolioManagement
{

    public static void main(String[] args)
    {
        // Sample data
        List<FinancialInvestment> portfolio1 = Arrays.asList(
                new FinancialInvestment("AAPL", 15000.0),
                new FinancialInvestment("GOOGL", 20000.0),
                new FinancialInvestment("AMZN", 25000.0));

        List<FinancialInvestment> portfolio2 = Arrays.asList(
                new FinancialInvestment("AAPL", 12000.0),
                new FinancialInvestment("TSLA", 18000.0),
                new FinancialInvestment("GOOGL", 22000.0));

        // BinaryOperator to combine investment values (summing values)
        BinaryOperator<FinancialInvestment> combineInvestmentValues =
                (inv1, inv2) -> new FinancialInvestment(inv1.getTickerSymbol(), inv1.getValue() + inv2.getValue());

        // Combine portfolios
        Map<String, FinancialInvestment> combinedPortfolio = new HashMap<>();

        portfolio1.forEach(investment -> combinedPortfolio.merge(investment.getTickerSymbol(), investment, combineInvestmentValues));
        portfolio2.forEach(investment -> combinedPortfolio.merge(investment.getTickerSymbol(), investment, combineInvestmentValues));

        System.out.println("Combined Portfolio:");
        combinedPortfolio.values().forEach(System.out::println);

        // BinaryOperator to find the better-performing investment (higher value)
        BinaryOperator<FinancialInvestment> betterInvestment = (inv1, inv2) -> inv1.getValue() >= inv2.getValue() ? inv1 : inv2;

        // Find better investments
        List<FinancialInvestment> betterInvestments = new ArrayList<>();
        portfolio1.forEach(investment ->
        {
            portfolio2.stream()
                    .filter(inv -> inv.getTickerSymbol().equals(investment.getTickerSymbol()))
                    .findFirst()
                    .ifPresent(inv -> betterInvestments.add(betterInvestment.apply(investment, inv)));
        });

        System.out.println("\nBetter Investments:");
        betterInvestments.forEach(System.out::println);

        // BinaryOperator to merge two portfolios
        BinaryOperator<Map<String, FinancialInvestment>> mergePortfolios = (port1, port2) ->
        {
            Map<String, FinancialInvestment> merged = new HashMap<>(port1);
            port2.forEach((ticker, investment) -> merged.merge(ticker, investment, combineInvestmentValues));
            return merged;
        };

        Map<String, FinancialInvestment> portfolio1Map = portfolio1.stream()
                .collect(Collectors.toMap(FinancialInvestment::getTickerSymbol, inv -> inv));
        Map<String, FinancialInvestment> portfolio2Map = portfolio2.stream()
                .collect(Collectors.toMap(FinancialInvestment::getTickerSymbol, inv -> inv));

        Map<String, FinancialInvestment> mergedPortfolio = mergePortfolios.apply(portfolio1Map, portfolio2Map);

        System.out.println("\nMerged Portfolio:");
        mergedPortfolio.values().forEach(System.out::println);
    }
}
