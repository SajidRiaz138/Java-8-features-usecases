package org.functions.predicate.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Patient
{
    private final String patientId;
    private final String name;
    private final double weight;
    private final double height;
    private final List<String> symptoms;
    private final double medicalBill;

    public double calculateBMI()
    {
        return weight / (height * height);
    }
}
