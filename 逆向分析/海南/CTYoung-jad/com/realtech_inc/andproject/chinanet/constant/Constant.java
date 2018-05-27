// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.constant;

import com.realtech_inc.andproject.chinanet.utils.DebugLog;

public final class Constant
{
    public static final class CheckPattern extends Enum
    {

        public static CheckPattern valueOf(String s)
        {
            return (CheckPattern)Enum.valueOf(com/realtech_inc/andproject/chinanet/constant/Constant$CheckPattern, s);
        }

        public static CheckPattern[] values()
        {
            return (CheckPattern[])$VALUES.clone();
        }

        private static final CheckPattern $VALUES[];
        public static final CheckPattern BOTH;
        public static final CheckPattern MODEL;
        public static final CheckPattern SIZE;

        static 
        {
            MODEL = new CheckPattern("MODEL", 0);
            SIZE = new CheckPattern("SIZE", 1);
            BOTH = new CheckPattern("BOTH", 2);
            $VALUES = (new CheckPattern[] {
                MODEL, SIZE, BOTH
            });
        }

        private CheckPattern(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class RunMode extends Enum
    {

        public static RunMode valueOf(String s)
        {
            return (RunMode)Enum.valueOf(com/realtech_inc/andproject/chinanet/constant/Constant$RunMode, s);
        }

        public static RunMode[] values()
        {
            return (RunMode[])$VALUES.clone();
        }

        private static final RunMode $VALUES[];
        public static final RunMode HUAWEI;
        public static final RunMode ONLINE;
        public static final RunMode REALTECH;
        public static final RunMode SHENLAN;

        static 
        {
            HUAWEI = new RunMode("HUAWEI", 0);
            SHENLAN = new RunMode("SHENLAN", 1);
            REALTECH = new RunMode("REALTECH", 2);
            ONLINE = new RunMode("ONLINE", 3);
            $VALUES = (new RunMode[] {
                HUAWEI, SHENLAN, REALTECH, ONLINE
            });
        }

        private RunMode(String s, int i)
        {
            super(s, i);
        }
    }


    public Constant()
    {
    }

    private static void setChecKModeUrl(String s)
    {
        if(ucmsettime == 0)
        {
            URL_CHECKMODEL = s;
            ucmsettime++;
        }
    }

    private static void setChecKSizeUrl(String s)
    {
        if(ucssettime == 0)
        {
            URL_CHECKSIZE = s;
            ucssettime++;
        }
    }

    public static void setLogoffUrl(String s)
    {
        URL_LOGOFF = s;
        ulfsettime++;
        DebugLog.d(TAG, (new StringBuilder()).append("Reset Logon Url: '").append(s).append("' In The ").append(ulfsettime).append("s Time.").toString());
    }

    public static void setLogonUrl(String s)
    {
        URL_LOGON = s;
        ulnsettime++;
        DebugLog.d(TAG, (new StringBuilder()).append("Reset Logon Url: '").append(s).append("' In The ").append(ulnsettime).append("s Time.").toString());
    }

    private static void setShowLogonUrl(String s)
    {
        if(uslsettime == 0)
        {
            URL_SHOWLOGON = s;
            uslsettime++;
        }
    }

    public static String AD_URL = "http://ad.singlenet.cn:9090/ad_hn.html";
    public static final String CHARSET_GB2312 = "GB2312";
    public static final String CHARSET_UTF_8 = "UTF-8";
    public static final String CHINANETSSID = "CHINANET";
    public static final String ENCRYPT_KEY = "leil";
    public static final String REQ_CHECKMODEL_PARAM = "deviceTAC";
    public static final String REQ_CHECKSIZE_PARAM = "deviceSize";
    public static final String REQ_LOGOFF_PARAM1 = "uuid";
    public static final String REQ_LOGOFF_PARAM2 = "userip";
    public static final String REQ_LOGOFF_PARAM3 = "acname";
    public static final String REQ_LOGON_PARAM1 = "uuid";
    public static final String REQ_LOGON_PARAM3 = "userip";
    public static final String REQ_LOGON_PARAM4 = "username";
    public static final String REQ_LOGON_PARAM5 = "password";
    public static final String REQ_LOGON_PARAM6 = "ratingtype";
    public static final String REQ_SHOWLOGON_PARAM = "wlanuserip";
    public static final String RES_CHECKMODEL_NODENAME1 = "Messagetype";
    public static final String RES_CHECKMODEL_NODENAME2 = "ResponseCode";
    public static final String RES_CHECKSIZE_NODENAME1 = "Messagetype";
    public static final String RES_CHECKSIZE_NODENAME2 = "ResponseCode";
    public static final String RES_CHECKSIZE_NODENAME3 = "Result";
    public static final String RES_LOGOFF_NODENAME1 = "Messagetype";
    public static final String RES_LOGOFF_NODENAME2 = "ResponseCode";
    public static final String RES_LOGOFF_NODENAME3 = "Date";
    public static final String RES_LOGON_NODENAME1 = "MessageType";
    public static final String RES_LOGON_NODENAME2 = "ResponseCode";
    public static final String RES_LOGON_NODENAME3 = "LogoffURL";
    public static final String RES_LOGON_NODENAME4 = "Uuid";
    public static final String RES_LOGON_NODENAME5 = "UserIp";
    public static final String RES_SHOWLOGON_NODENAME1 = "MessageType";
    public static final String RES_SHOWLOGON_NODENAME2 = "AccessProcedure";
    public static final String RES_SHOWLOGON_NODENAME3 = "AcName";
    public static final String RES_SHOWLOGON_NODENAME4 = "UserIp";
    public static final String RES_SHOWLOGON_NODENAME5 = "LoginURL";
    public static final String RES_SHOWLOGON_NODENAME6 = "Uuid";
    public static final String RES_SHOWLOGON_NODENAME7 = "Response";
    public static final String RHD_USERAGENT = "China Telecom Client";
    public static final String SMS_GENERATE_SEED1 = "ACEBDF";
    public static final String SMS_GENERATE_SEED2 = "79DFAD8F27DAF";
    public static final String SMS_PREFIX = "MM|";
    public static final String SMS_RECEIVER = "106593005";
    private static final String TAG = com/realtech_inc/andproject/chinanet/constant/Constant.getSimpleName();
    public static String URL_CHECKMODEL = "";
    private static final String URL_CHECKMODEL_HUAWEI = "http://61.183.0.134:8080/checkmodel.do";
    private static final String URL_CHECKMODEL_ONLINE = "http://61.183.0.137:8080/checkmodel.do";
    private static final String URL_CHECKMODEL_REALTECH = "";
    private static final String URL_CHECKMODEL_SHENLAN = "http://218.75.75.91:18080/test/test.php";
    public static String URL_CHECKSIZE = "";
    private static final String URL_CHECKSIZE_HUAWEI = "http://61.183.0.134:8080/checksize.do";
    private static final String URL_CHECKSIZE_ONLINE = "http://61.183.0.137:8080/checksize.do";
    private static final String URL_CHECKSIZE_REALTECH = "";
    private static final String URL_CHECKSIZE_SHENLAN = "";
    public static String URL_GETPORTAL = "http://www.baidu.com";
    public static String URL_LOGOFF = "";
    public static String URL_LOGON = "";
    public static String URL_SHOWLOGON = "";
    private static final String URL_SHOWLOGON_HUAWEI = "http://61.183.0.134:8080/showlogin.do";
    private static final String URL_SHOWLOGON_ONLINE = "http://61.183.0.136:8880/security.do";
    private static final String URL_SHOWLOGON_REALTECH = "http://yourjam.cn/ChinaNet/RedirectReply.xml";
    private static final String URL_SHOWLOGON_SHENLAN = "";
    public static RunMode runMode;
    private static int ucmsettime = 0;
    private static int ucssettime = 0;
    private static int ulfsettime = 0;
    private static int ulnsettime = 0;
    private static int uslsettime = 0;

    static 
    {
        runMode = RunMode.ONLINE;
        if(runMode.equals(RunMode.HUAWEI))
        {
            setChecKModeUrl("http://61.183.0.134:8080/checkmodel.do");
            setChecKSizeUrl("http://61.183.0.134:8080/checksize.do");
            setShowLogonUrl("http://61.183.0.134:8080/showlogin.do");
        } else
        if(runMode.equals(RunMode.SHENLAN))
        {
            setChecKModeUrl("http://218.75.75.91:18080/test/test.php");
            setChecKSizeUrl("");
            setShowLogonUrl("");
        } else
        if(runMode.equals(RunMode.REALTECH))
        {
            setChecKModeUrl("");
            setChecKSizeUrl("");
            setShowLogonUrl("http://yourjam.cn/ChinaNet/RedirectReply.xml");
        } else
        {
            setChecKModeUrl("http://61.183.0.137:8080/checkmodel.do");
            setChecKSizeUrl("http://61.183.0.137:8080/checksize.do");
            setShowLogonUrl("http://61.183.0.136:8880/security.do");
        }
    }
}
