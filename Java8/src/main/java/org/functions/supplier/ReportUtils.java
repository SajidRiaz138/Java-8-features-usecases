package org.functions.supplier;

import org.common.Report;

import java.util.HashMap;
import java.util.Map;

public class ReportUtils
{

    // Generates a sales report
    public static Report generateSalesReport()
    {
        Map<String, Object> data = new HashMap<>();
        data.put("totalSales", 50000);
        data.put("numberOfTransactions", 120);
        return new Report("Sales Report", data);
    }

    // Generates an inventory report
    public static Report generateInventoryReport()
    {
        Map<String, Object> data = new HashMap<>();
        data.put("totalItems", 1500);
        data.put("outOfStockItems", 50);
        return new Report("Inventory Report", data);
    }

    // Generates a financial report
    public static Report generateFinancialReport()
    {
        Map<String, Object> data = new HashMap<>();
        data.put("totalRevenue", 200000);
        data.put("totalExpenses", 150000);
        return new Report("Financial Report", data);
    }
}
