// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.b;

import android.net.Uri;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.f.z;
import com.xxx.sdk.b;
import com.xxx.sdk.e.a;
import com.xxx.sdk.f.d;

public final class c
    implements z
{

    public c()
    {
    }

    public c(g g1, d d1)
    {
        a = g1;
        d = d1;
        super();
    }

    public final boolean a(String s)
    {
        if(g.b(s))
        {
            e.a(b.a().getContext(), Uri.parse(s));
            a.a.T();
            return true;
        } else
        {
            return false;
        }
    }

    public final void k()
    {
        if(!a.d && !e.a(a.a.a))
        {
            d.am();
            a.d = true;
        }
    }

    public final void l()
    {
    }

    public final void m()
    {
    }

    private static String A = "optimizedAdClick";
    private static String B = "optimizedAdShowDuration";
    private static String C = "has_optimized_ad";
    private static String D = "optimized_platform_name";
    private static String E = "optimizedAdImei";
    private static String F = "optimizedAdMac";
    private static String z = "optimizedAdShow";
    public g a;
    public d d;
}
