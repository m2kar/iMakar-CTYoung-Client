// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Vector;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, AddressBookParsedResult

final class AddressBookAUResultParser extends ResultParser
{

    AddressBookAUResultParser()
    {
    }

    private static String[] matchMultipleValuePrefix(String s, int i, String s1, boolean flag)
    {
        Vector vector = null;
        int j = 1;
        do
        {
label0:
            {
                String s2;
                if(j <= i)
                {
                    s2 = matchSinglePrefixedField(s + j + ':', s1, '\r', flag);
                    if(s2 != null)
                        break label0;
                }
                Vector vector1;
                if(vector == null)
                    return null;
                else
                    return toStringArray(vector);
            }
            vector1 = vector;
            if(vector == null)
                vector1 = new Vector(i);
            vector1.addElement(s2);
            j++;
            vector = vector1;
        } while(true);
    }

    public static AddressBookParsedResult parse(Result result)
    {
        result = result.getText();
        if(result == null || result.indexOf("MEMORY") < 0 || result.indexOf("\r\n") < 0)
            return null;
        String s = matchSinglePrefixedField("NAME1:", result, '\r', true);
        String s1 = matchSinglePrefixedField("NAME2:", result, '\r', true);
        String as[] = matchMultipleValuePrefix("TEL", 3, result, true);
        String as1[] = matchMultipleValuePrefix("MAIL", 3, result, true);
        String s2 = matchSinglePrefixedField("MEMORY:", result, '\r', false);
        String s3 = matchSinglePrefixedField("ADD:", result, '\r', true);
        if(s3 == null)
        {
            result = null;
        } else
        {
            result = new String[1];
            result[0] = s3;
        }
        return new AddressBookParsedResult(maybeWrap(s), s1, as, as1, s2, result, null, null, null, null);
    }
}
