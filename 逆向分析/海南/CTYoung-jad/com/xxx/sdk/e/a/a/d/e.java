// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d;

import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import com.xxx.e.g;
import com.xxx.f.p;
import com.xxx.f.z;
import com.xxx.sdk.b.a;
import com.xxx.sdk.d.i;
import com.xxx.sdk.e.a.a.a.b;
import com.xxx.sdk.f.d;

public class e
    implements z
{

    public e()
    {
    }

    private e(p p1)
    {
        super.d = p1;
        super();
    }

    public boolean a(String s)
    {
        com.xxx.f.p.a(super.d);
        if(!com.xxx.e.g.b(s)) goto _L2; else goto _L1
_L1:
        com.xxx.e.e.a(com.xxx.f.p.a(super.d), Uri.parse(s));
        com.xxx.f.p.a(super.d).click();
        com.xxx.f.p.a(super.d).am();
        com.xxx.sdk.d.i.a().sendEmptyMessage(86);
_L4:
        super.d.update(a.URL_CHANGED);
        return true;
_L2:
        com.xxx.f.p.a(super.d).click();
        com.xxx.f.p.a(super.d).loadUrl(s);
        if(com.xxx.f.p.a(super.d) <= 0L)
            com.xxx.f.p.a(super.d, System.currentTimeMillis());
        if(!super.d.F && super.d.getVisibility() == 0)
        {
            super.d.handler.removeCallbacks(com.xxx.f.p.a(super.d));
            com.xxx.f.p.a(super.d).setVisibility(0);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void k()
    {
        if(com.xxx.e.e.a(com.xxx.f.p.a(super.d)))
        {
            super.d.update(a.FAILED);
            return;
        }
        if(super.d.bY != 0) goto _L2; else goto _L1
_L1:
        super.d.update(a.FIRST_URL_LOADED);
_L4:
        p p1 = super.d;
        p1.bY = p1.bY + 1;
        return;
_L2:
        if(super.d.bY == 1)
            com.xxx.f.p.a(super.d).am();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void l()
    {
        super.d.update(a.FAILED);
    }

    public void m()
    {
    }

    private static short a = 0;
    private static short b = 15;
    private static int be = 0xffffff;
    private static short c = 0;
    private static short d_short_static_fld = 1;
    private static short e = 2;
    private static short f = 3;
    private static short g = 4;
    private static short h = 5;
    private static short i = 0;
    private static short j = 1;
    private static short k = 4;
    private static short l = 3;
    private static short m = 0;
    private static short n = 1;
    private static short o = 2;
    private static short p = 3;
    private static short q = 8;
    private p d_com_xxx_f_p_fld;
}
