// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.e;

import android.content.Context;
import android.net.Uri;
import com.xxx.f.z;
import com.xxx.sdk.api.a;
import com.xxx.sdk.f.c;
import java.util.List;

// Referenced classes of package com.xxx.e:
//            g, e, a

public final class b
    implements z
{

    public b()
    {
    }

    public b(com.xxx.e.a a1)
    {
        a = a1;
        super();
    }

    public static boolean i(String s)
    {
        return a.f.contains(s);
    }

    public static void q(Context context)
    {
        a.f.clear();
        a.f = com.xxx.sdk.e.e.a.b(context);
    }

    public final boolean a(String s)
    {
        if(g.b(s))
        {
            com.xxx.e.e.a(com.xxx.sdk.b.a().getContext(), Uri.parse(s));
            a.a.T();
            return true;
        } else
        {
            return false;
        }
    }

    public final void k()
    {
        if(!a.d && !com.xxx.e.e.a(a.a.a))
        {
            a.d = true;
            a.c.am();
        }
    }

    public final void l()
    {
    }

    public final void m()
    {
    }

    public final com.xxx.e.a a;
}
