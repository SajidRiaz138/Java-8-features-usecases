package org.functions.consumer.usecases;

import org.functions.consumer.entity.Patient;

public class HospitalUtils
{

    // Logs patient information
    public static void logPatientInfo(Patient patient)
    {
        System.out.println("Logging Patient Info: " + patient);
    }

    // Updates the available bed count
    public static void updateAvailableBeds(int beds)
    {
        System.out.println("Updating available beds to: " + beds);
    }

    // Records medical expenses
    public static void recordMedicalExpenses(long expenses)
    {
        System.out.println("Recording medical expenses: $" + expenses);
    }

    // Adjusts medication dosage
    public static void adjustMedicationDosage(double dosage)
    {
        System.out.println("Adjusting medication dosage to: " + dosage + " mg");
    }
}
