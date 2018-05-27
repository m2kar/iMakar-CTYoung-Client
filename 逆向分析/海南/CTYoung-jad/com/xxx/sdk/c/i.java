// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c;

import com.xxx.sdk.a.j;
import com.xxx.sdk.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.e.e.e;
import com.xxx.sdk.e.e.f;
import com.xxx.sdk.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.xxx.sdk.c:
//            g

public final class i
    implements Runnable
{

    public i(g g1, long l1)
    {
        b = g1;
        l = l1;
        super();
    }

    public final void run()
    {
        Object obj;
        JSONObject jsonobject;
        Object obj1;
        Object obj2;
        obj = b.a_com_xxx_sdk_b_fld.a();
        try
        {
            jsonobject = new JSONObject();
            obj1 = b.a_com_xxx_sdk_b_fld.a();
            obj2 = new JSONObject();
            Object obj3 = a.a(b.a_com_xxx_sdk_b_fld.getContext());
            if(!com.xxx.sdk.e.b.c(((Map) (obj3))))
            {
                java.util.Map.Entry entry;
                for(obj3 = ((Map) (obj3)).entrySet().iterator(); ((Iterator) (obj3)).hasNext(); ((JSONObject) (obj2)).put((String)entry.getKey(), entry.getValue()))
                    entry = (java.util.Map.Entry)((Iterator) (obj3)).next();

            }
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            c.error("\u672A\u77E5\u9519\u8BEF", ((Throwable) (obj)));
            return;
        }
        if(l == 0L)
        {
            jsonobject.put("im", ((f) (obj1)).bj);
            jsonobject.put("sw", ((f) (obj1)).b.bx);
            jsonobject.put("sh", ((f) (obj1)).b.by);
            jsonobject.put("tm", ((f) (obj1)).bz);
            jsonobject.put("tb", ((f) (obj1)).cp);
            jsonobject.put("aid", ((f) (obj1)).ct);
            jsonobject.put("mc", ((f) (obj1)).bh);
        }
        if(((f) (obj1)).bW > 0)
        {
            jsonobject.put("thc", ((f) (obj1)).bW);
            obj1.bW = 0;
        }
        jsonobject.put("pkg", obj2);
        jsonobject.put("tel", ((f) (obj1)).cl);
        jsonobject.put("os", ((f) (obj1)).bA);
        jsonobject.put("osv", ((f) (obj1)).cm);
        jsonobject.put("ops", ((f) (obj1)).cq);
        jsonobject.put("lg", ((f) (obj1)).cr);
        obj1 = a.b();
        obj2 = a.a();
        jsonobject.put("sts", ((com.xxx.sdk.e.d.c) (obj1)).u);
        jsonobject.put("sfs", ((com.xxx.sdk.e.d.c) (obj1)).v);
        jsonobject.put("ets", ((com.xxx.sdk.e.d.c) (obj2)).u);
        jsonobject.put("efs", ((com.xxx.sdk.e.d.c) (obj2)).v);
        a(java/util/HashMap).("sys", jsonobject.toString());
        obj1 = b;
        com.xxx.sdk.c.g.c(((p) (obj)).R, a(java/util/HashMap).("sys", jsonobject.toString()).);
        b.R();
        b.b.value = String.valueOf(System.currentTimeMillis());
        b.a_com_xxx_sdk_a_i_fld.a(b.b);
        return;
    }

    private g b;
    private long l;
}
