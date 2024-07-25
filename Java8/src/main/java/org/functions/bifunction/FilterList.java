package org.functions.bifunction;

import org.common.Grape;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterList
{
    public static void main(String[] args)
    {
        List<Grape> basket = Arrays.asList(new Grape(org.common.Color.RED, 123),
                new Grape(org.common.Color.GREEN, 34),
                new Grape(org.common.Color.RED, 45));

        System.out.println(filterGrapes(basket, Grape::isRedGrapes));

        System.out.println(filterGrapes(basket, (apple) -> org.common.Color.RED == apple.getColor()));
    }

    private static List<Grape> filterGrapes(List<Grape> basket, Predicate<Grape> filter)
    {
        return basket.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}

