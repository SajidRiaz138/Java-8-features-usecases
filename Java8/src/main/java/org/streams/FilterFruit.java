package org.streams;

import org.common.Color;
import org.common.Grape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterFruit
{
    public static void main(String[] args)
    {

        List<Grape> basket = Arrays.asList(new Grape(Color.RED, 1100),
                new Grape(org.common.Color.GREEN, 340),
                new Grape(org.common.Color.RED, 450));
        System.out.println(groupByColor(basket));

        System.out.println(groupByColorJava8(basket));
    }

    private static Map<Color, List<Grape>> groupByColorJava8(List<Grape> grapes)
    {
        return grapes.stream()
                .filter((grape -> grape.getWeight() > 100))
                .collect(Collectors.groupingBy(Grape::getColor));
    }

    private static Map<Color, List<Grape>> groupByColor(List<Grape> grapes)
    {
        Map<Color, List<Grape>> groupByColor = new HashMap<>();

        for (Grape grape : grapes)
        {
            if (grape.getWeight() > 100)
            {
                Color color = grape.getColor();
                List<Grape> list = groupByColor.computeIfAbsent(color, k -> new ArrayList<>());
                list.add(grape);
            }
        }

        return groupByColor;
    }
}
