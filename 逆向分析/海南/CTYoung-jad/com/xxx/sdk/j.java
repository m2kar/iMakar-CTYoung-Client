// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import com.xxx.sdk.e.c;
import com.xxx.sdk.e.c.d;
import com.xxx.sdk.e.e.a;
import java.io.File;
import java.util.Arrays;
import java.util.Properties;

public final class j
{

    private j()
    {
        Properties properties;
        StringBuilder stringbuilder;
        stringbuilder = null;
        properties = null;
        super();
        g = false;
        r = 6;
        h = false;
        L = "sdk.db";
        M = "sdk-data";
        N = "none";
        Object obj1 = com/xxx/sdk/j.getClassLoader().getResourceAsStream("sdk.properties");
        Object obj = obj1;
        Object obj2 = new Properties();
        obj = obj1;
        ((Properties) (obj2)).load(((java.io.InputStream) (obj1)));
        obj = obj1;
        g = Boolean.valueOf(((Properties) (obj2)).getProperty("devMode")).booleanValue();
        obj = obj1;
        if(!g) goto _L2; else goto _L1
_L1:
        obj = obj1;
        r = Integer.valueOf(((Properties) (obj2)).getProperty("logLevel")).intValue();
        obj = obj1;
        h = Boolean.valueOf(((Properties) (obj2)).getProperty("log2file")).booleanValue();
_L5:
        obj = obj1;
        if(!(new File(com.xxx.sdk.e.e.a.B().concat("sdk.factory.unlock"))).exists())
            break MISSING_BLOCK_LABEL_172;
        obj = obj1;
        r = 1;
        obj = obj1;
        h = true;
        obj = obj1;
        L = ((Properties) (obj2)).getProperty("dbName", L);
        obj = obj1;
        M = ((Properties) (obj2)).getProperty("appName", M);
        obj = obj1;
        s = Integer.valueOf(((Properties) (obj2)).getProperty("httpConnectTimeout")).intValue();
        obj = obj1;
        t = Integer.valueOf(((Properties) (obj2)).getProperty("httpConnectRetryTimes")).intValue();
        obj = obj1;
        N = ((Properties) (obj2)).getProperty("sdkVer", N);
        obj = obj1;
        c.info("\u52A0\u8F7Dsdk.properties\u6587\u4EF6\u6210\u529F\uFF01");
        d.a(((java.io.Closeable) (obj1)));
        obj1 = properties;
        obj2 = stringbuilder;
        if(!g) goto _L4; else goto _L3
_L3:
        obj1 = properties;
        obj2 = stringbuilder;
        obj = com/xxx/sdk/j.getClassLoader().getResourceAsStream("ad-dev.properties");
_L6:
        obj1 = obj;
        obj2 = obj;
        properties = new Properties();
        obj1 = obj;
        obj2 = obj;
        properties.load(((java.io.InputStream) (obj)));
        obj1 = obj;
        obj2 = obj;
        a_java_lang_String_array1d_fld = properties.getProperty("settingsUrl", "").split(";");
        obj1 = obj;
        obj2 = obj;
        if(O != null)
            break MISSING_BLOCK_LABEL_398;
        obj1 = obj;
        obj2 = obj;
        if(P != null)
            break MISSING_BLOCK_LABEL_398;
        obj1 = obj;
        obj2 = obj;
        O = properties.getProperty("appid", "");
        obj1 = obj;
        obj2 = obj;
        P = properties.getProperty("appsecret", "");
        d.a(((java.io.Closeable) (obj)));
        c.info((new StringBuilder("Env\u73AF\u5883\u521D\u59CB\u5316\u6210\u529F\uFF0C\u8BE6\u89C1\uFF1A")).append(toString()).toString());
        return;
_L2:
        obj = obj1;
        h = false;
        obj = obj1;
        r = 5;
          goto _L5
        obj2;
_L8:
        obj = obj1;
        c.error("\u52A0\u8F7Dsdk.properties\u5931\u8D25\uFF01", ((Throwable) (obj2)));
        obj = obj1;
        throw new RuntimeException(((Throwable) (obj2)));
        obj2;
        obj1 = obj;
        obj = obj2;
_L7:
        d.a(((java.io.Closeable) (obj1)));
        throw obj;
_L4:
        obj1 = properties;
        obj2 = stringbuilder;
        obj = com/xxx/sdk/j.getClassLoader().getResourceAsStream("ad.properties");
          goto _L6
        Exception exception;
        exception;
        obj2 = obj1;
        stringbuilder = new StringBuilder("\u52A0\u8F7D");
        obj2 = obj1;
        if(g)
            obj = "ad-dev";
        else
            obj = "ad";
        obj2 = obj1;
        c.error(stringbuilder.append(((String) (obj))).append(".properties\u5931\u8D25\uFF01").toString(), exception);
        obj2 = obj1;
        throw new RuntimeException(exception);
        obj;
        d.a(((java.io.Closeable) (obj2)));
        throw obj;
        obj;
        obj1 = null;
          goto _L7
        obj2;
        obj1 = null;
          goto _L8
    }

