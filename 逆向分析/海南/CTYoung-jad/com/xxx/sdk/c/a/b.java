// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import com.xxx.e.k;
import com.xxx.sdk.a.e;
import com.xxx.sdk.d;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.e.e.f;
import com.xxx.sdk.j;
import com.xxx.sdk.p;
import com.xxx.sdk.q;
import com.xxx.sdk.r;
import com.xxx.sdk.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xxx.sdk.c.a:
//            d, c

public final class b
{

    b()
    {
        i = null;
        a_android_content_Context_fld = null;
    }

    private void K()
    {
        if(i != null && i.size() > 0)
        {
            for(Iterator iterator = i.iterator(); iterator.hasNext(); iterator.next());
        }
    }

    private void L()
    {
        if(b == null)
        {
            String s2 = com.xxx.sdk.b.a().d();
            String s1 = s2;
            if(s2 == null)
            {
                c.warn("\u5916\u90E8\u5B58\u50A8\u4E0D\u80FD\u4F7F\u7528\uFF0Cbanner\u5E7F\u544A\u5B58\u50A8\u76EE\u5F55\uFF1A".concat(s2));
                s1 = a_android_content_Context_fld.getApplicationInfo().dataDir.concat(File.separator);
            }
            b = new File(s1.concat(String.valueOf(com/xxx/sdk/c/a/a/b.getSimpleName().hashCode())));
            b.mkdirs();
        }
    }

