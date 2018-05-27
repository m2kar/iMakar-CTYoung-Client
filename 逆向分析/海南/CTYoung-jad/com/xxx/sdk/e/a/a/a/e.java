// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.a;

import java.util.Locale;

public final class e
{

    public e()
    {
    }

    public static int a(Locale locale, Locale locale1)
    {
        byte byte0 = 0;
        if(locale != null) goto _L2; else goto _L1
_L1:
        byte0 = -1;
_L4:
        return byte0;
_L2:
        if(!locale.getLanguage().equals(locale1.getLanguage()))
            continue; /* Loop/switch isn't completed */
        if(locale.getCountry().equals(locale1.getCountry()))
            return 3;
        if(!locale1.getCountry().isEmpty()) goto _L4; else goto _L3
_L3:
        return 2;
        if(!locale1.getCountry().isEmpty() && !locale1.getLanguage().isEmpty()) goto _L4; else goto _L5
_L5:
        return 1;
    }

    public static final Locale b = new Locale("", "");

}
