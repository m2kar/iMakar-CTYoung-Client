// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c.a;

import com.xxx.sdk.a.e;
import com.xxx.sdk.e.b;

public final class d
{

    private d(String s, String s1, String s2)
    {
        bh = null;
        bi = null;
        bj = null;
        bh = s;
        bi = s1;
        bj = s2;
    }

    public d(boolean flag)
    {
        bh = null;
        bi = null;
        bj = null;
        if(!flag)
        {
            bh = e.i();
            bi = e.k();
            bj = e.h();
        }
    }

    private static d a()
    {
        return new d(false);
    }

    public static d a(String s)
    {
        if(!com.xxx.sdk.e.b.f(s))
            if((s = s.split("\\|\\|\\|")) != null && s.length >= 3)
                return new d(s[0], s[1], s[2]);
        return null;
    }

    public static String a(d d1)
    {
        return d1.bh.concat("|||").concat(d1.bi).concat("|||").concat(d1.bj);
    }

    private static d b()
    {
        return new d(true);
    }

    public final String toString()
    {
        return (new StringBuilder("VaClient{mac='")).append(bh).append('\'').append(", ip='").append(bi).append('\'').append(", imei='").append(bj).append('\'').append('}').toString();
    }

    public String bh;
    public String bi;
    public String bj;
}
