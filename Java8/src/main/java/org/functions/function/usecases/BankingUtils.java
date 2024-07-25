package org.functions.function.usecases;

import org.functions.function.entity.Account;

import java.util.UUID;

public class BankingUtils
{

    // Generates account numbers
    public static String[] generateAccountNumbers(int count)
    {
        String[] accountNumbers = new String[count];
        for (int i = 0; i < count; i++)
        {
            accountNumbers[i] = "ACCT-" + (1000 + i);
        }
        return accountNumbers;
    }

    // Calculates interest based on years
    public static double calculateInterest(int years)
    {
        double principal = 10000.0;
        double rate = 5.0;
        return principal * Math.pow(1 + rate / 100, years) - principal;
    }

    // Generates transaction IDs
    public static String generateTransactionId(long seed)
    {
        return UUID.randomUUID().toString() + "-" + seed;
    }

    // Calculates total balance based on the number of transactions
    public static long calculateTotalBalance(int numOfTransactions)
    {
        long amountPerTransaction = 1000;
        return numOfTransactions * amountPerTransaction;
    }

    // Calculates interest amount based on principal
    public static double calculateInterestAmount(long principal)
    {
        double rate = 5.0;
        int years = 1;
        return principal * rate / 100;
    }

    // Calculates number of transactions from the total transaction amount
    public static int calculateNumOfTransactions(long totalAmount)
    {
        int amountPerTransaction = 1000;
        return (int) (totalAmount / amountPerTransaction);
    }

    // Generates account summaries
    public static String generateAccountSummary(double balance)
    {
        return "Account Summary: Balance = $" + balance;
    }

    // Gets number of transactions from an account
    public static int getNumberOfTransactions(Account account)
    {
        return account.getTransactions().size();
    }

    // Gets balance from an account
    public static double getBalanceFromAccount(Account account)
    {
        return account.getBalance();
    }

    // Gets account creation timestamp from an account
    public static long getAccountCreationTimestamp(Account account)
    {
        return account.getCreationTimestamp();
    }
}
