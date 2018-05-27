// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import com.xxx.f.b;

// Referenced classes of package com.xxx.sdk.d:
//            d

final class e
    implements Runnable
{

    e(d d1, b b1)
    {
        b = d1;
        d = b1;
        super();
    }

    public final void run()
    {
        com.xxx.sdk.d.d.a(b, d);
    }

    private d b;
    private b d;
}
