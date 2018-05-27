// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result.optional;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result.optional:
//            AbstractNDEFResultParser, NDEFRecord, NDEFTextResultParser, NDEFURIResultParser, 
//            NDEFSmartPosterParsedResult

final class NDEFSmartPosterResultParser extends AbstractNDEFResultParser
{

    NDEFSmartPosterResultParser()
    {
    }

    public static NDEFSmartPosterParsedResult parse(Result result)
    {
        result = result.getRawBytes();
        if(result != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return null;
_L2:
        if((obj = NDEFRecord.readRecord(result, 0)) == null || !((NDEFRecord) (obj)).isMessageBegin() || !((NDEFRecord) (obj)).isMessageEnd() || !((NDEFRecord) (obj)).getType().equals("Sp")) goto _L1; else goto _L3
_L3:
        int i;
        int j;
        byte byte0;
        Object obj1;
        byte abyte0[];
        i = 0;
        j = 0;
        result = null;
        abyte0 = ((NDEFRecord) (obj)).getPayload();
        byte0 = -1;
        obj1 = null;
        obj = null;
_L5:
        Object obj2;
        obj2 = result;
        if(i >= abyte0.length)
            continue; /* Loop/switch isn't completed */
        result = NDEFRecord.readRecord(abyte0, i);
        obj2 = result;
        if(result == null)
            continue; /* Loop/switch isn't completed */
        if(j == 0 && !result.isMessageBegin()) goto _L1; else goto _L4
_L4:
        String s1 = result.getType();
        String s;
        if("T".equals(s1))
        {
            obj2 = NDEFTextResultParser.decodeTextPayload(result.getPayload())[1];
            s = ((String) (obj));
        } else
        if("U".equals(s1))
        {
            s = NDEFURIResultParser.decodeURIPayload(result.getPayload());
            obj2 = obj1;
        } else
        {
            obj2 = obj1;
            s = ((String) (obj));
            if("act".equals(s1))
            {
                byte0 = result.getPayload()[0];
                obj2 = obj1;
                s = ((String) (obj));
            }
        }
        j++;
        i += result.getTotalRecordLength();
        obj1 = obj2;
        obj = s;
          goto _L5
        if(j == 0 || obj2 != null && !((NDEFRecord) (obj2)).isMessageEnd()) goto _L1; else goto _L6
_L6:
        return new NDEFSmartPosterParsedResult(byte0, ((String) (obj)), ((String) (obj1)));
    }
}
