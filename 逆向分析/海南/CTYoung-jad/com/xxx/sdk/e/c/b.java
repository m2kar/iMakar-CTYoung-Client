// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.c;

import java.nio.charset.Charset;

public final class b
{

    public b()
    {
    }

    public static Charset a(String s)
    {
        if(s == null)
            return Charset.defaultCharset();
        else
            return Charset.forName(s);
    }

    public static Charset a(Charset charset)
    {
        Charset charset1 = charset;
        if(charset == null)
            charset1 = Charset.defaultCharset();
        return charset1;
    }

    private static Charset ISO_8859_1;
    private static Charset US_ASCII;
    private static Charset UTF_16;
    private static Charset UTF_16BE;
    private static Charset UTF_16LE;
    private static Charset UTF_8;

    static 
    {
        Charset.forName("ISO-8859-1");
        Charset.forName("US-ASCII");
        Charset.forName("UTF-16");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-8");
    }
}
