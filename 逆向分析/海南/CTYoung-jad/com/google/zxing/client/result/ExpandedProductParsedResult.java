// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import java.util.Hashtable;

// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public class ExpandedProductParsedResult extends ParsedResult
{

    ExpandedProductParsedResult()
    {
        super(ParsedResultType.PRODUCT);
        productID = "";
        sscc = "";
        lotNumber = "";
        productionDate = "";
        packagingDate = "";
        bestBeforeDate = "";
        expirationDate = "";
        weight = "";
        weightType = "";
        weightIncrement = "";
        price = "";
        priceIncrement = "";
        priceCurrency = "";
        uncommonAIs = new Hashtable();
    }

    public ExpandedProductParsedResult(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, Hashtable hashtable)
    {
        super(ParsedResultType.PRODUCT);
        productID = s;
        sscc = s1;
        lotNumber = s2;
        productionDate = s3;
        packagingDate = s4;
        bestBeforeDate = s5;
        expirationDate = s6;
        weight = s7;
        weightType = s8;
        weightIncrement = s9;
        price = s10;
        priceIncrement = s11;
        priceCurrency = s12;
        uncommonAIs = hashtable;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof ExpandedProductParsedResult)
            if(productID.equals(((ExpandedProductParsedResult) (obj = (ExpandedProductParsedResult)obj)).productID) && sscc.equals(((ExpandedProductParsedResult) (obj)).sscc) && lotNumber.equals(((ExpandedProductParsedResult) (obj)).lotNumber) && productionDate.equals(((ExpandedProductParsedResult) (obj)).productionDate) && bestBeforeDate.equals(((ExpandedProductParsedResult) (obj)).bestBeforeDate) && expirationDate.equals(((ExpandedProductParsedResult) (obj)).expirationDate) && weight.equals(((ExpandedProductParsedResult) (obj)).weight) && weightType.equals(((ExpandedProductParsedResult) (obj)).weightType) && weightIncrement.equals(((ExpandedProductParsedResult) (obj)).weightIncrement) && price.equals(((ExpandedProductParsedResult) (obj)).price) && priceIncrement.equals(((ExpandedProductParsedResult) (obj)).priceIncrement) && priceCurrency.equals(((ExpandedProductParsedResult) (obj)).priceCurrency) && uncommonAIs.equals(((ExpandedProductParsedResult) (obj)).uncommonAIs))
                return true;
        return false;
    }

    public String getBestBeforeDate()
    {
        return bestBeforeDate;
    }

    public String getDisplayResult()
    {
        return productID;
    }

    public String getExpirationDate()
    {
        return expirationDate;
    }

    public String getLotNumber()
    {
        return lotNumber;
    }

    public String getPackagingDate()
    {
        return packagingDate;
    }

    public String getPrice()
    {
        return price;
    }

    public String getPriceCurrency()
    {
        return priceCurrency;
    }

    public String getPriceIncrement()
    {
        return priceIncrement;
    }

    public String getProductID()
    {
        return productID;
    }

    public String getProductionDate()
    {
        return productionDate;
    }

    public String getSscc()
    {
        return sscc;
    }

    public Hashtable getUncommonAIs()
    {
        return uncommonAIs;
    }

    public String getWeight()
    {
        return weight;
    }

    public String getWeightIncrement()
    {
        return weightIncrement;
    }

    public String getWeightType()
    {
        return weightType;
    }

    public int hashCode()
    {
        return (((((productID.hashCode() * 31 + sscc.hashCode()) * 31 + lotNumber.hashCode()) * 31 + productionDate.hashCode()) * 31 + bestBeforeDate.hashCode()) * 31 + expirationDate.hashCode()) * 31 + weight.hashCode() ^ ((((weightType.hashCode() * 31 + weightIncrement.hashCode()) * 31 + price.hashCode()) * 31 + priceIncrement.hashCode()) * 31 + priceCurrency.hashCode()) * 31 + uncommonAIs.hashCode();
    }

    public static final String KILOGRAM = "KG";
    public static final String POUND = "LB";
    private final String bestBeforeDate;
    private final String expirationDate;
    private final String lotNumber;
    private final String packagingDate;
    private final String price;
    private final String priceCurrency;
    private final String priceIncrement;
    private final String productID;
    private final String productionDate;
    private final String sscc;
    private final Hashtable uncommonAIs;
    private final String weight;
    private final String weightIncrement;
    private final String weightType;
}
