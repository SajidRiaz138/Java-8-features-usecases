package org.streams.listtomap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentGrades
{
    public static void main(String[] args)
    {
        List<Student> students = Arrays.asList(
                new Student("Alice", "A"),
                new Student("Bob", "B"),
                new Student("Charlie", "C"),
                new Student("Alice", "A+"));

        Map<String, String> studentGrades = students.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        Student::getGrade,
                        (existing, replacement) -> replacement, // In case of duplicate names, keep the latest grade
                        HashMap::new));

        System.out.println(studentGrades);
    }
}

@AllArgsConstructor
@Getter
@ToString
class Student
{
    private String name;
    private String grade;
}
