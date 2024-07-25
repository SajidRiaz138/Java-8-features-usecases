package org.functions.predicate.usecases;

import org.functions.predicate.entity.Patient;

import java.util.Arrays;
import java.util.List;

public class HospitalUtils
{

    // Evaluates whether a patient needs immediate attention
    public static boolean needsImmediateAttention(Patient patient)
    {
        List<String> criticalSymptoms = Arrays.asList("chest pain", "difficulty breathing", "loss of consciousness");
        return patient.getSymptoms().stream().anyMatch(criticalSymptoms::contains);
    }

    // Determines if the number of available beds exceeds a specified threshold
    public static boolean exceedsBedThreshold(int availableBeds)
    {
        int threshold = 20;
        return availableBeds > threshold;
    }

    // Checks if a patient's medical bill is above a certain limit
    public static boolean isMedicalBillAboveLimit(long medicalBill)
    {
        long limit = 100000; // Example limit: $100,000
        return medicalBill > limit;
    }

    // Assesses if a patient's BMI is within a healthy range
    public static boolean isBMIHealthy(double bmi)
    {
        double minBMI = 18.5;
        double maxBMI = 24.9;
        return bmi >= minBMI && bmi <= maxBMI;
    }
}
