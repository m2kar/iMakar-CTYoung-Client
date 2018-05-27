// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, URIParsedResult

final class URIResultParser extends ResultParser
{

    private URIResultParser()
    {
    }

    static boolean isBasicallyValidURI(String s)
    {
        if(s != null && s.indexOf(' ') < 0 && s.indexOf('\n') < 0) goto _L2; else goto _L1
_L1:
        int i;
        return false;
_L2:
        int k;
        if((i = s.indexOf('.')) >= s.length() - 2)
            continue; /* Loop/switch isn't completed */
        k = s.indexOf(':');
        if(i < 0 && k < 0)
            continue; /* Loop/switch isn't completed */
        if(k < 0)
            break MISSING_BLOCK_LABEL_159;
        if(i >= 0 && i <= k)
            continue; /* Loop/switch isn't completed */
        i = 0;
        do
        {
            if(i >= k)
                break MISSING_BLOCK_LABEL_159;
            char c = s.charAt(i);
            if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
                continue; /* Loop/switch isn't completed */
            i++;
        } while(true);
        if(k >= s.length() - 2) goto _L1; else goto _L3
_L3:
        int j = k + 1;
        do
        {
            if(j >= k + 3)
                break MISSING_BLOCK_LABEL_159;
            char c1 = s.charAt(j);
            if(c1 < '0' || c1 > '9')
                break;
            j++;
        } while(true);
        if(true) goto _L1; else goto _L4
_L4:
        return true;
    }

    public static URIParsedResult parse(Result result)
    {
        String s = result.getText();
        result = s;
        if(s != null)
        {
            result = s;
            if(s.startsWith("URL:"))
                result = s.substring(4);
        }
        if(!isBasicallyValidURI(result))
            return null;
        else
            return new URIParsedResult(result, null);
    }
}
