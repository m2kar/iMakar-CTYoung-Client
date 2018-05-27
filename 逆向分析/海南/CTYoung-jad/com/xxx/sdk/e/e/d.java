// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.e;


final class d
{

    d()
    {
        y = false;
        bQ = -1;
    }

    public final String toString()
    {
        return (new StringBuilder("PidStruct{pid=")).append(pid).append(", oomScore='").append(ch).append('\'').append(", oomAdjPath='").append(ci).append('\'').append(", pkgName='").append(cj).append('\'').append(", oomAdjCanRead=").append(y).append(", appType=").append(bQ).append('}').toString();
    }

    private static int bO = 0;
    private static int bP = 1;
    int bQ;
    String ch;
    String ci;
    String cj;
    int pid;
    boolean y;
}
