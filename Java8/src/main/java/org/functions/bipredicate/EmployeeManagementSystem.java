package org.functions.bipredicate;

import org.common.Employee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class EmployeeManagementSystem
{

    public static void main(String[] args)
    {
        // Sample data
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 5, 4.5, new HashSet<>(Arrays.asList("Java", "Spring", "SQL")), true, 40),
                new Employee("Bob", 2, 3.8, new HashSet<>(Arrays.asList("JavaScript", "React", "Node.js")), true, 35),
                new Employee("Charlie", 10, 4.2, new HashSet<>(Arrays.asList("Java", "Spring", "Microservices")), false, 45),
                new Employee("Diana", 8, 4.9, new HashSet<>(Arrays.asList("Python", "Django", "ML")), true, 38));

        // BiPredicate to check if an employee is eligible for promotion
        BiPredicate<Integer, Double> isEligibleForPromotion =
                (yearsOfExperience, performanceRating) -> yearsOfExperience >= 5 && performanceRating >= 4.0;

        // BiPredicate to filter employees for project assignment based on skills and availability
        BiPredicate<Set<String>, Boolean> isAvailableForProject = (skills, availability) -> skills.contains("Java") && availability;

        // BiPredicate to validate if an employee meets the required minimum work hours
        BiPredicate<Integer, Integer> meetsWorkHoursRequirement = (workHours, minRequiredHours) -> workHours >= minRequiredHours;

        // Check and print eligible employees for promotion
        List<Employee> eligibleForPromotion = employees.stream()
                .filter(emp -> isEligibleForPromotion.test(emp.getYearsOfExperience(), emp.getPerformanceRating()))
                .collect(Collectors.toList());
        System.out.println("Employees eligible for promotion:");
        eligibleForPromotion.forEach(emp -> System.out.println(emp.getName()));

        // Filter and print employees available for a Java project
        List<Employee> availableForProject = employees.stream()
                .filter(emp -> isAvailableForProject.test(emp.getSkills(), emp.isAvailable()))
                .collect(Collectors.toList());
        System.out.println("\nEmployees available for Java project:");
        availableForProject.forEach(emp -> System.out.println(emp.getName()));

        // Validate and print employees meeting the required work hours
        int requiredHours = 40;
        List<Employee> meetingWorkHoursRequirement = employees.stream()
                .filter(emp -> meetsWorkHoursRequirement.test(emp.getWeeklyWorkHours(), requiredHours))
                .collect(Collectors.toList());
        System.out.println("\nEmployees meeting the required work hours:");
        meetingWorkHoursRequirement.forEach(emp -> System.out.println(emp.getName()));
    }
}
