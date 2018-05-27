// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.os.CountDownTimer;

// Referenced classes of package com.xxx.f:
//            w, x

public final class y extends CountDownTimer
{

    public y(w w1, long l)
    {
        c = w1;
        super(l, 1000L);
    }

    public final void onFinish()
    {
        if(c.a != null)
            c.a.onFinish();
    }

    public final void onTick(long l)
    {
        if(l > 0L)
            w.a(c).setText((new StringBuilder(" ")).append(l / 1000L).append(" \u79D2").toString());
        else
        if(c.a != null)
        {
            c.a.onFinish();
            return;
        }
    }

    private w c;
}
