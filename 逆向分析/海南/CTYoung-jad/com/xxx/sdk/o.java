// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import java.util.Map;

// Referenced classes of package com.xxx.sdk:
//            m, k

final class o
    implements Runnable
{

    o(m m1, String s, Map map)
    {
        b = m1;
        Q = s;
        d = map;
        super();
    }

    public final void run()
    {
        try
        {
            k k1 = b.a;
            k1 = b.a;
            k.c(k.a(Q, k.b(d)));
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    private String Q;
    private m b;
    private Map d;
}
