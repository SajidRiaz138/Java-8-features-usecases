package org.functions.function.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Transaction
{
    private final String transactionId;
    private final double amount;
    private final long timestamp;
}
