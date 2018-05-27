// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.xxx.sdk.c.a.c;
import com.xxx.sdk.e.b;
import com.xxx.sdk.f.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xxx.sdk:
//            e, k, b, p, 
//            r

public abstract class d extends e
{

    public d()
    {
    }

    public static String a(String s)
    {
        if(com.xxx.sdk.e.b.f(s))
            return null;
        int i = s.indexOf('(');
        int j;
        int l;
        if(i < 0)
            i = 0;
        else
            i++;
        l = s.lastIndexOf(")");
        j = l;
        if(l < 0)
            j = s.length();
        return s.substring(i, j);
    }

    public static String a(Map map)
    {
        if(map != null && map.containsKey("optimized_platform_name"))
            return (String)map.get("optimized_platform_name");
        else
            return null;
    }

    public static void a(Context context, boolean flag)
    {
        if(!flag)
            break MISSING_BLOCK_LABEL_40;
        if(k.httpClient != null)
            k.httpClient.l.clear();
        try
        {
            CookieSyncManager.createInstance(context).startSync();
            context = CookieManager.getInstance();
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            return;
        }
        if(context == null)
            break MISSING_BLOCK_LABEL_40;
        context.removeAllCookie();
    }

    public static void a(a a1, String s)
    {
        Object obj = com.xxx.sdk.b.a().a();
        if(((p) (obj)).b == null) goto _L2; else goto _L1
_L1:
        if(!"exch".equals(s)) goto _L4; else goto _L3
_L3:
        s = new c();
        s.V = ((p) (obj)).a.V;
_L9:
        if(s != null)
            a1.id = ((c) (s)).V;
        return;
_L4:
        Iterator iterator = ((p) (obj)).b.iterator();
_L7:
        if(!iterator.hasNext()) goto _L2; else goto _L5
_L5:
        obj = (c)iterator.next();
        if(!((c) (obj)).name.equals(s)) goto _L7; else goto _L6
_L6:
        s = ((String) (obj));
        continue; /* Loop/switch isn't completed */
_L2:
        s = null;
        if(true) goto _L9; else goto _L8
_L8:
    }

    public static boolean a(Map map)
    {
        if(map != null && map.containsKey("has_optimized_ad"))
            return ((String)map.get("has_optimized_ad")).equals("1");
        else
            return false;
    }

    private static boolean b(Map map)
    {
        return map != null && map.containsKey("optimized_platform_name") && !"exch".equals((String)map.get("optimized_platform_name"));
    }

    public abstract a a(Map map);

    public boolean d()
    {
        Context context = com.xxx.sdk.b.a().getContext();
        if(context == null)
            com.xxx.sdk.e.c.warn("AdManager\u4E2Dcontext\u5BF9\u8C61\u4E3Anull,\u7CFB\u7EDF\u5F02\u5E38\u3002");
        else
        if(super.d() && com.xxx.sdk.e.e.a.f(context))
            return true;
        return false;
    }
}
