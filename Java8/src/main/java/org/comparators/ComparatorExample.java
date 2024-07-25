package org.comparators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class ComparatorExample
{
    public static void main(String[] args)
    {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 25, 3000),
                new Employee("Jane", 22, 3500),
                new Employee("Mary", 28, 2800),
                new Employee("Peter", 25, 3200),
                new Employee("Mike", 23, 3200));

        // Sorting by name
        List<Employee> sortedByName = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("Sorted by name: " + sortedByName);

        // Sorting by age, then by name
        List<Employee> sortedByAgeThenName = employees.stream()
                .sorted(Comparator.comparing(Employee::getAge)
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("Sorted by age then name: " + sortedByAgeThenName);

        // Sorting by salary in reverse order
        List<Employee> sortedBySalaryDesc = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println("Sorted by salary in reverse order: " + sortedBySalaryDesc);

        System.out.println();

        // Ascending order sorting based on users age
        employees.stream()
                .sorted((emp1, emp2) -> emp1.getAge() - emp2.getAge())
                .forEach(employee -> System.out.println(employee.getName()));

        System.out.println();

        // Descending order sorting based on users age
        employees.stream()
                .sorted((emp1, emp2) -> emp2.getAge() - emp1.getAge())
                .forEach(employee -> System.out.println(employee.getName()));

        System.out.println();
        // Sorting using lambdas along with compareTo() of compared attribute data types class. Here String already implements compareTo()
        employees.stream()
                .sorted((emp1, emp2) -> emp1.getName().compareTo(emp2.getName()))
                .forEach(employee -> System.out.println(employee.getName()));
        System.out.println();
        employees.stream()
                .sorted((emp1, emp2) -> emp2.getName().compareTo(emp1.getName()))
                .forEach(employee -> System.out.println(employee.getName()));

    }
}

@AllArgsConstructor
@ToString
@Getter
class Employee
{
    private final String name;
    private final int age;
    private final double salary;
}
