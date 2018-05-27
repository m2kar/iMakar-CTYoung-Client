// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import android.os.Environment;

public class Utils
{

    public Utils()
    {
    }

    public static boolean sdCardExists()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
