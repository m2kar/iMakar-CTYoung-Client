// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.a;


public final class j
{

    public j(int i, String s, String s1, long l)
    {
        id = i;
        name = s;
        value = s1;
        updated = l;
    }

    public final String toString()
    {
        return (new StringBuilder("SdkVars [id=")).append(id).append(", name=").append(name).append(", value=").append(value).append(", updated=").append(updated).append("]").toString();
    }

    private static String aX = "name";
    private static String aY = "value";
    private static String aZ = "updated";
    private static String af = "sdk_vars";
    private static String ag = "id";
    public static final String b[] = {
        "id", "name", "value", "updated"
    };
    public final int id;
    private String name;
    public long updated;
    public String value;

}
