// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.f.b;
import com.xxx.f.z;
import com.xxx.sdk.d.d;
import com.xxx.sdk.f.c;
import com.xxx.sdk.p;

public final class a
    implements z
{

    public a()
    {
    }

    public a(b b1)
    {
        c = b1;
        super();
    }

    public final boolean a(String s)
    {
        if(b.a(c) != null && !b.a(c))
        {
            b.a(c).click();
            b.b(c);
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
                b.a(c).startActivity(intent);
            }
            // Misplaced declaration of an exception variable
            catch(String s) { }
            s = d.a();
            if(s != null)
                s.sendEmptyMessage(96);
        } else
        {
            b.a(c);
            if(g.b(s))
            {
                e.a(b.a(c), Uri.parse(s));
                b.a(c).am();
                s = d.a();
                if(s != null)
                {
                    s.sendEmptyMessage(96);
                    return true;
                }
            } else
            {
                b.a(c).loadUrl(s);
                if(b.a(c) <= 0L)
                    b.a(c, System.currentTimeMillis());
                if(!c.F && c.getVisibility() == 0)
                {
                    c.handler.removeCallbacks(b.a(c));
                    b.a(c).setVisibility(0);
                }
                c.update(com.xxx.sdk.b.a.URL_CHANGED);
                return true;
            }
        }
        return true;
    }

    public final void k()
    {
        if(e.a(b.a(c)))
        {
            c.update(com.xxx.sdk.b.a.FAILED);
            return;
        }
        if(b.a(c) != 0) goto _L2; else goto _L1
_L1:
        c.update(com.xxx.sdk.b.a.FIRST_URL_LOADED);
_L4:
        b.b(c);
        return;
_L2:
        if(b.a(c) == 1)
            b.a(c).am();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final void l()
    {
        c.update(com.xxx.sdk.b.a.FAILED);
    }

    public final void m()
    {
    }

    private static int S = 0;
    private static int T = 1;
    private static int U = 2;
    private static int V = 3;
    private static int W = 4;
    private static int X = 5;
    private static int Y = 6;
    private static int Z = 0;
    private static int aa = 1;
    private static int ab = 2;
    private static int ac = 3;
    private static int ad = 4;
    private static int ae = 5;
    private static int af = 6;
    private static int ag = 1;
    private static int ah = 4;
    public b c;
}
