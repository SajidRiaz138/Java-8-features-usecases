package org.functions.function.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Account
{
    private final String accountNumber;
    private final double balance;
    private final List<Transaction> transactions;
    private final long creationTimestamp;
}
