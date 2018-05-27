// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result.optional;

import com.google.zxing.Result;
import com.google.zxing.client.result.TextParsedResult;

// Referenced classes of package com.google.zxing.client.result.optional:
//            AbstractNDEFResultParser, NDEFRecord

final class NDEFTextResultParser extends AbstractNDEFResultParser
{

    NDEFTextResultParser()
    {
    }

    static String[] decodeTextPayload(byte abyte0[])
    {
        int i = abyte0[0];
        boolean flag;
        String s;
        String s1;
        if((i & 0x80) != 0)
            flag = true;
        else
            flag = false;
        i &= 0x1f;
        s1 = bytesToString(abyte0, 1, i, "US-ASCII");
        if(flag)
            s = "UTF-16";
        else
            s = "UTF8";
        return (new String[] {
            s1, bytesToString(abyte0, i + 1, abyte0.length - i - 1, s)
        });
    }

    public static TextParsedResult parse(Result result)
    {
        result = result.getRawBytes();
        if(result != null)
            if((result = NDEFRecord.readRecord(result, 0)) != null && result.isMessageBegin() && result.isMessageEnd() && result.getType().equals("T"))
            {
                result = decodeTextPayload(result.getPayload());
                return new TextParsedResult(result[0], result[1]);
            }
        return null;
    }
}
