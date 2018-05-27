// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.b;

import com.xxx.sdk.e.c.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

final class h extends InputStream
{

    public h()
    {
        this(b);
    }

    public h(InputStream inputstream)
    {
        c = inputstream;
    }

    private void ad()
    {
        d.a(c);
    }

    public final int available()
    {
        return c.available();
    }

    public final void close()
    {
    }

    public final boolean equals(Object obj)
    {
        return c.equals(obj);
    }

    public final int hashCode()
    {
        return c.hashCode();
    }

    public final void mark(int i)
    {
        c.mark(i);
    }

    public final boolean markSupported()
    {
        return c.markSupported();
    }

    public final int read()
    {
        return c.read();
    }

    public final int read(byte abyte0[])
    {
        return c.read(abyte0);
    }

    public final int read(byte abyte0[], int i, int j)
    {
        return c.read(abyte0, i, j);
    }

    public final void reset()
    {
        c.reset();
    }

    public final long skip(long l)
    {
        return c.skip(l);
    }

    public final String toString()
    {
        return c.toString();
    }

    private static final InputStream b = new ByteArrayInputStream(new byte[0]);
    final InputStream c;

}
