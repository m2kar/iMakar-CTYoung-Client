// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import org.json.JSONObject;

public final class l
{

    public l()
    {
        a = 0.0F;
        b = 0.0F;
        i = false;
        c = 0.0F;
    }

    public static l a(JSONObject jsonobject)
    {
        l l1 = new l();
        l1.a = (float)jsonobject.optDouble("vaCount");
        l1.b = (float)jsonobject.optDouble("optVaCount");
        l1.i = jsonobject.optBoolean("optIp");
        l1.c = (float)jsonobject.optDouble("optRaWeight");
        return l1;
    }

    public final String toString()
    {
        return (new StringBuilder("OptVaConfig{vaCount=")).append(a).append(", optVaCount=").append(b).append(", optIp=").append(i).append(", optRaWeight=").append(c).append('}').toString();
    }

    public float a;
    public float b;
    public float c;
    public boolean i;
}
