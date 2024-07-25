package org.common;

import java.util.Set;

public class Employee
{
    private final String name;
    private final int yearsOfExperience;
    private final double performanceRating;
    private final Set<String> skills;
    private final boolean isAvailable;
    private final int weeklyWorkHours;

    public Employee(String name,
                    int yearsOfExperience,
                    double performanceRating,
                    Set<String> skills,
                    boolean isAvailable,
                    int weeklyWorkHours)
    {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.performanceRating = performanceRating;
        this.skills = skills;
        this.isAvailable = isAvailable;
        this.weeklyWorkHours = weeklyWorkHours;
    }

    public String getName()
    {
        return name;
    }

    public int getYearsOfExperience()
    {
        return yearsOfExperience;
    }

    public double getPerformanceRating()
    {
        return performanceRating;
    }

    public Set<String> getSkills()
    {
        return skills;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }

    public int getWeeklyWorkHours()
    {
        return weeklyWorkHours;
    }
}
