// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.e;

import android.content.Context;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.xxx.f.z;
import com.xxx.sdk.b.c;
import com.xxx.sdk.b.h;
import com.xxx.sdk.b.i;
import com.xxx.sdk.c.a;
import com.xxx.sdk.e.b;
import com.xxx.sdk.f.d;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.xxx.e:
//            e

public final class g
{

    public g()
    {
    }

    public g(d d1)
    {
        d = false;
        w = "";
        target = d1.target;
        x = d1.target.protocol;
        j = d1.target.a.ordinal();
        b = d1;
        a_com_xxx_f_z_fld = new c(this, d1);
    }

    private static float a(Context context)
    {
        return a(context).density;
    }

    public static DisplayMetrics a(Context context)
    {
        if(a_android_util_DisplayMetrics_static_fld == null)
        {
            a_android_util_DisplayMetrics_static_fld = new DisplayMetrics();
            a(context).getDefaultDisplay().getMetrics(a_android_util_DisplayMetrics_static_fld);
        }
        return a_android_util_DisplayMetrics_static_fld;
    }

    public static WindowManager a(Context context)
    {
        if(a_android_view_WindowManager_static_fld == null)
            a_android_view_WindowManager_static_fld = (WindowManager)context.getSystemService("window");
        return a_android_view_WindowManager_static_fld;
    }

    private static void a(Context context, Uri uri)
    {
        com.xxx.e.e.a(context, uri);
    }

    private static void a(Context context, h h1)
    {
        com.xxx.e.e.a(context, h1);
    }

    public static Map b(Context context)
    {
        char c1 = '\360';
        HashMap hashmap = new HashMap();
        int k = a(context).widthPixels;
        int l = a(context).heightPixels;
        if(k > l)
            k = l;
        if(k <= 240)
        {
            l = 40;
            k = c1;
        } else
        if(k <= 320)
        {
            l = 50;
            k = 320;
        } else
        if(k <= 480)
        {
            l = 80;
            k = 480;
        } else
        if(k <= 720)
        {
            l = 120;
            k = 720;
        } else
        if(k <= 1080)
        {
            l = 180;
            k = 1080;
        } else
        {
            l = Math.round(k / 6);
            k = com.xxx.sdk.c.a.a(k);
        }
        hashmap.put("img_w", String.valueOf(k));
        hashmap.put("img_h", String.valueOf(l));
        return hashmap;
    }

    public static boolean b(String s)
    {
        if(s == null)
            return false;
        else
            return s.toLowerCase().contains(".apk");
    }

    private static Map c(Context context)
    {
        HashMap hashmap = new HashMap();
        int k = a(context).widthPixels;
        int l = a(context).heightPixels;
        hashmap.put("img_w", String.valueOf(k));
        hashmap.put("img_h", String.valueOf(l));
        return hashmap;
    }

    private static int d(Context context)
    {
        return a(context).widthPixels;
    }

    private static int e(Context context)
    {
        return a(context).heightPixels;
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
        if(x == null || "".equals(x)) goto _L1; else goto _L3
_L3:
        Object obj;
        obj = com.xxx.e.e.b(x);
        if(!com.xxx.sdk.e.b.a(((Object []) (obj))))
        {
            String s = w;
            j();
            if(j != i.browser.ordinal())
                break MISSING_BLOCK_LABEL_150;
            if(!b(x))
                break MISSING_BLOCK_LABEL_138;
            b.am();
            com.xxx.e.e.a(context, Uri.parse(x));
        }
          goto _L1
        obj;
        Toast.makeText(context, "\u672A\u77E5\u5F02\u5E38\uFF01", 0).show();
        com.xxx.sdk.e.c.error((new StringBuilder("Ad click error:")).append(x).toString(), ((Throwable) (obj)));
          goto _L1
        context;
        throw context;
        a(context, x);
          goto _L1
        if(j != i.app.ordinal()) goto _L5; else goto _L4
_L4:
        com.xxx.e.e.a(context, target);
          goto _L1
_L5:
        if(j == i.call.ordinal() || j == i.message.ordinal() || j != i.download.ordinal()) goto _L1; else goto _L6
_L6:
        b.am();
        com.xxx.e.e.a(context, Uri.parse(obj[0]));
          goto _L1
    }

    public final void a(Context context, String s)
    {
        if(a_com_xxx_sdk_e_a_fld == null)
            a_com_xxx_sdk_e_a_fld = new com.xxx.sdk.e.a(context, a_com_xxx_f_z_fld);
        com.xxx.e.e.a(a_com_xxx_sdk_e_a_fld, context, s, 2);
    }

    public final void j()
    {
        if(b != null)
            b.click();
    }

    private static DisplayMetrics a_android_util_DisplayMetrics_static_fld;
    private static WindowManager a_android_view_WindowManager_static_fld;
    public z a_com_xxx_f_z_fld;
    public com.xxx.sdk.e.a a_com_xxx_sdk_e_a_fld;
    public d b;
    public boolean d;
    public int j;
    public h target;
    public String w;
    public String x;
}
