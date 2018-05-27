// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c.a.a;

import java.util.ArrayList;
import java.util.List;
import org.json.*;

// Referenced classes of package com.xxx.sdk.c.a.a:
//            e

public final class d
{

    public d()
    {
        l = new ArrayList();
    }

    public static d a(String s)
    {
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            s.printStackTrace();
            s = null;
        }
        if(s == null)
        {
            return null;
        } else
        {
            d d1 = new d();
            JSONArray jsonarray = s.optJSONArray("ads");
            d1.bm = s.optString("reqid");
            d1.id = s.optString("id");
            d1.l = e.a(jsonarray);
            return d1;
        }
    }

    private static d a(JSONObject jsonobject)
    {
        Object obj = null;
        if(jsonobject == null)
            return null;
        d d1 = new d();
        JSONArray jsonarray = jsonobject.optJSONArray("ads");
        d1.bm = jsonobject.optString("reqid");
        d1.id = jsonobject.optString("id");
        jsonobject = obj;
        if(jsonarray != null)
            if(jsonarray.length() <= 0)
            {
                jsonobject = obj;
            } else
            {
                jsonobject = new ArrayList();
                int i = 0;
                while(i < jsonarray.length()) 
                {
                    JSONObject jsonobject1 = jsonarray.optJSONObject(i);
                    e e1 = new e();
                    e1.aw = jsonobject1.optInt("adh");
                    e1.av = jsonobject1.optInt("adw");
                    e1.bq = jsonobject1.optString("adi");
                    e1.br = jsonobject1.optString("adurl");
                    e1.au = jsonobject1.optInt("adct");
                    e1.bt = jsonobject1.optJSONObject("nurl").optString("0");
                    e1.bs = jsonobject1.optString("curl");
                    e1.id = jsonobject1.optString("adid");
                    e1.bn = jsonobject1.optString("impid");
                    e1.at = jsonobject1.optInt("admt");
                    e1.bo = jsonobject1.optString("pmd");
                    e1.av = jsonobject1.optInt("adw");
                    e1.aw = jsonobject1.optInt("adh");
                    e1.bu = jsonobject1.optString("ade");
                    jsonobject.add(e1);
                    i++;
                }
            }
        d1.l = jsonobject;
        return d1;
    }

    public final String toString()
    {
        return (new StringBuilder("AdViewRespObj{id='")).append(id).append('\'').append(", reqid='").append(bm).append('\'').append(", ads=").append(l).append('}').toString();
    }

    private String bm;
    private String id;
    List l;
}
