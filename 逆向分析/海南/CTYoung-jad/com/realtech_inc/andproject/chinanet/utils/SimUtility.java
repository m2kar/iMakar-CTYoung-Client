// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;

// Referenced classes of package com.realtech_inc.andproject.chinanet.utils:
//            GaotongDoubleInfo, MtkDoubleInfo, SingleSim

public class SimUtility
{

    public SimUtility()
    {
    }

    public static String getProvidersName(String s)
    {
        String s1 = null;
        if(s.startsWith("46000") || s.startsWith("46002") || s.startsWith("46007"))
        {
            s1 = "\u4E2D\u56FD\u79FB\u52A8";
        } else
        {
            if(s.startsWith("46001") || s.startsWith("46006"))
                return "\u4E2D\u56FD\u8054\u901A";
            if(s.startsWith("46003") || s.startsWith("46005") || s.startsWith("46011"))
                return "\u4E2D\u56FD\u7535\u4FE1";
        }
        return s1;
    }

    public static Object getSimInfo(Context context)
    {
        GaotongDoubleInfo gaotongdoubleinfo = initQualcommDoubleSim(context);
        MtkDoubleInfo mtkdoubleinfo = initMtkDoubleSim(context);
        boolean flag = gaotongdoubleinfo.isGaotongDoubleSim();
        boolean flag1 = mtkdoubleinfo.isMtkDoubleSim();
        if(flag)
            return gaotongdoubleinfo;
        if(flag1)
            return mtkdoubleinfo;
        else
            return initSingleSim(context);
    }

    public static MtkDoubleInfo initMtkDoubleSim(Context context)
    {
        MtkDoubleInfo mtkdoubleinfo = new MtkDoubleInfo();
        try
        {
            context = (TelephonyManager)context.getSystemService("phone");
            Class.forName("com.android.internal.telephony.Phone");
            mtkdoubleinfo.setSimId_1(0);
            mtkdoubleinfo.setSimId_2(1);
            Method method = android/telephony/TelephonyManager.getDeclaredMethod("getSubscriberIdGemini", new Class[] {
                Integer.TYPE
            });
            mtkdoubleinfo.setImsi_1((String)method.invoke(context, new Object[] {
                Integer.valueOf(mtkdoubleinfo.getSimId_1())
            }));
            mtkdoubleinfo.setImsi_2((String)method.invoke(context, new Object[] {
                Integer.valueOf(mtkdoubleinfo.getSimId_2())
            }));
            method = android/telephony/TelephonyManager.getDeclaredMethod("getDeviceIdGemini", new Class[] {
                Integer.TYPE
            });
            mtkdoubleinfo.setImei_1((String)method.invoke(context, new Object[] {
                Integer.valueOf(mtkdoubleinfo.getSimId_1())
            }));
            mtkdoubleinfo.setImei_2((String)method.invoke(context, new Object[] {
                Integer.valueOf(mtkdoubleinfo.getSimId_2())
            }));
            method = android/telephony/TelephonyManager.getDeclaredMethod("getPhoneTypeGemini", new Class[] {
                Integer.TYPE
            });
            mtkdoubleinfo.setPhoneType_1(((Integer)method.invoke(context, new Object[] {
                Integer.valueOf(mtkdoubleinfo.getSimId_1())
            })).intValue());
            mtkdoubleinfo.setPhoneType_2(((Integer)method.invoke(context, new Object[] {
                Integer.valueOf(mtkdoubleinfo.getSimId_2())
            })).intValue());
            if(TextUtils.isEmpty(mtkdoubleinfo.getImsi_1()) && !TextUtils.isEmpty(mtkdoubleinfo.getImsi_2()))
                mtkdoubleinfo.setDefaultImsi(mtkdoubleinfo.getImsi_2());
            if(TextUtils.isEmpty(mtkdoubleinfo.getImsi_2()) && !TextUtils.isEmpty(mtkdoubleinfo.getImsi_1()))
                mtkdoubleinfo.setDefaultImsi(mtkdoubleinfo.getImsi_1());
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            mtkdoubleinfo.setMtkDoubleSim(false);
            return mtkdoubleinfo;
        }
        mtkdoubleinfo.setMtkDoubleSim(true);
        return mtkdoubleinfo;
    }

    public static GaotongDoubleInfo initQualcommDoubleSim(Context context)
    {
        GaotongDoubleInfo gaotongdoubleinfo = new GaotongDoubleInfo();
        gaotongdoubleinfo.setSimId_1(0);
        gaotongdoubleinfo.setSimId_2(1);
        try
        {
            Object obj = Class.forName("android.telephony.MSimTelephonyManager");
            context = ((Context) (context.getSystemService("phone_msim")));
            Method method = ((Class) (obj)).getMethod("getDeviceId", new Class[] {
                Integer.TYPE
            });
            obj = ((Class) (obj)).getMethod("getSubscriberId", new Class[] {
                Integer.TYPE
            });
            gaotongdoubleinfo.setImei_1((String)method.invoke(context, new Object[] {
                Integer.valueOf(gaotongdoubleinfo.getSimId_1())
            }));
            gaotongdoubleinfo.setImei_2((String)method.invoke(context, new Object[] {
                Integer.valueOf(gaotongdoubleinfo.getSimId_2())
            }));
            gaotongdoubleinfo.setImsi_1((String)((Method) (obj)).invoke(context, new Object[] {
                Integer.valueOf(gaotongdoubleinfo.getSimId_1())
            }));
            gaotongdoubleinfo.setImsi_2((String)((Method) (obj)).invoke(context, new Object[] {
                Integer.valueOf(gaotongdoubleinfo.getSimId_2())
            }));
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            context.printStackTrace();
            gaotongdoubleinfo.setGaotongDoubleSim(false);
            return gaotongdoubleinfo;
        }
        return gaotongdoubleinfo;
    }

    public static SingleSim initSingleSim(Context context)
    {
        SingleSim singlesim = new SingleSim();
        try
        {
            singlesim.setImsi(((TelephonyManager)context.getSystemService("phone")).getSubscriberId());
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            context.printStackTrace();
            return singlesim;
        }
        return singlesim;
    }
}
