// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.b;


public final class f
{

    public f()
    {
    }

    private String getPrefix()
    {
        return prefix;
    }

    private String getUri()
    {
        return uri;
    }

    private void setPrefix(String s)
    {
        prefix = s;
    }

    private void v(String s)
    {
        uri = s;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(prefix).append("=").append(uri).toString();
    }

    public String prefix;
    public String uri;
}
