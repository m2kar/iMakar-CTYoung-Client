// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.a;


public final class d
{

    public d(String s, byte abyte0[])
    {
        path = s;
        data = abyte0;
    }

    private byte[] getData()
    {
        return data;
    }

    private String getPath()
    {
        return path;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("Icon{path='")).append(path).append('\'').append(", size=");
        int i;
        if(data == null)
            i = 0;
        else
            i = data.length;
        return stringbuilder.append(i).append('}').toString();
    }

    public final byte data[];
    public final String path;
}
