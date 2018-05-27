// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e.a;

import java.io.Writer;

// Referenced classes of package com.xxx.sdk.e.a.a.e.a:
//            c

final class f extends c
{

    public f()
    {
        this(0, 0x7fffffff, true);
    }

    private f(int i, int j, boolean flag)
    {
        bI = i;
        bJ = j;
        v = flag;
    }

    private static f a(int i)
    {
        return b(i, 0x7fffffff);
    }

    public static f a(int i, int j)
    {
        return new f(i, j, true);
    }

    private static f b(int i)
    {
        return b(0, i);
    }

    private static f b(int i, int j)
    {
        return new f(i, j, false);
    }

    public final boolean a(int i, Writer writer)
    {
        if(v ? i < bI || i > bJ : i >= bI && i <= bJ)
        {
            return false;
        } else
        {
            writer.write("&#");
            writer.write(Integer.toString(i, 10));
            writer.write(59);
            return true;
        }
    }

    private final int bI;
    private final int bJ;
    private final boolean v;
}
