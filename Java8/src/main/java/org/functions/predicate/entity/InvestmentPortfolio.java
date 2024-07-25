package org.functions.predicate.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Getter
public class InvestmentPortfolio
{
    private final String portfolioId;
    private final List<Investment> investments;
    private final double totalValue;
}
