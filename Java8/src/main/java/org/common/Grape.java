package org.common;

public class Grape
{
    private org.common.Color color;
    private double weight;

    public Grape(org.common.Color color, double weight)
    {
        this.color = color;
        this.weight = weight;
    }

    public static boolean isRedGrapes(Grape grape)
    {
        return org.common.Color.RED == grape.getColor();
    }

    public org.common.Color getColor()
    {
        return color;
    }

    public double getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return "Grape{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
