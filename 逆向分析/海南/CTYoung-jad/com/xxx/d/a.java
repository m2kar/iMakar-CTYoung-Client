// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.d;


public final class a
{

    public a()
    {
        G = "";
        H = "";
        I = "";
        startTime = 0L;
        a = 0L;
    }

    private long a()
    {
        return a;
    }

    private String a()
    {
        return G;
    }

    private void a(long l)
    {
        a = l;
    }

    private String b()
    {
        return H;
    }

    private void b(String s)
    {
        G = s;
    }

    private String c()
    {
        return I;
    }

    private void c(String s)
    {
        H = s;
    }

    private void d(String s)
    {
        I = s;
    }

    private long getStartTime()
    {
        return startTime;
    }

    private void setStartTime(long l)
    {
        startTime = l;
    }

    public final String toString()
    {
        return (new StringBuilder("oldAppName:")).append(G).append(" currentAppName:").append(H).append(" startTime:").append(startTime).append(" lastAppName:").append(I).toString();
    }

    public String G;
    public String H;
    public String I;
    public long a;
    public long startTime;
}
