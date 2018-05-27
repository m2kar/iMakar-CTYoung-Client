// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.a;

import java.util.Arrays;
import java.util.Locale;

// Referenced classes of package com.xxx.sdk.e.a.a.d.a:
//            c, h, f

public final class d extends c
{

    public d(c c1)
    {
        super.size = c1.size;
        super.flags = c1.flags;
        super.key = c1.key;
    }

    private void a(h ah[])
    {
        a = ah;
    }

    private h[] a()
    {
        return a;
    }

    private long getCount()
    {
        return count;
    }

    private long m()
    {
        return x;
    }

    private void p(long l)
    {
        x = l;
    }

    private void setCount(long l)
    {
        count = l;
    }

    public final String a(f f, Locale locale)
    {
        if(a.length > 0)
            return a[0].toString();
        else
            return null;
    }

    public final String toString()
    {
        return (new StringBuilder("ResourceMapEntry{parent=")).append(x).append(", count=").append(count).append(", resourceTableMaps=").append(Arrays.toString(a)).append('}').toString();
    }

    h a[];
    long count;
    long x;
}
