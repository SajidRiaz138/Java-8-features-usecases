package org.functions.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Getter
@ToString
public class Patient
{
    private final String patientId;
    private final String name;
    private final double weight;
    private final double height;
    private final List<String> symptoms;
    private final double medicalBill;
}
