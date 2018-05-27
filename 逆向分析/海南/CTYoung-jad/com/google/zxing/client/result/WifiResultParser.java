// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, WifiParsedResult

final class WifiResultParser extends ResultParser
{

    private WifiResultParser()
    {
    }

    public static WifiParsedResult parse(Result result)
    {
        result = result.getText();
        if(result == null || !result.startsWith("WIFI:"))
        {
            return null;
        } else
        {
            String s = matchSinglePrefixedField("S:", result, ';', false);
            String s1 = matchSinglePrefixedField("P:", result, ';', false);
            return new WifiParsedResult(matchSinglePrefixedField("T:", result, ';', false), s, s1);
        }
    }
}
