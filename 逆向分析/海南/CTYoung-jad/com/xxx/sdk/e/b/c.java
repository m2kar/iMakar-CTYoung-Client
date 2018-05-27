// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.b;


public final class c extends Exception
{

    c(String s)
    {
        this(s, null);
    }

    c(String s, Throwable throwable)
    {
        super(s);
        initCause(throwable);
    }

    private static final long serialVersionUID = 1L;
}
