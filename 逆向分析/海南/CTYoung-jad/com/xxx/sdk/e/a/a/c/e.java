// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.c;


public final class e
{

    public e()
    {
    }

    public e(int i, long l)
    {
        idx = i;
        offset = l;
    }

    private long b()
    {
        return offset;
    }

    private static int c(int i)
    {
        return 0x2000000 | 0xffff & i;
    }

    private void c(long l)
    {
        offset = l;
    }

    private void j(int i)
    {
        idx = i;
    }

    private int n()
    {
        return idx;
    }

    private static int MAX = 0x1000002;
    private static int OTHER = 0x1000004;
    private static int bl = 0x1000000;
    private static int bm = 0x1000001;
    private static int bn = 0x1000003;
    private static int bo = 0x1000005;
    private static int bp = 0x1000006;
    private static int bq = 0x1000007;
    private static int br = 0x1000008;
    private static int bs = 0x1000009;
    public int idx;
    public long offset;
}
