// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            AbstractDoCoMoResultParser, AddressBookParsedResult

final class AddressBookDoCoMoResultParser extends AbstractDoCoMoResultParser
{

    AddressBookDoCoMoResultParser()
    {
    }

    public static AddressBookParsedResult parse(Result result)
    {
        String s1 = result.getText();
        if(s1 != null && s1.startsWith("MECARD:"))
            if((result = matchDoCoMoPrefixedField("N:", s1, true)) != null)
            {
                String s2 = parseName(result[0]);
                String s3 = matchSingleDoCoMoPrefixedField("SOUND:", s1, true);
                String as[] = matchDoCoMoPrefixedField("TEL:", s1, true);
                String as1[] = matchDoCoMoPrefixedField("EMAIL:", s1, true);
                String s4 = matchSingleDoCoMoPrefixedField("NOTE:", s1, false);
                String as2[] = matchDoCoMoPrefixedField("ADR:", s1, true);
                String s = matchSingleDoCoMoPrefixedField("BDAY:", s1, true);
                result = s;
                if(s != null)
                {
                    result = s;
                    if(!isStringOfDigits(s, 8))
                        result = null;
                }
                s = matchSingleDoCoMoPrefixedField("URL:", s1, true);
                s1 = matchSingleDoCoMoPrefixedField("ORG:", s1, true);
                return new AddressBookParsedResult(maybeWrap(s2), s3, as, as1, s4, as2, s1, result, null, s);
            }
        return null;
    }

    private static String parseName(String s)
    {
        int i = s.indexOf(',');
        String s1 = s;
        if(i >= 0)
            s1 = s.substring(i + 1) + ' ' + s.substring(0, i);
        return s1;
    }
}
