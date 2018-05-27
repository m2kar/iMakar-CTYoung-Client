// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.content.Context;
import android.content.Intent;
import com.xxx.f.w;
import com.xxx.f.x;
import com.xxx.sdk.api.a;
import com.xxx.sdk.api.c;
import com.xxx.sdk.api.d;
import com.xxx.sdk.b;
import com.xxx.sdk.d.p;

// Referenced classes of package com.xxx.c:
//            m

public final class n
    implements x
{

    public n()
    {
    }

    n(m m1)
    {
        a = m1;
        super();
    }

    private static void a(Context context, Intent intent)
    {
        com.xxx.sdk.api.c.a(context, intent);
    }

    private static void a(Context context, Class class1, int i, int j)
    {
        com.xxx.sdk.api.d.k(context);
        (new p(context, class1, i, j)).execute(new Void[0]);
    }

    private static void a(Intent intent)
    {
        intent = intent.getStringExtra("reason");
        if(intent != null && intent.equals("homekey"))
        {
            com.xxx.sdk.api.d.E();
            com.xxx.sdk.e.a.a(a.a, true);
        }
    }

    private static void b(Context context)
    {
        com.xxx.sdk.api.d.k(context);
        (new p(context)).execute(new Void[0]);
    }

    private static void b(Context context, Class class1, int i, int j)
    {
        (new p(context, class1, i, j)).execute(new Void[0]);
    }

    private static void c(Context context)
    {
        com.xxx.sdk.api.d.D();
        context = com.xxx.sdk.b.a(context);
        com.xxx.sdk.e.c.info("AdManager\u505C\u6B62...");
        context.u();
    }

    private static void d(Context context)
    {
        com.xxx.sdk.api.d.j(context);
    }

    private static void e(Context context)
    {
        (new p(context)).execute(new Void[0]);
    }

    private static void q()
    {
        com.xxx.sdk.api.d.D();
    }

    public final void onFinish()
    {
        a.a.setVisibility(8);
    }

    private m a;
}
