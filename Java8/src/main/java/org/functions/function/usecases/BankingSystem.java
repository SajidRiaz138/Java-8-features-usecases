package org.functions.function.usecases;

import org.functions.function.entity.Account;
import org.functions.function.entity.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class BankingSystem
{

    public static void main(String[] args)
    {
        // Sample transactions
        List<Transaction> transactions = Arrays.asList(
                new Transaction("TXN001", 1000.0, 1627852800L),
                new Transaction("TXN002", 2000.0, 1627939200L),
                new Transaction("TXN003", 1500.0, 1628025600L));

        // Sample account
        Account account = new Account("ACCT123", 4500.0, transactions, 1627756800L);

        // IntFunction<R> to generate account numbers
        IntFunction<String[]> generateAccountNumbers = BankingUtils::generateAccountNumbers;
        String[] accountNumbers = generateAccountNumbers.apply(3);
        System.out.println("Generated Account Numbers: " + String.join(", ", accountNumbers));

        // IntToDoubleFunction to calculate interest
        IntToDoubleFunction calculateInterest = BankingUtils::calculateInterest;
        double interest = calculateInterest.applyAsDouble(5);
        System.out.println("Calculated Interest for 5 years: $" + interest);

        // LongFunction<R> to generate transaction IDs
        LongFunction<String> generateTransactionId = BankingUtils::generateTransactionId;
        String transactionId = generateTransactionId.apply(1627852800L);
        System.out.println("Generated Transaction ID: " + transactionId);

        // IntToLongFunction to calculate total balance based on the number of transactions
        IntToLongFunction calculateTotalBalance = BankingUtils::calculateTotalBalance;
        long totalBalance = calculateTotalBalance.applyAsLong(10);
        System.out.println("Calculated Total Balance for 10 transactions: $" + totalBalance);

        // LongToDoubleFunction to calculate interest amount based on principal
        LongToDoubleFunction calculateInterestAmount = BankingUtils::calculateInterestAmount;
        double interestAmount = calculateInterestAmount.applyAsDouble(5000L);
        System.out.println("Calculated Interest Amount for $5000 principal: $" + interestAmount);

        // LongToIntFunction to calculate the number of transactions from the total transaction amount
        LongToIntFunction calculateNumOfTransactions = BankingUtils::calculateNumOfTransactions;
        int numOfTransactions = calculateNumOfTransactions.applyAsInt(3000L);
        System.out.println("Calculated Number of Transactions for $3000: " + numOfTransactions);

        // DoubleFunction<R> to generate account summaries based on the balance
        DoubleFunction<String> generateAccountSummary = BankingUtils::generateAccountSummary;
        String accountSummary = generateAccountSummary.apply(account.getBalance());
        System.out.println(accountSummary);

        // ToIntFunction<T> to get the number of transactions from an account
        ToIntFunction<Account> getNumberOfTransactions = BankingUtils::getNumberOfTransactions;
        int transactionCount = getNumberOfTransactions.applyAsInt(account);
        System.out.println("Number of Transactions: " + transactionCount);

        // ToDoubleFunction<T> to get the balance from an account
        ToDoubleFunction<Account> getBalanceFromAccount = BankingUtils::getBalanceFromAccount;
        double balance = getBalanceFromAccount.applyAsDouble(account);
        System.out.println("Account Balance: $" + balance);

        // ToLongFunction<T> to get the account creation timestamp from an account
        ToLongFunction<Account> getAccountCreationTimestamp = BankingUtils::getAccountCreationTimestamp;
        long creationTimestamp = getAccountCreationTimestamp.applyAsLong(account);
        System.out.println("Account Creation Timestamp: " + creationTimestamp);
    }
}
