// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.a;


public final class c
{

    public c()
    {
        required = true;
    }

    private int getMajor()
    {
        return major;
    }

    private int getMinor()
    {
        return minor;
    }

    private boolean isRequired()
    {
        return required;
    }

    private void setMajor(int i)
    {
        major = i;
    }

    private void setMinor(int i)
    {
        minor = i;
    }

    private void setRequired(boolean flag)
    {
        required = flag;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(major).append(".").append(minor).toString();
    }

    public int major;
    public int minor;
    public boolean required;
}
