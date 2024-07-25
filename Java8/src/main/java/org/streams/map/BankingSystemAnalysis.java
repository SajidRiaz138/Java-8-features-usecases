package org.streams.map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankingSystemAnalysis
{
    public static void main(String[] args)
    {
        Transaction transaction1 = new Transaction("1", 100.0, "USD", LocalDateTime.now());
        Transaction transaction2 = new Transaction("2", 200.0, "EUR", LocalDateTime.now());
        Transaction transaction3 = new Transaction("3", 150.0, "USD", LocalDateTime.now());
        Transaction transaction4 = new Transaction("4", 300.0, "EUR", LocalDateTime.now());

        Customer customer1 = new Customer("Alice", Arrays.asList(transaction1, transaction2));
        Customer customer2 = new Customer("Bob", Arrays.asList(transaction3, transaction4));

        List<Customer> customers = Arrays.asList(customer1, customer2);

        // Calculate total balance in USD, assuming 1 EUR = 1.2 USD
        double totalBalanceUSD = customers.stream()
                .flatMap(customer -> customer.getTransactions().stream())
                .mapToDouble(tx -> tx.getCurrency().equals("USD") ? tx.getAmount() : tx.getAmount() * 1.2)
                .sum();

        System.out.println("Total Balance in USD: $" + totalBalanceUSD);

        // List transactions for each customer, converting amounts to USD
        Map<String, List<String>> customerTransactionsInUSD = customers.stream()
                .collect(Collectors.toMap(
                        Customer::getName,
                        customer -> customer.getTransactions()
                                .stream()
                                .map(tx -> tx.getCurrency().equals("USD")
                                        ? tx.getId() + ": $" + tx.getAmount()
                                        : tx.getId() + ": $" + (tx.getAmount() * 1.2) + " (converted from EUR)")
                                .collect(Collectors.toList())));

        System.out.println("Customer Transactions in USD:");
        customerTransactionsInUSD.forEach((customer, transactions) ->
        {
            System.out.println(customer + ": " + transactions);
        });
    }
}


@AllArgsConstructor
@Getter
@ToString
class Transaction
{
    private final String id;
    private final double amount;
    private final String currency;
    private LocalDateTime date;
}

@AllArgsConstructor
@Getter
@ToString
class Customer
{
    private final String name;
    private final List<Transaction> transactions;
}
