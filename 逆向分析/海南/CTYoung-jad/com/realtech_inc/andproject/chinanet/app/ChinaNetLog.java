// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.app;

import android.util.Log;

public class ChinaNetLog
{

    public ChinaNetLog()
    {
    }

    public static void Lhh_i(String s)
    {
        i("LHH", s);
    }

    public static void i(String s)
    {
        i("ChinaNet", s);
    }

    public static void i(String s, String s1)
    {
        Log.i(s, s1);
    }

    public static final String TAG = "ChinaNet";
    public static final String lhh = "LHH";
}
