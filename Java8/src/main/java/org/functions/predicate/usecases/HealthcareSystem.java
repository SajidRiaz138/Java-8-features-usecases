package org.functions.predicate.usecases;

import org.functions.predicate.entity.Patient;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class HealthcareSystem
{
    public static void main(String[] args)
    {
        // Sample patient
        List<String> symptoms = Arrays.asList("fever", "cough", "difficulty breathing");
        Patient patient = new Patient("PAT001", "John Doe", 85.0, 1.75, symptoms, 120000.0);

        // Predicate<T> to evaluate whether a patient needs immediate attention
        Predicate<Patient> needsImmediateAttentionPredicate = HospitalUtils::needsImmediateAttention;
        boolean needsImmediateAttention = needsImmediateAttentionPredicate.test(patient);
        System.out.println("Needs Immediate Attention: " + needsImmediateAttention);

        // IntPredicate to determine if the number of available beds exceeds a specified threshold
        IntPredicate exceedsBedThresholdPredicate = HospitalUtils::exceedsBedThreshold;
        boolean exceedsBedThreshold = exceedsBedThresholdPredicate.test(25);
        System.out.println("Exceeds Bed Threshold: " + exceedsBedThreshold);

        // LongPredicate to check if a patient's medical bill is above a certain limit
        LongPredicate medicalBillAboveLimitPredicate = HospitalUtils::isMedicalBillAboveLimit;
        boolean isBillAboveLimit = medicalBillAboveLimitPredicate.test((long) patient.getMedicalBill());
        System.out.println("Medical Bill Above Limit: " + isBillAboveLimit);

        // DoublePredicate to assess if a patient's BMI is within a healthy range
        DoublePredicate bmiHealthyPredicate = HospitalUtils::isBMIHealthy;
        boolean isBMIHealthy = bmiHealthyPredicate.test(patient.calculateBMI());
        System.out.println("BMI Healthy: " + isBMIHealthy);
    }
}
