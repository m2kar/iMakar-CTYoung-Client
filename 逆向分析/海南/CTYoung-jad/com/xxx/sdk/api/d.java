// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.xxx.b.b;
import com.xxx.c.c;
import com.xxx.c.m;
import com.xxx.c.o;
import com.xxx.sdk.d.a;
import com.xxx.sdk.d.g;
import com.xxx.sdk.d.i;
import com.xxx.sdk.p;
import com.xxx.sdk.t;
import com.xxx.sdk.u;

// Referenced classes of package com.xxx.sdk.api:
//            a

public final class d extends BroadcastReceiver
{

    public d()
    {
    }

    public static void D()
    {
        Object obj = i.a();
        if(obj != null)
            ((Handler) (obj)).sendEmptyMessage(84);
        obj = com.xxx.sdk.d.d.a();
        if(obj != null)
        {
            ((Handler) (obj)).removeMessages(94);
            ((Handler) (obj)).sendEmptyMessage(94);
        }
    }

    public static void E()
    {
        F();
        H();
    }

    public static void F()
    {
        i i1 = i.a();
        if(i1 != null)
            i1.sendEmptyMessage(86);
    }

    private static void G()
    {
        a a1 = com.xxx.sdk.d.d.a();
        if(a1 != null)
        {
            a1.removeMessages(94);
            a1.sendEmptyMessage(94);
        }
    }

    public static void H()
    {
        a a1 = com.xxx.sdk.d.d.a();
        if(a1 != null)
            a1.sendEmptyMessage(96);
    }

    public static void c(Context context, Class class1, int i1, int j1)
    {
        class1 = new b(context, class1, i1, j1);
        context = com.xxx.sdk.b.a(context).a();
        if(context != null && ((p) (context)).a_com_xxx_sdk_u_fld != null)
            g.a(class1, ((p) (context)).a_com_xxx_sdk_u_fld.D);
        else
            g.a(class1, 0x36ee80);
        g.a().sendEmptyMessage(80);
    }

    public static void j(Context context)
    {
        switch(((TelephonyManager)context.getSystemService("phone")).getCallState())
        {
        default:
            return;

        case 1: // '\001'
            F();
            break;
        }
        H();
    }

    public static void k(Context context)
    {
        com.xxx.e.b.q(context);
        i.a(context, new m(context));
        i.a().f(88);
        com.xxx.sdk.d.d.a(context, new com.xxx.c.b(context));
        com.xxx.sdk.d.d.a().f(98);
    }

    public static void l(Context context)
    {
        o o1 = new o(context);
        context = com.xxx.sdk.b.a(context).a();
        if(context != null && ((p) (context)).a_com_xxx_sdk_t_fld != null)
            com.xxx.sdk.d.m.a(o1, ((p) (context)).a_com_xxx_sdk_t_fld.D);
        else
            com.xxx.sdk.d.m.a(o1, 0x5265c00);
        com.xxx.sdk.d.m.a().sendEmptyMessage(70);
    }

    private static void m(Context context)
    {
        i.a(context, new m(context));
        i.a().f(88);
    }

    private static void n(Context context)
    {
        com.xxx.sdk.d.d.a(context, new com.xxx.c.b(context));
        com.xxx.sdk.d.d.a().f(98);
    }

    private static void update()
    {
    }

    public final void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        if(!"android.intent.action.SCREEN_ON".equals(s)) goto _L2; else goto _L1
_L1:
        k(context);
        (new c(context)).a("unlock");
        (new com.xxx.sdk.d.p(context)).execute(new Void[0]);
_L4:
        return;
_L2:
        if("android.intent.action.SCREEN_OFF".equals(s))
        {
            D();
            com.xxx.sdk.e.a.a(com.xxx.sdk.api.a.a, true);
            return;
        }
        if("android.intent.action.ACTION_SHUTDOWN".equals(s))
        {
            D();
            com.xxx.sdk.e.a.a(com.xxx.sdk.api.a.a, true);
            return;
        }
        if("android.intent.action.PHONE_STATE".equals(s))
        {
            j(context);
            return;
        }
        if(!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(s))
            break; /* Loop/switch isn't completed */
        context = intent.getStringExtra("reason");
        if(context != null && context.equals("homekey"))
        {
            F();
            H();
            com.xxx.sdk.e.a.a(com.xxx.sdk.api.a.a, true);
            return;
        }
        if(true) goto _L4; else goto _L3
_L3:
        if(!"android.net.wifi.STATE_CHANGE".equals(s))
            continue; /* Loop/switch isn't completed */
        intent = intent.getParcelableExtra("networkInfo");
        if(intent == null) goto _L4; else goto _L5
_L5:
        boolean flag;
        if(((NetworkInfo)intent).getState() == android.net.NetworkInfo.State.CONNECTED)
            flag = true;
        else
            flag = false;
        if(!flag) goto _L4; else goto _L6
_L6:
        (new com.xxx.sdk.d.p(context)).execute(new Void[0]);
        return;
        if(!"android.intent.action.TIME_TICK".equals(s)) goto _L4; else goto _L7
_L7:
        if(com.xxx.sdk.b.a(context).a().j)
        {
            i.a().removeMessages(102);
            i.a().sendEmptyMessageDelayed(102, 3000L);
            return;
        } else
        {
            i.a().removeMessages(102);
            return;
        }
    }

    private static String TAG = "MyReceiver";
    private static String ac = "android.net.conn.CONNECTIVITY_CHANGE";
}
