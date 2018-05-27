// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, GeoParsedResult

final class GeoResultParser extends ResultParser
{

    private GeoResultParser()
    {
    }

    public static GeoParsedResult parse(Result result)
    {
        double d;
        double d1;
        double d2;
        String s;
        result = result.getText();
        if(result == null || !result.startsWith("geo:") && !result.startsWith("GEO:"))
            return null;
        int i = result.indexOf('?', 4);
        if(i < 0)
        {
            s = null;
            result = result.substring(4);
        } else
        {
            s = result.substring(i + 1);
            result = result.substring(4, i);
        }
        i = result.indexOf(',');
        if(i < 0)
            return null;
        int j = result.indexOf(',', i + 1);
        try
        {
            d2 = Double.parseDouble(result.substring(0, i));
        }
        // Misplaced declaration of an exception variable
        catch(Result result)
        {
            return null;
        }
        if(d2 <= 90D && d2 >= -90D) goto _L2; else goto _L1
_L2:
        if(j >= 0) goto _L4; else goto _L3
_L3:
        d = Double.parseDouble(result.substring(i + 1));
        d1 = 0.0D;
          goto _L5
_L4:
        d = Double.parseDouble(result.substring(i + 1, j));
        d1 = Double.parseDouble(result.substring(j + 1));
          goto _L5
_L7:
        return new GeoParsedResult(d2, d, d1, s);
_L1:
        return null;
_L5:
        if(d <= 180D && d >= -180D && d1 >= 0.0D) goto _L7; else goto _L6
_L6:
        return null;
    }
}
