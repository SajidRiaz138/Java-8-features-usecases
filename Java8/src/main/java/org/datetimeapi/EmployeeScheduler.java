package org.datetimeapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class EmployeeScheduler
{
    public static void main(String[] args)
    {
        List<Employee> employees = getEmployees();
        employees.forEach(employee -> System.out.println(employee.getName() + " total working hours: " + employee.getTotalWorkingHours().toHours() + " hours"));
        Duration standardHours = Duration.ofHours(40);
        employees.forEach(employee -> System.out.println(employee.getName() + " is working overtime: " + employee.isWorkingOvertime(standardHours)));

        ZoneId zoneId = ZoneId.of("America/New_York");
        employees.forEach(employee ->
        {
            System.out.println(employee.getName() + "'s shifts in New York time:");
            employee.getShifts()
                    .forEach(shift -> System.out.println("Start: " + shift.getStartInZone(zoneId) + ", End: " + shift.getEndInZone(zoneId)));
        });
    }

    private static List<Employee> getEmployees()
    {
        return Arrays.asList(
                new Employee("Alice",
                        Arrays.asList(new Shift("2023-07-23 09:00", "2023-07-23 17:00"),
                                new Shift("2023-07-24 09:00", "2023-07-24 17:00"))),
                new Employee("Bob",
                        Arrays.asList(new Shift("2023-07-23 08:00", "2023-07-23 18:00"),
                                new Shift("2023-07-24 08:00", "2023-07-24 18:00"))),
                new Employee("Charlie", Arrays.asList(new Shift("2023-07-23 09:00", "2023-07-23 17:00"),
                        new Shift("2023-07-24 09:00", "2023-07-24 12:00"))));
    }
}

@Getter
@ToString
@AllArgsConstructor
class Shift
{
    private LocalDateTime start;
    private LocalDateTime end;

    public Shift(String start, String end)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.start = LocalDateTime.parse(start, formatter);
        this.end = LocalDateTime.parse(end, formatter);
    }

    public Duration getDuration()
    {
        return Duration.between(start, end);
    }

    public ZonedDateTime getStartInZone(ZoneId zone)
    {
        return start.atZone(zone);
    }

    public ZonedDateTime getEndInZone(ZoneId zone)
    {
        return end.atZone(zone);
    }
}

@Getter
@ToString
@AllArgsConstructor
class Employee
{
    private final String name;
    private final List<Shift> shifts;

    public Duration getTotalWorkingHours()
    {
        return shifts.stream()
                .map(Shift::getDuration)
                .reduce(Duration.ZERO, Duration::plus);
    }

    public boolean isWorkingOvertime(Duration standardHours)
    {
        return getTotalWorkingHours().compareTo(standardHours) > 0;
    }
}
