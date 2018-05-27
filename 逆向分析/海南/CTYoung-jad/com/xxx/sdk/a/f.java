// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.a;


// Referenced classes of package com.xxx.sdk.a:
//            e

public final class f
{

    public f(int i, String s, String s1)
    {
        id = i;
        az = s;
        value = s1;
    }

    private void f(String s)
    {
        az = s;
    }

    private int getId()
    {
        return id;
    }

    private String getValue()
    {
        return value;
    }

    private String l()
    {
        return az;
    }

    private void setId(int i)
    {
        id = i;
    }

    private void setValue(String s)
    {
        value = s;
    }

    public final String toString()
    {
        return (new StringBuilder("OptimizeCmd{id=")).append(id).append(", cmd='").append(az).append('\'').append(", value='").append(value).append('\'').append('}').toString();
    }

    private static String ar = "ad";
    private static String as = "fetchOptAd";
    private static String at = "url";
    private static String au = "sdk_optimize";
    private static String av = "id";
    private static String aw = "cmd";
    private static String ax = "value";
    private static String ay = "executeTime";
    private e a;
    public String az;
    public int id;
    public String value;
}
