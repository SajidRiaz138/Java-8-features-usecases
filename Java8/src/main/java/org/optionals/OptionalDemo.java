package org.optionals;

import java.util.Optional;

public class OptionalDemo
{

    public static void main(String[] args)
    {
        // Creating Optionals
        Optional<String> optional1 = Optional.of("Hello"); // Optional containing a value
        Optional<String> optional2 = Optional.ofNullable(null); // Optional containing null
        Optional<String> optional3 = Optional.empty(); // Empty Optional

        // Checking if value is present
        System.out.println("optional1 is present: " + optional1.isPresent());
        System.out.println("optional2 is present: " + optional2.isPresent());
        System.out.println("optional3 is present: " + optional3.isPresent());

        // ifPresent
        optional1.ifPresent(value -> System.out.println("optional1 value: " + value));
        optional2.ifPresent(value -> System.out.println("optional2 value: " + value));

        // get
        if (optional1.isPresent())
        {
            System.out.println("optional1 get: " + optional1.get());
        }

        // orElse
        System.out.println("optional2 orElse: " + optional2.orElse("Default Value"));
        System.out.println("optional3 orElse: " + optional3.orElse("Default Value"));

        // orElseGet
        System.out.println("optional2 orElseGet: " + optional2.orElseGet(() -> "Generated Value"));
        System.out.println("optional3 orElseGet: " + optional3.orElseGet(() -> "Generated Value"));

        // orElseThrow
        try
        {
            System.out.println("optional2 orElseThrow: " + optional2.orElseThrow(() -> new RuntimeException("Value is not present")));
        }
        catch (Exception e)
        {
            System.out.println("optional2 orElseThrow: " + e.getMessage());
        }

        // map
        Optional<Integer> mappedOptional1 = optional1.map(String::length);
        System.out.println("optional1 map to length: " + mappedOptional1.orElse(0));

        Optional<Integer> mappedOptional2 = optional2.map(String::length);
        System.out.println("optional2 map to length: " + mappedOptional2.orElse(0));

        // flatMap
        Optional<String> flatMappedOptional1 = optional1.flatMap(value -> Optional.of(value.toUpperCase()));
        System.out.println("optional1 flatMap to uppercase: " + flatMappedOptional1.orElse("No Value"));

        Optional<String> flatMappedOptional2 = optional2.flatMap(value -> Optional.of(value.toUpperCase()));
        System.out.println("optional2 flatMap to uppercase: " + flatMappedOptional2.orElse("No Value"));

        // filter
        Optional<String> filteredOptional1 = optional1.filter(value -> value.startsWith("H"));
        System.out.println("optional1 filter starts with H: " + filteredOptional1.orElse("No Value"));

        Optional<String> filteredOptional2 = optional1.filter(value -> value.startsWith("X"));
        System.out.println("optional1 filter starts with X: " + filteredOptional2.orElse("No Value"));
    }
}
