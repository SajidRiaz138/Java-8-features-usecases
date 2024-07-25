package org.functions.operator;

import org.common.Investment;

import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.DoubleBinaryOperator;

public class BankingSystem
{

    public static void main(String[] args)
    {
        // Sample data
        Investment investment1 = new Investment("AAPL", 50, 150.0);
        Investment investment2 = new Investment("AAPL", 30, 150.0);

        // IntBinaryOperator to sum the number of shares
        IntBinaryOperator sumShares = Integer::sum;
        int totalShares = sumShares.applyAsInt(investment1.getNumberOfShares(), investment2.getNumberOfShares());
        System.out.println("Total Shares: " + totalShares); // Output: Total Shares: 80

        // LongBinaryOperator to calculate total value of shares
        LongBinaryOperator calculateTotalValue = (shares, price) -> (long) (shares * price);
        long totalValue = calculateTotalValue.applyAsLong(investment1.getNumberOfShares(), (long) investment1.getSharePrice());
        System.out.println("Total Value of Shares: $" + totalValue); // Output: Total Value of Shares: $7500

        // DoubleBinaryOperator to calculate final value after applying a growth rate
        DoubleBinaryOperator applyGrowthRate = (value, rate) -> value * (1 + rate / 100);
        double finalValue = applyGrowthRate.applyAsDouble(investment1.calculateValue(), 10.0);
        System.out.println("Final Value after 10% Growth: $" + finalValue); // Output: Final Value after 10% Growth: $8250.0
    }
}
