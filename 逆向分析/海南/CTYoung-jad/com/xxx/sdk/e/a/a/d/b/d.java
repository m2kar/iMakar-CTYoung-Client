// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.b;

import com.xxx.sdk.e.a.a.d.a.f;
import com.xxx.sdk.e.a.a.d.g;
import java.util.Locale;

public final class d
{

    public d()
    {
    }

    private String a(f f, Locale locale)
    {
        if(data != null)
            return (new StringBuilder("<![CDATA[")).append(data).append("]]>").toString();
        else
            return (new StringBuilder("<![CDATA[")).append(e.a(f, locale)).append("]]>").toString();
    }

    private g e()
    {
        return e;
    }

    private void e(g g1)
    {
        e = g1;
    }

    private String getData()
    {
        return data;
    }

    private String getValue()
    {
        return value;
    }

    private void setData(String s)
    {
        data = s;
    }

    private void setValue(String s)
    {
        value = s;
    }

    public final String toString()
    {
        return (new StringBuilder("XmlCData{data='")).append(data).append('\'').append(", typedData=").append(e).append('}').toString();
    }

    private static String bR = "<![CDATA[";
    private static String bS = "]]>";
    public String data;
    public g e;
    public String value;
}
