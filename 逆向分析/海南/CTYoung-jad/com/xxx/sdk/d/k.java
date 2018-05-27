// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;


// Referenced classes of package com.xxx.sdk.d:
//            c, i

final class k
    implements Runnable
{

    k(i j)
    {
        b = j;
        super();
    }

    public final void run()
    {
        Integer integer = (new c(i.a(b))).a();
        i.a().removeMessages(102);
        i.a().sendEmptyMessageDelayed(102, integer.intValue());
    }

    private i b;
}
