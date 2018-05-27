// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.*;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public class NetWorkUtils
{

    public NetWorkUtils()
    {
    }

    private static NetworkInfo getActiveNetworkInfo(Context context)
    {
        return ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static String getApnType(Context context)
    {
        String s;
        Cursor cursor;
        s = "nomatch";
        cursor = context.getContentResolver().query(PREFERRED_APN_URI, null, null, null, null);
        context = s;
        if(cursor == null) goto _L2; else goto _L1
_L1:
        context = s;
        if(!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        String s1 = cursor.getString(cursor.getColumnIndex("user"));
        if(s1 == null || !s1.startsWith("ctnet")) goto _L6; else goto _L5
_L5:
        context = "ctnet";
_L4:
        cursor.close();
_L2:
        return context;
_L6:
        if(s1 != null && s1.startsWith("ctwap"))
            context = "ctwap";
        else
        if(s1 != null && s1.startsWith("cmwap"))
            context = "cmwap";
        else
        if(s1 != null && s1.startsWith("cmnet"))
            context = "cmnet";
        else
        if(s1 != null && s1.startsWith("uniwap"))
            context = "uniwap";
        else
        if(s1 != null && s1.startsWith("uninet"))
            context = "uninet";
        else
        if(s1 != null && s1.startsWith("3gwap"))
        {
            context = "3gwap";
        } else
        {
            context = s;
            if(s1 != null)
            {
                context = s;
                if(s1.startsWith("3gnet"))
                    context = "3gnet";
            }
        }
        if(true) goto _L4; else goto _L7
_L7:
    }

    public static byte getCurrentNetType(Context context)
    {
        NetworkInfo networkinfo = getActiveNetworkInfo(context);
        byte byte1 = 0;
        byte byte0 = byte1;
        if(networkinfo != null)
        {
            String s1 = networkinfo.getExtraInfo();
            String s = s1;
            if(TextUtils.isEmpty(s1))
                s = networkinfo.getTypeName();
            byte0 = byte1;
            if(!TextUtils.isEmpty(s))
            {
                s = s.toLowerCase();
                if(s.indexOf("wifi") > -1)
                    byte0 = 1;
                else
                if(s.indexOf("ctnet") > -1)
                    byte0 = 2;
                else
                if(s.indexOf("ctwap") > -1)
                    byte0 = 3;
                else
                if(s.indexOf("cmnet") > -1)
                    byte0 = 6;
                else
                if(s.indexOf("cmwap") > -1)
                    byte0 = 4;
                else
                if(s.indexOf("uniwap") > -1)
                    byte0 = 5;
                else
                if(s.indexOf("3gwap") > -1)
                    byte0 = 5;
                else
                if(s.indexOf("uninet") > -1)
                {
                    byte0 = 7;
                } else
                {
                    byte0 = byte1;
                    if(s.indexOf("3gnet") > -1)
                        byte0 = 7;
                }
            }
        }
        byte1 = byte0;
        if(byte0 == 0)
        {
            context = getApnType(context);
            if(context != null && context.equals("ctnet"))
                byte1 = 2;
            else
            if(context != null && context.equals("ctwap"))
                byte1 = 3;
            else
            if(context != null && context.equals("cmwap"))
                byte1 = 4;
            else
            if(context != null && context.equals("cmnet"))
                byte1 = 6;
            else
            if(context != null && context.equals("uniwap"))
                byte1 = 5;
            else
            if(context != null && context.equals("3gwap"))
                byte1 = 5;
            else
            if(context != null && context.equals("uninet"))
            {
                byte1 = 7;
            } else
            {
                byte1 = byte0;
                if(context != null)
                {
                    byte1 = byte0;
                    if(context.equals("3gnet"))
                        byte1 = 7;
                }
            }
        }
        curNetworkType = byte1;
        return byte1;
    }

    public static boolean getNetworkConnectionStatus(Context context)
    {
        Object obj = (ConnectivityManager)context.getSystemService("connectivity");
        if(obj != null)
            if((obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo()) != null && ((context = (TelephonyManager)context.getSystemService("phone")) != null && (context.getDataState() == 2 || context.getDataState() == 0) && ((NetworkInfo) (obj)).isAvailable()))
                return true;
        return false;
    }

    public static byte getNetworkOperators(byte byte0)
    {
        if(byte0 != 0)
        {
            if(byte0 == 1)
                return 1;
            if(byte0 == 2 || byte0 == 3)
                return 10;
            if(byte0 == 4 || byte0 == 6)
                return 12;
            if(byte0 == 5 || byte0 == 7)
                return 11;
        }
        return 0;
    }

    public static byte getNetworkOperators(Context context)
    {
        if(isWifi(context))
            return 1;
        if(isCtcNetwork(context))
            return 10;
        if(isCmbNetwork(context))
            return 12;
        return ((byte)(!isCucNetwork(context) ? 0 : 11));
    }

    public static String getNetworkProxyInfo(Context context)
    {
        String s = Proxy.getDefaultHost();
        int i = Proxy.getDefaultPort();
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if(context != null)
            if((context = context.getActiveNetworkInfo()) != null && (((context = context.getTypeName().toLowerCase()) == null || !context.equals("wifi")) && s != null && i > 0 && i < 65535))
                return (new StringBuilder()).append(s).append(":").append(String.valueOf(i)).toString();
        return null;
    }

    public static int getNetworkProxyPort()
    {
        return Proxy.getDefaultPort();
    }

    public static String getNetworkProxyUrl()
    {
        if(curNetworkType == 1)
            return null;
        else
            return Proxy.getDefaultHost();
    }

    public static String getNetworkProxyUrl(Context context)
    {
        if(isWifi(context))
            return null;
        else
            return Proxy.getDefaultHost();
    }

    public static boolean isCmbNetwork(byte byte0)
    {
        return byte0 == 4 || byte0 == 6;
    }

    public static boolean isCmbNetwork(Context context)
    {
        return isCmbNetwork(getCurrentNetType(context));
    }

    public static boolean isCmbNetwork(String s)
    {
        while(s == null || !s.equals("cmwap") && !s.equals("cmnet")) 
            return false;
        return true;
    }

    public static boolean isCmwap(Context context)
    {
        return getApnType(context).equals("cmwap");
    }

    public static boolean isConnected(Context context)
    {
        context = getActiveNetworkInfo(context);
        return context != null && context.getState().compareTo(android.net.NetworkInfo.State.CONNECTED) == 0;
    }

    public static boolean isCtcNetwork(byte byte0)
    {
        return byte0 == 3 || byte0 == 2;
    }

    public static boolean isCtcNetwork(Context context)
    {
        return isCtcNetwork(getCurrentNetType(context));
    }

    public static boolean isCtcNetwork(String s)
    {
        while(s == null || !s.equals("ctwap") && !s.equals("ctnet")) 
            return false;
        return true;
    }

    public static boolean isCtwap(Context context)
    {
        return getApnType(context).equals("ctwap");
    }

    public static boolean isCucNetwork(byte byte0)
    {
        return byte0 == 5 || byte0 == 7;
    }

    public static boolean isCucNetwork(Context context)
    {
        return isCucNetwork(getCurrentNetType(context));
    }

    public static boolean isCucNetwork(String s)
    {
        while(s == null || !s.equals("uniwap") && !s.equals("uninet") && !s.equals("3gwap") && !s.equals("3gnet")) 
            return false;
        return true;
    }

    public static boolean isNetAvailable(Context context)
    {
        context = getActiveNetworkInfo(context);
        if(context != null)
            return context.isAvailable();
        else
            return false;
    }

    public static boolean isNetworkConnected(Context context)
    {
        context = getActiveNetworkInfo(context);
        if(context != null)
            return context.isConnected();
        else
            return false;
    }

    public static boolean isUniwap(Context context)
    {
        return getApnType(context).equals("uniwap");
    }

    public static boolean isWifi(Context context)
    {
        int i;
        try
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            return false;
        }
        if(context == null)
            break MISSING_BLOCK_LABEL_31;
        i = context.getType();
        return i == 1;
        return false;
    }

    private static final String CONNECT_TYPE_CMNET = "cmnet";
    private static final String CONNECT_TYPE_CMWAP = "cmwap";
    private static final String CONNECT_TYPE_CTNET = "ctnet";
    private static final String CONNECT_TYPE_CTWAP = "ctwap";
    private static final String CONNECT_TYPE_UNI3GNET = "3gnet";
    private static final String CONNECT_TYPE_UNI3GWAP = "3gwap";
    private static final String CONNECT_TYPE_UNINET = "uninet";
    private static final String CONNECT_TYPE_UNIWAP = "uniwap";
    private static final String CONNECT_TYPE_WIFI = "wifi";
    public static final byte CURRENT_NETWORK_TYPE_CM = 12;
    public static final byte CURRENT_NETWORK_TYPE_CMNET = 6;
    public static final byte CURRENT_NETWORK_TYPE_CMWAP = 4;
    public static final byte CURRENT_NETWORK_TYPE_CTC = 10;
    public static final byte CURRENT_NETWORK_TYPE_CTNET = 2;
    public static final byte CURRENT_NETWORK_TYPE_CTWAP = 3;
    public static final byte CURRENT_NETWORK_TYPE_CUC = 11;
    public static final byte CURRENT_NETWORK_TYPE_NONE = 0;
    public static final byte CURRENT_NETWORK_TYPE_UNIET = 7;
    public static final byte CURRENT_NETWORK_TYPE_UNIWAP = 5;
    public static final byte CURRENT_NETWORK_TYPE_WIFI = 1;
    private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    public static byte curNetworkType = 0;

}
