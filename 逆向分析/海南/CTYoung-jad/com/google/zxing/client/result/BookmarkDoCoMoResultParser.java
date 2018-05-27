// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            AbstractDoCoMoResultParser, URIResultParser, URIParsedResult

final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser
{

    private BookmarkDoCoMoResultParser()
    {
    }

    public static URIParsedResult parse(Result result)
    {
        String s = result.getText();
        if(s != null && s.startsWith("MEBKM:"))
        {
            result = matchSingleDoCoMoPrefixedField("TITLE:", s, true);
            String as[] = matchDoCoMoPrefixedField("URL:", s, true);
            if(as != null)
            {
                String s1 = as[0];
                if(URIResultParser.isBasicallyValidURI(s1))
                    return new URIParsedResult(s1, result);
            }
        }
        return null;
    }
}
