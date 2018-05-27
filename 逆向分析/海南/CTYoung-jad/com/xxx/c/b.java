// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.sdk.api.a;
import com.xxx.sdk.d.d;
import com.xxx.sdk.d.f;
import com.xxx.sdk.e.c;
import com.xxx.sdk.p;
import com.xxx.sdk.q;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.xxx.c:
//            a

public class b
    implements com.xxx.c.a, Observer
{

    public b(Context context)
    {
        b_boolean_fld = false;
        a_android_content_Context_fld = context;
    }

    private void a(String s)
    {
        com.xxx.sdk.api.a.c(true);
        a(s, false);
    }

    private void h()
    {
        Context context = a_android_content_Context_fld;
        int i = com.xxx.e.a.a(context, "bannerStock");
        if(i == 0x80000000)
            i = 1;
        else
            i++;
        com.xxx.e.a.a(context, "bannerStock", i);
    }

    public com.xxx.f.b a(com.xxx.sdk.f.c c1)
    {
        Object obj;
        obj = null;
        break MISSING_BLOCK_LABEL_2;
        if(c1 != null && a_android_content_Context_fld != null)
        {
            com.xxx.sdk.api.a.a(c1);
            c1 = new com.xxx.f.b(a_android_content_Context_fld, c1, com.xxx.e.g.a(a_android_content_Context_fld).heightPixels, com.xxx.e.g.a(a_android_content_Context_fld).widthPixels, this, true, com.xxx.sdk.b.a().a().a.F, false);
            obj = c1;
            if(((com.xxx.f.b) (c1)).e != null)
            {
                obj = c1;
                if(c1.r())
                {
                    c1.setOnClickListener(new com.xxx.f.a(((com.xxx.f.b) (c1)).a, ((com.xxx.f.b) (c1)).e));
                    return c1;
                }
            }
        }
        return ((com.xxx.f.b) (obj));
    }

    public final void a(com.xxx.f.b b1)
    {
        int i;
        a_com_xxx_f_b_fld = b1;
        i = com.xxx.sdk.c.a.a(a_android_content_Context_fld).height;
        a_android_view_WindowManager_LayoutParams_fld = new android.view.WindowManager.LayoutParams();
        if(android.os.Build.VERSION.SDK_INT < 19)
            break MISSING_BLOCK_LABEL_182;
        a_android_view_WindowManager_LayoutParams_fld.type = 2005;
_L1:
        a_android_view_WindowManager_LayoutParams_fld.format = 1;
        a_android_view_WindowManager_LayoutParams_fld.flags = 8;
        a_android_view_WindowManager_LayoutParams_fld.flags = a_android_view_WindowManager_LayoutParams_fld.flags | 0x400;
        a_android_view_WindowManager_LayoutParams_fld.flags = a_android_view_WindowManager_LayoutParams_fld.flags | 0x40000;
        a_android_view_WindowManager_LayoutParams_fld.flags = a_android_view_WindowManager_LayoutParams_fld.flags | 0x200;
        a_android_view_WindowManager_LayoutParams_fld.alpha = 1.0F;
        a_android_view_WindowManager_LayoutParams_fld.x = 0;
        a_android_view_WindowManager_LayoutParams_fld.y = 0;
        a_android_view_WindowManager_LayoutParams_fld.gravity = 48;
        a_android_view_WindowManager_LayoutParams_fld.width = -1;
        a_android_view_WindowManager_LayoutParams_fld.height = i;
        com.xxx.e.g.a(a_android_content_Context_fld).addView(b1, a_android_view_WindowManager_LayoutParams_fld);
        return;
        try
        {
            a_android_view_WindowManager_LayoutParams_fld.type = 2003;
        }
        // Misplaced declaration of an exception variable
        catch(com.xxx.f.b b1)
        {
            c.error("create banner view error");
            return;
        }
          goto _L1
    }

    public void a(com.xxx.sdk.f.a a1)
    {
        com.xxx.sdk.f.c c1;
        c1 = (com.xxx.sdk.f.c)a1;
        com.xxx.sdk.c.a(a1, com/xxx/sdk/f/c, t, a_boolean_fld);
        a_com_xxx_sdk_f_c_fld = c1;
        if(a.f.get())
            break MISSING_BLOCK_LABEL_57;
        com.xxx.sdk.api.a.B();
        if(c1 == null)
            break MISSING_BLOCK_LABEL_45;
        com.xxx.sdk.f.c.n();
        d.a().a(98, d.f);
        return;
        try
        {
            b_com_xxx_f_b_fld = a(c1);
            if(b_com_xxx_f_b_fld == null)
            {
                com.xxx.sdk.api.a.B();
                d.a().a(98, d.f);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch(com.xxx.sdk.f.a a1)
        {
            c.error("drawAd banner view error");
            a.j.set(false);
            com.xxx.sdk.api.a.B();
            d.a().a(98, d.f);
            if(c1 != null)
            {
                com.xxx.sdk.f.c.n();
                return;
            }
            break MISSING_BLOCK_LABEL_155;
        }
        a.j.set(true);
        b_com_xxx_f_b_fld.a = this;
        com.xxx.sdk.api.a.e(b_com_xxx_f_b_fld);
        d.a().sendEmptyMessage(95);
    }

    public final void a(String s, boolean flag)
    {
        a_boolean_fld = flag;
        t = s;
        a_com_xxx_sdk_d_f_fld = new f(this, a_android_content_Context_fld, s);
        a_com_xxx_sdk_d_f_fld.execute(new Map[0]);
    }

    public final void b(com.xxx.f.b b1)
    {
        try
        {
            a_com_xxx_f_b_fld = null;
            a_android_view_WindowManager_LayoutParams_fld = null;
            b_boolean_fld = false;
            com.xxx.e.g.a(a_android_content_Context_fld).removeView(b1);
            b1.av();
        }
        // Misplaced declaration of an exception variable
        catch(com.xxx.f.b b1)
        {
            b1.printStackTrace();
            c.error("remove banner view error");
        }
        com.xxx.sdk.api.a.B();
        if(com.xxx.sdk.api.a.a() != null)
            com.xxx.sdk.f.c.n();
    }

    public final void g()
    {
        if(a_com_xxx_sdk_d_f_fld != null)
            a_com_xxx_sdk_d_f_fld.cancel(true);
    }

    public void update(Observable observable, Object obj)
    {
        int i = 1;
        if(obj != null && a_com_xxx_sdk_f_c_fld != null)
            if(obj == com.xxx.sdk.b.a.FIRST_URL_LOADED)
            {
                a_com_xxx_sdk_f_c_fld.show();
                observable = a_android_content_Context_fld;
                int j = com.xxx.e.a.a(observable, "bannerStock");
                if(j != 0x80000000)
                    i = j + 1;
                com.xxx.e.a.a(observable, "bannerStock", i);
            } else
            {
                if(obj == com.xxx.sdk.b.a.REQUEST_CLOSE)
                {
                    d.a().sendEmptyMessage(97);
                    return;
                }
                if(obj == com.xxx.sdk.b.a.URL_CHANGED && !b_boolean_fld && a_android_view_WindowManager_LayoutParams_fld != null && a_com_xxx_f_b_fld != null)
                {
                    b_boolean_fld = true;
                    a_android_view_WindowManager_LayoutParams_fld.height = com.xxx.e.g.a(a_android_content_Context_fld).heightPixels;
                    observable = a_com_xxx_f_b_fld;
                    com.xxx.e.g.a(a_android_content_Context_fld).updateViewLayout(a_com_xxx_f_b_fld, a_android_view_WindowManager_LayoutParams_fld);
                    return;
                }
            }
    }

    private Context a_android_content_Context_fld;
    private android.view.WindowManager.LayoutParams a_android_view_WindowManager_LayoutParams_fld;
    private com.xxx.f.b a_com_xxx_f_b_fld;
    private f a_com_xxx_sdk_d_f_fld;
    private com.xxx.sdk.f.c a_com_xxx_sdk_f_c_fld;
    private boolean a_boolean_fld;
    private com.xxx.f.b b_com_xxx_f_b_fld;
    private boolean b_boolean_fld;
    private String t;
}
