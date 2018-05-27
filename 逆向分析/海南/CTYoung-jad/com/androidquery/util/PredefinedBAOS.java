// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.util;

import java.io.ByteArrayOutputStream;

public class PredefinedBAOS extends ByteArrayOutputStream
{

    public PredefinedBAOS(int i)
    {
        super(i);
    }

    public byte[] toByteArray()
    {
        if(count == buf.length)
            return buf;
        else
            return super.toByteArray();
    }
}
