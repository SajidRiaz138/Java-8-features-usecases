package org.functions.predicate.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Getter
public class Investment
{
    private final String investmentId;
    private final String type;
    private final double value;
    private final double riskLevel; // Risk level from 0.0 (low) to 1.0 (high)
}
