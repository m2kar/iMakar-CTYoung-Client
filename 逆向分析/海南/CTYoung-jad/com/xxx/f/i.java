// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;


// Referenced classes of package com.xxx.f:
//            H

final class I
    implements Runnable
{

    I(H h)
    {
        c = h;
        super();
    }

    public final void run()
    {
        c.dismiss();
    }

    private H c;
}
