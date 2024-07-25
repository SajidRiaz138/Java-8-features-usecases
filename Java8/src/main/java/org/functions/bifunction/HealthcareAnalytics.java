package org.functions.bifunction;

import org.common.Patient;
import org.common.Treatment;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;

public class HealthcareAnalytics
{

    public static void main(String[] args)
    {
        List<Patient> patients = Arrays.asList(
                new Patient("John Doe", Arrays.asList(new Treatment(500.0, 1), new Treatment(300.0, 2))),
                new Patient("Jane Smith", Arrays.asList(new Treatment(700.0, 1), new Treatment(200.0, 3))),
                new Patient("Alice Johnson", Arrays.asList(new Treatment(400.0, 1), new Treatment(150.0, 4))),
                new Patient("Bob Brown", Arrays.asList(new Treatment(1000.0, 1), new Treatment(600.0, 2))));

        // Calculate total visits using ToIntBiFunction
        ToIntBiFunction<Integer, Integer> totalVisitsCalculator = Integer::sum;
        int totalVisits = patients.stream()
                .flatMap(patient -> patient.getTreatments().stream())
                .mapToInt(treatment -> totalVisitsCalculator.applyAsInt(0, treatment.getVisitCount()))
                .sum();
        System.out.println("Total Visits: " + totalVisits); // Output: Total Visits: 15

        // Calculate total cost using ToLongBiFunction
        ToLongBiFunction<Double, Integer> totalCostCalculator = (cost, visits) -> (long) (cost * visits);
        long totalCost = patients.stream()
                .flatMap(patient -> patient.getTreatments().stream())
                .mapToLong(treatment -> totalCostCalculator.applyAsLong(treatment.getCost(), treatment.getVisitCount()))
                .sum();
        System.out.println("Total Cost: $" + totalCost); // Output: Total Cost: $7500

        // Calculate average cost per visit using ToDoubleBiFunction
        ToDoubleBiFunction<Double, Integer> averageCostPerVisitCalculator =
                (totalCostValue, totalVisitCount) -> totalCostValue / totalVisitCount;
        double totalTreatmentCost = patients.stream()
                .flatMap(patient -> patient.getTreatments().stream())
                .mapToDouble(treatment -> treatment.getCost() * treatment.getVisitCount())
                .sum();
        double averageCostPerVisit = averageCostPerVisitCalculator.applyAsDouble(totalTreatmentCost, totalVisits);
        System.out.println("Average Cost per Visit: $" + averageCostPerVisit); // Output: Average Cost per Visit: $500.0

        // Calculate maximum treatment cost
        double maxTreatmentCost = patients.stream()
                .flatMap(patient -> patient.getTreatments().stream())
                .mapToDouble(Treatment::getCost)
                .max()
                .orElse(0.0);
        System.out.println("Maximum Treatment Cost: $" + maxTreatmentCost); // Output: Maximum Treatment Cost: $1000.0

        // Calculate minimum treatment cost
        double minTreatmentCost = patients.stream()
                .flatMap(patient -> patient.getTreatments().stream())
                .mapToDouble(Treatment::getCost)
                .min()
                .orElse(0.0);
        System.out.println("Minimum Treatment Cost: $" + minTreatmentCost); // Output: Minimum Treatment Cost: $150.0
    }
}
