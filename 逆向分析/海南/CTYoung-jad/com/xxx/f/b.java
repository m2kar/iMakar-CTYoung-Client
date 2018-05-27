// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.os.*;
import android.webkit.WebView;
import com.xxx.c.k;

// Referenced classes of package com.xxx.f:
//            A

final class B extends Handler
{

    B(A a, Looper looper)
    {
        b = a;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 29
    //                   1 94;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if((message = b.cx) != null)
            if(b.I)
            {
                b.a_android_webkit_WebView_fld.loadUrl((new StringBuilder("javascript:")).append(message).toString());
                return;
            } else
            {
                b.a_android_os_Handler_fld.sendEmptyMessageDelayed(0, 100L);
                return;
            }
          goto _L1
_L3:
        if(b.o != null)
        {
            b.a_android_webkit_WebView_fld.loadUrl(b.a_com_xxx_c_k_fld.url, b.o);
            return;
        } else
        {
            b.a_android_webkit_WebView_fld.loadUrl(b.a_com_xxx_c_k_fld.url);
            return;
        }
    }

    private A b;
}
