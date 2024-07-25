package org.streams.reduceoperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class ReduceOperation
{

    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(4, 5, 6, 19);
        System.out.println(sumNumbers(numbers));
        System.out.println(finMax(numbers));
        System.out.println(getCountCharacterOccurrences("Hello", 'l'));
        System.out.println(getCountCharacterOccurrences("Hello11", '1'));
        System.out.println(findFactorialOfNumber(5));
        System.out.println(concatStrings(Arrays.asList("Hello", "How are you!")));
        System.out.println(findLongestString(Arrays.asList("Hello", "How are you!")));
    }

    private static double getAverage(List<Integer> numbers)
    {
        // Calculate sum and count
        double[] sumAndCount = numbers.stream()
                .reduce(new double[2],
                        (acc, n) ->
                        {
                            acc[0] += n;
                            acc[1]++;
                            return acc;
                        },
                        (acc1, acc2) ->
                        {
                            acc1[0] += acc2[0];
                            acc1[1] += acc2[1];
                            return acc1;
                        });
        // Calculate average
        return sumAndCount[0] / sumAndCount[1];
    }

    private static String combineString(List<String> strings)
    {
        return strings.stream()
                .reduce((s1, s2) -> s1 + ", " + s2)
                .orElse("");
    }

    private static int countWordsInList(List<Integer> list)
    {
        return list.stream()
                .reduce(0, (count, word) -> count + 1, Integer::sum);

    }

    private static int finMin(List<Integer> list)
    {
        return list.stream().reduce(Integer.MAX_VALUE, Integer::min);
    }

    private static int finMax(List<Integer> list)
    {
        return list.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }

    private static long getCountCharacterOccurrences(String string, char characterToCount)
    {
        return string.chars()
                .mapToObj(obj -> (char) obj)
                .filter(c -> c == characterToCount)
                .reduce(0, (aggregateCount, c) -> aggregateCount + 1, Integer::sum);
    }

    private static long findFactorialOfNumber(long number)
    {
        return LongStream.rangeClosed(1, number).reduce(1, (a, b) -> a * b);
    }

    private static String concatStrings(List<String> list)
    {
        return list.stream().reduce("", (s1, s2) -> s1 + " " + s2);
    }

    private static String findLongestString(List<String> list)
    {
        return list.stream().reduce("", (s1, s2) -> s1.length() > s2.length() ? s1 : s2);
    }

    private static int sumNumbers(List<Integer> list)
    {
        return list.stream().reduce(0, Integer::sum);
    }

}
