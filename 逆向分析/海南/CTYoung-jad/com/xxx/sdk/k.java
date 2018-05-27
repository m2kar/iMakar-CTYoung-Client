// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import android.content.Context;
import com.xxx.sdk.e.b;
import com.xxx.sdk.e.b.d;
import com.xxx.sdk.e.b.f;
import com.xxx.sdk.e.b.i;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e;
import com.xxx.sdk.e.e.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.xxx.sdk:
//            b, j, p

public abstract class k
{

    public k()
    {
    }

    public static com.xxx.sdk.e.b.b a(Context context)
    {
        i(context);
        return httpClient;
    }

    public static String a(String s, String s1)
    {
        String s2;
        if(com.xxx.sdk.e.b.f(s))
        {
            s2 = null;
        } else
        {
            s2 = s;
            if(!com.xxx.sdk.e.b.f(s1))
            {
                String as[] = s.split(";");
                String s3 = as[0];
                if(s3.indexOf("?") == -1)
                    s = s3.concat("?").concat(s1);
                else
                if(!s.endsWith("&"))
                    s = s3.concat("&").concat(s1);
                else
                    s = s3.concat(s1);
                as[0] = s;
                return com.xxx.sdk.e.b.a(com.xxx.sdk.e.b.a(as), ";");
            }
        }
        return s2;
    }

    public static String a(String s, Map map)
    {
        return a(s, map, "get", true);
    }

