// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.xxx.e.g;
import com.xxx.f.A;
import com.xxx.sdk.b.a;
import com.xxx.sdk.e.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.xxx.c:
//            j, k

public final class i
    implements Observer
{

    public i(Context context, ArrayList arraylist)
    {
        index = 0;
        e = true;
        handler = new j(this, Looper.getMainLooper());
        a_android_content_Context_fld = context;
        a_java_util_ArrayList_fld = arraylist;
        if(arraylist == null)
            e = false;
    }

    static void a(i i1)
    {
        try
        {
            i1.handler.removeMessages(120);
            i1.handler.removeMessages(122);
            i1.handler.removeMessages(121);
            g.a(i1.a_android_content_Context_fld).removeView(i1.a_com_xxx_f_A_fld);
            i1.a_com_xxx_f_A_fld.av();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(i i1)
        {
            com.xxx.sdk.e.c.error("\u79FB\u9664browser\u51FA\u9519");
        }
    }

    private Map c()
    {
        if(index > 0)
        {
            HashMap hashmap = new HashMap();
            if(a_java_util_ArrayList_fld.size() > index && ((k)a_java_util_ArrayList_fld.get(index)).a != null)
                hashmap.putAll(((k)a_java_util_ArrayList_fld.get(index)).a);
            hashmap.put("Referer", a_com_xxx_f_A_fld.a.getUrl());
            return hashmap;
        } else
        {
            return ((k)a_java_util_ArrayList_fld.get(index)).a;
        }
    }

    private void close()
    {
        try
        {
            handler.removeMessages(120);
            handler.removeMessages(122);
            handler.removeMessages(121);
            g.a(a_android_content_Context_fld).removeView(a_com_xxx_f_A_fld);
            a_com_xxx_f_A_fld.av();
            return;
        }
        catch(Exception exception)
        {
            com.xxx.sdk.e.c.error("\u79FB\u9664browser\u51FA\u9519");
        }
    }

    private void n()
    {
        if(e)
        {
            handler.sendEmptyMessage(121);
            return;
        } else
        {
            handler.sendEmptyMessage(120);
            return;
        }
    }

    private void o()
    {
        int i1;
        int j1;
        android.view.WindowManager.LayoutParams layoutparams;
        i1 = g.a(a_android_content_Context_fld).widthPixels;
        j1 = g.a(a_android_content_Context_fld).heightPixels;
        layoutparams = new android.view.WindowManager.LayoutParams();
        if(android.os.Build.VERSION.SDK_INT < 19)
            break MISSING_BLOCK_LABEL_112;
        layoutparams.type = 2005;
_L1:
        layoutparams.format = 1;
        layoutparams.gravity = 51;
        layoutparams.width = i1;
        layoutparams.height = j1;
        a_com_xxx_f_A_fld = new A(a_android_content_Context_fld);
        a_com_xxx_f_A_fld.a = this;
        b();
        g.a(a_android_content_Context_fld).addView(a_com_xxx_f_A_fld, layoutparams);
        return;
        try
        {
            layoutparams.type = 2002;
        }
        catch(Exception exception)
        {
            com.xxx.sdk.e.c.error((new StringBuilder("\u6D4F\u89C8\u7A97\u53E3\u521B\u5EFA\u5931\u8D25")).append(exception.getMessage()).toString());
            return;
        }
          goto _L1
    }

    private void p()
    {
        a_com_xxx_f_A_fld.setVisibility(8);
    }

    final boolean b()
    {
        if(a_java_util_ArrayList_fld != null && index < a_java_util_ArrayList_fld.size())
        {
            a_com_xxx_f_A_fld.setVisibility(8);
            k k1 = (k)a_java_util_ArrayList_fld.get(index);
            A a1 = a_com_xxx_f_A_fld;
            HashMap hashmap;
            if(index > 0)
            {
                hashmap = new HashMap();
                if(a_java_util_ArrayList_fld.size() > index && ((k)a_java_util_ArrayList_fld.get(index)).a != null)
                    hashmap.putAll(((k)a_java_util_ArrayList_fld.get(index)).a);
                hashmap.put("Referer", a_com_xxx_f_A_fld.a.getUrl());
            } else
            {
                hashmap = ((k)a_java_util_ArrayList_fld.get(index)).a;
            }
            a1.a(k1, hashmap);
            handler.sendEmptyMessageDelayed(123, 0x1d4c0L);
            return true;
        } else
        {
            return false;
        }
    }

    public final void update(Observable observable, Object obj)
    {
        if(obj != a.FIRST_URL_LOADED) goto _L2; else goto _L1
_L1:
        handler.removeMessages(123);
        if(a_java_util_ArrayList_fld == null || index >= a_java_util_ArrayList_fld.size()) goto _L4; else goto _L3
_L3:
        observable = (k)a_java_util_ArrayList_fld.get(index);
        handler.removeMessages(122);
        handler.sendEmptyMessageDelayed(122, ((k) (observable)).duration * 1000);
_L6:
        return;
_L4:
        handler.removeMessages(120);
        handler.sendEmptyMessageDelayed(120, 2000L);
        return;
_L2:
        if(obj == a.FAILED)
        {
            handler.sendEmptyMessage(120);
            return;
        }
        if(obj == a.BACK_KEY_DOWN)
        {
            handler.sendEmptyMessage(120);
            return;
        }
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static int k = 120;
    private static int l = 121;
    private static int m = 122;
    private static int n = 123;
    private static int o = 0x1d4c0;
    Context a_android_content_Context_fld;
    A a_com_xxx_f_A_fld;
    private ArrayList a_java_util_ArrayList_fld;
    public boolean e;
    public Handler handler;
    int index;
}
