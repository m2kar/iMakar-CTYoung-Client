// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c.a.a;

import com.xxx.sdk.b;
import com.xxx.sdk.b.d;
import com.xxx.sdk.e.e.*;

final class h
{

    public h()
    {
        f f1 = b.a().a();
        bi = a.D();
        bw = f1.bj;
        bh = f1.bh;
        bx = f1.cq;
        by = f1.cp;
        bz = f1.bz;
        bA = f1.bA;
        bB = f1.cm;
        aA = f1.b.bx;
        aB = f1.b.by;
        ay = d.j();
        az = 2;
    }

    public final String toString()
    {
        return String.format("{\"w\":%d,\"ip\":\"%s\",\"did\":\"%s\",\"mac\":\"%s\",\"carrier\":\"%s\",\"make\":\"%s\",\"model\":\"%s\",\"os\":\"%s\",\"osv\":\"%s\",\"connectiontype\":%d,\"devicetype\":%d,\"h\":%d}", new Object[] {
            Integer.valueOf(aA), bi, bw, bh, bx, by, bz, bA, bB, Integer.valueOf(ay), 
            Integer.valueOf(az), Integer.valueOf(aB)
        });
    }

    private int aA;
    private int aB;
    private int ay;
    private int az;
    private String bA;
    private String bB;
    String bh;
    String bi;
    private final String bl;
    String bw;
    private String bx;
    private String by;
    private String bz;
}