    public static j a()
    {
        com/xxx/sdk/j;
        JVM INSTR monitorenter ;
        j j1;
        if(a_com_xxx_sdk_j_static_fld == null)
            a_com_xxx_sdk_j_static_fld = new j();
        j1 = a_com_xxx_sdk_j_static_fld;
        com/xxx/sdk/j;
        JVM INSTR monitorexit ;
        return j1;
        Exception exception;
        exception;
        throw exception;
    }

    private void y()
    {
        java.io.InputStream inputstream;
        java.io.InputStream inputstream1;
        Object obj1;
        Properties properties;
        properties = null;
        inputstream = null;
        inputstream1 = inputstream;
        obj1 = properties;
        if(!g) goto _L2; else goto _L1
_L1:
        inputstream1 = inputstream;
        obj1 = properties;
        inputstream = com/xxx/sdk/j.getClassLoader().getResourceAsStream("ad-dev.properties");
_L4:
        inputstream1 = inputstream;
        obj1 = inputstream;
        properties = new Properties();
        inputstream1 = inputstream;
        obj1 = inputstream;
        properties.load(inputstream);
        inputstream1 = inputstream;
        obj1 = inputstream;
        a_java_lang_String_array1d_fld = properties.getProperty("settingsUrl", "").split(";");
        inputstream1 = inputstream;
        obj1 = inputstream;
        if(O != null)
            break MISSING_BLOCK_LABEL_134;
        inputstream1 = inputstream;
        obj1 = inputstream;
        if(P != null)
            break MISSING_BLOCK_LABEL_134;
        inputstream1 = inputstream;
        obj1 = inputstream;
        O = properties.getProperty("appid", "");
        inputstream1 = inputstream;
        obj1 = inputstream;
        P = properties.getProperty("appsecret", "");
        d.a(inputstream);
        return;
_L2:
        inputstream1 = inputstream;
        obj1 = properties;
        inputstream = com/xxx/sdk/j.getClassLoader().getResourceAsStream("ad.properties");
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        obj1 = inputstream1;
        StringBuilder stringbuilder = new StringBuilder("\u52A0\u8F7D");
        obj1 = inputstream1;
        Object obj;
        if(g)
            obj = "ad-dev";
        else
            obj = "ad";
        obj1 = inputstream1;
        c.error(stringbuilder.append(((String) (obj))).append(".properties\u5931\u8D25\uFF01").toString(), exception);
        obj1 = inputstream1;
        throw new RuntimeException(exception);
        obj;
        d.a(((java.io.Closeable) (obj1)));
        throw obj;
    }

    public final String toString()
    {
        return (new StringBuilder("Env [devMode=")).append(g).append(", logLevel=").append(r).append(", log2file=").append(h).append(", dbName=").append(L).append(", appName=").append(M).append(", httpConnectTimeout=").append(s).append(", httpConnectRetryTimes=").append(t).append(", sdkVer=").append(N).append(", settingsUrl=").append(Arrays.toString(a_java_lang_String_array1d_fld)).append(", appid=").append(O).append(", appsecret=").append(P).append("]").toString();
    }

    public static j a_com_xxx_sdk_j_static_fld = null;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String a_java_lang_String_array1d_fld[];
    private boolean g;
    public boolean h;
    public int r;
    private int s;
    private int t;

}
