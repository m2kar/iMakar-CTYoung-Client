// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xxx.e.a;
import com.xxx.e.g;
import com.xxx.f.o;
import com.xxx.f.p;
import com.xxx.f.w;
import com.xxx.f.y;
import com.xxx.sdk.b;
import com.xxx.sdk.c;
import com.xxx.sdk.d.i;
import com.xxx.sdk.d.l;
import com.xxx.sdk.f.d;
import com.xxx.sdk.s;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.xxx.c:
//            a, n

public class m
    implements com.xxx.c.a, Observer
{

    public m(Context context)
    {
        a_android_content_Context_fld = context;
    }

    private void a(String s1)
    {
        a(s1, false);
    }

    private void h()
    {
        Context context = a_android_content_Context_fld;
        int j = com.xxx.e.a.a(context, "floatingStock");
        if(j == 0x80000000)
            j = 1;
        else
            j++;
        com.xxx.e.a.a(context, "floatingStock", j);
    }

    public final p a(d d1, boolean flag, boolean flag1)
    {
        Object obj;
        obj = null;
        break MISSING_BLOCK_LABEL_3;
        if(d1 != null && a_android_content_Context_fld != null)
        {
            com.xxx.sdk.api.a.a(d1);
            int j = com.xxx.e.g.a(a_android_content_Context_fld).heightPixels;
            j = com.xxx.e.g.a(a_android_content_Context_fld).widthPixels;
            if(d1.imageW > 0 && d1.imageH > 0)
            {
                j = d1.imageH;
                j = d1.imageW;
            }
            obj = a_android_content_Context_fld;
            if(flag1)
                j = -1;
            else
                j = com.xxx.sdk.b.a().a().a.F;
            d1 = new p(((Context) (obj)), d1, this, flag, j, flag1);
            d1.a = this;
            obj = d1;
            if(((p) (d1)).f != null)
            {
                obj = d1;
                if(d1.r())
                {
                    d1.setOnClickListener(new o(((p) (d1)).a, ((p) (d1)).f));
                    return d1;
                }
            }
        }
        return ((p) (obj));
    }

    public void a(com.xxx.sdk.f.a a1)
    {
        d d1;
        d1 = (d)a1;
        c = d1;
        com.xxx.sdk.c.a(a1, com/xxx/sdk/f/d, t, a_boolean_fld);
        if(com.xxx.sdk.api.a.g.get())
            break MISSING_BLOCK_LABEL_57;
        com.xxx.sdk.api.a.A();
        if(d1 == null)
            break MISSING_BLOCK_LABEL_45;
        com.xxx.sdk.f.d.n();
        i.a().a(88, i.f);
        return;
        try
        {
            a_com_xxx_f_w_fld = new w(a_android_content_Context_fld, new n(this));
            b = a(d1, true, false);
            if(b == null)
            {
                com.xxx.sdk.api.a.A();
                i.a().a(88, i.f);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch(com.xxx.sdk.f.a a1)
        {
            com.xxx.sdk.e.c.error("drawAd system view error");
            com.xxx.sdk.api.a.e_java_util_concurrent_atomic_AtomicBoolean_static_fld.set(false);
            com.xxx.sdk.api.a.A();
            i.a().a(88, i.f);
            if(d1 != null)
            {
                com.xxx.sdk.f.d.n();
                return;
            }
            break MISSING_BLOCK_LABEL_171;
        }
        com.xxx.sdk.api.a.e_java_util_concurrent_atomic_AtomicBoolean_static_fld.set(true);
        com.xxx.sdk.api.a.e(b);
        i.a().f(85);
    }

    public final void a(String s1, boolean flag)
    {
        a_boolean_fld = flag;
        t = s1;
        a_com_xxx_sdk_d_l_fld = new l(this, a_android_content_Context_fld, s1);
        a_com_xxx_sdk_d_l_fld.execute(new Map[0]);
    }

    public final void c(p p1)
    {
        int j;
        int k;
        android.view.WindowManager.LayoutParams layoutparams;
        j = com.xxx.e.g.a(a_android_content_Context_fld).widthPixels;
        k = com.xxx.e.g.a(a_android_content_Context_fld).heightPixels;
        layoutparams = new android.view.WindowManager.LayoutParams();
        if(android.os.Build.VERSION.SDK_INT < 19)
            break MISSING_BLOCK_LABEL_125;
        layoutparams.type = 2005;
_L1:
        layoutparams.format = 1;
        layoutparams.gravity = 51;
        layoutparams.width = j;
        layoutparams.height = k;
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams1.addRule(9);
        a_com_xxx_f_w_fld.setLayoutParams(layoutparams1);
        p1.addView(a_com_xxx_f_w_fld);
        com.xxx.e.g.a(a_android_content_Context_fld).addView(p1, layoutparams);
        return;
        try
        {
            layoutparams.type = 2002;
        }
        // Misplaced declaration of an exception variable
        catch(p p1)
        {
            com.xxx.sdk.e.c.error("create system view error");
            p1.printStackTrace();
            return;
        }
          goto _L1
    }

    public final void d(p p1)
    {
        try
        {
            com.xxx.e.g.a(a_android_content_Context_fld).removeView(p1);
            p1.av();
        }
        // Misplaced declaration of an exception variable
        catch(p p1)
        {
            p1.printStackTrace();
            com.xxx.sdk.e.c.error("remove system view error");
        }
        com.xxx.sdk.api.a.A();
        if(com.xxx.sdk.api.a.a() != null)
            com.xxx.sdk.f.d.n();
    }

    public final void g()
    {
        if(a_com_xxx_sdk_d_l_fld != null)
            a_com_xxx_sdk_d_l_fld.cancel(true);
    }

    public void update(Observable observable, Object obj)
    {
        if(obj == null) goto _L2; else goto _L1
_L1:
        if(obj != com.xxx.sdk.b.a.FIRST_URL_LOADED) goto _L4; else goto _L3
_L3:
        if(c != null)
        {
            c.show();
            observable = a_android_content_Context_fld;
            int j = com.xxx.e.a.a(observable, "floatingStock");
            if(j == 0x80000000)
                j = 1;
            else
                j++;
            com.xxx.e.a.a(observable, "floatingStock", j);
        }
        com.xxx.sdk.api.a.e_long_static_fld = System.currentTimeMillis();
        i.a().sendEmptyMessage(89);
        if(a_com_xxx_f_w_fld != null)
        {
            observable = a_com_xxx_f_w_fld;
            if(((w) (observable)).a != null)
                ((w) (observable)).a.start();
        }
_L2:
        return;
_L4:
        if(obj != com.xxx.sdk.b.a.STAY)
            break; /* Loop/switch isn't completed */
        if(a_com_xxx_f_w_fld != null)
        {
            a_com_xxx_f_w_fld.setVisibility(8);
            a_com_xxx_f_w_fld.stop();
            return;
        }
        if(true) goto _L2; else goto _L5
_L5:
        if(obj != com.xxx.sdk.b.a.URL_CHANGED)
            continue; /* Loop/switch isn't completed */
        if(a_com_xxx_f_w_fld == null) goto _L2; else goto _L6
_L6:
        a_com_xxx_f_w_fld.setVisibility(8);
        a_com_xxx_f_w_fld.stop();
        return;
        if(obj != com.xxx.sdk.b.a.REQUEST_CLOSE) goto _L2; else goto _L7
_L7:
        com.xxx.sdk.d.d.a().sendEmptyMessage(97);
        return;
    }

    private static final String TAG = "SystemAdViewController";
    private Context a_android_content_Context_fld;
    w a_com_xxx_f_w_fld;
    private l a_com_xxx_sdk_d_l_fld;
    private boolean a_boolean_fld;
    private p b;
    private d c;
    private String t;
}
