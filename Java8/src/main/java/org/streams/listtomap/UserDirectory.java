package org.streams.listtomap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDirectory
{
    public static void main(String[] args)
    {
        List<User> employees = Arrays.asList(
                new User("Alice", 1),
                new User("Bob", 2),
                new User("Charlie", 3),
                new User("Charlie", 1));

        Map<String, Integer> employeeDirectory = employees.stream()
                .collect(Collectors.toMap(
                        User::getName,
                        User::getId,
                        (e1, e2) -> e2, // keep latest one
                        HashMap::new));

        System.out.println(employeeDirectory);
    }
}

@Getter
@AllArgsConstructor
@ToString
class User
{
    private String name;
    private int id;
}
