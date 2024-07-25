package org.streams.listtomap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequency
{
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Integer> wordFrequencies = words.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        word -> 1,
                        Integer::sum, // Merge function to sum the frequencies
                        HashMap::new));

        System.out.println(wordFrequencies);
    }
}
