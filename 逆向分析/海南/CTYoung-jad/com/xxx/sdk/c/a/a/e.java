// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c.a.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{

    public e()
    {
    }

    private static e a(JSONObject jsonobject)
    {
        e e1 = new e();
        e1.aw = jsonobject.optInt("adh");
        e1.av = jsonobject.optInt("adw");
        e1.bq = jsonobject.optString("adi");
        e1.br = jsonobject.optString("adurl");
        e1.au = jsonobject.optInt("adct");
        e1.bt = jsonobject.optJSONObject("nurl").optString("0");
        e1.bs = jsonobject.optString("curl");
        e1.id = jsonobject.optString("adid");
        e1.bn = jsonobject.optString("impid");
        e1.at = jsonobject.optInt("admt");
        e1.bo = jsonobject.optString("pmd");
        e1.av = jsonobject.optInt("adw");
        e1.aw = jsonobject.optInt("adh");
        e1.bu = jsonobject.optString("ade");
        return e1;
    }

    static List a(JSONArray jsonarray)
    {
        if(jsonarray == null || jsonarray.length() <= 0)
            return null;
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            e e1 = new e();
            e1.aw = jsonobject.optInt("adh");
            e1.av = jsonobject.optInt("adw");
            e1.bq = jsonobject.optString("adi");
            e1.br = jsonobject.optString("adurl");
            e1.au = jsonobject.optInt("adct");
            e1.bt = jsonobject.optJSONObject("nurl").optString("0");
            e1.bs = jsonobject.optString("curl");
            e1.id = jsonobject.optString("adid");
            e1.bn = jsonobject.optString("impid");
            e1.at = jsonobject.optInt("admt");
            e1.bo = jsonobject.optString("pmd");
            e1.av = jsonobject.optInt("adw");
            e1.aw = jsonobject.optInt("adh");
            e1.bu = jsonobject.optString("ade");
            arraylist.add(e1);
        }

        return arraylist;
    }

    public final String toString()
    {
        return (new StringBuilder("Ad{impId='")).append(bn).append('\'').append(", pmd='").append(bo).append('\'').append(", id='").append(id).append('\'').append(", mt=").append(at).append(", adm='").append(null).append('\'').append(", adi='").append(bq).append('\'').append(", adurl='").append(br).append('\'').append(", adw=").append(av).append(", adh=").append(aw).append(", curl='").append(bs).append('\'').append(", nurl='").append(bt).append('\'').append(", adct=").append(au).append('}').toString();
    }

    int at;
    int au;
    int av;
    int aw;
    String bn;
    String bo;
    private String bp;
    String bq;
    String br;
    String bs;
    String bt;
    String bu;
    String id;
}
