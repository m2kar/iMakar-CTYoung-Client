// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xxx.e.g;
import com.xxx.f.A;
import com.xxx.sdk.e.c;

// Referenced classes of package com.xxx.c:
//            i

final class j extends Handler
{

    j(i k, Looper looper)
    {
        a = k;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 120 123: default 36
    //                   120 52
    //                   121 62
    //                   122 237
    //                   123 42;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        super.handleMessage(message);
        return;
_L5:
        i.a(a);
        continue; /* Loop/switch isn't completed */
_L2:
        i.a(a);
        continue; /* Loop/switch isn't completed */
_L3:
        i i1 = a;
        int k;
        int l;
        android.view.WindowManager.LayoutParams layoutparams;
        k = g.a(i1.a_android_content_Context_fld).widthPixels;
        l = g.a(i1.a_android_content_Context_fld).heightPixels;
        layoutparams = new android.view.WindowManager.LayoutParams();
        if(android.os.Build.VERSION.SDK_INT < 19) goto _L7; else goto _L6
_L6:
        layoutparams.type = 2005;
_L8:
        Exception exception;
        layoutparams.format = 1;
        layoutparams.gravity = 51;
        layoutparams.width = k;
        layoutparams.height = l;
        i1.a_com_xxx_f_A_fld = new A(i1.a_android_content_Context_fld);
        i1.a_com_xxx_f_A_fld.a = i1;
        i1.b();
        g.a(i1.a_android_content_Context_fld).addView(i1.a_com_xxx_f_A_fld, layoutparams);
        continue; /* Loop/switch isn't completed */
_L7:
        try
        {
            layoutparams.type = 2002;
        }
        // Misplaced declaration of an exception variable
        catch(Exception exception)
        {
            c.error((new StringBuilder("\u6D4F\u89C8\u7A97\u53E3\u521B\u5EFA\u5931\u8D25")).append(exception.getMessage()).toString());
            continue; /* Loop/switch isn't completed */
        }
        if(true) goto _L8; else goto _L4
_L4:
        i j1 = a;
        j1.index = j1.index + 1;
        if(!a.b())
            a.handler.sendEmptyMessage(120);
        if(true) goto _L1; else goto _L9
_L9:
    }

    private i a;
}