    public static b a()
    {
        com/xxx/sdk/c/a/b;
        JVM INSTR monitorenter ;
        b b1;
        if(a_com_xxx_sdk_c_a_b_static_fld == null)
            a_com_xxx_sdk_c_a_b_static_fld = new b();
        b1 = a_com_xxx_sdk_c_a_b_static_fld;
        com/xxx/sdk/c/a/b;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static b a(Context context)
    {
        b b1 = a();
        a_com_xxx_sdk_c_a_b_static_fld = b1;
        b1.a_android_content_Context_fld = context;
        if(context != null)
        {
            context = context.getSharedPreferences("Env.config", 0);
            if(context.contains("appid"))
            {
                String s1 = context.getString("appid", null);
                if(s1 != null)
                    j.a().O = s1;
                j.a().P = context.getString("appsecret", null);
            }
        }
        return a_com_xxx_sdk_c_a_b_static_fld;
    }

    private File a()
    {
        if(b == null && b == null)
        {
            String s2 = com.xxx.sdk.b.a().d();
            String s1 = s2;
            if(s2 == null)
            {
                c.warn("\u5916\u90E8\u5B58\u50A8\u4E0D\u80FD\u4F7F\u7528\uFF0Cbanner\u5E7F\u544A\u5B58\u50A8\u76EE\u5F55\uFF1A".concat(s2));
                s1 = a_android_content_Context_fld.getApplicationInfo().dataDir.concat(File.separator);
            }
            b = new File(s1.concat(String.valueOf(com/xxx/sdk/c/a/a/b.getSimpleName().hashCode())));
            b.mkdirs();
        }
        return b;
    }

    public static Map a(Map map, int l, int i1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("img_w", String.valueOf(l));
        hashmap.put("img_h", String.valueOf(i1));
        hashmap.put("dt", "0");
        hashmap.put("p", "1");
        hashmap.put("rt", String.valueOf(System.currentTimeMillis() / 1000L));
        hashmap.put("make", com.xxx.sdk.b.a().a().cp);
        hashmap.put("model", com.xxx.sdk.b.a().a().bz);
        hashmap.put("os", com.xxx.sdk.b.a().a().bA);
        hashmap.put("osv", com.xxx.sdk.b.a().a().cm);
        hashmap.put("androidid", com.xxx.sdk.b.a().a().ct);
        hashmap.put("ua", com.xxx.sdk.e.e.a.h(a().a_android_content_Context_fld));
        Object obj = com.xxx.sdk.b.a().a().bh;
        String s2 = com.xxx.sdk.b.a().a().bj;
        com.xxx.sdk.c.a.d d1 = k.a().a(map, com.xxx.sdk.b.a().a().a_com_xxx_sdk_r_fld.a);
        map = ((Map) (obj));
        String s1 = s2;
        if(d1 != null)
        {
            if(!com.xxx.sdk.e.b.f(d1.bh))
                obj = d1.bh;
            if(!com.xxx.sdk.e.b.f(d1.bi))
                hashmap.put("ip", d1.bi);
            else
                hashmap.put("ip", com.xxx.sdk.e.e.a.D());
            map = ((Map) (obj));
            s1 = s2;
            if(!com.xxx.sdk.e.b.f(d1.bj))
            {
                s1 = d1.bj;
                map = ((Map) (obj));
            }
        }
        obj = map;
        if(map != null)
        {
            obj = map;
            if(!map.contains(":"))
                obj = e.c(map);
        }
        hashmap.put("mac", obj);
        hashmap.put("uid", s1);
        return hashmap;
    }

    private Context getContext()
    {
        return a_android_content_Context_fld;
    }

    public final com.xxx.sdk.f.a a(Class class1, Map map)
    {
        com.xxx.sdk.f.c c1;
        Object obj;
        Object obj1;
        c1 = null;
        obj1 = null;
        obj = obj1;
        if(i == null) goto _L2; else goto _L1
_L1:
        if(!i.isEmpty()) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L2:
        return ((com.xxx.sdk.f.a) (obj));
_L4:
        obj = com.xxx.sdk.b.a().a();
        boolean flag = ((p) (obj)).a_com_xxx_sdk_q_fld.k;
        boolean flag1 = ((p) (obj)).a_com_xxx_sdk_s_fld.k;
        boolean flag2 = d.a(map);
        String s1;
        Iterator iterator;
        com.xxx.sdk.b.b b1;
        if(flag2 && map.containsKey("optimized_platform_name"))
            s1 = (String)map.get("optimized_platform_name");
        else
            s1 = null;
        iterator = i.iterator();
        obj = c1;
        if(iterator.hasNext())
        {
            b1 = (com.xxx.sdk.b.b)iterator.next();
            if(!flag2 || b1.getAlias().equals(s1))
            {
                if(com/xxx/sdk/f/c.equals(class1) && flag)
                {
                    obj = c1;
                    if(b1.a().B > 0)
                        obj = b1.a(map);
                } else
                if(com/xxx/sdk/f/d.equals(class1) && flag1)
                {
                    obj = c1;
                    if(b1.a().as > 0)
                        obj = b1.a(map);
                } else
                {
                    c.warn((new StringBuilder("\u7B2C\u4E09\u65B9\u5E73\u53F0\u4E0D\u652F\u6301\u3001\u6216\u5E7F\u544A\u672A\u5F00\u542F:")).append(class1.getCanonicalName()).toString());
                    obj = c1;
                }
                c1 = ((com.xxx.sdk.f.c) (obj));
                if(obj != null)
                {
                    c1 = ((com.xxx.sdk.f.c) (obj));
                    if(flag2)
                        return ((com.xxx.sdk.f.a) (obj));
                }
            }
            break MISSING_BLOCK_LABEL_111;
        }
        continue; /* Loop/switch isn't completed */
        if(true) goto _L2; else goto _L5
_L5:
    }

    public final void b(List list)
    {
        if(i != null && i.size() > 0)
            i.clear();
        i = new ArrayList();
        if(list == null || list.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = list.iterator();
_L10:
        if(!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        byte byte0;
        com.xxx.sdk.c.a.c c1;
        c1 = (com.xxx.sdk.c.a.c)iterator.next();
        list = c1.name;
        byte0 = -1;
        list.hashCode();
        JVM INSTR tableswitch -1421968056 -1421968056: default 108
    //                   -1421968056 148;
           goto _L4 _L5
_L4:
        byte0;
        JVM INSTR tableswitch 0 0: default 128
    //                   0 163;
           goto _L6 _L7
_L6:
        list = null;
_L8:
        if(list != null)
            i.add(list);
        continue; /* Loop/switch isn't completed */
_L5:
        if(list.equals("adview"))
            byte0 = 0;
          goto _L4
_L7:
        list = new com.xxx.sdk.c.a.a.b(a_android_content_Context_fld);
        list.a(c1);
          goto _L8
_L2:
        return;
        if(true) goto _L10; else goto _L9
_L9:
    }

    private static b a_com_xxx_sdk_c_a_b_static_fld = null;
    public Context a_android_content_Context_fld;
    public File b;
    public List i;

}
