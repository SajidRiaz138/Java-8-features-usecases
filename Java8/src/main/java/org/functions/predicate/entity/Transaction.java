package org.functions.predicate.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Getter
public class Transaction
{
    private final String transactionId;
    private final long amount;
}
