package org.functions.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class TaxPayer
{
    private final String taxpayerId;
    private final String name;
    private final double income;
    private final double taxPaid;
}
