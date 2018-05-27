// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c.a.a;

import android.content.Context;
import android.util.DisplayMetrics;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.sdk.c.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.xxx.sdk.c.a.a:
//            h, f, i, g

public final class c
{

    public c()
    {
        a_com_xxx_sdk_c_a_a_h_fld = new h();
    }

    public static c a(Context context, com.xxx.sdk.c.a.c c1, boolean flag)
    {
        c c2 = new c();
        c2.id = "adview";
        c2.a_com_xxx_sdk_c_a_a_f_fld = new f();
        c2.a_com_xxx_sdk_c_a_a_f_fld.id = c1.bg;
        c2.a_com_xxx_sdk_c_a_a_f_fld.bv = c1.packageName;
        c2.a_com_xxx_sdk_c_a_a_f_fld.name = c1.M;
        c2.a_com_xxx_sdk_c_a_a_f_fld.m = new ArrayList();
        c2.a_com_xxx_sdk_c_a_a_f_fld.m.addAll(c1.d);
        c2.j = new ArrayList();
        c1 = new i();
        c1.a = new com.xxx.sdk.c.a.a.g();
        int l;
        if(flag)
        {
            context = com.xxx.sdk.c.a.a(context);
            ((i) (c1)).a.ax = ((e) (context)).height;
            ((i) (c1)).a.w = ((e) (context)).width;
        } else
        {
            ((i) (c1)).a.ax = g.a(context).heightPixels;
            ((i) (c1)).a.w = g.a(context).widthPixels;
        }
        c1.id = "imID";
        if(flag)
            l = 0;
        else
            l = 1;
        c1.aC = l;
        c2.j.add(c1);
        return c2;
    }

    public final String toString()
    {
        return String.format("{\"id\":\"%s\",\"app\":%s,\"imp\":%s,\"device\":%s}", new Object[] {
            id, a_com_xxx_sdk_c_a_a_f_fld, j, a_com_xxx_sdk_c_a_a_h_fld
        });
    }

    private static List k;
    private f a_com_xxx_sdk_c_a_a_f_fld;
    h a_com_xxx_sdk_c_a_a_h_fld;
    private final String bl;
    private String id;
    private List j;
}
