package org.common;

public class Sale
{
    private final String productName;
    private final int quantitySold;

    public Sale(String productName, int quantitySold)
    {
        this.productName = productName;
        this.quantitySold = quantitySold;
    }

    public String getProductName()
    {
        return productName;
    }

    public int getQuantitySold()
    {
        return quantitySold;
    }
}
