// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.xxx.sdk.d.d;
import com.xxx.sdk.f.c;

public final class a
    implements android.view.View.OnClickListener
{

    public a(Context context, c c)
    {
        a = context;
        b = new com.xxx.e.a(c);
    }

    public final void onClick(View view)
    {
        view = d.a();
        if(view != null)
            view.sendEmptyMessage(96);
        b.a(a);
    }

    private Context a;
    private com.xxx.e.a b;
}
