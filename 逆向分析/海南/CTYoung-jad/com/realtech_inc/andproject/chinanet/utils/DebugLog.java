// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import android.util.Log;

public class DebugLog
{

    public DebugLog()
    {
    }

    public static void d(String s, String s1)
    {
        if(DEBUG)
            Log.d(s, s1);
    }

    public static void e(String s, String s1)
    {
        if(DEBUG)
            Log.e(s, s1);
    }

    public static void e(String s, String s1, Throwable throwable)
    {
        if(DEBUG)
            Log.e(s, s1, throwable);
    }

    public static void i(String s, String s1)
    {
        if(DEBUG)
            Log.i(s, s1);
    }

    public static void off()
    {
        DEBUG = false;
    }

    public static void v(String s, String s1)
    {
        if(DEBUG)
            Log.v(s, s1);
    }

    public static void w(String s, String s1)
    {
        if(DEBUG)
            Log.w(s, s1);
    }

    private static boolean DEBUG = true;

}
