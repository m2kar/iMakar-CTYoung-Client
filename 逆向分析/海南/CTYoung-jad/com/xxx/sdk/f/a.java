// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.f;

import com.xxx.sdk.a.g;
import com.xxx.sdk.a.h;
import com.xxx.sdk.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e;
import com.xxx.sdk.k;
import com.xxx.sdk.m;
import com.xxx.sdk.p;
import com.xxx.sdk.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.xxx.sdk.f:
//            b

public abstract class a extends k
    implements Serializable
{

    public a()
    {
        throwRate = 0;
        trackState = 0;
        v v1 = com.xxx.sdk.b.a().a().a;
        if(v1 != null)
        {
            sysShowUrl = v1.Z;
            sysClickUrl = v1.aa;
            eSysClickUrl = v1.ab;
        }
    }

    private static String[] a(String s)
    {
        String as1[];
        JSONArray jsonarray;
        jsonarray = new JSONArray(s);
        as1 = new String[jsonarray.length()];
        int i = 0;
_L2:
        Object obj = as1;
        if(i >= jsonarray.length())
            break; /* Loop/switch isn't completed */
        as1[i] = jsonarray.optString(i);
        i++;
        if(true) goto _L2; else goto _L1
        obj;
        obj = new String[1];
        obj[0] = s;
_L1:
        return ((String []) (obj));
    }

    private void activate()
    {
        b(activateUrl, null);
    }

    private void ag()
    {
        sysClickUrl = null;
    }

    private void ah()
    {
        sysShowUrl = null;
    }

    private void ai()
    {
        eSysClickUrl = null;
    }

    private void aj()
    {
        b(cacheUrl, null);
    }

    private void ak()
    {
        b(cacheUrl, null);
    }

    private void al()
    {
        y(clickUrl);
        Map map = e.a(java/util/HashMap).a("at", getAlias()).a("cid", id).f;
        if(isOptAd)
            map.put("opt", "1");
        else
            map.put("opt", "0");
        com.xxx.sdk.m.a().a(sysClickUrl, map);
    }

    private void an()
    {
        y(showUrl);
        Map map = e.a(java/util/HashMap).a("at", getAlias()).a("cid", id).f;
        if(isOptAd)
            map.put("opt", "1");
        else
            map.put("opt", "0");
        com.xxx.sdk.m.a().a(sysShowUrl, map);
    }

    private void ao()
    {
        isOptAd = true;
    }

    private void ap()
    {
        b(installUrl, null);
    }

    private void aq()
    {
        b(activateUrl, null);
    }

    private void ar()
    {
        d(null);
    }

    private void as()
    {
        b(downloadUrl, null);
    }

    private void at()
    {
        b(downloadUrl, null);
    }

    public static void b(String s, Map map)
    {
        if(!com.xxx.sdk.e.b.f(s))
        {
            map = b(map);
            ArrayList arraylist = new ArrayList();
            s = s.split(";");
            for(int i = 0; i < s.length; i++)
                arraylist.add(new h(s[i], map, "get"));

            (new g(com.xxx.sdk.b.a().getContext())).a(arraylist);
        }
    }

    private static void c(String s, Map map)
    {
        if(!com.xxx.sdk.e.b.f(s))
        {
            s = s.split(";");
            for(int i = 0; i < s.length; i++)
                com.xxx.sdk.m.a().a(s[i], map);

        }
    }

    private void h(boolean flag)
    {
        clearCookies = flag;
    }

    public static boolean m()
    {
        boolean flag = isFloating.getAndSet(true);
        if(flag)
        {
            com.xxx.sdk.e.c.warn("\u5DF2\u7ECF\u5B58\u5728\u60AC\u6D6E\u7C7B\u578B\u5E7F\u544A\u4E86, \u4E0D\u80FD\u663E\u793Abanner\u5E7F\u544A\uFF0C \u5219\u629B\u51FA\u5F02\u5E38");
            throw new com.xxx.sdk.f.b();
        } else
        {
            return flag;
        }
    }

    public static boolean n()
    {
        com.xxx.sdk.c.x();
        isFloating.set(false);
        return true;
    }

    private boolean o()
    {
        return clearCookies;
    }

    private static void y(String s)
    {
        s = a(s);
        int l = s.length;
        for(int i = 0; i < l; i++)
        {
            String s1 = s[i];
            if(com.xxx.sdk.e.b.f(s1))
                continue;
            String as1[] = s1.split(";");
            for(int j = 0; j < as1.length; j++)
                com.xxx.sdk.m.a().a(as1[j], null);

        }

    }

    public final void am()
    {
label0:
        {
            if((trackState & 4) == 0)
            {
                trackState = trackState | 4;
                if(!com.xxx.sdk.e.b.f(eSysClickUrl))
                    break label0;
            }
            return;
        }
        Map map = e.a(java/util/HashMap).a("at", getAlias()).a("cid", id).f;
        if(isOptAd)
            map.put("opt", "1");
        else
            map.put("opt", "0");
        com.xxx.sdk.m.a().a(eSysClickUrl, map);
    }

    public final void click()
    {
        if((trackState & 2) == 0)
        {
            trackState = trackState | 2;
            y(clickUrl);
            Map map = e.a(java/util/HashMap).a("at", getAlias()).a("cid", id).f;
            if(isOptAd)
                map.put("opt", "1");
            else
                map.put("opt", "0");
            com.xxx.sdk.m.a().a(sysClickUrl, map);
        }
    }

    public void d(Map map)
    {
        b(reactivateUrl, map);
    }

    public String getAlias()
    {
        return null;
    }

    public void install()
    {
        b(installUrl, null);
    }

    public final boolean p()
    {
        int i = com.xxx.sdk.e.b.b(100);
        return throwRate > 0 && i < throwRate;
    }

    public void show()
    {
        if((trackState & 1) == 0)
        {
            trackState = trackState | 1;
            y(showUrl);
            Map map = e.a(java/util/HashMap).a("at", getAlias()).a("cid", id).f;
            if(isOptAd)
                map.put("opt", "1");
            else
                map.put("opt", "0");
            com.xxx.sdk.m.a().a(sysShowUrl, map);
        }
    }

    public final void w(int i)
    {
        throwRate = i;
    }

    public static final int CLICK = 2;
    public static final int OPEN = 4;
    public static final int SHOW = 1;
    static AtomicBoolean isFloating = new AtomicBoolean(false);
    private static final long serialVersionUID = 0xafe4292496721639L;
    public String activateUrl;
    public String cacheUrl;
    public boolean clearCookies;
    public String clickUrl;
    public String downloadUrl;
    public String eSysClickUrl;
    public String id;
    public String installUrl;
    public boolean isOptAd;
    public String reactivateUrl;
    public String showUrl;
    public String sysClickUrl;
    public String sysShowUrl;
    protected int throwRate;
    int trackState;

}
