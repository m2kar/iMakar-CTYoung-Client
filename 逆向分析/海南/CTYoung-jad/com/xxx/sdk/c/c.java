// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c;

import com.xxx.sdk.a;
import com.xxx.sdk.a.i;
import com.xxx.sdk.a.j;
import com.xxx.sdk.b;
import com.xxx.sdk.b.g;
import com.xxx.sdk.d;
import com.xxx.sdk.e.e;
import com.xxx.sdk.f.f;
import com.xxx.sdk.h;
import com.xxx.sdk.p;
import com.xxx.sdk.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends d
    implements a, h, Runnable
{

    public c()
    {
        a_com_xxx_sdk_b_fld = null;
        a_java_io_File_fld = null;
        a_java_util_Hashtable_fld = new Hashtable();
        a_com_xxx_sdk_a_i_fld = null;
        a_com_xxx_sdk_a_c_fld = null;
        a_com_xxx_sdk_a_j_fld = null;
        k = new AtomicBoolean(false);
        l = new AtomicBoolean(false);
    }

    private void M()
    {
        int i1;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        com.xxx.sdk.f.e e1;
        Object obj4;
        Object obj5;
        try
        {
            obj1 = a_com_xxx_sdk_b_fld.a();
            if(com.xxx.sdk.e.b.f(((p) (obj1)).a.cacheUrl))
            {
                com.xxx.sdk.e.c.warn("\u865A\u6846\u5E94\u7528\u5E7F\u544A\u7F13\u5B58\u5730\u5740\u6CA1\u6709\u8BBE\u7F6E\u3002");
                return;
            }
        }
        catch(Exception exception)
        {
            com.xxx.sdk.e.c.a("\u8BF7\u6C42\u865A\u6846\u4E0B\u8F7D\u5E7F\u544A\u4E2D\u6216\u8005\u89E3\u6790\u5E76\u4E0B\u8F7D\u5B83\u4E2D\u5F02\u5E38\u3002", exception);
            return;
        }
        obj = com.xxx.sdk.e.e.a.a(a_com_xxx_sdk_b_fld.getContext());
        obj2 = com.xxx.sdk.e.e.a.b();
        obj3 = com.xxx.sdk.e.e.a.a();
        obj3 = a(c(((p) (obj1)).a.cacheUrl, com.xxx.sdk.e.e.a(java/util/HashMap).a("sts", ((com.xxx.sdk.e.d.c) (obj2)).u).a("sfs", ((com.xxx.sdk.e.d.c) (obj2)).v).a("ets", ((com.xxx.sdk.e.d.c) (obj3)).u).a("efs", ((com.xxx.sdk.e.d.c) (obj3)).v).f));
        if(com.xxx.sdk.e.b.f(((String) (obj3)))) goto _L2; else goto _L1
_L1:
        N();
        obj1 = new ArrayList();
        obj2 = new Hashtable();
        obj3 = new JSONArray(((String) (obj3)));
        i1 = 0;
_L13:
        if(i1 >= ((JSONArray) (obj3)).length()) goto _L4; else goto _L3
_L3:
        obj4 = ((JSONArray) (obj3)).getJSONObject(i1);
        String s1 = ((JSONObject) (obj4)).optString("package");
        obj5 = new File(a_java_io_File_fld.getPath().concat(File.separator).concat(s1));
        e1 = new com.xxx.sdk.f.e();
        e1.id = ((JSONObject) (obj4)).optString("id");
        e1.mode = ((JSONObject) (obj4)).optInt("mode", 0);
        e1.remoteInstaller = ((JSONObject) (obj4)).optString("app");
        e1.inMarket = ((JSONObject) (obj4)).optBoolean("inMarket");
        e1.installer = a_java_io_File_fld.getPath().concat(File.separator).concat(s1).concat(".apk");
        e1.marketInstaller = com.xxx.sdk.e.e.a.b(a_com_xxx_sdk_b_fld.getContext(), s1);
        e1.packageName = s1;
        e1.state = 0;
        e1.updated = System.currentTimeMillis();
        s1 = (new StringBuilder("cid=")).append(((JSONObject) (obj4)).optString("id")).toString();
        e1.showUrl = a(((JSONObject) (obj4)).optString("show"), s1);
        e1.clickUrl = a(((JSONObject) (obj4)).optString("click"), s1);
        e1.installUrl = a(((JSONObject) (obj4)).optString("install"), s1);
        e1.downloadUrl = a(((JSONObject) (obj4)).optString("download"), s1);
        e1.cacheUrl = a(((JSONObject) (obj4)).optString("cache"), s1);
        e1.activateUrl = a(((JSONObject) (obj4)).optString("activate"), s1);
        e1.reactivateUrl = a(((JSONObject) (obj4)).optString("reactivate"), s1);
        e1.reactivateExpires = ((JSONObject) (obj4)).optLong("reactivateExpires");
        e1.checksum = ((JSONObject) (obj4)).optString("checksum");
        e1.expires = ((JSONObject) (obj4)).optLong("expires");
        e1.appCacheable = ((JSONObject) (obj4)).optBoolean("appCacheable", true);
        e1.netSupports = ((JSONObject) (obj4)).optInt("netSupports", 7);
        if(((JSONObject) (obj4)).has("bannerAd") && ((JSONObject) (obj4)).optJSONArray("bannerAd").length() > aq)
            e1.bannerAd = a(((JSONObject) (obj4)).optJSONArray("bannerAd").optString(aq), ((File) (obj5)));
        if(((JSONObject) (obj4)).has("floatingAd") && ((JSONObject) (obj4)).optJSONArray("floatingAd").length() > aq)
            e1.floatingAd = a(((JSONObject) (obj4)).optJSONArray("floatingAd").optString(aq), ((File) (obj5)));
        obj4 = e1.packageName;
        obj5 = (com.xxx.sdk.f.e)a_java_util_Hashtable_fld.get(obj4);
        if(obj5 == null) goto _L6; else goto _L5
_L5:
        if(((com.xxx.sdk.f.e) (obj5)).state != 2) goto _L6; else goto _L7
_L7:
        com.xxx.sdk.e.c.info((new StringBuilder("\u865A\u6846\u5E94\u7528\u5E7F\u544A\u8D44\u6E90[")).append(((String) (obj4))).append("]\u5DF2\u7ECF\u88AB\u63A8\u8350\u5B89\u88C5\u8FC7\uFF0C\u4E0D\u518D\u505A\u6FC0\u6D3B\u63A8\u5E7F, \u53EA\u505A\u4E8C\u6B21\u6FC0\u6D3B\u63A8\u5E7F\u3002").toString());
          goto _L8
_L6:
        if(((List) (obj)).contains(obj4)) goto _L8; else goto _L9
_L9:
        if(obj5 == null)
            break MISSING_BLOCK_LABEL_776;
        if(!((com.xxx.sdk.f.e) (obj5)).checksum.equals(e1.checksum))
            com.xxx.sdk.e.b.b(new String[] {
                ((com.xxx.sdk.f.e) (obj5)).installer, ((com.xxx.sdk.f.e) (obj5)).icon
            });
        if(e1.appCacheable)
            a(e1, true);
        ((Map) (obj2)).put(obj4, e1);
        ((List) (obj1)).add(new com.xxx.sdk.a.d(e1));
          goto _L8
_L4:
        exception = a_java_util_Hashtable_fld.values().iterator();
_L11:
        do
        {
            if(!exception.hasNext())
                break MISSING_BLOCK_LABEL_913;
            obj3 = (com.xxx.sdk.f.e)exception.next();
        } while(obj3 == null);
        if(((com.xxx.sdk.f.e) (obj3)).state != 2) goto _L11; else goto _L10
_L10:
        ((Map) (obj2)).put(((com.xxx.sdk.f.e) (obj3)).packageName, obj3);
        ((List) (obj1)).add(new com.xxx.sdk.a.d(((com.xxx.sdk.f.e) (obj3))));
          goto _L11
        com.xxx.sdk.e.c.info((new StringBuilder("\u65B0\u7F13\u5B58app\u63A8\u5E7F\u5185\u5BB9\uFF1A")).append(obj2).toString());
        if(a_com_xxx_sdk_a_c_fld.a("launcher", ((List) (obj1))))
        {
            a_com_xxx_sdk_a_j_fld.updated = System.currentTimeMillis();
            a_com_xxx_sdk_a_i_fld.a(a_com_xxx_sdk_a_j_fld);
            a_java_util_Hashtable_fld.clear();
            a_java_util_Hashtable_fld.putAll(((Map) (obj2)));
        }
_L2:
        return;
_L8:
        i1++;
        if(true) goto _L13; else goto _L12
_L12:
    }

    private void N()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = com.xxx.sdk.e.b.c(a_java_util_Hashtable_fld);
        if(flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        List list;
        return;
_L2:
        if(com.xxx.sdk.e.b.a(list = a_com_xxx_sdk_a_c_fld.a("launcher")))
            continue; /* Loop/switch isn't completed */
        int i1 = 0;
_L4:
        com.xxx.sdk.a.d d1;
        com.xxx.sdk.f.e e1;
        if(i1 >= list.size())
            continue; /* Loop/switch isn't completed */
        d1 = (com.xxx.sdk.a.d)list.get(i1);
        e1 = com.xxx.sdk.f.e.d(d1.ao);
        if(e1 != null)
            break MISSING_BLOCK_LABEL_101;
        com.xxx.sdk.e.c.warn((new StringBuilder("\u6B63\u5E38\u60C5\u51B5\u4E0D\u5B58\u5728\uFF0C\u65E0\u6CD5\u53CD\u5E8F\u5217\u5316\uFF0C\u4E32\u65E0\u6548\uFF0C\u95EE\u9898\u4E32\u662F\uFF1A")).append(d1.ao).toString());
        break MISSING_BLOCK_LABEL_124;
        a_java_util_Hashtable_fld.put(d1.an, e1);
        break MISSING_BLOCK_LABEL_124;
        Exception exception;
        exception;
        throw exception;
        i1++;
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L1; else goto _L5
_L5:
    }

    private com.xxx.sdk.f.e a(Map map)
    {
        if(!f())
        {
            map = null;
        } else
        {
            Object obj1 = a_com_xxx_sdk_b_fld.a();
            Object obj;
            if(map != null)
                obj = map.get("at");
            else
                obj = null;
            if(obj == null)
            {
                int j1 = ((p) (obj1)).a.K;
                if(j1 <= 0)
                {
                    com.xxx.sdk.e.c.warn("\u6700\u5927\u684C\u9762\u5E94\u7528\u63A8\u5E7F\u8BBE\u7F6E\u62100\u6216\u8005\u66F4\u5C0F\u65F6\uFF0C\u5219\u4E0D\u63A8\u5E7F\u684C\u9762\u5FEB\u6377\u65B9\u5F0F\u3002");
                    return null;
                }
                N();
                obj1 = a_java_util_Hashtable_fld.elements();
                int i1 = 0;
                do
                {
                    if(!((Enumeration) (obj1)).hasMoreElements())
                        break;
                    if(1 == ((com.xxx.sdk.f.e)((Enumeration) (obj1)).nextElement()).state)
                        i1++;
                } while(true);
                if(i1 >= j1)
                {
                    com.xxx.sdk.e.c.warn((new StringBuilder("\u5F53\u524D\u684C\u9762\u5E94\u7528\u63A8\u5E7F\u5DF2\u7ECF\u8D85\u8FC7\u4E0A\u9650")).append(j1).toString());
                    return null;
                }
            }
            obj1 = (com.xxx.sdk.f.e)a(com/xxx/sdk/f/e, map);
            if(obj1 == null)
                return null;
            map = ((Map) (obj1));
            if(obj == null)
            {
                map = ((Map) (obj1));
                if(!((com.xxx.sdk.f.e) (obj1)).parsed)
                    if(a(((com.xxx.sdk.f.e) (obj1)), false))
                    {
                        map = new com.xxx.sdk.a.d();
                        map.an = ((com.xxx.sdk.f.e) (obj1)).packageName;
                        map.ao = com.xxx.sdk.e.b.b(obj1);
                        map.am = "launcher";
                        map.status = 2;
                        a_com_xxx_sdk_a_c_fld.a("launcher", map);
                        return ((com.xxx.sdk.f.e) (obj1));
                    } else
                    {
                        return null;
                    }
            }
        }
        return map;
    }

    private com.xxx.sdk.f.e a(JSONObject jsonobject)
    {
        String s1 = jsonobject.optString("package");
        File file = new File(a_java_io_File_fld.getPath().concat(File.separator).concat(s1));
        com.xxx.sdk.f.e e1 = new com.xxx.sdk.f.e();
        e1.id = jsonobject.optString("id");
        e1.mode = jsonobject.optInt("mode", 0);
        e1.remoteInstaller = jsonobject.optString("app");
        e1.inMarket = jsonobject.optBoolean("inMarket");
        e1.installer = a_java_io_File_fld.getPath().concat(File.separator).concat(s1).concat(".apk");
        e1.marketInstaller = com.xxx.sdk.e.e.a.b(a_com_xxx_sdk_b_fld.getContext(), s1);
        e1.packageName = s1;
        e1.state = 0;
        e1.updated = System.currentTimeMillis();
        s1 = (new StringBuilder("cid=")).append(jsonobject.optString("id")).toString();
        e1.showUrl = a(jsonobject.optString("show"), s1);
        e1.clickUrl = a(jsonobject.optString("click"), s1);
        e1.installUrl = a(jsonobject.optString("install"), s1);
        e1.downloadUrl = a(jsonobject.optString("download"), s1);
        e1.cacheUrl = a(jsonobject.optString("cache"), s1);
        e1.activateUrl = a(jsonobject.optString("activate"), s1);
        e1.reactivateUrl = a(jsonobject.optString("reactivate"), s1);
        e1.reactivateExpires = jsonobject.optLong("reactivateExpires");
        e1.checksum = jsonobject.optString("checksum");
        e1.expires = jsonobject.optLong("expires");
        e1.appCacheable = jsonobject.optBoolean("appCacheable", true);
        e1.netSupports = jsonobject.optInt("netSupports", 7);
        if(jsonobject.has("bannerAd") && jsonobject.optJSONArray("bannerAd").length() > aq)
            e1.bannerAd = a(jsonobject.optJSONArray("bannerAd").optString(aq), file);
        if(jsonobject.has("floatingAd") && jsonobject.optJSONArray("floatingAd").length() > aq)
            e1.floatingAd = a(jsonobject.optJSONArray("floatingAd").optString(aq), file);
        return e1;
    }

    private static String a(Object obj)
    {
        if(obj == null)
            return null;
        if(obj.equals(com/xxx/sdk/f/c))
            return "banner";
        if(obj.equals(com/xxx/sdk/f/d))
            return "floating";
        if(obj.equals(com/xxx/sdk/f/f))
            return "push";
        if(obj.equals(com/xxx/sdk/f/e))
            return "shortcut";
        else
            return obj.toString();
    }

    private boolean a(com.xxx.sdk.f.e e1, boolean flag)
    {
label0:
        {
            String s2 = e1.installer;
            String s1 = s2;
            if(!(new File(s2)).exists())
            {
                if(!flag)
                    break label0;
                if(!com.xxx.sdk.e.e.a.d(a_com_xxx_sdk_b_fld.getContext()))
                    return false;
                s1 = a(e1.remoteInstaller, a_java_io_File_fld, e1.packageName.concat(".apk"));
                if(com.xxx.sdk.e.b.f(s1) || !com.xxx.sdk.e.b.b(s1, e1.checksum) || !e1.packageName.equals(com.xxx.sdk.e.e.a.p(s1)))
                {
                    com.xxx.sdk.e.b.b(new String[] {
                        s1
                    });
                    return false;
                }
                e1.cached = 1;
                com.xxx.sdk.f.a.b(((com.xxx.sdk.f.a) (e1)).cacheUrl, null);
            }
            if(!e1.parsed)
            {
                String as[] = com.xxx.sdk.e.e.a.a(s1, a_java_io_File_fld.getPath().concat(File.separator).concat(e1.packageName).concat(File.separator));
                if(as != null)
                {
                    e1.title = as[1];
                    e1.icon = as[2];
                    e1.parsed = true;
                    return true;
                } else
                {
                    com.xxx.sdk.e.c.warn("\u4E0B\u8F7D\u5B89\u88C5\u5305\u4E0D\u5B8C\u6574\u5220\u9664\u5B83\u3002");
                    com.xxx.sdk.e.b.b(new String[] {
                        s1
                    });
                    return false;
                }
            } else
            {
                return true;
            }
        }
        return false;
    }

    private boolean e(String s1)
    {
        while(!f() || com.xxx.sdk.e.b.f(s1) || a_com_xxx_sdk_b_fld.a().a.W.indexOf(s1) < 0) 
            return false;
        return true;
    }

    private boolean f()
    {
        if(l.getAndSet(true))
            return true;
        a_com_xxx_sdk_b_fld = com.xxx.sdk.b.a();
        boolean flag = com.xxx.sdk.e.e.a.i(a_com_xxx_sdk_b_fld.getContext());
        String s1;
        if(flag)
            s1 = com.xxx.sdk.e.e.a.B();
        else
            s1 = a_com_xxx_sdk_b_fld.d();
        if(com.xxx.sdk.e.b.f(s1))
        {
            com.xxx.sdk.e.c.warn("\uFF33\uFF24\u5361\u4E0D\u5B58\u5728\u6216\u8005\u65E0\u6743\u8BFB\u5199\uFF0C\u6CA1\u6CD5\u7F13\u5B58");
            return false;
        }
        if(a_java_io_File_fld == null)
            if(flag)
                a_java_io_File_fld = new File(s1.concat(File.separator).concat("AppStore"));
            else
                a_java_io_File_fld = new File(s1.concat(String.valueOf(com/xxx/sdk/f/e.getSimpleName().hashCode())));
        a_java_io_File_fld.mkdirs();
        a_com_xxx_sdk_a_i_fld = new i(a_com_xxx_sdk_b_fld.getContext());
        if(a_com_xxx_sdk_a_j_fld == null)
            a_com_xxx_sdk_a_j_fld = a_com_xxx_sdk_a_i_fld.a("launcher_ad");
        a_com_xxx_sdk_a_c_fld = new com.xxx.sdk.a.c(a_com_xxx_sdk_b_fld.getContext());
        aq = com.xxx.sdk.e.e.e.a(a_com_xxx_sdk_b_fld.a().b.density);
        return true;
    }

    public final com.xxx.sdk.f.a a(Class class1, Map map)
    {
        if(!f())
            return null;
        if(a(map))
            return null;
        if(com.xxx.sdk.e.b.c(map) || !map.containsKey("at")) goto _L2; else goto _L1
_L1:
        map = ((Map) (map.get("at")));
        if(map == null) goto _L2; else goto _L3
_L3:
        if(com.xxx.sdk.e.b.f(map.toString())) goto _L2; else goto _L4
_L7:
        boolean flag;
        boolean flag1;
        int i1;
        Object obj;
        Object obj1;
        Object obj2;
        Iterator iterator;
        if(f() && !com.xxx.sdk.e.b.f(map) && a_com_xxx_sdk_b_fld.a().a.W.indexOf(map) >= 0)
            flag = true;
        else
            flag = false;
        if(flag) goto _L6; else goto _L5
_L5:
        com.xxx.sdk.e.c.info((new StringBuilder("\u5E94\u7528\u63A8\u5E7F\u4E0D\u652F\u6301\u8BE5\u5E7F\u544A\u5F62\u5F0F\uFF3B")).append(map).append("\uFF3D").toString());
        return null;
_L34:
        if(!map.equals(com/xxx/sdk/f/c))
            break MISSING_BLOCK_LABEL_149;
        map = "banner";
          goto _L7
        if(!map.equals(com/xxx/sdk/f/d))
            break MISSING_BLOCK_LABEL_166;
        map = "floating";
          goto _L7
        if(!map.equals(com/xxx/sdk/f/f))
            break MISSING_BLOCK_LABEL_183;
        map = "push";
          goto _L7
        if(!map.equals(com/xxx/sdk/f/e))
            break MISSING_BLOCK_LABEL_199;
        map = "shortcut";
          goto _L7
        map = map.toString();
          goto _L7
_L6:
        obj = a_com_xxx_sdk_b_fld.a();
        if(((p) (obj)).a.k)
            break MISSING_BLOCK_LABEL_235;
        com.xxx.sdk.e.c.warn("\u5E94\u7528\u63A8\u5E7F\u88AB\u7CFB\u7EDF\u5173\u95ED\u3002");
        return null;
        N();
        if(a_java_io_File_fld != null && a_java_util_Hashtable_fld != null && !a_java_util_Hashtable_fld.isEmpty())
            break MISSING_BLOCK_LABEL_271;
        com.xxx.sdk.e.c.info("\u6CA1\u6709\u5916\u90E8\u5B58\u50A8\u8BBE\u5907\u6216\u8005\u7F13\u5B58\u4E2D\u6CA1\u6709\u5E7F\u544A\uFF0C\u8FD4\u56DE\u7A7A\u5E7F\u544A\u3002");
        return null;
        if("banner".equals(map) || "floating".equals(map) || "push".equals(map))
            flag = true;
        else
            flag = false;
        if("home".equals(map) || "unlock".equals(map))
            flag1 = true;
        else
            flag1 = false;
        obj1 = com.xxx.sdk.e.e.a.b();
        obj2 = com.xxx.sdk.e.e.a.a();
        map = "";
        if(!flag)
            break MISSING_BLOCK_LABEL_417;
        map = c(((p) (obj)).a.U, com.xxx.sdk.e.e.a(java/util/HashMap).a("net", String.valueOf(com.xxx.sdk.b.d.j())).a("sts", ((com.xxx.sdk.e.d.c) (obj1)).u).a("sfs", ((com.xxx.sdk.e.d.c) (obj1)).v).a("ets", ((com.xxx.sdk.e.d.c) (obj2)).u).a("efs", ((com.xxx.sdk.e.d.c) (obj2)).v).f);
        if(com.xxx.sdk.e.b.f(map)) goto _L9; else goto _L8
_L8:
        obj2 = new JSONArray(map);
        if(((JSONArray) (obj2)).length() <= 0) goto _L9; else goto _L10
_L10:
        i1 = 0;
        obj1 = null;
_L36:
        obj = obj1;
        if(i1 >= ((JSONArray) (obj2)).length()) goto _L12; else goto _L11
_L11:
        obj = ((JSONArray) (obj2)).getString(i1);
        iterator = a_java_util_Hashtable_fld.values().iterator();
_L14:
        map = ((Map) (obj1));
        if(!iterator.hasNext())
            break; /* Loop/switch isn't completed */
        map = (com.xxx.sdk.f.e)iterator.next();
        if(!((com.xxx.sdk.f.e) (map)).id.equals(obj)) goto _L14; else goto _L13
_L13:
        if(!flag)
            break MISSING_BLOCK_LABEL_573;
        if(2 != ((com.xxx.sdk.f.e) (map)).state && (com.xxx.sdk.e.b.f(((com.xxx.sdk.f.e) (map)).installer) || !(new File(((com.xxx.sdk.f.e) (map)).installer)).exists()) && !com.xxx.sdk.b.d.check(((com.xxx.sdk.f.e) (map)).netSupports)) goto _L14; else goto _L15
_L15:
        break; /* Loop/switch isn't completed */
        if(!flag1)
            continue; /* Loop/switch isn't completed */
        if(!((com.xxx.sdk.f.e) (map)).inMarket || ((com.xxx.sdk.f.e) (map)).state == 2 || com.xxx.sdk.e.b.f(((com.xxx.sdk.f.e) (map)).installer) || !(new File(((com.xxx.sdk.f.e) (map)).installer)).exists()) goto _L14; else goto _L16
_L16:
        break; /* Loop/switch isn't completed */
        if(((com.xxx.sdk.f.e) (map)).state == 2 || ((com.xxx.sdk.f.e) (map)).state == 1 || com.xxx.sdk.e.b.f(((com.xxx.sdk.f.e) (map)).installer) || !(new File(((com.xxx.sdk.f.e) (map)).installer)).exists()) goto _L14; else goto _L17
_L12:
        map = ((Map) (obj));
        if(obj != null) goto _L19; else goto _L18
_L18:
        com.xxx.sdk.e.c.warn("\u6CA1\u6709\u62FF\u5230\u5408\u9002\u7684\u5E7F\u544A\uFF0C\u5BFB\u627Ecrazy\u6A21\u5F0F\u7684\u5E7F\u544A\u64AD\u653E\uFF0C\u6B64\u72B6\u51B5\u53EA\u505A\u6FC0\u6D3B\u3002");
        obj1 = a_java_util_Hashtable_fld.values().iterator();
_L22:
        map = ((Map) (obj));
        if(!((Iterator) (obj1)).hasNext()) goto _L19; else goto _L20
_L20:
        map = (com.xxx.sdk.f.e)((Iterator) (obj1)).next();
        if(((com.xxx.sdk.f.e) (map)).mode != 1 || ((com.xxx.sdk.f.e) (map)).state == 2 || com.xxx.sdk.e.b.f(((com.xxx.sdk.f.e) (map)).installer) || !(new File(((com.xxx.sdk.f.e) (map)).installer)).exists()) goto _L22; else goto _L21
_L21:
        if(!flag) goto _L23; else goto _L19
_L19:
        if(map == null) goto _L25; else goto _L24
_L24:
        obj1 = com.xxx.sdk.e.e.a.a(com.xxx.sdk.b.a().getContext());
        obj = new com.xxx.sdk.b.h();
        obj.a = com.xxx.sdk.b.i.app;
        if(2 != ((com.xxx.sdk.f.e) (map)).state || !((List) (obj1)).contains(((com.xxx.sdk.f.e) (map)).packageName)) goto _L27; else goto _L26
_L26:
        obj.protocol = ((com.xxx.sdk.f.e) (map)).packageName;
_L31:
        obj1 = map.E();
        if(!class1.equals(com/xxx/sdk/f/c)) goto _L29; else goto _L28
_L28:
        if(com.xxx.sdk.e.b.f(((com.xxx.sdk.f.e) (map)).bannerAd))
            break MISSING_BLOCK_LABEL_1448;
        com.xxx.sdk.f.c c1 = new com.xxx.sdk.f.c();
        c1.id = ((com.xxx.sdk.f.e) (map)).id;
        c1.resource = new com.xxx.sdk.b.f();
        c1.resource.a = g.image;
        c1.resource.n = true;
        c1.resource.ba = ((com.xxx.sdk.f.e) (map)).bannerAd;
        c1.target = ((com.xxx.sdk.b.h) (obj));
        c1.showUrl = com.xxx.sdk.f.e.a(((com.xxx.sdk.f.e) (map)).showUrl, ((String) (obj1)));
        c1.clickUrl = com.xxx.sdk.f.e.a(((com.xxx.sdk.f.e) (map)).clickUrl, ((String) (obj1)));
        class1 = (com.xxx.sdk.f.a)class1.cast(c1);
_L32:
        com.xxx.sdk.e.c.info((new StringBuilder("\u8BF7\u6C42\u5230\u5E94\u7528\u63A8\u5E7F\u5E7F\u544A\u5185\u5BB9\uFF3B")).append(map).append("]\uFF0C\u8F6C\u6362\u6210\u5BF9\u5E94\u8BF7\u6C42\u5E7F\u544A\u5185\u5BB9\uFF3B").append(class1).append("\uFF3D").toString());
        return class1;
_L25:
        try
        {
            com.xxx.sdk.e.c.info("\u6CA1\u6709\u8BF7\u6C42\u5230\u5E94\u7528\u63A8\u5E7F\u5E7F\u544A");
        }
        // Misplaced declaration of an exception variable
        catch(Class class1)
        {
            com.xxx.sdk.e.c.a("\u8BF7\u6C42\u5E94\u7528\u63A8\u5E7F\u4E2D\u6216\u8005\u89E3\u6790\u5B83\u5F02\u5E38\u3002", class1);
        }
        return null;
_L23:
        if(!flag1)
            continue; /* Loop/switch isn't completed */
        if(!((com.xxx.sdk.f.e) (map)).inMarket) goto _L30; else goto _L19
_L30:
        break; /* Loop/switch isn't completed */
        if(((com.xxx.sdk.f.e) (map)).state == 1) goto _L22; else goto _L19
_L27:
        obj.protocol = ((com.xxx.sdk.f.e) (map)).installer;
        obj.bb = ((com.xxx.sdk.f.e) (map)).remoteInstaller;
          goto _L31
_L29:
label0:
        {
            if(!class1.equals(com/xxx/sdk/f/d))
                break label0;
            if(com.xxx.sdk.e.b.f(((com.xxx.sdk.f.e) (map)).floatingAd))
                break MISSING_BLOCK_LABEL_1448;
            obj3 = new com.xxx.sdk.f.d();
            obj3.id = ((com.xxx.sdk.f.e) (map)).id;
            obj3.resource = new com.xxx.sdk.b.f();
            ((com.xxx.sdk.f.d) (obj3)).resource.a = g.image;
            ((com.xxx.sdk.f.d) (obj3)).resource.n = true;
            ((com.xxx.sdk.f.d) (obj3)).resource.ba = ((com.xxx.sdk.f.e) (map)).floatingAd;
            obj3.target = ((com.xxx.sdk.b.h) (obj));
            obj3.showUrl = com.xxx.sdk.f.e.a(((com.xxx.sdk.f.e) (map)).showUrl, ((String) (obj1)));
            obj3.clickUrl = com.xxx.sdk.f.e.a(((com.xxx.sdk.f.e) (map)).clickUrl, ((String) (obj1)));
            class1 = (com.xxx.sdk.f.a)class1.cast(obj3);
        }
          goto _L32
label1:
        {
            if(!class1.equals(com/xxx/sdk/f/f))
                break label1;
            if(com.xxx.sdk.e.b.f(((com.xxx.sdk.f.e) (map)).bannerAd))
                break MISSING_BLOCK_LABEL_1448;
            obj3 = new f();
            obj3.id = ((com.xxx.sdk.f.e) (map)).id;
            obj3.pushId = ((com.xxx.sdk.f.e) (map)).remoteInstaller.hashCode();
            obj3.title = ((com.xxx.sdk.f.e) (map)).title;
            obj3.icon = ((com.xxx.sdk.f.e) (map)).icon;
            obj3.resource = new com.xxx.sdk.b.f();
            ((f) (obj3)).resource.a = g.image;
            ((f) (obj3)).resource.n = true;
            ((f) (obj3)).resource.ba = ((com.xxx.sdk.f.e) (map)).bannerAd;
            obj3.target = ((com.xxx.sdk.b.h) (obj));
            obj3.showUrl = com.xxx.sdk.f.e.a(((com.xxx.sdk.f.e) (map)).showUrl, ((String) (obj1)));
            obj3.clickUrl = com.xxx.sdk.f.e.a(((com.xxx.sdk.f.e) (map)).clickUrl, ((String) (obj1)));
            class1 = (com.xxx.sdk.f.a)class1.cast(obj3);
        }
          goto _L32
        if(!class1.equals(com/xxx/sdk/f/e))
            break MISSING_BLOCK_LABEL_1448;
        class1 = (com.xxx.sdk.f.a)class1.cast(map);
          goto _L32
_L2:
        map = class1;
_L4:
        if(map != null) goto _L34; else goto _L33
_L33:
        map = null;
          goto _L7
_L17:
        obj = map;
        if(map != null) goto _L12; else goto _L35
_L35:
        i1++;
        obj1 = map;
          goto _L36
_L9:
        obj = null;
          goto _L12
        class1 = null;
          goto _L32
    }

    public final com.xxx.sdk.f.a a(Map map)
    {
        if(!f())
        {
            map = null;
        } else
        {
            Object obj1 = a_com_xxx_sdk_b_fld.a();
            Object obj;
            if(map != null)
                obj = map.get("at");
            else
                obj = null;
            if(obj == null)
            {
                int j1 = ((p) (obj1)).a.K;
                if(j1 <= 0)
                {
                    com.xxx.sdk.e.c.warn("\u6700\u5927\u684C\u9762\u5E94\u7528\u63A8\u5E7F\u8BBE\u7F6E\u62100\u6216\u8005\u66F4\u5C0F\u65F6\uFF0C\u5219\u4E0D\u63A8\u5E7F\u684C\u9762\u5FEB\u6377\u65B9\u5F0F\u3002");
                    return null;
                }
                N();
                obj1 = a_java_util_Hashtable_fld.elements();
                int i1 = 0;
                do
                {
                    if(!((Enumeration) (obj1)).hasMoreElements())
                        break;
                    if(1 == ((com.xxx.sdk.f.e)((Enumeration) (obj1)).nextElement()).state)
                        i1++;
                } while(true);
                if(i1 >= j1)
                {
                    com.xxx.sdk.e.c.warn((new StringBuilder("\u5F53\u524D\u684C\u9762\u5E94\u7528\u63A8\u5E7F\u5DF2\u7ECF\u8D85\u8FC7\u4E0A\u9650")).append(j1).toString());
                    return null;
                }
            }
            obj1 = (com.xxx.sdk.f.e)a(com/xxx/sdk/f/e, map);
            if(obj1 == null)
                return null;
            map = ((Map) (obj1));
            if(obj == null)
            {
                map = ((Map) (obj1));
                if(!((com.xxx.sdk.f.e) (obj1)).parsed)
                    if(a(((com.xxx.sdk.f.e) (obj1)), false))
                    {
                        map = new com.xxx.sdk.a.d();
                        map.an = ((com.xxx.sdk.f.e) (obj1)).packageName;
                        map.ao = com.xxx.sdk.e.b.b(obj1);
                        map.am = "launcher";
                        map.status = 2;
                        a_com_xxx_sdk_a_c_fld.a("launcher", map);
                        return ((com.xxx.sdk.f.a) (obj1));
                    } else
                    {
                        return null;
                    }
            }
        }
        return map;
    }

    public final com.xxx.sdk.f.e b(String s1)
    {
        if(f())
        {
            if(a_java_util_Hashtable_fld != null && a_java_util_Hashtable_fld.containsKey(s1))
                return (com.xxx.sdk.f.e)a_java_util_Hashtable_fld.get(s1);
            s1 = a_com_xxx_sdk_a_c_fld.a("launcher", s1);
            if(s1 != null && !com.xxx.sdk.e.b.f(((com.xxx.sdk.a.d) (s1)).ao))
                return com.xxx.sdk.f.e.d(((com.xxx.sdk.a.d) (s1)).ao);
        }
        return null;
    }

    public final com.xxx.sdk.f.e c(String s1)
    {
        Object obj;
        obj = null;
        break MISSING_BLOCK_LABEL_3;
_L2:
        do
            return null;
        while(com.xxx.sdk.e.b.f(s1) || !f());
        String s2;
        s2 = s1.trim().replaceFirst("http://", "").replaceFirst(".apk", "");
        s1 = b(s2);
        if(s1 == null)
            break; /* Loop/switch isn't completed */
        if(com.xxx.sdk.e.e.a.a(a_com_xxx_sdk_b_fld.getContext()).contains(s2)) goto _L2; else goto _L1
_L1:
        boolean flag = (new File(((com.xxx.sdk.f.e) (s1)).installer)).exists();
        if(!flag) goto _L2; else goto _L3
_L3:
        return s1;
        Exception exception;
        exception;
        s1 = obj;
_L5:
        com.xxx.sdk.e.c.a("\u67E5\u627E\u684C\u9762\u63A8\u5E7F\u4FE1\u606F\u5931\u8D25\u3002", exception);
        return s1;
        exception;
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected final boolean d()
    {
        android.content.Context context = com.xxx.sdk.b.a().getContext();
        if(context == null)
        {
            com.xxx.sdk.e.c.warn("AdManager\u4E2Dcontext\u5BF9\u8C61\u4E3Anull,\u7CFB\u7EDF\u5F02\u5E38\u3002");
            return false;
        } else
        {
            return com.xxx.sdk.e.e.a.d(context);
        }
    }

    public final void onDestroy()
    {
    }

    public final void r()
    {
        if(!f())
            return;
        if(a_java_io_File_fld == null)
        {
            com.xxx.sdk.e.c.warn("\uFF33\uFF24\u5361\u4E0D\u5B58\u5728\u6216\u8005\u65E0\u6743\u8BFB\u5199\uFF0C\u6CA1\u6CD5\u7F13\u5B58");
            return;
        }
        if(a_com_xxx_sdk_a_j_fld.updated == 0L)
        {
            (new Thread(this)).start();
            return;
        } else
        {
            s();
            return;
        }
    }

    public void run()
    {
        if(!a_com_xxx_sdk_b_fld.a().a.k)
        {
            com.xxx.sdk.e.c.warn("\u865A\u6846\u5E94\u7528\u5E7F\u544A\u88AB\u7CFB\u7EDF\u5173\u95ED\u3002");
            return;
        }
        if(!k.compareAndSet(false, true)) goto _L2; else goto _L1
_L1:
        Object obj1 = a_com_xxx_sdk_b_fld.a();
        if(!com.xxx.sdk.e.b.f(((p) (obj1)).a.cacheUrl)) goto _L4; else goto _L3
_L3:
        com.xxx.sdk.e.c.warn("\u865A\u6846\u5E94\u7528\u5E7F\u544A\u7F13\u5B58\u5730\u5740\u6CA1\u6709\u8BBE\u7F6E\u3002");
_L6:
        k.set(false);
        return;
_L4:
        Object obj;
        Object obj2;
        obj = com.xxx.sdk.e.e.a.a(a_com_xxx_sdk_b_fld.getContext());
        com.xxx.sdk.e.d.c c1 = com.xxx.sdk.e.e.a.b();
        obj2 = com.xxx.sdk.e.e.a.a();
        obj2 = a(c(((p) (obj1)).a.cacheUrl, com.xxx.sdk.e.e.a(java/util/HashMap).a("sts", c1.u).a("sfs", c1.v).a("ets", ((com.xxx.sdk.e.d.c) (obj2)).u).a("efs", ((com.xxx.sdk.e.d.c) (obj2)).v).f));
        if(com.xxx.sdk.e.b.f(((String) (obj2)))) goto _L6; else goto _L5
_L5:
        Hashtable hashtable;
        N();
        obj1 = new ArrayList();
        hashtable = new Hashtable();
        obj2 = new JSONArray(((String) (obj2)));
        int i1 = 0;
_L9:
        com.xxx.sdk.f.e e1;
        Object obj3;
        Object obj4;
        if(i1 >= ((JSONArray) (obj2)).length())
            break MISSING_BLOCK_LABEL_877;
        obj3 = ((JSONArray) (obj2)).getJSONObject(i1);
        String s1 = ((JSONObject) (obj3)).optString("package");
        obj4 = new File(a_java_io_File_fld.getPath().concat(File.separator).concat(s1));
        e1 = new com.xxx.sdk.f.e();
        e1.id = ((JSONObject) (obj3)).optString("id");
        e1.mode = ((JSONObject) (obj3)).optInt("mode", 0);
        e1.remoteInstaller = ((JSONObject) (obj3)).optString("app");
        e1.inMarket = ((JSONObject) (obj3)).optBoolean("inMarket");
        e1.installer = a_java_io_File_fld.getPath().concat(File.separator).concat(s1).concat(".apk");
        e1.marketInstaller = com.xxx.sdk.e.e.a.b(a_com_xxx_sdk_b_fld.getContext(), s1);
        e1.packageName = s1;
        e1.state = 0;
        e1.updated = System.currentTimeMillis();
        s1 = (new StringBuilder("cid=")).append(((JSONObject) (obj3)).optString("id")).toString();
        e1.showUrl = a(((JSONObject) (obj3)).optString("show"), s1);
        e1.clickUrl = a(((JSONObject) (obj3)).optString("click"), s1);
        e1.installUrl = a(((JSONObject) (obj3)).optString("install"), s1);
        e1.downloadUrl = a(((JSONObject) (obj3)).optString("download"), s1);
        e1.cacheUrl = a(((JSONObject) (obj3)).optString("cache"), s1);
        e1.activateUrl = a(((JSONObject) (obj3)).optString("activate"), s1);
        e1.reactivateUrl = a(((JSONObject) (obj3)).optString("reactivate"), s1);
        e1.reactivateExpires = ((JSONObject) (obj3)).optLong("reactivateExpires");
        e1.checksum = ((JSONObject) (obj3)).optString("checksum");
        e1.expires = ((JSONObject) (obj3)).optLong("expires");
        e1.appCacheable = ((JSONObject) (obj3)).optBoolean("appCacheable", true);
        e1.netSupports = ((JSONObject) (obj3)).optInt("netSupports", 7);
        if(((JSONObject) (obj3)).has("bannerAd") && ((JSONObject) (obj3)).optJSONArray("bannerAd").length() > aq)
            e1.bannerAd = a(((JSONObject) (obj3)).optJSONArray("bannerAd").optString(aq), ((File) (obj4)));
        if(((JSONObject) (obj3)).has("floatingAd") && ((JSONObject) (obj3)).optJSONArray("floatingAd").length() > aq)
            e1.floatingAd = a(((JSONObject) (obj3)).optJSONArray("floatingAd").optString(aq), ((File) (obj4)));
        obj3 = e1.packageName;
        obj4 = (com.xxx.sdk.f.e)a_java_util_Hashtable_fld.get(obj3);
        if(obj4 == null)
            break MISSING_BLOCK_LABEL_764;
        if(((com.xxx.sdk.f.e) (obj4)).state == 2)
        {
            com.xxx.sdk.e.c.info((new StringBuilder("\u865A\u6846\u5E94\u7528\u5E7F\u544A\u8D44\u6E90[")).append(((String) (obj3))).append("]\u5DF2\u7ECF\u88AB\u63A8\u8350\u5B89\u88C5\u8FC7\uFF0C\u4E0D\u518D\u505A\u6FC0\u6D3B\u63A8\u5E7F, \u53EA\u505A\u4E8C\u6B21\u6FC0\u6D3B\u63A8\u5E7F\u3002").toString());
            break MISSING_BLOCK_LABEL_1041;
        }
        if(((List) (obj)).contains(obj3))
            break MISSING_BLOCK_LABEL_1041;
        if(obj4 == null)
            break MISSING_BLOCK_LABEL_819;
        if(!((com.xxx.sdk.f.e) (obj4)).checksum.equals(e1.checksum))
            com.xxx.sdk.e.b.b(new String[] {
                ((com.xxx.sdk.f.e) (obj4)).installer, ((com.xxx.sdk.f.e) (obj4)).icon
            });
        Exception exception;
        if(e1.appCacheable)
            a(e1, true);
        hashtable.put(obj3, e1);
        ((List) (obj1)).add(new com.xxx.sdk.a.d(e1));
        break MISSING_BLOCK_LABEL_1041;
        exception = a_java_util_Hashtable_fld.values().iterator();
_L8:
        do
        {
            if(!exception.hasNext())
                break MISSING_BLOCK_LABEL_958;
            obj2 = (com.xxx.sdk.f.e)exception.next();
        } while(obj2 == null);
        if(((com.xxx.sdk.f.e) (obj2)).state == 2)
        {
            hashtable.put(((com.xxx.sdk.f.e) (obj2)).packageName, obj2);
            ((List) (obj1)).add(new com.xxx.sdk.a.d(((com.xxx.sdk.f.e) (obj2))));
        }
        if(true) goto _L8; else goto _L7
_L7:
        try
        {
            com.xxx.sdk.e.c.info((new StringBuilder("\u65B0\u7F13\u5B58app\u63A8\u5E7F\u5185\u5BB9\uFF1A")).append(hashtable).toString());
            if(a_com_xxx_sdk_a_c_fld.a("launcher", ((List) (obj1))))
            {
                a_com_xxx_sdk_a_j_fld.updated = System.currentTimeMillis();
                a_com_xxx_sdk_a_i_fld.a(a_com_xxx_sdk_a_j_fld);
                a_java_util_Hashtable_fld.clear();
                a_java_util_Hashtable_fld.putAll(hashtable);
            }
        }
        // Misplaced declaration of an exception variable
        catch(Exception exception)
        {
            com.xxx.sdk.e.c.a("\u8BF7\u6C42\u865A\u6846\u4E0B\u8F7D\u5E7F\u544A\u4E2D\u6216\u8005\u89E3\u6790\u5E76\u4E0B\u8F7D\u5B83\u4E2D\u5F02\u5E38\u3002", exception);
        }
          goto _L6
_L2:
        com.xxx.sdk.e.c.warn("\u6B63\u5728\u865A\u6846\u5E94\u7528\u66F4\u65B0\u4E2D\uFF0C\u672C\u6B21\u66F4\u65B0\u88AB\u7EC8\u6B62\u3002");
        return;
        i1++;
          goto _L9
    }

    public final void s()
    {
        if(d() && f())
        {
            if(a_java_io_File_fld == null)
            {
                com.xxx.sdk.e.c.warn("\uFF33\uFF24\u5361\u4E0D\u5B58\u5728\u6216\u8005\u65E0\u6743\u8BFB\u5199\uFF0C\u6CA1\u6CD5\u7F13\u5B58");
                return;
            }
            long l1 = a_com_xxx_sdk_b_fld.a().d;
            if(System.currentTimeMillis() - a_com_xxx_sdk_a_j_fld.updated > l1)
            {
                (new Thread(this)).start();
                return;
            }
        }
    }

    private com.xxx.sdk.a.c a_com_xxx_sdk_a_c_fld;
    private i a_com_xxx_sdk_a_i_fld;
    private j a_com_xxx_sdk_a_j_fld;
    private b a_com_xxx_sdk_b_fld;
    private File a_java_io_File_fld;
    private Hashtable a_java_util_Hashtable_fld;
    private int aq;
    private AtomicBoolean k;
    private AtomicBoolean l;
}
