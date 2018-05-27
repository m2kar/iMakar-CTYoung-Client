// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, ISBNParsedResult

public class ISBNResultParser extends ResultParser
{

    private ISBNResultParser()
    {
    }

    public static ISBNParsedResult parse(Result result)
    {
        BarcodeFormat barcodeformat = result.getBarcodeFormat();
        if(BarcodeFormat.EAN_13.equals(barcodeformat))
            if((result = result.getText()) != null && result.length() == 13 && (result.startsWith("978") || result.startsWith("979")))
                return new ISBNParsedResult(result);
        return null;
    }
}
