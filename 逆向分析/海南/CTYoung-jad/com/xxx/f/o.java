// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.xxx.e.g;
import com.xxx.sdk.d.i;
import com.xxx.sdk.f.d;

public final class o
    implements android.view.View.OnClickListener
{

    public o(Context context, d d)
    {
        a = context;
        b = new g(d);
    }

    public final void onClick(View view)
    {
        view = i.a();
        if(view != null)
            view.sendEmptyMessage(86);
        b.a(a);
    }

    private Context a;
    private g b;
}
