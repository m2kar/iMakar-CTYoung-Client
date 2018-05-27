// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, TelParsedResult

final class TelResultParser extends ResultParser
{

    private TelResultParser()
    {
    }

    public static TelParsedResult parse(Result result)
    {
        String s = result.getText();
        if(s == null || !s.startsWith("tel:") && !s.startsWith("TEL:"))
            return null;
        int i;
        if(s.startsWith("TEL:"))
            result = "tel:" + s.substring(4);
        else
            result = s;
        i = s.indexOf('?', 4);
        if(i < 0)
            s = s.substring(4);
        else
            s = s.substring(4, i);
        return new TelParsedResult(s, result, null);
    }
}
