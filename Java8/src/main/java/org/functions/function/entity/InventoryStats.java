package org.functions.function.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class InventoryStats
{
    private final String productId;
    private final int quantity;
    private final long restockDate;
}
