// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import com.xxx.e.k;
import com.xxx.sdk.d.i;
import com.xxx.sdk.e.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.c.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.xxx.sdk:
//            u, s, t, q, 
//            w, r, v, l

public class p
{

    public p()
    {
        b_long_fld = 0x1b7740L;
        c_long_fld = 0x44aa200L;
        d = 0x44aa200L;
        s = 5000;
        t = 1;
        j = false;
        z = 0x36ee80;
        a_java_util_List_fld = new ArrayList(0);
        a_com_xxx_sdk_u_fld = new u();
        a_com_xxx_sdk_s_fld = new s();
        a_com_xxx_sdk_t_fld = new t();
        a_com_xxx_sdk_q_fld = new q();
        a_com_xxx_sdk_v_fld = null;
        a_com_xxx_sdk_r_fld = null;
        a_com_xxx_sdk_w_fld = new w();
        b_java_util_ArrayList_fld = new ArrayList(5);
        c_java_util_ArrayList_fld = new ArrayList(5);
        b_java_util_List_fld = new ArrayList();
        A = 60;
        B = 40;
        version = 0;
    }

    private int a()
    {
        int i1 = A + B;
        if(i1 > 0)
            return (A * 100) / i1;
        else
            return 60;
    }

    public static final int a(String s1)
    {
        int i1;
        try
        {
            i1 = (new JSONObject(s1)).optInt("version");
        }
        // Misplaced declaration of an exception variable
        catch(String s1)
        {
            return 0;
        }
        return i1;
    }

    private com.xxx.sdk.c.a.c a(String s1)
    {
        if(b_java_util_List_fld == null)
            return null;
        if("exch".equals(s1))
        {
            s1 = new com.xxx.sdk.c.a.c();
            s1.V = a_com_xxx_sdk_r_fld.V;
            return s1;
        }
        for(Iterator iterator = b_java_util_List_fld.iterator(); iterator.hasNext();)
        {
            com.xxx.sdk.c.a.c c1 = (com.xxx.sdk.c.a.c)iterator.next();
            if(c1.name.equals(s1))
                return c1;
        }

        return null;
    }

