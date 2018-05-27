// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.oned.UPCEReader;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, ProductParsedResult

final class ProductResultParser extends ResultParser
{

    private ProductResultParser()
    {
    }

    public static ProductParsedResult parse(Result result)
    {
        BarcodeFormat barcodeformat = result.getBarcodeFormat();
        if(BarcodeFormat.UPC_A.equals(barcodeformat) || BarcodeFormat.UPC_E.equals(barcodeformat) || BarcodeFormat.EAN_8.equals(barcodeformat) || BarcodeFormat.EAN_13.equals(barcodeformat)) goto _L2; else goto _L1
_L1:
        String s;
        return null;
_L2:
        if((s = result.getText()) != null)
        {
            int j = s.length();
            int i = 0;
label0:
            do
            {
label1:
                {
                    if(i >= j)
                        break label1;
                    char c = s.charAt(i);
                    if(c < '0' || c > '9')
                        break label0;
                    i++;
                }
            } while(true);
        }
        if(true) goto _L1; else goto _L3
_L3:
        if(BarcodeFormat.UPC_E.equals(barcodeformat))
            result = UPCEReader.convertUPCEtoUPCA(s);
        else
            result = s;
        return new ProductParsedResult(s, result);
    }
}
