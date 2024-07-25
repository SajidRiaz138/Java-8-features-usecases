package org.functions.consumer.usecases;

import org.functions.consumer.entity.TaxPayer;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.DoubleConsumer;

public class TaxOfficeSystem
{
    public static void main(String[] args)
    {
        TaxPayer taxpayer = new TaxPayer("TAX001", "Alice Smith", 75000.0, 15000.0);

        // Consumer<T> to log taxpayer information
        Consumer<TaxPayer> logTaxpayerInfoConsumer = TaxOfficeUtils::logTaxpayerInfo;
        logTaxpayerInfoConsumer.accept(taxpayer);

        // IntConsumer to update tax bracket threshold
        IntConsumer updateTaxBracketThresholdConsumer = TaxOfficeUtils::updateTaxBracketThreshold;
        updateTaxBracketThresholdConsumer.accept(50000);

        // LongConsumer to record financial transactions
        LongConsumer recordFinancialTransactionConsumer = TaxOfficeUtils::recordFinancialTransaction;
        recordFinancialTransactionConsumer.accept(250000L);

        // DoubleConsumer to adjust tax rates
        DoubleConsumer adjustTaxRateConsumer = TaxOfficeUtils::adjustTaxRate;
        adjustTaxRateConsumer.accept(22.5);
    }
}
