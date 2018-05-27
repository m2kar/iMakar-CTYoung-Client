// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.content.Context;
import com.xxx.sdk.b.a;

// Referenced classes of package com.xxx.f:
//            K, p

final class s extends K
{

    s(p p1, Context context)
    {
        d = p1;
        super(context);
    }

    protected final void onScrollChanged(int i, int j, int k, int l)
    {
        if(!com.xxx.f.p.a(d))
        {
            d.update(a.STAY);
            p.b(d);
        }
        super.onScrollChanged(i, j, k, l);
    }

    private p d;
}
