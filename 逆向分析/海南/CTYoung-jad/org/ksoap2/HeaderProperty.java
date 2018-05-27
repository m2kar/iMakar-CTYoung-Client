// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2;


public class HeaderProperty
{

    public HeaderProperty(String s, String s1)
    {
        key = s;
        value = s1;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    public void setKey(String s)
    {
        key = s;
    }

    public void setValue(String s)
    {
        value = s;
    }

    private String key;
    private String value;
}
