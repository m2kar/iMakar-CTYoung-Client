// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.b;


public final class h
{

    public h()
    {
    }

    private String getName()
    {
        return name;
    }

    private String getNamespace()
    {
        return bP;
    }

    private void setName(String s)
    {
        name = s;
    }

    private void setNamespace(String s)
    {
        bP = s;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("</");
        if(bP != null)
            stringbuilder.append(bP).append(":");
        stringbuilder.append(name).append('>');
        return stringbuilder.toString();
    }

    public String bP;
    public String name;
}
