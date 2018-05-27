// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.os.Handler;
import com.xxx.c.k;

// Referenced classes of package com.xxx.f:
//            D, A

final class C
    implements Runnable
{

    C(A a)
    {
        b = a;
        super();
    }

    public final void run()
    {
        new D();
        String s = com.xxx.sdk.k.get(b.a_com_xxx_c_k_fld.y);
        b.cx = s;
        b.a_android_os_Handler_fld.sendEmptyMessage(1);
    }

    private A b;
}
