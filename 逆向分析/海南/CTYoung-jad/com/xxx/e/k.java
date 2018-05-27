// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieManager;
import com.xxx.sdk.a.e;
import com.xxx.sdk.b;
import com.xxx.sdk.c.a.c;
import com.xxx.sdk.c.a.d;
import com.xxx.sdk.f.a;
import com.xxx.sdk.l;
import com.xxx.sdk.p;
import com.xxx.sdk.r;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public final class k
{

    public k()
    {
        bX = 0;
        a_java_util_Stack_fld = new Stack();
    }

    private void K()
    {
        Iterator iterator = a().iterator();
        HashSet hashset = new HashSet();
        do
        {
            if(!iterator.hasNext())
                break;
            d d1 = d.a((String)iterator.next());
            if(d1 != null)
            {
                d1.bi = e.k();
                hashset.add(d.a(d1));
            }
        } while(true);
        a(hashset);
        init(bX);
    }

    public static k a()
    {
        if(a_com_xxx_e_k_static_fld == null)
            a_com_xxx_e_k_static_fld = new k();
        return a_com_xxx_e_k_static_fld;
    }

    private static String a(d d1, String s)
    {
        d1 = b(d1);
        return com.xxx.sdk.b.a().getContext().getSharedPreferences(d1, 0).getString(q(s), null);
    }

    public static HashSet a()
    {
        return (HashSet)com.xxx.sdk.b.a().getContext().getSharedPreferences("client", 0).getStringSet("ips", new HashSet());
    }

    public static void a(HashSet hashset)
    {
        com.xxx.sdk.b.a().getContext().getSharedPreferences("client", 0).edit().putStringSet("ips", hashset).commit();
    }

    private boolean a(String s, a a1)
    {
        Object obj = null;
        if(!a_java_util_Stack_fld.empty())
            obj = (d)a_java_util_Stack_fld.pop();
        if(a1 == null)
        {
            return false;
        } else
        {
            a1 = CookieManager.getInstance();
            s = q(s);
            a1 = a1.getCookie(s);
            obj = b(((d) (obj)));
            com.xxx.sdk.b.a().getContext().getSharedPreferences(((String) (obj)), 0).edit().putString(s, a1);
            return true;
        }
    }

    private static d[] a(int i)
    {
        if(i < 0)
            return null;
        d ad[] = new d[i];
        HashSet hashset = a();
        int i1;
        if(hashset.size() > 0)
        {
            Iterator iterator = hashset.iterator();
            int j1 = 0;
            do
            {
                i1 = j1;
                if(!iterator.hasNext())
                    break;
                i1 = j1;
                if(j1 >= i)
                    break;
                ad[j1] = d.a((String)iterator.next());
                j1++;
            } while(true);
        } else
        {
            i1 = 0;
        }
        boolean flag = false;
        for(; i1 < i; i1++)
        {
            d d1 = new d(false);
            ad[i1] = d1;
            hashset.add(d.a(d1));
            flag = true;
        }

        if(flag)
            a(hashset);
        return ad;
    }

    private static String b(d d1)
    {
        String s1 = "default";
        String s = s1;
        if(d1 != null)
        {
            s = s1;
            if(!com.xxx.sdk.e.b.f(d1.bi))
                s = d1.bi;
        }
        return (new StringBuilder("cookie_")).append(s).toString();
    }

    private boolean j(String s)
    {
        Object obj;
        CookieManager cookiemanager;
        obj = null;
        if(!a_java_util_Stack_fld.empty())
            obj = (d)a_java_util_Stack_fld.peek();
        cookiemanager = CookieManager.getInstance();
        String s1;
        s1 = (new URL(s)).getHost();
        obj = b(((d) (obj)));
        s = com.xxx.sdk.b.a().getContext().getSharedPreferences(((String) (obj)), 0).getString(q(s), null);
        if(s == null)
            break MISSING_BLOCK_LABEL_85;
        cookiemanager.setCookie(s1, s);
        return true;
        s;
        s.printStackTrace();
        return false;
    }

    private static String q(String s)
    {
        String s1;
        try
        {
            s1 = (new URL(s)).getHost();
        }
        catch(MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            return s;
        }
        return s1;
    }

    public final d a(Map map, l l1)
    {
        if(l1 == null)
            return null;
        boolean flag = com.xxx.sdk.d.a(map);
        float f;
        float f1;
        d d1;
        if(flag)
            f = l1.b;
        else
            f = l1.a;
        d1 = new d(true);
        if(flag)
            f1 = l1.c;
        else
            f1 = 1.0F;
        if(f > 0.0F)
        {
            int i = (int)Math.ceil(f);
            Random random = new Random();
            if((float)random.nextInt((int)((f + f1) * 100F)) >= f1 * 100F && a_com_xxx_sdk_c_a_d_array1d_fld != null)
            {
                i = random.nextInt(Math.min(i, a_com_xxx_sdk_c_a_d_array1d_fld.length));
                d1.bh = a_com_xxx_sdk_c_a_d_array1d_fld[i].bh;
                d1.bj = a_com_xxx_sdk_c_a_d_array1d_fld[i].bj;
                if(com.xxx.sdk.d.a(map) && l1.i)
                    d1.bi = a_com_xxx_sdk_c_a_d_array1d_fld[i].bi;
            }
        }
        if(map.containsKey("optimizedAdImei") && map.get("optimizedAdImei") != null)
            d1.bj = (String)map.get("optimizedAdImei");
        if(map.containsKey("optimizedAdMac") && map.get("optimizedAdMac") != null)
            d1.bh = (String)map.get("optimizedAdMac");
        return d1;
    }

    public final void a(p p1)
    {
        int j1;
        if(p1.b != null)
        {
            Iterator iterator = p1.b.iterator();
            int i = 0;
            do
            {
                j1 = i;
                if(!iterator.hasNext())
                    break;
                c c1 = (c)iterator.next();
                if(c1.a != null)
                    i = Math.max(i, (int)Math.ceil(Math.max(c1.a.b, c1.a.a)));
            } while(true);
        } else
        {
            j1 = 0;
        }
        int i1 = j1;
        if(p1.a != null)
        {
            i1 = j1;
            if(p1.a.a != null)
                i1 = (int)Math.ceil(Math.max(p1.a.a.b, p1.a.a.a));
        }
        if(i1 == bX)
        {
            return;
        } else
        {
            init(i1);
            return;
        }
    }

    public final void init(int i)
    {
        d ad[];
        ad = null;
        bX = i;
        if(bX <= 0) goto _L2; else goto _L1
_L1:
        int j1 = bX;
        if(j1 >= 0) goto _L4; else goto _L3
_L3:
        a_com_xxx_sdk_c_a_d_array1d_fld = ad;
        return;
_L4:
        ad = new d[j1];
        HashSet hashset = a();
        if(hashset.size() > 0)
        {
            Iterator iterator = hashset.iterator();
            int i1 = 0;
            do
            {
                i = i1;
                if(!iterator.hasNext())
                    break;
                i = i1;
                if(i1 >= j1)
                    break;
                ad[i1] = d.a((String)iterator.next());
                i1++;
            } while(true);
        } else
        {
            i = 0;
        }
        boolean flag = false;
        for(; i < j1; i++)
        {
            d d1 = new d(false);
            ad[i] = d1;
            hashset.add(d.a(d1));
            flag = true;
        }

        if(flag)
            a(hashset);
        if(true) goto _L3; else goto _L2
_L2:
        a_com_xxx_sdk_c_a_d_array1d_fld = null;
        return;
    }

    private static k a_com_xxx_e_k_static_fld;
    private Stack a_java_util_Stack_fld;
    private d a_com_xxx_sdk_c_a_d_array1d_fld[];
    public int bX;
}
