package org.functions.function.usecases;

import org.functions.function.entity.Shipment;

import java.util.function.*;

public class LogisticsManagementSystem
{
    public static void main(String[] args)
    {
        // Sample shipment
        Shipment shipment = new Shipment("SHIP123", 20, 40.0, 1001L, 20.0);

        // IntFunction<R> to generate shipment labels
        IntFunction<String[]> generateLabels = LogisticsUtils::generateShipmentLabels;
        String[] labels = generateLabels.apply(shipment.getNumberOfItems());
        System.out.println("Shipment Labels: " + String.join(", ", labels));

        // IntToDoubleFunction to calculate shipping cost
        IntToDoubleFunction calculateCost = LogisticsUtils::calculateShippingCost;
        double shippingCost = calculateCost.applyAsDouble((int) shipment.getTotalWeight());
        System.out.println("Shipping Cost: $" + shippingCost);

        // LongFunction<R> to generate tracking ID
        LongFunction<String> generateTrackingId = LogisticsUtils::generateTrackingId;
        String trackingId = generateTrackingId.apply(shipment.getOrderNumber());
        System.out.println("Tracking ID: " + trackingId);

        // IntToLongFunction to calculate delivery time
        IntToLongFunction calculateDeliveryTime = LogisticsUtils::calculateDeliveryTime;
        long deliveryTime = calculateDeliveryTime.applyAsLong(300); // 300 km
        System.out.println("Estimated Delivery Time: " + deliveryTime + " hours");

        // LongToDoubleFunction to calculate fuel consumption
        LongToDoubleFunction calculateFuelConsumption = LogisticsUtils::calculateFuelConsumption;
        double fuelConsumption = calculateFuelConsumption.applyAsDouble(300L);
        System.out.println("Fuel Consumption: " + fuelConsumption + " liters");

        // LongToIntFunction to calculate number of items from weight
        LongToIntFunction calculateNumberOfItems = LogisticsUtils::calculateNumberOfItems;
        int numberOfItemsFromWeight = calculateNumberOfItems.applyAsInt(40L);
        System.out.println("Number of Items from Weight: " + numberOfItemsFromWeight);

        // DoubleFunction<R> to generate shipping receipt
        DoubleFunction<String> generateReceipt = LogisticsUtils::generateShippingReceipt;
        String receipt = generateReceipt.apply(shippingCost);
        System.out.println("Shipping Receipt: " + receipt);

        // ToIntFunction<T> to get number of items from shipment
        ToIntFunction<Shipment> getNumberOfItems = LogisticsUtils::getNumberOfItemsFromShipment;
        int numberOfItems = getNumberOfItems.applyAsInt(shipment);
        System.out.println("Number of Items: " + numberOfItems);

        // ToDoubleFunction<T> to get total weight from shipment
        ToDoubleFunction<Shipment> getTotalWeight = LogisticsUtils::getTotalWeightFromShipment;
        double totalWeight = getTotalWeight.applyAsDouble(shipment);
        System.out.println("Total Weight: " + totalWeight + " kg");

        // ToLongFunction<T> to get order number from shipment
        ToLongFunction<Shipment> getOrderNumber = LogisticsUtils::getOrderNumberFromShipment;
        long orderNumber = getOrderNumber.applyAsLong(shipment);
        System.out.println("Order Number: " + orderNumber);
    }
}
