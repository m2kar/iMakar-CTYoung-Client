// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import com.xxx.sdk.e.b;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k
{

    public k()
    {
    }

    public static ArrayList a(JSONArray jsonarray)
    {
        if(jsonarray == null)
            return null;
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            k k1 = new k();
            k1.duration = jsonobject.optInt("showDuration");
            k1.url = jsonobject.optString("url");
            k1.y = jsonobject.optString("jsFile");
            if(jsonobject.has("header"))
            {
                JSONObject jsonobject1 = jsonobject.optJSONObject("header");
                if(jsonobject1 != null)
                {
                    Iterator iterator = jsonobject1.keys();
                    if(iterator.hasNext())
                    {
                        k1.a = new HashMap();
                        do
                        {
                            if(!iterator.hasNext())
                                break;
                            String s = (String)iterator.next();
                            String s1 = jsonobject1.optString(s);
                            if(!b.f(s1))
                                k1.a.put(s, s1);
                        } while(true);
                    }
                }
            }
            k1.y = jsonobject.optString("jsFile");
            arraylist.add(k1);
        }

        return arraylist;
    }

    public final String toString()
    {
        return (new StringBuilder("OptUrl{url='")).append(url).append('\'').append(", duration=").append(duration).append(", remoteJsFile='").append(y).append('\'').append('}').toString();
    }

    public HashMap a;
    public int duration;
    public String url;
    public String y;
}
