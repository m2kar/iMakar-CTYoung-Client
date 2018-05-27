// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.e;

import android.content.Context;
import android.content.IntentFilter;
import com.xxx.sdk.api.c;
import com.xxx.sdk.api.d;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f
{

    public f()
    {
    }

    public static void r(Context context)
    {
        if(!m.getAndSet(true))
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.SCREEN_OFF");
            intentfilter.addAction("android.intent.action.SCREEN_ON");
            intentfilter.addAction("android.intent.action.ACTION_SHUTDOWN");
            intentfilter.addAction("android.intent.action.PHONE_STATE");
            intentfilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentfilter.addAction("android.net.wifi.STATE_CHANGE");
            intentfilter.addAction("android.intent.action.TIME_TICK");
            a_com_xxx_sdk_api_d_static_fld = new d();
            context.registerReceiver(a_com_xxx_sdk_api_d_static_fld, intentfilter);
            intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentfilter.addAction("android.intent.action.PACKAGE_CHANGED");
            intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentfilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
            intentfilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentfilter.addAction("android.intent.action.PACKAGE_RESTARTED");
            intentfilter.addDataScheme("package");
            a_com_xxx_sdk_api_c_static_fld = new c();
            context.registerReceiver(a_com_xxx_sdk_api_c_static_fld, intentfilter);
        }
    }

    private static void s(Context context)
    {
        if(m.getAndSet(false))
        {
            context.unregisterReceiver(a_com_xxx_sdk_api_d_static_fld);
            context.unregisterReceiver(a_com_xxx_sdk_api_c_static_fld);
        }
    }

    private static c a_com_xxx_sdk_api_c_static_fld;
    private static d a_com_xxx_sdk_api_d_static_fld;
    private static AtomicBoolean m = new AtomicBoolean(false);

}
