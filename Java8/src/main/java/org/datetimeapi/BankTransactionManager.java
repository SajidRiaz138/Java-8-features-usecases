package org.datetimeapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BankTransactionManager
{
    public static void main(String[] args)
    {
        List<Account> accounts = getAccounts();
        accounts.forEach(account -> System.out.println("Account " + account.getAccountId() + " total amount: " + account.calculateTotalAmount()));

        accounts.forEach(account ->
        {
            List<Transaction> transactions = account.getTransactions();
            for (int i = 0; i < transactions.size() - 1; i++)
            {
                Duration duration = transactions.get(i).durationUntil(transactions.get(i + 1));
                System.out.println("Duration between " + transactions.get(i).getTransactionId() + " and "
                        + transactions.get(i + 1).getTransactionId() + ": " + duration.toHours() + " hours");
            }
        });
        LocalDateTime periodStart = LocalDateTime.of(2023, 7, 23, 0, 0);
        LocalDateTime periodEnd = LocalDateTime.of(2023, 7, 30, 23, 59);
        Period period = Period.ofDays(1); // Daily statements
        accounts.forEach(account ->
        {
            System.out.println("Periodic statements for account " + account.getAccountId() + ":");
            account.printPeriodicStatements(periodStart, periodEnd, period);
        });
    }

    private static List<Account> getAccounts()
    {
        return Arrays.asList(
                new Account("A1001", Arrays.asList(
                        new Transaction("T1001", 200.00, "2023-07-23 10:00"),
                        new Transaction("T1002", 150.00, "2023-07-24 12:00"),
                        new Transaction("T1003", 100.00, "2023-07-25 14:00"))),
                new Account("A1002", Arrays.asList(
                        new Transaction("T1004", 300.00, "2023-07-23 11:00"),
                        new Transaction("T1005", 400.00, "2023-07-25 16:00"),
                        new Transaction("T1006", 250.00, "2023-07-26 18:00"))));
    }
}

@ToString
@Getter
class Transaction
{
    private final String transactionId;
    private final double amount;
    private final LocalDateTime transactionDate;

    public Transaction(String transactionId, double amount, String transactionDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionDate = LocalDateTime.parse(transactionDate, formatter);
    }

    public ZonedDateTime getTransactionDateInZone(ZoneId zone)
    {
        return transactionDate.atZone(zone);
    }

    public Duration durationUntil(Transaction nextTransaction)
    {
        return Duration.between(this.transactionDate, nextTransaction.getTransactionDate());
    }
}

@ToString
@Getter
@AllArgsConstructor
class Account
{
    private final String accountId;
    private final List<Transaction> transactions;

    public double calculateTotalAmount()
    {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double calculateTotalAmountInPeriod(LocalDateTime start, LocalDateTime end)
    {
        return transactions.stream()
                .filter(tx -> !tx.getTransactionDate().isBefore(start) && !tx.getTransactionDate().isAfter(end))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public List<Transaction> getTransactionsInPeriod(LocalDateTime start, LocalDateTime end)
    {
        return transactions.stream()
                .filter(tx -> !tx.getTransactionDate().isBefore(start) && !tx.getTransactionDate().isAfter(end))
                .collect(Collectors.toList());
    }

    public void printPeriodicStatements(LocalDateTime start, LocalDateTime end, Period period)
    {
        LocalDateTime currentStart = start;
        while (currentStart.isBefore(end))
        {
            LocalDateTime currentEnd = currentStart.plus(period);
            double totalAmount = calculateTotalAmountInPeriod(currentStart, currentEnd);
            System.out.println("Statement from " + currentStart + " to " + currentEnd + ": Total Amount = " + totalAmount);
            currentStart = currentEnd;
        }
    }
}
