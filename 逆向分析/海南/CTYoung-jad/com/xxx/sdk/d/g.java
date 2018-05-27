// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.os.Handler;
import android.os.Message;
import com.xxx.b.b;

// Referenced classes of package com.xxx.sdk.d:
//            h

public final class g extends Handler
{

    private g(b b1, int i)
    {
        a_com_xxx_b_b_fld = b1;
        f = i;
    }

    public static g a()
    {
        return a_com_xxx_sdk_d_g_static_fld;
    }

    public static void a(b b1, int i)
    {
        com/xxx/sdk/d/g;
        JVM INSTR monitorenter ;
        if(a_com_xxx_sdk_d_g_static_fld == null)
            a_com_xxx_sdk_d_g_static_fld = new g(b1, i);
        com/xxx/sdk/d/g;
        JVM INSTR monitorexit ;
        return;
        b1;
        throw b1;
    }

    public static void h(int i)
    {
        f = i;
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 80 80: default 24
    //                   80 30;
           goto _L1 _L2
_L1:
        super.handleMessage(message);
        return;
_L2:
        b b1 = a_com_xxx_b_b_fld;
        b1.a_com_xxx_sdk_d_h_fld = new h(b1, b1.a_android_content_Context_fld);
        b1.a_com_xxx_sdk_d_h_fld.execute(new Void[0]);
        sendEmptyMessageDelayed(80, f);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static g a_com_xxx_sdk_d_g_static_fld = null;
    private static int f = 0;
    private static int h = 80;
    private b a_com_xxx_b_b_fld;

    static 
    {
        f = 0x36ee80;
    }
}
