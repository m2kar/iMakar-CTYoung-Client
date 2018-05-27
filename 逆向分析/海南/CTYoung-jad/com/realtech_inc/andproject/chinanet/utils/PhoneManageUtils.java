// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.net.*;
import java.util.Enumeration;

// Referenced classes of package com.realtech_inc.andproject.chinanet.utils:
//            DebugLog

public class PhoneManageUtils
{

    private PhoneManageUtils()
    {
    }

    public static PhoneManageUtils getInstence()
    {
        if(instence == null)
        {
            PhoneManageUtils phonemanageutils = new PhoneManageUtils();
            instence = phonemanageutils;
            return phonemanageutils;
        } else
        {
            return instence;
        }
    }

    public String getImei()
        throws Exception
    {
        return ((TelephonyManager)mContext.getSystemService("phone")).getDeviceId();
    }

    public String getImsi()
        throws Exception
    {
        return ((TelephonyManager)mContext.getSystemService("phone")).getSubscriberId();
    }

    public void initDeviceInfo(Context context)
    {
        mContext = context;
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        context = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo();
        if(telephonymanager.getSimState() == 5)
            IMSI = telephonymanager.getSubscriberId();
        IMEI = telephonymanager.getDeviceId();
        MAC = context.getMacAddress();
        MODEL = Build.MODEL;
        SDK = android.os.Build.VERSION.SDK;
        initLocalIpAddress();
    }

    public void initLocalIpAddress()
    {
        try
        {
            for(Enumeration enumeration = NetworkInterface.getNetworkInterfaces(); enumeration.hasMoreElements();)
            {
                Enumeration enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
                while(enumeration1.hasMoreElements()) 
                {
                    InetAddress inetaddress = (InetAddress)enumeration1.nextElement();
                    if(!inetaddress.isLoopbackAddress())
                        IP = inetaddress.getHostAddress().toString();
                }
            }

        }
        catch(SocketException socketexception)
        {
            DebugLog.i("PhoneManageUtils", socketexception.toString());
        }
        IP = null;
    }

    public static String IMEI;
    public static String IMSI;
    public static String IP;
    public static String MAC;
    public static String MODEL;
    public static String SDK;
    private static PhoneManageUtils instence;
    private Context mContext;
}
