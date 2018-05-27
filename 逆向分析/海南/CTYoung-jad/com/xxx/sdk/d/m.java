// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.xxx.c.o;

// Referenced classes of package com.xxx.sdk.d:
//            n

public final class m extends Handler
{

    private m(o o1, int i)
    {
        a_com_xxx_c_o_fld = o1;
        f = i;
    }

    private void S()
    {
        o o1 = a_com_xxx_c_o_fld;
        o1.a_com_xxx_sdk_d_n_fld = new n(o1, o1.a_android_content_Context_fld);
        o1.a_com_xxx_sdk_d_n_fld.execute(new Void[0]);
        sendEmptyMessageDelayed(70, f);
    }

    public static m a()
    {
        return a_com_xxx_sdk_d_m_static_fld;
    }

    public static void a(o o1, int i)
    {
        com/xxx/sdk/d/m;
        JVM INSTR monitorenter ;
        if(a_com_xxx_sdk_d_m_static_fld == null)
            a_com_xxx_sdk_d_m_static_fld = new m(o1, i);
        com/xxx/sdk/d/m;
        JVM INSTR monitorexit ;
        return;
        o1;
        throw o1;
    }

    public static void h(int i)
    {
        f = i;
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 70 70: default 24
    //                   70 30;
           goto _L1 _L2
_L1:
        super.handleMessage(message);
        return;
_L2:
        o o1 = a_com_xxx_c_o_fld;
        o1.a_com_xxx_sdk_d_n_fld = new n(o1, o1.a_android_content_Context_fld);
        o1.a_com_xxx_sdk_d_n_fld.execute(new Void[0]);
        sendEmptyMessageDelayed(70, f);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static m a_com_xxx_sdk_d_m_static_fld = null;
    private static int f = 0;
    private static int h = 70;
    private Context a_android_content_Context_fld;
    private o a_com_xxx_c_o_fld;

    static 
    {
        f = 0x36ee80;
    }
}
