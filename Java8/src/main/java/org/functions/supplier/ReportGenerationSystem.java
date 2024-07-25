package org.functions.supplier;

import org.common.Report;
import java.util.function.Supplier;

public class ReportGenerationSystem
{
    public static void main(String[] args)
    {
        // Supplier for sales report
        Supplier<Report> salesReportSupplier = ReportUtils::generateSalesReport;

        // Supplier for inventory report
        Supplier<Report> inventoryReportSupplier = ReportUtils::generateInventoryReport;

        // Supplier for financial report
        Supplier<Report> financialReportSupplier = ReportUtils::generateFinancialReport;

        // Retrieve and print sales report
        Report salesReport = salesReportSupplier.get();
        System.out.println("Sales Report: " + salesReport);

        // Retrieve and print inventory report
        Report inventoryReport = inventoryReportSupplier.get();
        System.out.println("Inventory Report: " + inventoryReport);

        // Retrieve and print financial report
        Report financialReport = financialReportSupplier.get();
        System.out.println("Financial Report: " + financialReport);

        // Example of lazy initialization
        Supplier<Report> lazySalesReportSupplier = () ->
        {
            System.out.println("Generating sales report...");
            return ReportUtils.generateSalesReport();
        };

        // Report is not generated until get() is called
        System.out.println("Lazy Sales Report (before get):");
        Report lazySalesReport = lazySalesReportSupplier.get();
        System.out.println("Lazy Sales Report (after get): " + lazySalesReport);

        // Example of caching
        Supplier<Report> cachedReportSupplier = Common.createCachedSupplier(ReportUtils::generateSalesReport);
        Report cachedReport1 = cachedReportSupplier.get();
        Report cachedReport2 = cachedReportSupplier.get();

        System.out.println("Cached Report (first call): " + cachedReport1);
        System.out.println("Cached Report (second call): " + cachedReport2);

        // Example of dynamic update
        Supplier<Report> dynamicReportSupplier = Common.createDynamicSupplier(
                ReportUtils::generateSalesReport,
                ReportUtils::generateInventoryReport);

        System.out.println("Dynamic Report (first call): " + dynamicReportSupplier.get());
        System.out.println("Dynamic Report (second call): " + dynamicReportSupplier.get());
    }
}
