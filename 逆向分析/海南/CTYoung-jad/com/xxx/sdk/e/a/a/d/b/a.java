// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.b;

import com.xxx.sdk.e.a.a.d.a.f;
import com.xxx.sdk.e.a.a.d.g;
import java.util.Locale;

public final class a
{

    public a()
    {
    }

    private String a(f f, Locale locale)
    {
        if(bQ != null)
            return bQ;
        if(d != null)
            return d.a(f, locale);
        else
            return "";
    }

    private g d()
    {
        return d;
    }

    private void d(g g1)
    {
        d = g1;
    }

    private String getName()
    {
        return name;
    }

    private String getNamespace()
    {
        return bP;
    }

    private String getValue()
    {
        return value;
    }

    private void setName(String s)
    {
        name = s;
    }

    private void setNamespace(String s)
    {
        bP = s;
    }

    private void setValue(String s)
    {
        value = s;
    }

    private void u(String s)
    {
        bQ = s;
    }

    private String x()
    {
        return bQ;
    }

    public final String toString()
    {
        return (new StringBuilder("Attribute{name='")).append(name).append('\'').append(", namespace='").append(bP).append('\'').append('}').toString();
    }

    public String bP;
    public String bQ;
    public g d;
    public String name;
    public String value;
}
