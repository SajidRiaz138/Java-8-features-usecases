package org.functions.consumer.usecases;

import org.functions.consumer.entity.Patient;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.DoubleConsumer;

public class HospitalManagementSystem
{
    public static void main(String[] args)
    {
        // Sample patient
        List<String> symptoms = Arrays.asList("fever", "cough", "difficulty breathing");
        Patient patient = new Patient("PAT001", "John Doe", 85.0, 1.75, symptoms, 120000.0);

        // Consumer<T> to log patient information
        Consumer<Patient> logPatientInfoConsumer = HospitalUtils::logPatientInfo;
        logPatientInfoConsumer.accept(patient);

        // IntConsumer to update available bed count
        IntConsumer updateAvailableBedsConsumer = HospitalUtils::updateAvailableBeds;
        updateAvailableBedsConsumer.accept(25);

        // LongConsumer to record medical expenses
        LongConsumer recordMedicalExpensesConsumer = HospitalUtils::recordMedicalExpenses;
        recordMedicalExpensesConsumer.accept((long) patient.getMedicalBill());

        // DoubleConsumer to adjust medication dosage
        DoubleConsumer adjustMedicationDosageConsumer = HospitalUtils::adjustMedicationDosage;
        adjustMedicationDosageConsumer.accept(500.0);
    }
}
