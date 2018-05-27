// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d;

import com.xxx.sdk.e.a.a.d.a.f;
import com.xxx.sdk.e.a.a.e.c;
import java.util.Locale;

public final class g
{

    public g(int i)
    {
        value = String.valueOf(i);
    }

    public g(long l)
    {
        n = l;
    }

    public g(String s)
    {
        value = s;
    }

    public g(boolean flag)
    {
        value = String.valueOf(flag);
    }

    private long d()
    {
        return n;
    }

    private void e(long l)
    {
        n = l;
    }

    private String getValue()
    {
        return value;
    }

    private void setValue(String s)
    {
        value = s;
    }

    public final String a(f f, Locale locale)
    {
        if(value != null)
        {
            return value;
        } else
        {
            f = c.a(n, f, locale);
            value = f;
            return f;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("ResourceEntity{resourceId=")).append(n).append(", value='").append(value).append('\'').append('}').toString();
    }

    public long n;
    public String value;
}
