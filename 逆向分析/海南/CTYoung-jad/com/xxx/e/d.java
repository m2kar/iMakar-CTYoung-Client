// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.e;

import android.net.Uri;
import com.xxx.f.z;
import com.xxx.sdk.b;
import com.xxx.sdk.e.a;
import com.xxx.sdk.f.c;

// Referenced classes of package com.xxx.e:
//            b, g, e, a

final class d
    implements z
{

    private d(com.xxx.e.a a1)
    {
        super.a = a1;
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
            super.a.d = true;
            super.a.c.am();
        }
    }

    public final void l()
    {
    }

    public final void m()
    {
    }

    private com.xxx.e.a a;
}
