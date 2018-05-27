// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            URIParsedResult

final class URLTOResultParser
{

    private URLTOResultParser()
    {
    }

    public static URIParsedResult parse(Result result)
    {
        Object obj = null;
        String s = result.getText();
        int i;
        if(s != null && (s.startsWith("urlto:") || s.startsWith("URLTO:")))
            if((i = s.indexOf(':', 6)) >= 0)
            {
                if(i <= 6)
                    result = obj;
                else
                    result = s.substring(6, i);
                return new URIParsedResult(s.substring(i + 1), result);
            }
        return null;
    }
}
