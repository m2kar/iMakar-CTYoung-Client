// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.a;


// Referenced classes of package com.xxx.sdk.e.a.a.d.a:
//            n

public final class m
{

    public m(n n1)
    {
        W = n1.W;
    }

    private boolean a(int i)
    {
        return i < b.length;
    }

    private void b(long al[])
    {
        b = al;
    }

    private long[] b()
    {
        return b;
    }

    private String getName()
    {
        return name;
    }

    private short o()
    {
        return W;
    }

    private void o(short word0)
    {
        W = word0;
    }

    private void setName(String s)
    {
        name = s;
    }

    public final String toString()
    {
        return (new StringBuilder("TypeSpec{name='")).append(name).append('\'').append(", id=").append(W).append('}').toString();
    }

    public short W;
    public long b[];
    public String name;
}
