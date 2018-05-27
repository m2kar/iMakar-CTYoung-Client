// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.e;

import android.content.Context;
import android.content.pm.*;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;

public final class e
{

    private e(Context context)
    {
        DisplayMetrics displaymetrics;
        density = 1.0F;
        targetSdkVersion = -1;
        displaymetrics = context.getResources().getDisplayMetrics();
        Field field;
        if(Integer.parseInt(android.os.Build.VERSION.SDK) < 4)
            break MISSING_BLOCK_LABEL_76;
        context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo;
        field = android/content/pm/ApplicationInfo.getField("targetSdkVersion");
        if(context != null && field != null)
            try
            {
                targetSdkVersion = field.getInt(context);
            }
            // Misplaced declaration of an exception variable
            catch(Context context) { }
        bU = displaymetrics.widthPixels;
        bV = displaymetrics.heightPixels;
        density = displaymetrics.density;
        if(targetSdkVersion < 4)
        {
            bx = Math.round((float)bU * density);
            by = Math.round((float)bV * density);
        } else
        {
            bx = bU;
            by = bV;
        }
        if(bx > by)
        {
            int i = bx;
            bx = by;
            by = i;
        }
        return;
    }

    private float a()
    {
        return density;
    }

    public static int a(float f)
    {
        if(f <= 0.75F)
            return 0;
        return f < 1.5F ? 1 : 2;
    }

    private static int a(int i)
    {
        int k = i % 10;
        int j;
        if(k > 0 && k <= 4)
        {
            j = i - k;
        } else
        {
            j = i;
            if(k > 4)
            {
                j = i;
                if(k <= 9)
                    return i + (10 - k);
            }
        }
        return j;
    }

    public static e a(Context context)
    {
        com/xxx/sdk/e/e/e;
        JVM INSTR monitorenter ;
        if(a == null)
            a = new e(context);
        context = a;
        com/xxx/sdk/e/e/e;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private int getScreenHeight()
    {
        return by;
    }

    private int getScreenWidth()
    {
        return bx;
    }

    private static e a = null;
    private static int bR = 0;
    private static int bS = 1;
    private static int bT = 2;
    private int bU;
    private int bV;
    public int bx;
    public int by;
    public float density;
    private int targetSdkVersion;

}
