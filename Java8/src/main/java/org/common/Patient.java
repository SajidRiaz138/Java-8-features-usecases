package org.common;

import java.util.Collections;
import java.util.List;

public class Patient
{
    private final String name;
    private final List<Treatment> treatments;

    public Patient(String name, List<Treatment> treatments)
    {
        this.name = name;
        this.treatments = treatments;
    }

    public String getName()
    {
        return name;
    }

    public List<Treatment> getTreatments()
    {
        return Collections.unmodifiableList(treatments);
    }
}
