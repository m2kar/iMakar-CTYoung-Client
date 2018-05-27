// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c.a;

import com.xxx.sdk.l;
import com.xxx.sdk.w;
import java.util.ArrayList;

public final class c
{

    public c()
    {
        b = new w();
        clearCookies = false;
    }

    private l a()
    {
        return a;
    }

    private void a(l l1)
    {
        a = l1;
    }

    private ArrayList c()
    {
        return d;
    }

    private void d(int i)
    {
        B = i;
    }

    private void e(int i)
    {
        as = i;
    }

    private String getAlias()
    {
        return name;
    }

    private String getPackageName()
    {
        return packageName;
    }

    private int k()
    {
        return B;
    }

    private int l()
    {
        return as;
    }

    private String m()
    {
        return bg;
    }

    private String n()
    {
        return M;
    }

    public final String toString()
    {
        return (new StringBuilder("PlatformMeta{name='")).append(name).append('\'').append(", cid='").append(V).append('\'').append(", configUrl='").append(bf).append('\'').append(", checksum='").append(checksum).append('\'').append(", floatweight=").append(as).append(", bannerWeight=").append(B).append(", packageName='").append(packageName).append('\'').append(", appName='").append(M).append('\'').append(", appKey='").append(bg).append('\'').append(", appTypes=").append(d).append(", optVaConfig=").append(a).append('}').toString();
    }

    private static String bd = "exch";
    private static String be = "adview";
    public int B;
    public String M;
    public String V;
    public l a;
    public int as;
    public w b;
    public String bf;
    public String bg;
    public String checksum;
    public boolean clearCookies;
    public ArrayList d;
    public String name;
    public String packageName;
}
