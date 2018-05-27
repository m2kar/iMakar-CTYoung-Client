// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.sdk.b.a;
import com.xxx.sdk.d.i;
import com.xxx.sdk.e.a.a.a.b;
import com.xxx.sdk.f.d;

// Referenced classes of package com.xxx.f:
//            z, p

final class t
    implements z
{

    private t(p p1)
    {
        super.d = p1;
        super();
    }

    public final boolean a(String s)
    {
        com.xxx.f.p.a(super.d);
        if(!g.b(s)) goto _L2; else goto _L1
_L1:
        e.a(com.xxx.f.p.a(super.d), Uri.parse(s));
        com.xxx.f.p.a(super.d).click();
        com.xxx.f.p.a(super.d).am();
        i.a().sendEmptyMessage(86);
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

    public final void k()
    {
        if(e.a(com.xxx.f.p.a(super.d)))
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

    public final void l()
    {
        super.d.update(a.FAILED);
    }

    public final void m()
    {
    }

    private p d;
}
