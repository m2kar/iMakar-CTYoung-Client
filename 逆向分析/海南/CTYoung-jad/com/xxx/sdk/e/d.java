// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e;

import android.content.Context;
import android.os.*;
import android.widget.Toast;

final class d extends Handler
{

    d(Looper looper, Context context)
    {
        b = context;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        Toast.makeText(b, message.obj.toString(), 1).show();
    }

    private Context b;
}
