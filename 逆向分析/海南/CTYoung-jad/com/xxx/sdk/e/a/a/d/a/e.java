// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.a;

import com.xxx.sdk.e.a.a.d.h;
import java.util.*;

// Referenced classes of package com.xxx.sdk.e.a.a.d.a:
//            a, m, k

public final class e
{

    private e()
    {
    }

    public e(a a1)
    {
        g = new HashMap();
        h = new HashMap();
        name = a1.name;
        W = (short)(int)a1.id;
    }

    private m a(Short short1)
    {
        return (m)g.get(short1);
    }

    private h a()
    {
        return b;
    }

    private List a(Short short1)
    {
        return (List)h.get(short1);
    }

    private void a(k k1)
    {
        List list = (List)h.get(Short.valueOf(k1.W));
        Object obj = list;
        if(list == null)
        {
            obj = new ArrayList();
            h.put(Short.valueOf(k1.W), obj);
        }
        ((List) (obj)).add(k1);
    }

    private void a(m m1)
    {
        g.put(Short.valueOf(m1.W), m1);
    }

    private void a(h h1)
    {
        b = h1;
    }

    private h b()
    {
        return c;
    }

    private void b(h h1)
    {
        c = h1;
    }

    private void b(Map map)
    {
        g = map;
    }

    private void c(Map map)
    {
        h = map;
    }

    private Map e()
    {
        return g;
    }

    private Map f()
    {
        return h;
    }

    private String getName()
    {
        return name;
    }

    private short o()
    {
        return W;
    }

    private void o(short word0)
    {
        W = word0;
    }

    private void setName(String s)
    {
        name = s;
    }

    private static String HTTP_GET = "GET";
    private static String HTTP_POST = "POST";
    private static String TAG = "PixmobHttpClient";
    private static String bM = "HEAD";
    private static String bN = "PUT";
    private static String bO = "DELETE";
    public short W;
    public h b;
    public h c;
    public Map g;
    public Map h;
    private String name;
}