    private static String a(String s, Map map, String s1)
    {
        int l;
        Object obj;
label0:
        {
            if(s1 != null)
            {
                obj = map;
                if(!"get".equalsIgnoreCase(s1))
                    break label0;
            }
            s1 = URLEncodedUtils.parse(URI.create(s), "UTF-8");
            obj = map;
            if(!com.xxx.sdk.e.b.a(s1))
            {
                if(map == null)
                {
                    s = new HashMap();
                } else
                {
                    s = com.xxx.sdk.e.e.a(java/util/HashMap);
                    ((e) (s)).f.putAll(map);
                    s = ((e) (s)).f;
                }
                s1 = s1.iterator();
                while(s1.hasNext()) 
                {
                    map = (NameValuePair)s1.next();
                    obj = map.getName();
                    if(map.getValue() == null)
                        map = "";
                    else
                        map = map.getValue();
                    s.put(obj, map);
                }
                obj = s;
            }
        }
        if(com.xxx.sdk.e.b.c(((Map) (obj))))
            return "";
        try
        {
            map = (String[])((Map) (obj)).keySet().toArray(new String[0]);
            Arrays.sort(map);
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            com.xxx.sdk.e.c.a("\u751F\u6210checksum\u5931\u8D25\u3002", s);
            return "";
        }
        s = map[0];
        s = (new StringBuilder()).append(s).append("=").toString();
        s1 = (String)((Map) (obj)).get(map[0]);
        if(s1 == null) goto _L2; else goto _L1
_L1:
        s = (new StringBuilder()).append(s).append(URLEncoder.encode(s1, "UTF-8")).toString();
          goto _L2
_L8:
        if(l >= map.length) goto _L4; else goto _L3
_L3:
        s = (new StringBuilder()).append(s).append("&").toString();
        s = (new StringBuilder()).append(s).append(map[l]).toString();
        s = (new StringBuilder()).append(s).append("=").toString();
        s1 = (String)((Map) (obj)).get(map[l]);
        if(s1 == null) goto _L6; else goto _L5
_L5:
        s = (new StringBuilder()).append(s).append(URLEncoder.encode(s1, "UTF-8")).toString();
          goto _L6
_L4:
        s = (new StringBuilder()).append(s).append("|").toString();
        s = (new StringBuilder()).append(s).append(com.xxx.sdk.b.a.P).toString();
        map = com.xxx.sdk.e.b.e(s);
        com.xxx.sdk.e.c.info((new StringBuilder("\u539F\u59CB\u4E32\uFF1A")).append(s).append(", \u52A0\u5BC6\uFF1A").append(map).toString());
        return map;
_L2:
        l = 1;
        continue; /* Loop/switch isn't completed */
_L6:
        l++;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public static String a(String s, Map map, String s1, boolean flag)
    {
        int l;
        Object obj;
        String s2;
        i(null);
        obj = map;
        if(map == null)
            obj = new HashMap();
        ((Map) (obj)).putAll(trackParams);
        map = s1;
        if(com.xxx.sdk.e.b.f(s1))
            map = "get";
        s2 = a(s, ((Map) (obj)), ((String) (map)));
        l = 0;
_L3:
        if(l >= RETRY_TIME)
            break MISSING_BLOCK_LABEL_264;
        if(!"post".equalsIgnoreCase(map))
            break MISSING_BLOCK_LABEL_147;
        s1 = httpClient.c(s);
_L1:
        s1 = s1.a("sv", com.xxx.sdk.b.a.N).a("checksum", s2);
        s1.p = ((Map) (obj));
        s1 = s1.a(new int[] {
            200, 502
        }).a();
        if(((f) (s1)).statusCode == 502)
        {
            com.xxx.sdk.e.c.warn("\u670D\u52A1\u5668502(Bad gateway!)\u9519\u8BEF\uFF0C\u91CD\u65B0\u8BD5\u4E00\u6B21\u3002");
            break MISSING_BLOCK_LABEL_266;
        }
        break MISSING_BLOCK_LABEL_158;
        s1 = httpClient.a(s);
          goto _L1
        StringBuilder stringbuilder = new StringBuilder(512);
        s1.a(stringbuilder);
        s1 = stringbuilder.toString();
        return s1;
        s1;
        com.xxx.sdk.e.c.a("\u8BF7\u6C42\u6570\u636E\u5F02\u5E38\uFF01", s1);
        if(flag && a(s1.getCause()))
        {
            com.xxx.sdk.e.c.info((new StringBuilder("\u53D1\u9001")).append(map).append("\u8D85\u65F6\uFF0C\u91CD\u8BD5\u4E00\u6B21").toString());
            com.xxx.sdk.e.b.U();
            break MISSING_BLOCK_LABEL_266;
        }
        com.xxx.sdk.e.c.info((new StringBuilder("\u975E\u8D85\u65F6\u539F\u56E0\u5BFC\u81F4\u5F02\u5E38\u6216\u8005\u7A0B\u5E8F\u672C\u8EAB\u8BBE\u7F6E\u4E0D\u91CD\u8BD5\uFF0C\u672C\u6B21")).append(map).append("\u7ED3\u675F\u3002").toString());
        return null;
        l++;
        if(true) goto _L3; else goto _L2
_L2:
    }

    private static String a(String s, Map map, boolean flag)
    {
        return a(s, map, "post", flag);
    }

    public static final boolean a(Throwable throwable)
    {
        return throwable != null && (throwable instanceof SocketTimeoutException);
    }

    public static String b(String s)
    {
        return a(s, null, "post", true);
    }

    private static String b(String s, Map map)
    {
        return a(s, map, "get", false);
    }

    public static String b(Map map)
    {
        if(map == null)
            return null;
        ArrayList arraylist = new ArrayList();
        map = map.entrySet().iterator();
        do
        {
            if(!map.hasNext())
                break;
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if(!com.xxx.sdk.e.b.f((String)entry.getKey()))
                arraylist.add(((String)entry.getKey()).concat("=").concat(com.xxx.sdk.e.b.d((String)entry.getValue())));
        } while(true);
        return com.xxx.sdk.e.b.a(arraylist, "&");
    }

    public static String c(String s, Map map)
    {
        return a(s, map, "post", true);
    }

    public static boolean c(String s)
    {
        boolean flag1;
        Object obj2;
        flag1 = false;
        obj2 = null;
        i(null);
        Object obj = (new URL(s)).getHost();
        if(obj == null) goto _L2; else goto _L1
_L1:
        if(!((String) (obj)).contains("harmight.com")) goto _L2; else goto _L3
_L3:
        obj = new HashMap(trackParams);
        Object obj1;
        ((Map) (obj)).put("timestamp", String.valueOf(System.currentTimeMillis()));
        obj1 = a(s, ((Map) (obj)), "get");
_L11:
        int l = 0;
_L8:
        boolean flag = flag1;
        if(l >= RETRY_TIME) goto _L5; else goto _L4
_L4:
        try
        {
            obj2 = httpClient.a(s).a("sv", com.xxx.sdk.b.a.N);
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            com.xxx.sdk.e.c.a("\u8BF7\u6C42\u6570\u636E\u5F02\u5E38\uFF01", s);
            com.xxx.sdk.e.c.info("\u975E\u8D85\u65F6\u539F\u56E0\u5BFC\u81F4\u5F02\u5E38\uFF0C\u672C\u6B21track\u7ED3\u675F\u3002");
            return false;
        }
        if(obj1 == null)
            break MISSING_BLOCK_LABEL_123;
        ((d) (obj2)).a("checksum", ((String) (obj1)));
        if(obj == null)
            break MISSING_BLOCK_LABEL_135;
        obj2.p = ((Map) (obj));
        obj2 = ((d) (obj2)).a(new int[] {
            200, 502, 301, 302
        }).a();
        if(((f) (obj2)).statusCode != 502) goto _L7; else goto _L6
_L6:
        com.xxx.sdk.e.c.warn("\u670D\u52A1\u5668502(Bad gateway!)\u9519\u8BEF\uFF0C\u91CD\u65B0\u8BD5\u4E00\u6B21\u3002");
        l++;
          goto _L8
        obj1;
        obj = null;
_L9:
        ((MalformedURLException) (obj1)).printStackTrace();
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
_L7:
        s = new StringBuilder();
        ((f) (obj2)).a(s);
        com.xxx.sdk.e.e.a.x(s.toString());
        flag = true;
_L5:
        return flag;
        obj1;
        if(true) goto _L9; else goto _L2
_L2:
        obj = null;
        obj1 = obj2;
        if(true) goto _L11; else goto _L10
_L10:
    }

    private static String e()
    {
        i(null);
        return trackParamsStr;
    }

    private static String f()
    {
        return String.valueOf(System.currentTimeMillis());
    }

    private static String g()
    {
        Object obj = new SimpleDateFormat("yyyyMMddhhmmss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        obj = ((DateFormat) (obj)).format(calendar.getTime());
        int l = (int)(System.currentTimeMillis() % 1000L);
        return (new StringBuilder()).append(com.xxx.sdk.b.a().a().ct).append(((String) (obj))).append(String.valueOf(l)).toString();
    }

    public static String get(String s)
    {
        return a(s, null, "get", true);
    }

    private static void i(Context context)
    {
        com/xxx/sdk/k;
        JVM INSTR monitorenter ;
        com.xxx.sdk.b b1 = com.xxx.sdk.b.a();
        Context context1;
        context1 = context;
        if(context != null)
            break MISSING_BLOCK_LABEL_18;
        context1 = b1.getContext();
        int l;
        context = b1.a();
        if(((p) (context)).t <= 0)
            break MISSING_BLOCK_LABEL_104;
        l = ((p) (context)).t;
_L1:
        RETRY_TIME = l;
        CONN_TIMEOUT = ((p) (context)).s;
        if(httpClient != null)
            break MISSING_BLOCK_LABEL_114;
        context = new com.xxx.sdk.e.b.b(context1);
        httpClient = context;
        l = CONN_TIMEOUT;
        if(l >= 0)
            break MISSING_BLOCK_LABEL_109;
        throw new IllegalArgumentException((new StringBuilder("Invalid connect timeout: ")).append(l).toString());
        context;
        com/xxx/sdk/k;
        JVM INSTR monitorexit ;
        throw context;
        l = 1;
          goto _L1
        context.connectTimeout = l;
        if(trackParams == null)
        {
            context = b1.a();
            context = com.xxx.sdk.e.e.a(java/util/HashMap).a("h", com.xxx.sdk.b.a.O).a("hid", com.xxx.sdk.e.b.e(((com.xxx.sdk.e.e.f) (context)).ct)).f;
            trackParams = context;
            trackParamsStr = b(context);
        }
        com/xxx/sdk/k;
        JVM INSTR monitorexit ;
    }

    private static void init()
    {
        i(null);
    }

    private static void z()
    {
        if(httpClient != null)
            httpClient.l.clear();
    }

    public String a(String s, File file)
    {
        return a(s, file, ((String) (null)));
    }

    public String a(String s, File file, String s1)
    {
        int l;
        String s2;
        String s3;
        l = 0;
        i(null);
        if(com.xxx.sdk.e.b.f(s))
            return null;
        s3 = file.getAbsolutePath();
        file.mkdirs();
        s2 = s;
        file = s1;
        if(com.xxx.sdk.e.b.f(s1))
        {
            s2 = com.xxx.sdk.e.b.f(s);
            int i1 = s2.lastIndexOf(".");
            int j1 = s2.lastIndexOf("/");
            s = s2.substring(i1);
            if(j1 > i1)
                s = s2.substring(i1, j1 + 1);
            file = String.valueOf(s2.hashCode()).concat(s);
        }
        if(!d() && file.toLowerCase().endsWith(".apk"))
            return "";
        s3 = s3.concat(File.separator).concat(file);
        file = new File(s3);
        s = file;
        if(file.exists())
            return s3;
          goto _L1
        s1;
_L7:
        com.xxx.sdk.e.c.a("\u4E0B\u8F7D\u6587\u4EF6\u5F02\u5E38\uFF01", s1);
        file = s;
        if(s != null)
        {
            s.delete();
            file = null;
        }
        if(!a(s1.getCause())) goto _L3; else goto _L2
_L2:
        com.xxx.sdk.e.c.info("\u4E0B\u8F7D\u6587\u4EF6\u8D85\u65F6\uFF0C\u91CD\u8BD5\u4E00\u6B21");
        com.xxx.sdk.e.b.U();
        l++;
        s = file;
_L1:
        if(l >= RETRY_TIME) goto _L5; else goto _L4
_L4:
        if(s != null)
            break MISSING_BLOCK_LABEL_236;
        file = new File(s3);
        s = file;
        s.createNewFile();
        file = httpClient.a(s2).a("sv", com.xxx.sdk.b.a.N).a(new int[] {
            200
        });
        file.a = new i(new FileOutputStream(s));
        file.a();
        com.xxx.sdk.e.c.info((new StringBuilder("\u4E0B\u8F7D\u6587\u4EF6\u6210\u529F\uFF0C\u6587\u4EF6\uFF1A")).append(s3).toString());
        return s3;
_L3:
        com.xxx.sdk.e.c.info("\u975E\u8D85\u65F6\u539F\u56E0\u5BFC\u81F4\u5F02\u5E38\uFF0C\u672C\u6B21\u4E0B\u8F7D\u7ED3\u675F\u3002");
_L5:
        com.xxx.sdk.e.c.warn("\u6587\u4EF6\u4E0B\u8F7D\u5931\u8D25\uFF01");
        return null;
        s1;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public boolean d()
    {
        return true;
    }

    public static final int BUFFER_SIZE = 512;
    public static int CONN_TIMEOUT = 0;
    public static final String HTTP_GET = "get";
    public static final String HTTP_POST = "post";
    public static final int READ_TIMEOUT = 1000;
    public static final int RETRY_DELAY = 1000;
    public static int RETRY_TIME = 1;
    static com.xxx.sdk.e.b.b httpClient = null;
    static Map trackParams;
    static String trackParamsStr;

    static 
    {
        CONN_TIMEOUT = 5000;
    }
}
