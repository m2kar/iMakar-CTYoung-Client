// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import com.xxx.sdk.b.a;

// Referenced classes of package com.xxx.f:
//            p

final class u
    implements Runnable
{

    u(p p1)
    {
        d = p1;
        super();
    }

    public final void run()
    {
        d.update(a.REQUEST_CLOSE);
    }

    private p d;
}
