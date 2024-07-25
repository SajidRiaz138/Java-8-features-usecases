package org.functions.function.usecases;

import org.functions.function.entity.Shipment;

public class LogisticsUtils
{

    // Generates shipment labels
    public static String[] generateShipmentLabels(int numberOfItems)
    {
        String[] labels = new String[numberOfItems];
        for (int i = 0; i < numberOfItems; i++)
        {
            labels[i] = "Label-" + (i + 1);
        }
        return labels;
    }

    // Calculates shipping cost based on weight
    public static double calculateShippingCost(int weight)
    {
        return weight * 0.5; // Example cost calculation: $0.5 per kg
    }

    // Generates tracking ID based on order number
    public static String generateTrackingId(long orderNumber)
    {
        return "TRACK-" + orderNumber;
    }

    // Calculates estimated delivery time based on distance
    public static long calculateDeliveryTime(int distance)
    {
        return distance / 60L; // Example: 1 hour per 60 km
    }

    // Calculates fuel consumption based on distance
    public static double calculateFuelConsumption(long distance)
    {
        return distance * 0.1; // Example: 0.1 liters per km
    }

    // Calculates number of items from weight
    public static int calculateNumberOfItems(long weight)
    {
        return (int) (weight / 2); // Example: 1 item per 2 kg
    }

    // Generates shipping receipt based on cost
    public static String generateShippingReceipt(double cost)
    {
        return "Receipt: $" + cost;
    }

    // Gets number of items from a shipment
    public static int getNumberOfItemsFromShipment(Shipment shipment)
    {
        return shipment.getNumberOfItems();
    }

    // Gets total weight from a shipment
    public static double getTotalWeightFromShipment(Shipment shipment)
    {
        return shipment.getTotalWeight();
    }

    // Gets order number from a shipment
    public static long getOrderNumberFromShipment(Shipment shipment)
    {
        return shipment.getOrderNumber();
    }
}