    public static p a(String s1)
    {
        int i1;
        int j1;
        Object obj;
        Object obj1;
        JSONObject jsonobject;
        Object obj2;
        Object obj3;
        ArrayList arraylist;
        try
        {
            jsonobject = new JSONObject(s1);
            obj1 = jsonobject.getJSONArray("blackList");
            obj = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch(String s1)
        {
            com.xxx.sdk.e.c.a("\u52A0\u8F7Dsettings\u6216\u8005\u89E3\u6790\u5B83\u51FA\u9519\uFF01", s1);
            return null;
        }
        i1 = 0;
        if(i1 >= ((JSONArray) (obj1)).length())
            break; /* Loop/switch isn't completed */
        ((List) (obj)).add(((JSONArray) (obj1)).optString(i1));
        i1++;
        if(true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_30;
_L1:
        ((List) (obj)).addAll(c_java_util_List_static_fld);
        obj1 = new p();
        obj1.a_java_util_List_fld = ((List) (obj));
        obj1.c_long_fld = jsonobject.optLong("floatingFreq");
        obj1.d = jsonobject.optLong("launcherFreq");
        obj1.b_long_fld = jsonobject.optLong("settingsFreq");
        obj1.version = a(s1);
        obj1.C = jsonobject.optInt("switches");
        obj1.t = jsonobject.optInt("httpConnectRetryTimes", 1);
        obj1.s = jsonobject.optInt("httpConnectTimeout", 5000);
        obj1.R = jsonobject.optString("deviceInfo");
        s1 = jsonobject.optJSONObject("track");
        if(s1 == null)
            break MISSING_BLOCK_LABEL_271;
        obj1.a_com_xxx_sdk_v_fld = new v();
        ((p) (obj1)).a_com_xxx_sdk_v_fld.Z = s1.optString("show");
        ((p) (obj1)).a_com_xxx_sdk_v_fld.aa = s1.optString("click");
        ((p) (obj1)).a_com_xxx_sdk_v_fld.ab = s1.optString("open");
        i.i(s1.optInt("clock", 500));
        s1 = jsonobject.optJSONObject("cmdTask");
        if(s1 == null)
            break MISSING_BLOCK_LABEL_320;
        obj1.j = s1.optBoolean("enable");
        obj1.z = s1.optInt("freq");
        obj1.S = s1.optString("requestUrl");
        s1 = jsonobject.optJSONObject("exch");
        if(s1 == null)
            break MISSING_BLOCK_LABEL_408;
        obj1.a_com_xxx_sdk_r_fld = new r();
        ((p) (obj1)).a_com_xxx_sdk_r_fld.V = s1.optString("cid");
        ((p) (obj1)).a_com_xxx_sdk_r_fld.a = l.a(s1);
        obj = s1.optJSONObject("throwRate");
        ((p) (obj1)).a_com_xxx_sdk_r_fld.b = w.a(((JSONObject) (obj)));
        ((p) (obj1)).a_com_xxx_sdk_r_fld.clearCookies = s1.optBoolean("cleanCookie");
        s1 = jsonobject.optJSONArray("platform");
        if(s1 == null) goto _L4; else goto _L3
_L3:
        if(s1.length() <= 0) goto _L4; else goto _L5
_L5:
        ((p) (obj1)).b_java_util_List_fld.clear();
        obj1.b_java_util_List_fld = new ArrayList();
        i1 = 0;
_L9:
        if(i1 >= s1.length())
            break; /* Loop/switch isn't completed */
        obj = s1.optJSONObject(i1);
        obj2 = new com.xxx.sdk.c.a.c();
        obj2.name = ((JSONObject) (obj)).optString("name");
        obj2.V = ((JSONObject) (obj)).optString("cid");
        obj2.checksum = ((JSONObject) (obj)).optString("checksum");
        obj2.bf = ((JSONObject) (obj)).optString("url");
        obj2.bg = ((JSONObject) (obj)).optString("appKey");
        obj2.packageName = ((JSONObject) (obj)).optString("appPackage");
        obj2.M = ((JSONObject) (obj)).optString("appName");
        obj2.clearCookies = ((JSONObject) (obj)).optBoolean("cleanCookie");
        obj2.a = l.a(((JSONObject) (obj)));
        obj3 = ((JSONObject) (obj)).optJSONArray("appType");
        arraylist = new ArrayList();
        j1 = 0;
_L7:
        if(j1 >= ((JSONArray) (obj3)).length())
            break; /* Loop/switch isn't completed */
        arraylist.add(Integer.valueOf(((JSONArray) (obj3)).optInt(i1)));
        j1++;
        if(true) goto _L7; else goto _L6
_L6:
        obj2.d = arraylist;
        obj3 = ((JSONObject) (obj)).optJSONObject("weights");
        obj2.as = ((JSONObject) (obj3)).optInt("floating");
        obj2.B = ((JSONObject) (obj3)).optInt("banner");
        obj2.b = w.a(((JSONObject) (obj)).optJSONObject("throwRate"));
        ((p) (obj1)).b_java_util_List_fld.add(obj2);
        i1++;
        if(true) goto _L9; else goto _L8
_L4:
        ((p) (obj1)).b_java_util_List_fld.clear();
_L8:
        s1 = jsonobject.optJSONArray("adtype");
        if(s1 == null) goto _L11; else goto _L10
_L10:
        j1 = 0;
_L40:
        if(j1 >= s1.length()) goto _L13; else goto _L12
_L12:
        obj = s1.optJSONObject(j1);
        if(obj == null) goto _L15; else goto _L14
_L14:
        obj2 = ((JSONObject) (obj)).optString("type");
        ((String) (obj2)).hashCode();
        JVM INSTR lookupswitch 2: default 1859
    //                   -1396342996: 808
    //                   2010122246: 824;
           goto _L16 _L17 _L18
_L17:
        if(!((String) (obj2)).equals("banner")) goto _L16; else goto _L19
_L19:
        i1 = 0;
          goto _L20
_L18:
        if(!((String) (obj2)).equals("floating")) goto _L16; else goto _L21
_L21:
        i1 = 1;
          goto _L20
_L38:
        obj1.B = ((JSONObject) (obj)).optInt("weight");
          goto _L15
_L39:
        obj1.A = ((JSONObject) (obj)).optInt("weight");
          goto _L15
_L11:
        obj1.B = 4;
        obj1.A = 6;
_L13:
        ((p) (obj1)).b_java_util_ArrayList_fld.add(Integer.valueOf(0));
        ((p) (obj1)).b_java_util_ArrayList_fld.add(Integer.valueOf(0));
        ((p) (obj1)).b_java_util_ArrayList_fld.add(Integer.valueOf(0));
        ((p) (obj1)).c_java_util_ArrayList_fld.add(Integer.valueOf(0));
        ((p) (obj1)).c_java_util_ArrayList_fld.add(Integer.valueOf(0));
        ((p) (obj1)).c_java_util_ArrayList_fld.add(Integer.valueOf(0));
        s1 = jsonobject.optJSONArray("module");
        if(s1 == null) goto _L23; else goto _L22
_L22:
        j1 = 0;
_L47:
        if(j1 >= s1.length()) goto _L23; else goto _L24
_L24:
        obj = s1.optJSONObject(j1);
        if(obj == null) goto _L26; else goto _L25
_L25:
        String s2 = ((JSONObject) (obj)).optString("type");
        s2.hashCode();
        JVM INSTR lookupswitch 3: default 1891
    //                   -799212381: 1135
    //                   1874684019: 1151
    //                   1989774883: 1119;
           goto _L27 _L28 _L29 _L30
_L46:
        if(i1 < 0) goto _L26; else goto _L31
_L31:
        obj = ((JSONObject) (obj)).optJSONObject("weights");
        int k1 = ((JSONObject) (obj)).optInt("floating");
        ((p) (obj1)).b_java_util_ArrayList_fld.set(i1, Integer.valueOf(k1));
        k1 = ((JSONObject) (obj)).optInt("banner");
        ((p) (obj1)).c_java_util_ArrayList_fld.set(i1, Integer.valueOf(k1));
          goto _L26
_L30:
        if(!s2.equals("exchange")) goto _L27; else goto _L32
_L32:
        i1 = 0;
          goto _L33
_L28:
        if(!s2.equals("promotion")) goto _L27; else goto _L34
_L34:
        i1 = 1;
          goto _L33
_L29:
        if(!s2.equals("platform")) goto _L27; else goto _L35
_L35:
        i1 = 2;
          goto _L33
_L23:
        s1 = jsonobject.getJSONObject("bannerAd");
        obj1.a_com_xxx_sdk_q_fld = new q();
        ((p) (obj1)).a_com_xxx_sdk_q_fld.k = s1.getBoolean("enable");
        ((p) (obj1)).a_com_xxx_sdk_q_fld.T = s1.optString("adSpaceId");
        ((p) (obj1)).a_com_xxx_sdk_q_fld.U = s1.optString("requestUrl");
        ((p) (obj1)).a_com_xxx_sdk_q_fld.cacheUrl = s1.optString("cacheUrl");
        ((p) (obj1)).a_com_xxx_sdk_q_fld.D = s1.optInt("freq");
        com.xxx.sdk.d.d.g(s1.optInt("clock", 200));
        ((p) (obj1)).a_com_xxx_sdk_q_fld.E = s1.optInt("times");
        ((p) (obj1)).a_com_xxx_sdk_q_fld.F = s1.optInt("showDuration", 5000);
        ((p) (obj1)).a_com_xxx_sdk_q_fld.G = s1.optInt("clickDuration", 5000);
        s1 = jsonobject.getJSONObject("floatingAd");
        obj1.a_com_xxx_sdk_s_fld = new s();
        ((p) (obj1)).a_com_xxx_sdk_s_fld.k = s1.optBoolean("enable");
        ((p) (obj1)).a_com_xxx_sdk_s_fld.T = s1.optString("adSpaceId");
        ((p) (obj1)).a_com_xxx_sdk_s_fld.U = s1.optString("requestUrl");
        ((p) (obj1)).a_com_xxx_sdk_s_fld.cacheUrl = s1.optString("cacheUrl");
        ((p) (obj1)).a_com_xxx_sdk_s_fld.D = s1.optInt("freq");
        ((p) (obj1)).a_com_xxx_sdk_s_fld.E = s1.optInt("times");
        i.g(s1.optInt("clock", 200));
        ((p) (obj1)).a_com_xxx_sdk_s_fld.F = s1.optInt("showDuration", 5000);
        ((p) (obj1)).a_com_xxx_sdk_s_fld.G = s1.optInt("clickDuration", 5000);
        ((p) (obj1)).a_com_xxx_sdk_s_fld.H = s1.optInt("maxCachedNum");
        s1 = jsonobject.getJSONObject("pushAd");
        obj1.a_com_xxx_sdk_u_fld = new u();
        ((p) (obj1)).a_com_xxx_sdk_u_fld.T = s1.optString("adSpaceId");
        ((p) (obj1)).a_com_xxx_sdk_u_fld.U = s1.optString("requestUrl");
        ((p) (obj1)).a_com_xxx_sdk_u_fld.cacheUrl = s1.optString("cacheUrl");
        ((p) (obj1)).a_com_xxx_sdk_u_fld.k = s1.optBoolean("enable");
        ((p) (obj1)).a_com_xxx_sdk_u_fld.E = s1.optInt("times");
        ((p) (obj1)).a_com_xxx_sdk_u_fld.X = s1.optString("defaultTitle");
        ((p) (obj1)).a_com_xxx_sdk_u_fld.D = s1.optInt("freq");
        ((p) (obj1)).a_com_xxx_sdk_u_fld.Y = s1.optString("defaultIcon");
        obj = jsonobject.optJSONObject("promotionAd");
        s1 = ((String) (obj));
        if(obj != null) goto _L37; else goto _L36
_L36:
        s1 = jsonobject.optJSONObject("launcherAd");
_L37:
        obj1.a_com_xxx_sdk_t_fld = new t();
        ((p) (obj1)).a_com_xxx_sdk_t_fld.k = s1.optBoolean("enable");
        ((p) (obj1)).a_com_xxx_sdk_t_fld.T = s1.optString("adSpaceId");
        ((p) (obj1)).a_com_xxx_sdk_t_fld.U = s1.optString("requestUrl");
        ((p) (obj1)).a_com_xxx_sdk_t_fld.cacheUrl = s1.optString("cacheUrl");
        ((p) (obj1)).a_com_xxx_sdk_t_fld.D = s1.optInt("freq");
        ((p) (obj1)).a_com_xxx_sdk_t_fld.I = s1.optInt("unlockFreq");
        ((p) (obj1)).a_com_xxx_sdk_t_fld.J = s1.optInt("backHomeFreq");
        ((p) (obj1)).a_com_xxx_sdk_t_fld.K = s1.optInt("maxApps");
        ((p) (obj1)).a_com_xxx_sdk_t_fld.W = s1.optString("adTypes");
        s1 = s1.optJSONObject("throwRate");
        t t1 = ((p) (obj1)).a_com_xxx_sdk_t_fld;
        w.a(s1);
        com.xxx.sdk.c.a.b.a().b(((p) (obj1)).b_java_util_List_fld);
        k.a().a(((p) (obj1)));
        return ((p) (obj1));
_L16:
        i1 = -1;
_L20:
        i1;
        JVM INSTR tableswitch 0 1: default 1884
    //                   0 840
    //                   1 866;
           goto _L15 _L38 _L39
_L15:
        j1++;
          goto _L40
_L27:
        i1 = -1;
_L33:
        i1;
        JVM INSTR tableswitch 0 2: default 1920
    //                   0 1932
    //                   1 1937
    //                   2 1942;
           goto _L41 _L42 _L43 _L44
_L41:
        i1 = -1;
        if(true) goto _L46; else goto _L45
_L45:
_L26:
        j1++;
          goto _L47
_L42:
        i1 = 0;
          goto _L46
_L43:
        i1 = 1;
          goto _L46
_L44:
        i1 = 2;
          goto _L46
    }

    private ArrayList a()
    {
        return b_java_util_ArrayList_fld;
    }

    private ArrayList b()
    {
        return c_java_util_ArrayList_fld;
    }

    private boolean e()
    {
        return (C & 1) > 0;
    }

    public String toString()
    {
        return (new StringBuilder("Settings [settingsFreq=")).append(b_long_fld).append(", floatingFreq=").append(c_long_fld).append(", launcherFreq=").append(d).append(", deviceInfo=").append(R).append(", blackList=").append(a_java_util_List_fld).append(", pushAd=").append(a_com_xxx_sdk_u_fld).append(", floatingAd=").append(a_com_xxx_sdk_s_fld).append(", LauncherAd=").append(a_com_xxx_sdk_t_fld).append(", bannerAd=").append(a_com_xxx_sdk_q_fld).append(", track=").append(a_com_xxx_sdk_v_fld).append(", exch=").append(a_com_xxx_sdk_r_fld).append("]").toString();
    }

    private static String DEFAULT;
    private static List c_java_util_List_static_fld;
    private static int u = 1;
    private static int v = 0;
    private static int x = 1;
    private static int y = 2;
    int A;
    int B;
    public int C;
    public String R;
    public String S;
    public q a_com_xxx_sdk_q_fld;
    public r a_com_xxx_sdk_r_fld;
    public s a_com_xxx_sdk_s_fld;
    public t a_com_xxx_sdk_t_fld;
    public u a_com_xxx_sdk_u_fld;
    public v a_com_xxx_sdk_v_fld;
    public w a_com_xxx_sdk_w_fld;
    public List a_java_util_List_fld;
    public long b_long_fld;
    public ArrayList b_java_util_ArrayList_fld;
    public List b_java_util_List_fld;
    public long c_long_fld;
    public ArrayList c_java_util_ArrayList_fld;
    public long d;
    public boolean j;
    public int s;
    public int t;
    public int version;
    public int z;

    static 
    {
        java.io.InputStream inputstream;
        java.io.InputStream inputstream1;
        c_java_util_List_static_fld = new ArrayList();
        inputstream1 = null;
        inputstream = null;
        java.io.InputStream inputstream2 = com/xxx/sdk/p.getClassLoader().getResourceAsStream("appblack.list");
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        List list = com.xxx.sdk.e.c.d.a(inputstream2);
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        if(com.xxx.sdk.e.b.a(list)) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L3:
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        if(i1 >= list.size())
            break; /* Loop/switch isn't completed */
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        String s1 = ((String)list.get(i1)).replaceAll("//.*", "");
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        if(com.xxx.sdk.e.b.f(s1))
            break MISSING_BLOCK_LABEL_115;
        inputstream = inputstream2;
        inputstream1 = inputstream2;
        c_java_util_List_static_fld.add(s1);
        i1++;
        if(true) goto _L3; else goto _L2
_L2:
        if(inputstream2 != null)
            com.xxx.sdk.e.c.d.a(inputstream2);
_L5:
        return;
        IOException ioexception;
        ioexception;
        inputstream1 = inputstream;
        com.xxx.sdk.e.c.a("\u8BFB\u53D6appblack.list\u5931\u8D25\uFF0C\u52A0\u8F7D\u9ED1\u540D\u5355\u5931\u8D25\u3002", ioexception);
        if(inputstream == null) goto _L5; else goto _L4
_L4:
        com.xxx.sdk.e.c.d.a(inputstream);
        return;
        Exception exception;
        exception;
        if(inputstream1 != null)
            com.xxx.sdk.e.c.d.a(inputstream1);
        throw exception;
    }
}
