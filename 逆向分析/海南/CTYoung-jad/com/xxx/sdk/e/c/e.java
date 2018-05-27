// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.c;

import java.io.Serializable;
import java.io.Writer;

public final class e extends Writer
    implements Serializable
{

    public e()
    {
        builder = new StringBuilder();
    }

    public e(byte byte0)
    {
        builder = new StringBuilder(4);
    }

    private e(StringBuilder stringbuilder)
    {
        if(stringbuilder == null)
            stringbuilder = new StringBuilder();
        builder = stringbuilder;
    }

    private StringBuilder a()
    {
        return builder;
    }

    public final Writer append(char c)
    {
        builder.append(c);
        return this;
    }

    public final Writer append(CharSequence charsequence)
    {
        builder.append(charsequence);
        return this;
    }

    public final Writer append(CharSequence charsequence, int i, int j)
    {
        builder.append(charsequence, i, j);
        return this;
    }

    public final volatile Appendable append(char c)
    {
        return append(c);
    }

    public final volatile Appendable append(CharSequence charsequence)
    {
        return append(charsequence);
    }

    public final volatile Appendable append(CharSequence charsequence, int i, int j)
    {
        return append(charsequence, i, j);
    }

    public final void close()
    {
    }

    public final void flush()
    {
    }

    public final String toString()
    {
        return builder.toString();
    }

    public final void write(String s)
    {
        if(s != null)
            builder.append(s);
    }

    public final void write(char ac[], int i, int j)
    {
        if(ac != null)
            builder.append(ac, i, j);
    }

    private final StringBuilder builder;
}
