// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import org.json.JSONObject;

public final class w
{

    public w()
    {
    }

    public static w a(JSONObject jsonobject)
    {
        w w1 = new w();
        if(jsonobject != null)
        {
            w1.M = jsonobject.optInt("banner");
            w1.L = jsonobject.optInt("floating");
        }
        return w1;
    }

    private void a(int i)
    {
        L = i;
    }

    private int b()
    {
        return L;
    }

    private void b(int i)
    {
        M = i;
    }

    private int c()
    {
        return M;
    }

    public int L;
    public int M;
}
