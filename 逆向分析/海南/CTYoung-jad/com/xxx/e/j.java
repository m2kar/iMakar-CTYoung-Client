// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.e;

import android.net.Uri;
import com.xxx.f.z;
import com.xxx.sdk.b;
import com.xxx.sdk.b.c;
import com.xxx.sdk.e.a;
import com.xxx.sdk.f.d;

// Referenced classes of package com.xxx.e:
//            g, e

final class j
    implements z
{

    private j(g g1, d d1)
    {
        super.a = g1;
        super.d = d1;
        super();
    }

    public final boolean a(String s)
    {
        if(com.xxx.e.g.b(s))
        {
            com.xxx.e.e.a(b.a().getContext(), Uri.parse(s));
            super.a.a.T();
            return true;
        } else
        {
            return false;
        }
    }

    public final void k()
    {
        if(!super.a.d && !com.xxx.e.e.a(super.a.a.a))
        {
            super.d.am();
            super.a.d = true;
        }
    }

    public final void l()
    {
    }

    public final void m()
    {
    }

    private g a;
    private d d;
}
