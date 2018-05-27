// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e;

import java.nio.ByteBuffer;

public final class a
{

    public a()
    {
    }

    private static int a(ByteBuffer bytebuffer)
    {
        return bytebuffer.getShort() & 0xffff;
    }

    private static long a(ByteBuffer bytebuffer)
    {
        return (long)bytebuffer.getInt() & 0xffffffffL;
    }

    private static String a(ByteBuffer bytebuffer, int i)
    {
        StringBuilder stringbuilder = new StringBuilder(i);
        for(int j = 0; j < i; j++)
            stringbuilder.append(bytebuffer.getChar());

        return stringbuilder.toString();
    }

    private static short a(ByteBuffer bytebuffer)
    {
        return (short)(bytebuffer.get() & 0xff);
    }

    private static void a(ByteBuffer bytebuffer, int i)
    {
        bytebuffer.position(bytebuffer.position() + i);
    }

    private static byte[] a(ByteBuffer bytebuffer, int i)
    {
        byte abyte0[] = new byte[i];
        bytebuffer.get(abyte0);
        return abyte0;
    }
}
