// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.b;

import com.xxx.sdk.b;
import com.xxx.sdk.e.e.f;

public abstract class d
{

    private d()
    {
    }

    public static boolean check(int i)
    {
        int k = j();
        return (k & i) == k;
    }

    public static int j()
    {
        f f1 = b.a().a();
        if(f1 != null && !"0".equals(f1.cs) && !"3".equals(f1.cs))
        {
            if("1".equals(f1.cs) || "2".equals(f1.cs))
                return 1;
            if("4".equals(f1.cs))
                return 4;
            if("5".equals(f1.cs) || "6".equals(f1.cs))
                return 2;
        }
        return 0;
    }

    private static int al = 7;
    private static int am = 1;
    private static int an = 2;
    private static int ao = 4;
    private static int ap;
}
