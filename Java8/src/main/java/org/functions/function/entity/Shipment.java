package org.functions.function.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
@ToString
public class Shipment
{
    private final String shipmentId;
    private final int numberOfItems;
    private final double totalWeight;
    private final long orderNumber;
    private final double shippingCost;
}
