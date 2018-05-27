// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Vector;

// Referenced classes of package com.google.zxing.client.result:
//            AbstractDoCoMoResultParser, AddressBookParsedResult

final class BizcardResultParser extends AbstractDoCoMoResultParser
{

    BizcardResultParser()
    {
    }

    private static String buildName(String s, String s1)
    {
        if(s == null)
            return s1;
        if(s1 != null)
            s = s + ' ' + s1;
        return s;
    }

    private static String[] buildPhoneNumbers(String s, String s1, String s2)
    {
        int j;
        Vector vector;
        vector = new Vector(3);
        if(s != null)
            vector.addElement(s);
        if(s1 != null)
            vector.addElement(s1);
        if(s2 != null)
            vector.addElement(s2);
        j = vector.size();
        if(j != 0) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        s1 = new String[j];
        int i = 0;
        do
        {
            s = s1;
            if(i >= j)
                continue;
            s1[i] = (String)vector.elementAt(i);
            i++;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static AddressBookParsedResult parse(Result result)
    {
        String s5 = result.getText();
        if(s5 == null || !s5.startsWith("BIZCARD:"))
        {
            return null;
        } else
        {
            result = buildName(matchSingleDoCoMoPrefixedField("N:", s5, true), matchSingleDoCoMoPrefixedField("X:", s5, true));
            String s = matchSingleDoCoMoPrefixedField("T:", s5, true);
            String s1 = matchSingleDoCoMoPrefixedField("C:", s5, true);
            String as[] = matchDoCoMoPrefixedField("A:", s5, true);
            String s2 = matchSingleDoCoMoPrefixedField("B:", s5, true);
            String s3 = matchSingleDoCoMoPrefixedField("M:", s5, true);
            String s4 = matchSingleDoCoMoPrefixedField("F:", s5, true);
            s5 = matchSingleDoCoMoPrefixedField("E:", s5, true);
            return new AddressBookParsedResult(maybeWrap(result), null, buildPhoneNumbers(s2, s3, s4), maybeWrap(s5), null, as, s1, null, s, null);
        }
    }
}
