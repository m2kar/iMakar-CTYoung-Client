// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.content.Context;
import com.xxx.sdk.b;
import com.xxx.sdk.b.h;
import com.xxx.sdk.b.i;
import com.xxx.sdk.d.n;
import com.xxx.sdk.f.a;
import com.xxx.sdk.f.e;
import com.xxx.sdk.p;
import com.xxx.sdk.t;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.xxx.c:
//            a

public final class c
    implements com.xxx.c.a
{

    public c(Context context)
    {
        a_android_content_Context_fld = context;
    }

    private Map a()
    {
        return a_java_util_Map_fld;
    }

    public final void a(a a1)
    {
        if(a1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        if(!(a1 instanceof e) || !((e)a1).inMarket)
            break MISSING_BLOCK_LABEL_75;
        if((s = ((e)a1).marketInstaller) == null) goto _L1; else goto _L3
_L3:
        try
        {
            a1.show();
            a1 = new h();
            a1.protocol = s;
            a1.a = i.app;
            com.xxx.e.e.a(a_android_content_Context_fld, a1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(a a1)
        {
            com.xxx.sdk.e.c.error("open app market error", a1);
        }
        return;
        com.xxx.sdk.e.c.error("this object is not LauncherAd or not in market.");
        return;
    }

    public final void a(String s)
    {
        long l;
        p p1;
        l = System.currentTimeMillis();
        p1 = b.a(a_android_content_Context_fld).a();
        if(!s.equals("unlock")) goto _L2; else goto _L1
_L1:
        long l1;
        long l3;
        l1 = com.xxx.sdk.api.a.g;
        l3 = p1.a.I;
        if(com.xxx.sdk.api.a.g == 0L || l - l1 >= l3) goto _L4; else goto _L3
_L3:
        return;
_L4:
        com.xxx.sdk.api.a.g = l;
_L6:
        a_java_util_Map_fld = com.xxx.sdk.e.e.a(java/util/HashMap).a("at", s).f;
        a_com_xxx_sdk_d_n_fld = new n(this, a_android_content_Context_fld);
        a_com_xxx_sdk_d_n_fld.execute(new Void[0]);
        return;
_L2:
        if(s.equals("home"))
        {
            long l2 = com.xxx.sdk.api.a.h;
            if(com.xxx.sdk.api.a.h != 0L && l - l2 < (long)p1.a.J)
                continue; /* Loop/switch isn't completed */
            com.xxx.sdk.api.a.h = l;
        }
        if(true) goto _L6; else goto _L5
_L5:
        if(true) goto _L3; else goto _L7
_L7:
    }

    private Context a_android_content_Context_fld;
    private n a_com_xxx_sdk_d_n_fld;
    public Map a_java_util_Map_fld;
}
