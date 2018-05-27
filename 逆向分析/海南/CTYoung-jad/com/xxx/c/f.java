// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import com.xxx.e.g;
import com.xxx.f.p;
import com.xxx.f.w;
import com.xxx.sdk.api.a;
import com.xxx.sdk.d.i;
import com.xxx.sdk.d.l;
import com.xxx.sdk.e.c;
import com.xxx.sdk.f.d;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

// Referenced classes of package com.xxx.c:
//            m, g

public final class f extends m
{

    private f(Context context)
    {
        super(context);
        handler = new com.xxx.c.g(this, Looper.getMainLooper());
        a_android_content_Context_fld = context;
    }

    public static f a(Context context)
    {
        com/xxx/c/f;
        JVM INSTR monitorenter ;
        if(b_com_xxx_c_f_static_fld == null)
            b_com_xxx_c_f_static_fld = new f(context);
        context = b_com_xxx_c_f_static_fld;
        com/xxx/c/f;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    static void a(f f1, p p1)
    {
        if(p1 != null)
        {
            f1.c(p1);
            a.e = System.currentTimeMillis();
            return;
        } else
        {
            f1.handler.sendEmptyMessageDelayed(99, 1000L);
            return;
        }
    }

    private void a(p p1)
    {
        if(p1 != null)
        {
            c(p1);
            a.e = System.currentTimeMillis();
            return;
        } else
        {
            handler.sendEmptyMessageDelayed(99, 1000L);
            return;
        }
    }

    private void a(Map map)
    {
        b_java_util_Map_fld = map;
    }

    private void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if(flag)
            break MISSING_BLOCK_LABEL_11;
        b_java_util_Map_fld = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private Map b()
    {
        return b_java_util_Map_fld;
    }

    static void b(f f1, p p1)
    {
        f1.handler.removeMessages(99);
        f1.handler.removeMessages(98);
        try
        {
            com.xxx.e.g.a(f1.a_android_content_Context_fld).removeView(p1);
            p1.av();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(f f1)
        {
            com.xxx.sdk.e.c.error("remove system view error");
        }
    }

    private void b(p p1)
    {
        handler.removeMessages(99);
        handler.removeMessages(98);
        try
        {
            com.xxx.e.g.a(a_android_content_Context_fld).removeView(p1);
            p1.av();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(p p1)
        {
            com.xxx.sdk.e.c.error("remove system view error");
        }
    }

    public final void a(com.xxx.sdk.f.a a1)
    {
        d d1;
        d1 = (d)a1;
        if(d1 != null)
            a1.isOptAd = true;
        a_com_xxx_sdk_f_d_fld = d1;
        a_com_xxx_f_w_fld = new w(a_android_content_Context_fld, new com.xxx.b.a((byte)0));
        a_com_xxx_f_p_fld = a(d1, false, true);
        if(a_com_xxx_f_p_fld == null)
        {
            com.xxx.sdk.d.i.a().sendEmptyMessageDelayed(88, i.f);
            return;
        }
        try
        {
            a_com_xxx_f_p_fld.setVisibility(8);
            a_com_xxx_f_p_fld.a = this;
            com.xxx.sdk.d.i.a().sendEmptyMessage(85);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(com.xxx.sdk.f.a a1)
        {
            com.xxx.sdk.e.c.error("drawAd system view error");
        }
        com.xxx.sdk.d.i.a().sendEmptyMessageDelayed(88, i.f);
        return;
    }

    public final void f()
    {
        l l1 = new l(this, a_android_content_Context_fld, "");
        HashMap hashmap = new HashMap();
        hashmap.put("has_optimized_ad", "1");
        hashmap.put("optimized_platform_name", b_java_util_Map_fld.get("optimized_platform_name"));
        if(b_java_util_Map_fld.containsKey("optimizedAdImei"))
            hashmap.put("optimizedAdImei", b_java_util_Map_fld.get("optimizedAdImei"));
        if(b_java_util_Map_fld.containsKey("optimizedAdMac"))
            hashmap.put("optimizedAdMac", b_java_util_Map_fld.get("optimizedAdMac"));
        l1.execute(new Map[] {
            hashmap
        });
    }

    public final void update(Observable observable, Object obj)
    {
        if(obj != null)
            if(obj == com.xxx.sdk.b.a.FIRST_URL_LOADED)
            {
                if(a_com_xxx_sdk_f_d_fld != null)
                    a_com_xxx_sdk_f_d_fld.show();
                int k = (int)(Math.random() * 5D + 5D);
                int j = k;
                if(b_java_util_Map_fld != null)
                {
                    j = k;
                    if(b_java_util_Map_fld.containsKey("optimizedAdShowDuration"))
                    {
                        int i1 = ((Integer)b_java_util_Map_fld.get("optimizedAdShowDuration")).intValue();
                        j = i1;
                        if(i1 <= 0)
                            j = (int)(Math.random() * 5D) + 5;
                    }
                }
                handler.sendEmptyMessageDelayed(97, j * 1000);
            } else
            if(obj == com.xxx.sdk.b.a.FAILED)
            {
                handler.sendEmptyMessageDelayed(97, 200L);
                return;
            }
    }

    private static f b_com_xxx_c_f_static_fld;
    private static int f = 1000;
    private static int g = 99;
    private static int h = 98;
    private static int i = 97;
    private Context a_android_content_Context_fld;
    p a_com_xxx_f_p_fld;
    private d a_com_xxx_sdk_f_d_fld;
    public Map b_java_util_Map_fld;
    private boolean c;
    private Handler handler;
}
