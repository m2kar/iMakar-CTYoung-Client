// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.view.View;
import com.xxx.sdk.api.d;

// Referenced classes of package com.xxx.f:
//            p

final class r
    implements android.view.View.OnClickListener
{

    r(p p1)
    {
        d = p1;
        super();
    }

    public final void onClick(View view)
    {
        p.a(d);
        com.xxx.sdk.api.d.F();
    }

    private p d;
}
