// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import com.xxx.f.p;

// Referenced classes of package com.xxx.sdk.d:
//            i

final class j
    implements Runnable
{

    j(i k, p p)
    {
        b = k;
        c = p;
        super();
    }

    public final void run()
    {
        i.a(b, c);
    }

    private i b;
    private p c;
}
