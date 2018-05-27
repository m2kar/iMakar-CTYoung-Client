// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.view.View;

// Referenced classes of package com.xxx.f:
//            p

final class q
    implements Runnable
{

    q(p p1)
    {
        d = p1;
        super();
    }

    public final void run()
    {
        p.a(d).setVisibility(0);
    }

    private p d;
}
