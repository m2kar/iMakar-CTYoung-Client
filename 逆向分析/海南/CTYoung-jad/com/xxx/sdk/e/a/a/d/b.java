// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d;

import java.nio.ByteBuffer;

public class b
{

    public b()
    {
    }

    public b(int i, int j, long l1)
    {
        bu = i;
        headerSize = j;
        m = l1;
    }

    private static int a(ByteBuffer bytebuffer)
    {
        return bytebuffer.getShort() & 0xffff;
    }

    public static long a(ByteBuffer bytebuffer)
    {
        return (long)bytebuffer.getInt() & 0xffffffffL;
    }

    public static String a(ByteBuffer bytebuffer, int i)
    {
        StringBuilder stringbuilder = new StringBuilder(i);
        for(int j = 0; j < i; j++)
            stringbuilder.append(bytebuffer.getChar());

        return stringbuilder.toString();
    }

    public static short a(ByteBuffer bytebuffer)
    {
        return (short)(bytebuffer.get() & 0xff);
    }

    public static void a(ByteBuffer bytebuffer, int i)
    {
        bytebuffer.position(bytebuffer.position() + i);
    }

    public static byte[] a(ByteBuffer bytebuffer, int i)
    {
        byte abyte0[] = new byte[i];
        bytebuffer.get(abyte0);
        return abyte0;
    }

    private long c()
    {
        return m;
    }

    private void d(long l1)
    {
        m = l1;
    }

    private void l(int i)
    {
        bu = i;
    }

    private void m(int i)
    {
        headerSize = i;
    }

    private int p()
    {
        return bu;
    }

    private int q()
    {
        return headerSize;
    }

    public final int o()
    {
        return (int)(m - (long)headerSize);
    }

    public int bu;
    public int headerSize;
    private long m;
}
