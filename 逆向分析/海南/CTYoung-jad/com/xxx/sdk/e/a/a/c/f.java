// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.c;

import com.xxx.sdk.e.a.a.d.b.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xxx.sdk.e.a.a.c:
//            h

final class f
{

    public f()
    {
        q = new ArrayList();
        r = new ArrayList();
    }

    private void b(com.xxx.sdk.e.a.a.d.b.f f1)
    {
        f1 = new h(f1.prefix, f1.uri, (byte)0);
        q.remove(f1);
        r.remove(f1);
    }

    private void b(g g1)
    {
        g1 = new h(g1.prefix, g1.uri, (byte)0);
        q.add(g1);
        r.add(g1);
    }

    private List h()
    {
        if(!r.isEmpty())
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(r);
            r.clear();
            return arraylist;
        } else
        {
            return Collections.emptyList();
        }
    }

    public final String h(String s)
    {
        if(s == null)
            return null;
        for(Iterator iterator = q.iterator(); iterator.hasNext();)
        {
            h h1 = (h)iterator.next();
            if(h1.uri.equals(s))
                return h1.prefix;
        }

        return null;
    }

    List q;
    List r;
}
