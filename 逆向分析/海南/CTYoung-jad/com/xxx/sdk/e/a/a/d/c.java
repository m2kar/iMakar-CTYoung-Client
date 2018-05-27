// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.f.z;
import com.xxx.sdk.b.h;
import com.xxx.sdk.b.i;
import com.xxx.sdk.c.a.a.a;
import com.xxx.sdk.e.b;
import com.xxx.sdk.f.d;
import com.xxx.sdk.p;

public class c
    implements z
{

    public c()
    {
    }

    private c(com.xxx.f.b b1)
    {
        super.c = b1;
        super();
    }

    private c(d d1)
    {
        super.d = false;
        super.w = "";
        super.target = d1.target;
        super.x = d1.target.protocol;
        super.j = d1.target.a.ordinal();
        super.b = d1;
        super.a_com_xxx_f_z_fld = new com.xxx.sdk.b.c(this, d1);
    }

    private static void a(Context context, Uri uri)
    {
        e.a(context, uri);
    }

    private static void a(Context context, h h1)
    {
        e.a(context, h1);
    }

    private void a(Context context, String s)
    {
        if(super.a_com_xxx_sdk_e_a_fld == null)
            super.a_com_xxx_sdk_e_a_fld = new com.xxx.sdk.e.a(context, super.a_com_xxx_f_z_fld);
        e.a(super.a_com_xxx_sdk_e_a_fld, context, s, 2);
    }

    private static boolean b(String s)
    {
        if(s == null)
            return false;
        else
            return s.toLowerCase().contains(".apk");
    }

    private void j()
    {
        if(super.b != null)
            super.b.click();
    }

    public void a(Context context)
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
        obj = e.b(super.x);
        if(!com.xxx.sdk.e.b.a(((Object []) (obj))))
        {
            String s = super.w;
            j();
            if(super.j != i.browser.ordinal())
                break MISSING_BLOCK_LABEL_150;
            if(!g.b(super.x))
                break MISSING_BLOCK_LABEL_138;
            super.b.am();
            e.a(context, Uri.parse(super.x));
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
        e.a(context, super.target);
          goto _L1
_L5:
        if(super.j == i.call.ordinal() || super.j == i.message.ordinal() || super.j != i.download.ordinal()) goto _L1; else goto _L6
_L6:
        super.b.am();
        e.a(context, Uri.parse(obj[0]));
          goto _L1
    }

    public boolean a(String s)
    {
        if(com.xxx.f.b.a(super.c) != null && !com.xxx.f.b.a(super.c))
        {
            com.xxx.f.b.a(super.c).click();
            com.xxx.f.b.b(super.c);
        }
        boolean flag;
        if((com.xxx.sdk.b.a().a().C & 1) > 0)
            flag = true;
        else
            flag = false;
        if(flag)
        {
            try
            {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(s));
                intent.setFlags(0x30000000);
                com.xxx.f.b.a(super.c).startActivity(intent);
            }
            // Misplaced declaration of an exception variable
            catch(String s) { }
            s = com.xxx.sdk.d.d.a();
            if(s != null)
                s.sendEmptyMessage(96);
        } else
        {
            com.xxx.f.b.a(super.c);
            if(g.b(s))
            {
                e.a(com.xxx.f.b.a(super.c), Uri.parse(s));
                com.xxx.f.b.a(super.c).am();
                s = com.xxx.sdk.d.d.a();
                if(s != null)
                {
                    s.sendEmptyMessage(96);
                    return true;
                }
            } else
            {
                com.xxx.f.b.a(super.c).loadUrl(s);
                if(com.xxx.f.b.a(super.c) <= 0L)
                    com.xxx.f.b.a(super.c, System.currentTimeMillis());
                if(!super.c.F && super.c.getVisibility() == 0)
                {
                    super.c.handler.removeCallbacks(com.xxx.f.b.a(super.c));
                    com.xxx.f.b.a(super.c).setVisibility(0);
                }
                super.c.update(com.xxx.sdk.b.a.URL_CHANGED);
                return true;
            }
        }
        return true;
    }

    public void k()
    {
        if(e.a(com.xxx.f.b.a(super.c)))
        {
            super.c.update(com.xxx.sdk.b.a.FAILED);
            return;
        }
        if(com.xxx.f.b.a(super.c) != 0) goto _L2; else goto _L1
_L1:
        super.c.update(com.xxx.sdk.b.a.FIRST_URL_LOADED);
_L4:
        com.xxx.f.b.b(super.c);
        return;
_L2:
        if(com.xxx.f.b.a(super.c) == 1)
            com.xxx.f.b.a(super.c).am();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void l()
    {
        super.c.update(com.xxx.sdk.b.a.FAILED);
    }

    public void m()
    {
    }

    private static int NULL = 0;
    private static int aD = 1;
    private static int aE = 2;
    private static int aF = 3;
    private static int aG = 256;
    private static int aH = 256;
    private static int aI = 257;
    private static int aJ = 258;
    private static int aK = 259;
    private static int aL = 260;
    private static int aM = 383;
    private static int aN = 384;
    private static int aO = 512;
    private static int aP = 513;
    private static int aQ = 514;
    private z a_com_xxx_f_z_fld;
    private com.xxx.sdk.e.a a_com_xxx_sdk_e_a_fld;
    private d b;
    private com.xxx.f.b c;
    private boolean d;
    private int j;
    private h target;
    private String w;
    private String x;
}
