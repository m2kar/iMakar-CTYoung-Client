// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import com.xxx.sdk.e.b;
import java.util.Map;
import java.util.concurrent.*;

// Referenced classes of package com.xxx.sdk:
//            n, o, k

public final class m
{

    private m()
    {
        a_java_util_concurrent_ExecutorService_fld = new ThreadPoolExecutor(2, 4, 30L, TimeUnit.NANOSECONDS, new LinkedBlockingQueue());
        a_com_xxx_sdk_k_fld = new n();
    }

    public static m a()
    {
        if(a_com_xxx_sdk_m_static_fld == null)
            a_com_xxx_sdk_m_static_fld = new m();
        return a_com_xxx_sdk_m_static_fld;
    }

    public final void a(String s, Map map)
    {
        if(b.f(s))
        {
            return;
        } else
        {
            s = new o(this, s, map);
            a_java_util_concurrent_ExecutorService_fld.execute(s);
            return;
        }
    }

    public final void execute(Runnable runnable)
    {
        a_java_util_concurrent_ExecutorService_fld.execute(runnable);
    }

    private static m a_com_xxx_sdk_m_static_fld;
    k a_com_xxx_sdk_k_fld;
    private ExecutorService a_java_util_concurrent_ExecutorService_fld;
}
