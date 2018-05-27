// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xxx.e.g;
import com.xxx.f.b;
import com.xxx.sdk.api.a;
import com.xxx.sdk.d.f;
import com.xxx.sdk.e.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

// Referenced classes of package com.xxx.c:
//            b, e

public final class d extends com.xxx.c.b
{

    private d(Context context)
    {
        super(context);
        c = true;
        handler = new e(this, Looper.getMainLooper());
        a_android_content_Context_fld = context;
    }

    public static d a(Context context)
    {
        com/xxx/c/d;
        JVM INSTR monitorenter ;
        if(a_com_xxx_c_d_static_fld == null)
            a_com_xxx_c_d_static_fld = new d(context);
        context = a_com_xxx_c_d_static_fld;
        com/xxx/c/d;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    static void a(d d1, b b1)
    {
        if(b1 != null)
        {
            d1.a(b1);
            a.e = System.currentTimeMillis();
        }
    }

    private void a(Map map)
    {
        b_java_util_Map_fld = map;
    }

    private boolean a()
    {
        return c;
    }

    private Map b()
    {
        return b_java_util_Map_fld;
    }

    static void b(d d1, b b1)
    {
        d1.b_com_xxx_f_b_fld = null;
        d1.handler.removeMessages(99);
        d1.handler.removeMessages(98);
        try
        {
            com.xxx.e.g.a(d1.a_android_content_Context_fld).removeView(b1);
            b1.av();
        }
        // Misplaced declaration of an exception variable
        catch(b b1)
        {
            com.xxx.sdk.e.c.error("remove banner view error");
        }
        d1.i();
    }

    private void c(b b1)
    {
        if(b1 != null)
        {
            a(b1);
            a.e = System.currentTimeMillis();
        }
    }

    private void d(b b1)
    {
        b_com_xxx_f_b_fld = null;
        handler.removeMessages(99);
        handler.removeMessages(98);
        try
        {
            com.xxx.e.g.a(a_android_content_Context_fld).removeView(b1);
            b1.av();
        }
        // Misplaced declaration of an exception variable
        catch(b b1)
        {
            com.xxx.sdk.e.c.error("remove banner view error");
        }
        i();
    }

    private void i()
    {
        this;
        JVM INSTR monitorenter ;
        c = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final b a(com.xxx.sdk.f.c c1)
    {
        while(c1 == null || a_android_content_Context_fld == null) 
            return null;
        return new b(a_android_content_Context_fld, c1, com.xxx.e.g.a(a_android_content_Context_fld).heightPixels, com.xxx.e.g.a(a_android_content_Context_fld).widthPixels, this, false, -1, true);
    }

    public final void a(com.xxx.sdk.f.a a1)
    {
        com.xxx.sdk.f.c c1;
        c1 = (com.xxx.sdk.f.c)a1;
        b_com_xxx_sdk_f_c_fld = c1;
        if(c1 != null)
            a1.isOptAd = true;
        b_com_xxx_f_b_fld = a(c1);
        if(b_com_xxx_f_b_fld == null)
        {
            i();
            return;
        }
        try
        {
            b_com_xxx_f_b_fld.setVisibility(8);
            b_com_xxx_f_b_fld.a = this;
            handler.sendEmptyMessage(98);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(com.xxx.sdk.f.a a1)
        {
            com.xxx.sdk.e.c.error("drawAd banner view error");
        }
        i();
        handler.sendEmptyMessageDelayed(99, 1000L);
        return;
    }

    public final void f()
    {
        f f1 = new f(this, a_android_content_Context_fld, "");
        HashMap hashmap = new HashMap();
        hashmap.put("has_optimized_ad", "1");
        hashmap.put("optimized_platform_name", b_java_util_Map_fld.get("optimized_platform_name"));
        if(b_java_util_Map_fld.containsKey("optimizedAdImei"))
            hashmap.put("optimizedAdImei", b_java_util_Map_fld.get("optimizedAdImei"));
        if(b_java_util_Map_fld.containsKey("optimizedAdMac"))
            hashmap.put("optimizedAdMac", b_java_util_Map_fld.get("optimizedAdMac"));
        f1.execute(new Map[] {
            hashmap
        });
        c = false;
    }

    public final void update(Observable observable, Object obj)
    {
        if(obj != null)
            if(obj == com.xxx.sdk.b.a.FAILED)
                handler.sendEmptyMessageDelayed(97, 200L);
            else
            if(obj == com.xxx.sdk.b.a.FIRST_URL_LOADED)
            {
                if(b_com_xxx_sdk_f_c_fld != null)
                    b_com_xxx_sdk_f_c_fld.show();
                int k = (int)(Math.random() * 5D + 5D);
                int j = k;
                if(b_java_util_Map_fld != null)
                {
                    j = k;
                    if(b_java_util_Map_fld.containsKey("optimizedAdShowDuration"))
                    {
                        int l = ((Integer)b_java_util_Map_fld.get("optimizedAdShowDuration")).intValue();
                        j = l;
                        if(l <= 0)
                            j = (int)(Math.random() * 5D) + 5;
                    }
                }
                handler.sendEmptyMessageDelayed(97, j * 1000);
                return;
            }
    }

    private static d a_com_xxx_c_d_static_fld;
    private static int f = 1000;
    private static int g = 99;
    private static int h = 98;
    private static int i = 97;
    private Context a_android_content_Context_fld;
    b b_com_xxx_f_b_fld;
    private com.xxx.sdk.f.c b_com_xxx_sdk_f_c_fld;
    public Map b_java_util_Map_fld;
    private boolean c;
    private Handler handler;
}
