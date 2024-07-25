package org.common;

public class Treatment
{
    private final double cost;
    private final int visitCount;

    public Treatment(double cost, int visitCount)
    {
        this.cost = cost;
        this.visitCount = visitCount;
    }

    public double getCost()
    {
        return cost;
    }

    public int getVisitCount()
    {
        return visitCount;
    }
}
