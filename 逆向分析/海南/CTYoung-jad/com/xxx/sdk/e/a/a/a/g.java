// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.a;


public final class g
{

    public g()
    {
        required = true;
    }

    private String getName()
    {
        return name;
    }

    private boolean isRequired()
    {
        return required;
    }

    private void setName(String s)
    {
        name = s;
    }

    private void setRequired(boolean flag)
    {
        required = flag;
    }

    public final String toString()
    {
        return name;
    }

    public String name;
    public boolean required;
}
