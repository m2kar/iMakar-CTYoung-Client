// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;

import com.google.zxing.Result;

// Referenced classes of package com.google.zxing.client.result:
//            AbstractDoCoMoResultParser, EmailAddressParsedResult

final class EmailDoCoMoResultParser extends AbstractDoCoMoResultParser
{

    EmailDoCoMoResultParser()
    {
    }

    private static boolean isAtextSymbol(char c)
    {
        for(int i = 0; i < ATEXT_SYMBOLS.length; i++)
            if(c == ATEXT_SYMBOLS[i])
                return true;

        return false;
    }

    static boolean isBasicallyValidEmailAddress(String s)
    {
        if(s != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        boolean flag = false;
        int i = 0;
        do
        {
            flag1 = flag;
            if(i >= s.length())
                continue;
            char c = s.charAt(i);
            if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && !isAtextSymbol(c))
                return false;
            flag1 = flag;
            if(c == '@')
            {
                if(flag)
                    return false;
                flag1 = true;
            }
            i++;
            flag = flag1;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static EmailAddressParsedResult parse(Result result)
    {
        result = result.getText();
        String as[];
        String s;
        if(result != null && result.startsWith("MATMSG:"))
            if((as = matchDoCoMoPrefixedField("TO:", result, true)) != null && isBasicallyValidEmailAddress(s = as[0]))
                return new EmailAddressParsedResult(s, matchSingleDoCoMoPrefixedField("SUB:", result, false), matchSingleDoCoMoPrefixedField("BODY:", result, false), "mailto:" + s);
        return null;
    }

    private static final char ATEXT_SYMBOLS[] = {
        '@', '.', '!', '#', '$', '%', '&', '\'', '*', '+', 
        '-', '/', '=', '?', '^', '_', '`', '{', '|', '}', 
        '~'
    };

}
