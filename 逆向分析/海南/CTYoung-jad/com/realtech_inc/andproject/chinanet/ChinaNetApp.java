// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet;

import android.app.Application;
import com.realtech_inc.andproject.chinanet.io.SharedPrefsManager;
import com.realtech_inc.andproject.chinanet.utils.DebugLog;
import com.realtech_inc.andproject.chinanet.utils.PhoneManageUtils;

public class ChinaNetApp extends Application
{

    public ChinaNetApp()
    {
    }

    public void onCreate()
    {
        super.onCreate();
        DebugLog.off();
        SharedPrefsManager.getInstance(PACKAGENAME).setContext(getApplicationContext());
        PhoneManageUtils.getInstence().initDeviceInfo(getApplicationContext());
    }

    private static final String PACKAGENAME = com/realtech_inc/andproject/chinanet/ChinaNetApp.getPackage().getName();

}
