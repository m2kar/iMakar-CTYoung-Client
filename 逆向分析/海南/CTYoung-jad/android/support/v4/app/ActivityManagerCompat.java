// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.app;

import android.app.ActivityManager;

// Referenced classes of package android.support.v4.app:
//            ActivityManagerCompatKitKat

public final class ActivityManagerCompat
{

    private ActivityManagerCompat()
    {
    }

    public static boolean isLowRamDevice(ActivityManager activitymanager)
    {
        if(android.os.Build.VERSION.SDK_INT >= 19)
            return ActivityManagerCompatKitKat.isLowRamDevice(activitymanager);
        else
            return false;
    }
}
