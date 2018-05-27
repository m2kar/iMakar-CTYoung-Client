// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class URIParsedResult extends ParsedResult
{

    public URIParsedResult(String s, String s1)
    {
        super(ParsedResultType.URI);
        uri = massageURI(s);
        title = s1;
    }

    private boolean containsUser()
    {
        int i = uri.indexOf(':') + 1;
        int k;
        for(k = uri.length(); i < k && uri.charAt(i) == '/'; i++);
        int l = uri.indexOf('/', i);
        int j = l;
        if(l < 0)
            j = k;
        k = uri.indexOf('@', i);
        return k >= i && k < j;
    }

    private static boolean isColonFollowedByPortNumber(String s, int i)
    {
        int j;
        int k = s.indexOf('/', i + 1);
        j = k;
        if(k < 0)
            j = s.length();
        if(j > i + 1) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        i++;
label0:
        do
        {
label1:
            {
                if(i >= j)
                    break label1;
                if(s.charAt(i) < '0' || s.charAt(i) > '9')
                    break label0;
                i++;
            }
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private static String massageURI(String s)
    {
        int i = s.indexOf(':');
        if(i < 0)
            return "http://" + s;
        if(isColonFollowedByPortNumber(s, i))
            return "http://" + s;
        else
            return s.substring(0, i).toLowerCase() + s.substring(i);
    }

    public String getDisplayResult()
    {
        StringBuffer stringbuffer = new StringBuffer(30);
        maybeAppend(title, stringbuffer);
        maybeAppend(uri, stringbuffer);
        return stringbuffer.toString();
    }

    public String getTitle()
    {
        return title;
    }

    public String getURI()
    {
        return uri;
    }

    public boolean isPossiblyMaliciousURI()
    {
        return containsUser();
    }

    private final String title;
    private final String uri;
}
