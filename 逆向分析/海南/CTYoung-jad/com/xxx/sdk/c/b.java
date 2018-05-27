// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c;

import android.util.DisplayMetrics;
import com.xxx.sdk.a;
import com.xxx.sdk.a.i;
import com.xxx.sdk.a.j;
import com.xxx.sdk.b.f;
import com.xxx.sdk.b.g;
import com.xxx.sdk.d;
import com.xxx.sdk.e.c;
import com.xxx.sdk.f.e;
import com.xxx.sdk.h;
import com.xxx.sdk.k;
import com.xxx.sdk.p;
import com.xxx.sdk.r;
import com.xxx.sdk.s;
import com.xxx.sdk.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.xxx.sdk.c:
//            c

public final class b extends d
    implements a, Runnable
{

    public b()
    {
        a_java_io_File_fld = null;
        a_com_xxx_sdk_b_fld = null;
        a_java_util_Hashtable_fld = new Hashtable();
        a_com_xxx_sdk_a_i_fld = null;
        a_com_xxx_sdk_a_j_fld = null;
        a_com_xxx_sdk_a_c_fld = null;
        k = new AtomicBoolean(false);
        l = new AtomicBoolean(false);
    }

    private void M()
    {
        int i1;
        Object obj;
        Object obj1;
        String s1;
        String s2;
        String s3;
        try
        {
            obj = a_com_xxx_sdk_b_fld.a();
            if(com.xxx.sdk.e.b.f(((p) (obj)).a_com_xxx_sdk_s_fld.cacheUrl))
            {
                com.xxx.sdk.e.c.warn("\u63D2\u5C4F\u5E7F\u544A\u7F13\u5B58\u5730\u5740\u6CA1\u6709\u8BBE\u7F6E\u3002");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            com.xxx.sdk.e.c.a("\u8BF7\u6C42\u7F13\u5B58\u63D2\u5C4F\u5E7F\u544A\u4E2D\u6216\u8005\u89E3\u6790\u5E76\u4E0B\u8F7D\u5B83\u4E2D\u5F02\u5E38\u3002", ((Throwable) (obj)));
            return;
        }
        obj1 = a(get(((p) (obj)).a_com_xxx_sdk_s_fld.cacheUrl));
        if(com.xxx.sdk.e.b.f(((String) (obj1)))) goto _L2; else goto _L1
_L1:
        obj = new ArrayList();
        obj1 = new JSONArray(((String) (obj1)));
        i1 = 0;
_L12:
        if(i1 >= ((JSONArray) (obj1)).length()) goto _L4; else goto _L3
_L3:
        s1 = ((JSONArray) (obj1)).getJSONObject(i1).optString("material");
        if(com.xxx.sdk.b.f.b(s1).a == g.h5) goto _L6; else goto _L5
_L5:
        s2 = com.xxx.sdk.e.b.e(s1);
        if(!a_java_util_Hashtable_fld.containsKey(s2)) goto _L8; else goto _L7
_L7:
        ((List) (obj)).add(new com.xxx.sdk.a.d("floating", s2, (String)a_java_util_Hashtable_fld.get(s2)));
          goto _L6
_L8:
        s3 = a(s1, a_java_io_File_fld);
        if(!com.xxx.sdk.e.b.f(s3)) goto _L10; else goto _L9
_L9:
        com.xxx.sdk.e.c.warn((new StringBuilder("\u63D2\u5C4F\u8D44\u6E90[")).append(s1).append("]\u6CA1\u6709\u4E0B\u8F7D\u6210\u529F\u3002").toString());
          goto _L6
_L10:
        com.xxx.sdk.e.c.info((new StringBuilder("\u63D2\u5C4F\u8D44\u6E90[")).append(s1).append("]\u7F13\u5B58\u952E\u503C\uFF1A[").append(s2).append(":").append(s3).append("]").toString());
        a_java_util_Hashtable_fld.put(s2, s3);
        ((List) (obj)).add(new com.xxx.sdk.a.d("floating", s2, s3));
          goto _L6
_L4:
        if(a_com_xxx_sdk_a_c_fld.a("floating", ((List) (obj))))
        {
            a_com_xxx_sdk_a_j_fld.updated = System.currentTimeMillis();
            a_com_xxx_sdk_a_i_fld.a(a_com_xxx_sdk_a_j_fld);
        }
_L2:
        return;
_L6:
        i1++;
        if(true) goto _L12; else goto _L11
_L11:
    }

    private com.xxx.sdk.f.a a(int i1, Map map, p p1)
    {
        switch(i1)
        {
        default:
            return null;

        case 0: // '\0'
            if(p1 != null && p1.a_com_xxx_sdk_r_fld != null)
                a(a_com_xxx_sdk_b_fld.getContext(), p1.a_com_xxx_sdk_r_fld.clearCookies);
            return c(map);

        case 2: // '\002'
            return com.xxx.sdk.c.a.b.a().a(com/xxx/sdk/f/d, map);

        case 1: // '\001'
            p1 = a_com_xxx_sdk_b_fld.a();
            break;
        }
        if(p1 != null)
        {
            map = (com.xxx.sdk.f.d)p1.a(com/xxx/sdk/f/d, map);
            com.xxx.sdk.e.c.info((new StringBuilder("\u83B7\u53D6APP\u63A8\u5E7Ffloating\u5E7F\u544A\u5176\u5185\u5BB9\u4E3A\uFF1A")).append(map).toString());
            if(map != null)
            {
                map.w(a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_w_fld.L);
                map.sysClickUrl = null;
                map.sysShowUrl = null;
                map.eSysClickUrl = null;
                return map;
            }
            com.xxx.sdk.e.c.info("\u6CA1\u6709\u627E\u5230\u5408\u9002APP\u63A8\u5E7Ffloating\u63A8\u5E7F\u5E7F\u544A\uFF0C\u7EE7\u7EED\u5411adServer\u8BF7\u6C42\u5E7F\u544A\u3002");
        }
        return null;
    }

    private com.xxx.sdk.f.a a(ArrayList arraylist, Map map, p p1)
    {
        Stack stack = com.xxx.sdk.c.a(arraylist);
        arraylist = null;
        do
        {
            if(stack.empty() || arraylist != null)
                break;
            switch(((Integer)stack.pop()).intValue())
            {
            default:
                arraylist = null;
                continue;

            case 0: // '\0'
                if(p1 != null && p1.a_com_xxx_sdk_r_fld != null)
                    a(a_com_xxx_sdk_b_fld.getContext(), p1.a_com_xxx_sdk_r_fld.clearCookies);
                arraylist = c(map);
                continue;

            case 2: // '\002'
                arraylist = com.xxx.sdk.c.a.b.a().a(com/xxx/sdk/f/d, map);
                continue;

            case 1: // '\001'
                arraylist = a_com_xxx_sdk_b_fld.a();
                break;
            }
            if(arraylist != null)
            {
                arraylist = (com.xxx.sdk.f.d)arraylist.a(com/xxx/sdk/f/d, map);
                com.xxx.sdk.e.c.info((new StringBuilder("\u83B7\u53D6APP\u63A8\u5E7Ffloating\u5E7F\u544A\u5176\u5185\u5BB9\u4E3A\uFF1A")).append(arraylist).toString());
                if(arraylist != null)
                {
                    arraylist.w(a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_w_fld.L);
                    arraylist.sysClickUrl = null;
                    arraylist.sysShowUrl = null;
                    arraylist.eSysClickUrl = null;
                    continue;
                }
                com.xxx.sdk.e.c.info("\u6CA1\u6709\u627E\u5230\u5408\u9002APP\u63A8\u5E7Ffloating\u63A8\u5E7F\u5E7F\u544A\uFF0C\u7EE7\u7EED\u5411adServer\u8BF7\u6C42\u5E7F\u544A\u3002");
            }
            arraylist = null;
        } while(true);
        return arraylist;
    }

    private com.xxx.sdk.f.d b(Map map)
    {
        int i1;
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = a(map);
        i1 = ((flag) ? 1 : 0);
        Object obj;
        if(!f())
            return null;
        i1 = ((flag) ? 1 : 0);
        p p1;
        try
        {
            p1 = a_com_xxx_sdk_b_fld.a();
        }
        // Misplaced declaration of an exception variable
        catch(Map map)
        {
            if(i1 != 0)
                com.xxx.sdk.f.a.n();
            int j1;
            Stack stack;
            if(map instanceof com.xxx.sdk.f.b)
            {
                throw (com.xxx.sdk.f.b)map;
            } else
            {
                com.xxx.sdk.e.c.a("\u8BF7\u6C42\u63D2\u5C4F\u5E7F\u544A\u4E2D\u6216\u8005\u89E3\u6790\u5B83\u5F02\u5E38\u3002", map);
                return null;
            }
        }
        i1 = ((flag) ? 1 : 0);
        if(p1.a_com_xxx_sdk_s_fld.k)
            break MISSING_BLOCK_LABEL_74;
        i1 = ((flag) ? 1 : 0);
        com.xxx.sdk.e.c.warn("\u63D2\u5C4F\u5E7F\u544A\u88AB\u7CFB\u7EDF\u5173\u95ED\u3002");
        return null;
        if(flag1)
            break MISSING_BLOCK_LABEL_85;
        i1 = ((flag) ? 1 : 0);
        com.xxx.sdk.f.a.m();
        flag = true;
        i1 = ((flag) ? 1 : 0);
        if(!com.xxx.sdk.d.a(map)) goto _L2; else goto _L1
_L1:
        i1 = ((flag) ? 1 : 0);
        if(!"exch".contentEquals(com.xxx.sdk.d.a(map))) goto _L4; else goto _L3
_L3:
        i1 = ((flag) ? 1 : 0);
        map = c(map);
_L5:
        if(map != null)
            break MISSING_BLOCK_LABEL_129;
        i1 = ((flag) ? 1 : 0);
        com.xxx.sdk.f.a.n();
        i1 = ((flag) ? 1 : 0);
        com.xxx.sdk.e.c.info((new StringBuilder("\u8BF7\u6C42\u5230\u63D2\u5C4F\u5E7F\u544A\uFF0C\u5176\u5185\u5BB9\uFF1A")).append(map).toString());
        return map;
_L4:
        i1 = ((flag) ? 1 : 0);
        map = (com.xxx.sdk.f.d)com.xxx.sdk.c.a.b.a().a(com/xxx/sdk/f/d, map);
          goto _L5
_L2:
        i1 = ((flag) ? 1 : 0);
        j1 = com.xxx.e.a.a(a_com_xxx_sdk_b_fld.getContext(), "floatingStock");
        if(j1 != 0x80000000) goto _L7; else goto _L6
_L6:
        i1 = ((flag) ? 1 : 0);
        j1 = com.xxx.sdk.b.a().a().a_com_xxx_sdk_s_fld.E;
        i1 = j1;
_L16:
        if(i1 <= 0) goto _L9; else goto _L8
_L8:
        i1 = ((flag) ? 1 : 0);
        stack = com.xxx.sdk.c.a(p1.b);
        obj = null;
_L17:
        i1 = ((flag) ? 1 : 0);
        if(stack.empty() || obj != null) goto _L11; else goto _L10
_L10:
        i1 = ((flag) ? 1 : 0);
        ((Integer)stack.pop()).intValue();
        JVM INSTR tableswitch 0 2: default 519
    //                   0 313
    //                   1 376
    //                   2 360;
           goto _L12 _L13 _L14 _L15
_L7:
        i1 = ((flag) ? 1 : 0);
        j1 = com.xxx.sdk.b.a().a().a_com_xxx_sdk_s_fld.E - j1;
        i1 = j1;
          goto _L16
_L13:
        if(p1 == null)
            break MISSING_BLOCK_LABEL_348;
        i1 = ((flag) ? 1 : 0);
        if(p1.a_com_xxx_sdk_r_fld == null)
            break MISSING_BLOCK_LABEL_348;
        i1 = ((flag) ? 1 : 0);
        a(a_com_xxx_sdk_b_fld.getContext(), p1.a_com_xxx_sdk_r_fld.clearCookies);
        i1 = ((flag) ? 1 : 0);
        obj = c(map);
          goto _L17
_L15:
        i1 = ((flag) ? 1 : 0);
        obj = com.xxx.sdk.c.a.b.a().a(com/xxx/sdk/f/d, map);
          goto _L17
_L14:
        i1 = ((flag) ? 1 : 0);
        obj = a_com_xxx_sdk_b_fld.a();
        if(obj == null) goto _L19; else goto _L18
_L18:
        i1 = ((flag) ? 1 : 0);
        obj = (com.xxx.sdk.f.d)((h) (obj)).a(com/xxx/sdk/f/d, map);
        i1 = ((flag) ? 1 : 0);
        com.xxx.sdk.e.c.info((new StringBuilder("\u83B7\u53D6APP\u63A8\u5E7Ffloating\u5E7F\u544A\u5176\u5185\u5BB9\u4E3A\uFF1A")).append(obj).toString());
        if(obj == null) goto _L21; else goto _L20
_L20:
        i1 = ((flag) ? 1 : 0);
        ((com.xxx.sdk.f.d) (obj)).w(a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_w_fld.L);
        i1 = ((flag) ? 1 : 0);
        obj.sysClickUrl = null;
        i1 = ((flag) ? 1 : 0);
        obj.sysShowUrl = null;
        i1 = ((flag) ? 1 : 0);
        obj.eSysClickUrl = null;
          goto _L17
_L21:
        i1 = ((flag) ? 1 : 0);
        com.xxx.sdk.e.c.info("\u6CA1\u6709\u627E\u5230\u5408\u9002APP\u63A8\u5E7Ffloating\u63A8\u5E7F\u5E7F\u544A\uFF0C\u7EE7\u7EED\u5411adServer\u8BF7\u6C42\u5E7F\u544A\u3002");
          goto _L19
_L11:
        i1 = ((flag) ? 1 : 0);
        map = (com.xxx.sdk.f.d)obj;
          goto _L5
_L9:
        map = null;
          goto _L5
_L12:
        obj = null;
          goto _L17
_L19:
        obj = null;
          goto _L17
    }

    private static Map b(Map map)
    {
        android.content.Context context = com.xxx.sdk.b.a().getContext();
        return com.xxx.sdk.c.a.b.a(map, com.xxx.e.g.a(context).widthPixels, com.xxx.e.g.a(context).heightPixels);
    }

    private com.xxx.sdk.f.d c(Map map)
    {
        Object obj = a_com_xxx_sdk_b_fld.a();
        if(!com.xxx.sdk.e.b.f(((p) (obj)).a_com_xxx_sdk_s_fld.U))
            break MISSING_BLOCK_LABEL_29;
        com.xxx.sdk.e.c.warn("\u63D2\u5C4F\u5E7F\u544A\u8BF7\u6C42\u5730\u5740\u6CA1\u6709\u8BBE\u7F6E\u3002");
        return null;
        obj = ((p) (obj)).a_com_xxx_sdk_s_fld.U;
        android.content.Context context = com.xxx.sdk.b.a().getContext();
        map = a(com.xxx.sdk.k.a(((String) (obj)), com.xxx.sdk.c.a.b.a(map, com.xxx.e.g.a(context).widthPixels, com.xxx.e.g.a(context).heightPixels), "get", false));
        if(com.xxx.sdk.e.b.f(map))
            return null;
        Object obj1;
        Object obj2;
        e e1;
        try
        {
            map = new JSONObject(map);
            com.xxx.sdk.e.e.a.a(map);
            obj1 = map.getJSONObject("creative");
        }
        // Misplaced declaration of an exception variable
        catch(Map map)
        {
            return null;
        }
        if(obj1 != null)
            break MISSING_BLOCK_LABEL_116;
        com.xxx.sdk.e.c.info("\u65E0\u63D2\u5C4F\u5E7F\u544A\uFF0C\u5E7F\u544A\u4E32\u4E2D\u4E0D\u5305\u542Bcreative\u8282\u70B9\u3002");
        return null;
        map = new com.xxx.sdk.f.d();
        a(map, "exch");
        obj2 = ((JSONObject) (obj1)).optString("click");
        map.target = com.xxx.sdk.b.h.b(((String) (obj2)));
        map.showUrl = ((JSONObject) (obj1)).optString("third_show_url");
        map.clickUrl = ((JSONObject) (obj1)).optString("third_click_url");
        if(((com.xxx.sdk.f.d) (map)).target == null || ((com.xxx.sdk.f.d) (map)).target.a != com.xxx.sdk.b.i.app)
            break MISSING_BLOCK_LABEL_254;
        e1 = ((com.xxx.sdk.c.c)a_com_xxx_sdk_b_fld.a(com/xxx/sdk/c/c)).c(((com.xxx.sdk.f.d) (map)).target.protocol);
        if(e1 != null)
            break MISSING_BLOCK_LABEL_227;
        com.xxx.sdk.e.c.info("\u63D2\u5C4F\u5E7F\u544A\u843D\u5730\u9875\u63A8\u5E7F\u7684\u5E94\u7528\u7F13\u5B58\u4E2D\u4E0D\u5B58\u5728\uFF0C\u5219\u8FD4\u56DE\u7A7A\u5E7F\u544A");
        return null;
        ((com.xxx.sdk.f.d) (map)).target.protocol = e1.installer;
        if(!com.xxx.sdk.e.b.f(((com.xxx.sdk.f.d) (map)).clickUrl))
            break MISSING_BLOCK_LABEL_272;
        map.clickUrl = ((String) (obj2));
_L1:
        obj1 = ((JSONObject) (obj1)).optString("material");
        obj2 = com.xxx.sdk.b.f.b(((String) (obj1)));
        if(obj2 == null)
            return null;
        break MISSING_BLOCK_LABEL_327;
        map.clickUrl = (new StringBuilder()).append(((com.xxx.sdk.f.d) (map)).clickUrl).append(";").toString();
        map.clickUrl = (new StringBuilder()).append(((com.xxx.sdk.f.d) (map)).clickUrl).append(((String) (obj2))).toString();
          goto _L1
        map.w(a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_r_fld.b.L);
        if(((f) (obj2)).a != g.h5)
            break MISSING_BLOCK_LABEL_364;
        map.resource = ((f) (obj2));
        return map;
        if(a_java_io_File_fld != null && !com.xxx.sdk.e.b.c(a_java_util_Hashtable_fld))
            break MISSING_BLOCK_LABEL_389;
        com.xxx.sdk.e.c.info("\u6CA1\u6709\u5916\u90E8\u5B58\u50A8\u8BBE\u5907\u6216\u8005\u7F13\u5B58\u4E2D\u6CA1\u6709\u5E7F\u544A\uFF0C\u8FD4\u56DE\u7A7A\u5E7F\u544A\u3002");
        return null;
        obj1 = com.xxx.sdk.e.b.e(((String) (obj1)));
        if(!com.xxx.sdk.e.b.f(((String) (obj1))) && a_java_util_Hashtable_fld.containsKey(obj1))
            break MISSING_BLOCK_LABEL_420;
        com.xxx.sdk.e.c.info("\u6CA1\u6709\u8FD4\u56DE\u63D2\u5C4F\u8D44\u6E90\u6216\u8005\u8FD4\u56DE\u7684\u63D2\u5C4F\u8D44\u6E90\u6CA1\u6709\u88AB\u7F13\u5B58\u3002");
        return null;
        obj2 = (String)a_java_util_Hashtable_fld.get(obj1);
        if((new File(((String) (obj2)))).exists())
            break MISSING_BLOCK_LABEL_483;
        com.xxx.sdk.e.c.warn((new StringBuilder("\u7F13\u5B58\u8D44\u6E90[")).append(((String) (obj2))).append("]\u672C\u5730\u4E0D\u5B58\u5728, \u6E05\u9664\u672C\u5730\u7F13\u5B58\u3002").toString());
        a_java_util_Hashtable_fld.remove(obj1);
        return null;
        map.resource = com.xxx.sdk.b.f.b(((String) (obj2)));
        map.clearCookies = a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_r_fld.clearCookies;
        return map;
    }

    private com.xxx.sdk.f.d d(Map map)
    {
        h h1 = a_com_xxx_sdk_b_fld.a();
        if(h1 != null)
        {
            map = (com.xxx.sdk.f.d)h1.a(com/xxx/sdk/f/d, map);
            com.xxx.sdk.e.c.info((new StringBuilder("\u83B7\u53D6APP\u63A8\u5E7Ffloating\u5E7F\u544A\u5176\u5185\u5BB9\u4E3A\uFF1A")).append(map).toString());
            if(map != null)
            {
                map.w(a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_w_fld.L);
                map.sysClickUrl = null;
                map.sysShowUrl = null;
                map.eSysClickUrl = null;
                return map;
            }
            com.xxx.sdk.e.c.info("\u6CA1\u6709\u627E\u5230\u5408\u9002APP\u63A8\u5E7Ffloating\u63A8\u5E7F\u5E7F\u544A\uFF0C\u7EE7\u7EED\u5411adServer\u8BF7\u6C42\u5E7F\u544A\u3002");
        }
        return null;
    }

    private boolean f()
    {
        if(l.getAndSet(true))
            return true;
        a_com_xxx_sdk_b_fld = com.xxx.sdk.b.a();
        String s1 = a_com_xxx_sdk_b_fld.d();
        if(com.xxx.sdk.e.b.f(s1))
        {
            com.xxx.sdk.e.c.warn("\uFF33\uFF24\u5361\u4E0D\u5B58\u5728\u6216\u8005\u65E0\u6743\u8BFB\u5199\uFF0C\u6CA1\u6CD5\u7F13\u5B58");
            return false;
        }
        if(a_java_io_File_fld == null)
            a_java_io_File_fld = new File(s1.concat(String.valueOf(com/xxx/sdk/f/d.getSimpleName().hashCode())));
        a_java_io_File_fld.mkdirs();
        a_com_xxx_sdk_a_i_fld = new i(a_com_xxx_sdk_b_fld.getContext());
        if(a_com_xxx_sdk_a_j_fld == null)
            a_com_xxx_sdk_a_j_fld = a_com_xxx_sdk_a_i_fld.a("floating_ad");
        a_com_xxx_sdk_a_c_fld = new com.xxx.sdk.a.c(a_com_xxx_sdk_b_fld.getContext());
        return true;
    }

    public final com.xxx.sdk.f.a a(Map map)
    {
        return b(map);
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
        }
        List list = a_com_xxx_sdk_a_c_fld.a("floating");
        if(!com.xxx.sdk.e.b.a(list))
        {
            for(int i1 = 0; i1 < list.size(); i1++)
            {
                com.xxx.sdk.a.d d1 = (com.xxx.sdk.a.d)list.get(i1);
                a_java_util_Hashtable_fld.put(d1.an, d1.ao);
            }

        }
        s();
    }

    public final void run()
    {
        if(!a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_s_fld.k)
        {
            com.xxx.sdk.e.c.warn("\u63D2\u5C4F\u5E7F\u544A\u88AB\u7CFB\u7EDF\u5173\u95ED\u3002");
            return;
        }
        if(!k.compareAndSet(false, true)) goto _L2; else goto _L1
_L1:
        Object obj = a_com_xxx_sdk_b_fld.a();
        if(!com.xxx.sdk.e.b.f(((p) (obj)).a_com_xxx_sdk_s_fld.cacheUrl)) goto _L4; else goto _L3
_L3:
        com.xxx.sdk.e.c.warn("\u63D2\u5C4F\u5E7F\u544A\u7F13\u5B58\u5730\u5740\u6CA1\u6709\u8BBE\u7F6E\u3002");
_L6:
        k.set(false);
        return;
_L4:
        Object obj1 = a(get(((p) (obj)).a_com_xxx_sdk_s_fld.cacheUrl));
        if(com.xxx.sdk.e.b.f(((String) (obj1)))) goto _L6; else goto _L5
_L5:
        obj = new ArrayList();
        obj1 = new JSONArray(((String) (obj1)));
        int i1 = 0;
_L10:
        if(i1 >= ((JSONArray) (obj1)).length()) goto _L8; else goto _L7
_L7:
        String s1;
        String s2;
        s1 = ((JSONArray) (obj1)).getJSONObject(i1).optString("material");
        if(com.xxx.sdk.b.f.b(s1).a == g.h5)
            break MISSING_BLOCK_LABEL_379;
        s2 = com.xxx.sdk.e.b.e(s1);
        if(a_java_util_Hashtable_fld.containsKey(s2))
        {
            ((List) (obj)).add(new com.xxx.sdk.a.d("floating", s2, (String)a_java_util_Hashtable_fld.get(s2)));
            break MISSING_BLOCK_LABEL_379;
        }
        String s3 = a(s1, a_java_io_File_fld);
        if(com.xxx.sdk.e.b.f(s3))
        {
            com.xxx.sdk.e.c.warn((new StringBuilder("\u63D2\u5C4F\u8D44\u6E90[")).append(s1).append("]\u6CA1\u6709\u4E0B\u8F7D\u6210\u529F\u3002").toString());
            break MISSING_BLOCK_LABEL_379;
        }
        try
        {
            com.xxx.sdk.e.c.info((new StringBuilder("\u63D2\u5C4F\u8D44\u6E90[")).append(s1).append("]\u7F13\u5B58\u952E\u503C\uFF1A[").append(s2).append(":").append(s3).append("]").toString());
            a_java_util_Hashtable_fld.put(s2, s3);
            ((List) (obj)).add(new com.xxx.sdk.a.d("floating", s2, s3));
            break MISSING_BLOCK_LABEL_379;
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            com.xxx.sdk.e.c.a("\u8BF7\u6C42\u7F13\u5B58\u63D2\u5C4F\u5E7F\u544A\u4E2D\u6216\u8005\u89E3\u6790\u5E76\u4E0B\u8F7D\u5B83\u4E2D\u5F02\u5E38\u3002", ((Throwable) (obj)));
        }
          goto _L6
_L8:
        if(!a_com_xxx_sdk_a_c_fld.a("floating", ((List) (obj)))) goto _L6; else goto _L9
_L9:
        a_com_xxx_sdk_a_j_fld.updated = System.currentTimeMillis();
        a_com_xxx_sdk_a_i_fld.a(a_com_xxx_sdk_a_j_fld);
          goto _L6
_L2:
        com.xxx.sdk.e.c.warn("\u63D2\u5C4F\u8D44\u6E90\u6B63\u5728\u66F4\u65B0\u4E2D\uFF0C\u672C\u6B21\u66F4\u65B0\u88AB\u7EC8\u6B62\u3002");
        return;
        i1++;
          goto _L10
    }

    public final void s()
    {
        if(f())
        {
            if(a_java_io_File_fld == null)
            {
                com.xxx.sdk.e.c.warn("\uFF33\uFF24\u5361\u4E0D\u5B58\u5728\u6216\u8005\u65E0\u6743\u8BFB\u5199\uFF0C\u6CA1\u6CD5\u7F13\u5B58");
                return;
            }
            if(System.currentTimeMillis() - a_com_xxx_sdk_a_j_fld.updated > a_com_xxx_sdk_b_fld.a().c)
            {
                (new Thread(this)).start();
                return;
            }
        }
    }

    private com.xxx.sdk.a.c a_com_xxx_sdk_a_c_fld;
    private i a_com_xxx_sdk_a_i_fld;
    private j a_com_xxx_sdk_a_j_fld;
    private com.xxx.sdk.b a_com_xxx_sdk_b_fld;
    private File a_java_io_File_fld;
    private Hashtable a_java_util_Hashtable_fld;
    private AtomicBoolean k;
    private AtomicBoolean l;
}
