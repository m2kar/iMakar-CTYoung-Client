// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.b;

import com.xxx.sdk.e.a.a.e.f;
import java.util.Map;

public final class b
{

    public b()
    {
    }

    public static String a(long l)
    {
        String s1 = (String)k.get(Integer.valueOf((int)l));
        String s = s1;
        if(s1 == null)
            s = (new StringBuilder("AttrId:0x")).append(Long.toHexString(l)).toString();
        return s;
    }

    private static final Map k = f.g();

}
