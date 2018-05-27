// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.io;


public final class HTTP_Type extends Enum
{

    private HTTP_Type(String s, int i, int j)
    {
        super(s, i);
        type = j;
    }

    public static HTTP_Type valueOf(String s)
    {
        return (HTTP_Type)Enum.valueOf(com/realtech_inc/andproject/chinanet/io/HTTP_Type, s);
    }

    public static HTTP_Type[] values()
    {
        return (HTTP_Type[])$VALUES.clone();
    }

    public int getValue()
    {
        return type;
    }

    private static final HTTP_Type $VALUES[];
    public static final HTTP_Type GET;
    public static final HTTP_Type POST;
    int type;

    static 
    {
        POST = new HTTP_Type("POST", 0, 0);
        GET = new HTTP_Type("GET", 1, 1);
        $VALUES = (new HTTP_Type[] {
            POST, GET
        });
    }
}
