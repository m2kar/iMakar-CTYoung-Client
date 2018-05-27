// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.flowerwindow;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.f.z;
import com.xxx.sdk.b;
import com.xxx.sdk.b.c;
import com.xxx.sdk.b.h;
import com.xxx.sdk.b.i;
import com.xxx.sdk.d.p;
import com.xxx.sdk.f.d;

public final class a
{

    public a()
    {
    }

    private a(d d1)
    {
        super.d = false;
        super.w = "";
        super.target = d1.target;
        super.x = d1.target.protocol;
        super.j = d1.target.a.ordinal();
        super.b = d1;
        super.a_com_xxx_f_z_fld = new c(this, d1);
    }

    private static void a(Context context, Intent intent)
    {
        com.xxx.sdk.api.c.a(context, intent);
    }

    private static void a(Context context, Uri uri)
    {
        com.xxx.e.e.a(context, uri);
    }

    private static void a(Context context, h h1)
    {
        com.xxx.e.e.a(context, h1);
    }

    private static void a(Context context, Class class1, int k, int l)
    {
        com.xxx.sdk.api.d.k(context);
        (new p(context, class1, k, l)).execute(new Void[0]);
    }

    private void a(Context context, String s)
    {
        if(super.a_com_xxx_sdk_e_a_fld == null)
            super.a_com_xxx_sdk_e_a_fld = new com.xxx.sdk.e.a(context, super.a_com_xxx_f_z_fld);
        com.xxx.e.e.a(super.a_com_xxx_sdk_e_a_fld, context, s, 2);
    }

    private static void a(Intent intent)
    {
        intent = intent.getStringExtra("reason");
        if(intent != null && intent.equals("homekey"))
        {
            com.xxx.sdk.api.d.E();
            com.xxx.sdk.e.a.a(com.xxx.sdk.api.a.a, true);
        }
    }

    private static void b(Context context)
    {
        com.xxx.sdk.api.d.k(context);
        (new p(context)).execute(new Void[0]);
    }

    private static void b(Context context, Class class1, int k, int l)
    {
        (new p(context, class1, k, l)).execute(new Void[0]);
    }

    private static boolean b(String s)
    {
        if(s == null)
            return false;
        else
            return s.toLowerCase().contains(".apk");
    }

    private static void c(Context context)
    {
        com.xxx.sdk.api.d.D();
        context = com.xxx.sdk.b.a(context);
        com.xxx.sdk.e.c.info("AdManager\u505C\u6B62...");
        context.u();
    }

    private static void d(Context context)
    {
        com.xxx.sdk.api.d.j(context);
    }

    private static void e(Context context)
    {
        (new p(context)).execute(new Void[0]);
    }

    private void j()
    {
        if(super.b != null)
            super.b.click();
    }

    private static void q()
    {
        com.xxx.sdk.api.d.D();
    }

    public final void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if(context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(super.x == null || "".equals(super.x)) goto _L1; else goto _L3
_L3:
        Object obj;
        obj = com.xxx.e.e.b(super.x);
        if(!com.xxx.sdk.e.b.a(((Object []) (obj))))
        {
            String s = super.w;
            j();
            if(super.j != i.browser.ordinal())
                break MISSING_BLOCK_LABEL_150;
            if(!g.b(super.x))
                break MISSING_BLOCK_LABEL_138;
            super.b.am();
            com.xxx.e.e.a(context, Uri.parse(super.x));
        }
          goto _L1
        obj;
        Toast.makeText(context, "\u672A\u77E5\u5F02\u5E38\uFF01", 0).show();
        com.xxx.sdk.e.c.error((new StringBuilder("Ad click error:")).append(super.x).toString(), ((Throwable) (obj)));
          goto _L1
        context;
        throw context;
        a(context, super.x);
          goto _L1
        if(super.j != i.app.ordinal()) goto _L5; else goto _L4
_L4:
        com.xxx.e.e.a(context, super.target);
          goto _L1
_L5:
        if(super.j == i.call.ordinal() || super.j == i.message.ordinal() || super.j != i.download.ordinal()) goto _L1; else goto _L6
_L6:
        super.b.am();
        com.xxx.e.e.a(context, Uri.parse(obj[0]));
          goto _L1
    }

    private z a_com_xxx_f_z_fld;
    private com.xxx.sdk.e.a a_com_xxx_sdk_e_a_fld;
    private d b;
    private boolean d;
    private int j;
    private h target;
    private String w;
    private String x;
}
