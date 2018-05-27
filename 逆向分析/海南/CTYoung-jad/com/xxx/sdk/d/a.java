// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.os.Handler;

public class a extends Handler
{

    public a()
    {
    }

    public final void a(int i, int j)
    {
        if(!hasMessages(i))
            sendEmptyMessageDelayed(i, j);
    }

    public final void f(int i)
    {
        if(hasMessages(i))
            removeMessages(i);
        sendEmptyMessage(i);
    }
}
