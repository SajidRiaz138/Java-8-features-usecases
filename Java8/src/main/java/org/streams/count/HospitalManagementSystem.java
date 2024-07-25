package org.streams.count;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HospitalManagementSystem
{
    public static void main(String[] args)
    {
        Patient patient1 = new Patient("Alice", 30, "Flu");
        Patient patient2 = new Patient("Bob", 45, "Covid-19");
        Patient patient3 = new Patient("Charlie", 25, "Flu");
        Patient patient4 = new Patient("Dave", 60, "Diabetes");
        Patient patient5 = new Patient("Eve", 35, "Covid-19");

        Doctor doctor1 = new Doctor("Dr. Smith", "General Medicine");
        Doctor doctor2 = new Doctor("Dr. Johnson", "Endocrinology");
        Doctor doctor3 = new Doctor("Dr. Brown", "Virology");

        Appointment appointment1 = new Appointment(1, patient1, doctor1, LocalDate.of(2023, 7, 1));
        Appointment appointment2 = new Appointment(2, patient2, doctor3, LocalDate.of(2023, 7, 2));
        Appointment appointment3 = new Appointment(3, patient3, doctor1, LocalDate.of(2023, 7, 3));
        Appointment appointment4 = new Appointment(4, patient4, doctor2, LocalDate.of(2023, 7, 4));
        Appointment appointment5 = new Appointment(5, patient5, doctor3, LocalDate.of(2023, 7, 5));

        List<Appointment> appointments = Arrays.asList(appointment1, appointment2, appointment3, appointment4, appointment5);

        Department department1 = new Department("General Medicine", Collections.singletonList(doctor1));
        Department department2 = new Department("Endocrinology", Collections.singletonList(doctor2));
        Department department3 = new Department("Virology", Collections.singletonList(doctor3));

        List<Department> departments = Arrays.asList(department1, department2, department3);

        // Count the number of patients per doctor
        Map<String, Long> patientsPerDoctor = appointments.stream()
                .collect(Collectors.groupingBy(app -> app.getDoctor().getName(), Collectors.counting()));

        System.out.println("Number of patients per doctor:");
        patientsPerDoctor.forEach((doctor, count) -> System.out.println(doctor + ": " + count + " patients"));

        // Count the number of appointments per department
        Map<String, Long> appointmentsPerDepartment = departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        department -> department.getDoctors()
                                .stream()
                                .flatMap(doctor -> appointments.stream().filter(app -> app.getDoctor().equals(doctor)))
                                .count()));

        System.out.println("\nNumber of appointments per department:");
        appointmentsPerDepartment.forEach((department, count) -> System.out.println(department + ": " + count + " appointments"));

        // Count the number of patients with specific conditions
        Map<String, Long> patientsWithConditions = appointments.stream()
                .map(Appointment::getPatient)
                .collect(Collectors.groupingBy(Patient::getCondition, Collectors.counting()));

        System.out.println("\nNumber of patients with specific conditions:");
        patientsWithConditions.forEach((condition, count) -> System.out.println(condition + ": " + count + " patients"));
    }
}

@AllArgsConstructor
@Getter
class Patient
{
    private final String name;
    private final int age;
    private final String condition;
}

@AllArgsConstructor
@Getter
class Doctor
{
    private final String name;
    private final String specialization;
}

@AllArgsConstructor
@Getter
class Appointment
{
    private final int appointmentId;
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDate date;
}

@AllArgsConstructor
@Getter
class Department
{
    private String name;
    private List<Doctor> doctors;
}
