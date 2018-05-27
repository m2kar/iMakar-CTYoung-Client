// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.a;

import com.xxx.sdk.e.a.a.d.h;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.xxx.sdk.e.a.a.d.a:
//            e

public final class f
{

    public f()
    {
        i = new HashMap();
    }

    private e a(short word0)
    {
        return (e)i.get(Short.valueOf(word0));
    }

    private void a(e e1)
    {
        i.put(Short.valueOf(e1.W), e1);
    }

    private h c()
    {
        return a;
    }

    private void c(h h)
    {
        a = h;
    }

    public static Map j = com.xxx.sdk.e.a.a.e.f.h();
    public h a;
    public Map i;

}
