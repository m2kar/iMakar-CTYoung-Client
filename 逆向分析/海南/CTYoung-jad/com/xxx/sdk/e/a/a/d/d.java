// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d;


// Referenced classes of package com.xxx.sdk.e.a.a.d:
//            g

public final class d
{

    public d()
    {
    }

    private g a()
    {
        return a;
    }

    private short a()
    {
        return I;
    }

    private void a(g g)
    {
        a = g;
    }

    private void a(short word0)
    {
        I = word0;
    }

    private short b()
    {
        return J;
    }

    private void b(short word0)
    {
        J = word0;
    }

    private int getSize()
    {
        return size;
    }

    private void setSize(int i)
    {
        size = i;
    }

    public final String toString()
    {
        return (new StringBuilder("ResValue{size=")).append(size).append(", res0=").append(I).append(", dataType=").append(J).append(", data=").append(a).append('}').toString();
    }

    public short I;
    public short J;
    public g a;
    public int size;
}
