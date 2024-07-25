package org.functions.supplier.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Customer
{
    private final String customerId;
    private final String name;
    private final String email;
}
