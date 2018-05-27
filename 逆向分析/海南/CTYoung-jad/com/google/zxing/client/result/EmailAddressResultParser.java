// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Hashtable;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, EmailAddressParsedResult, EmailDoCoMoResultParser

final class EmailAddressResultParser extends ResultParser
{

    EmailAddressResultParser()
    {
    }

    public static EmailAddressParsedResult parse(Result result)
    {
        String s2 = result.getText();
        if(s2 != null)
        {
            if(s2.startsWith("mailto:") || s2.startsWith("MAILTO:"))
            {
                Object obj = s2.substring(7);
                int i = ((String) (obj)).indexOf('?');
                result = ((Result) (obj));
                if(i >= 0)
                    result = ((String) (obj)).substring(0, i);
                Hashtable hashtable = parseNameValuePairs(s2);
                String s = null;
                String s1 = null;
                obj = result;
                if(hashtable != null)
                {
                    obj = result;
                    if(result.length() == 0)
                        obj = (String)hashtable.get("to");
                    s = (String)hashtable.get("subject");
                    s1 = (String)hashtable.get("body");
                }
                return new EmailAddressParsedResult(((String) (obj)), s, s1, s2);
            }
            if(EmailDoCoMoResultParser.isBasicallyValidEmailAddress(s2))
                return new EmailAddressParsedResult(s2, null, null, "mailto:" + s2);
        }
        return null;
    }
}
