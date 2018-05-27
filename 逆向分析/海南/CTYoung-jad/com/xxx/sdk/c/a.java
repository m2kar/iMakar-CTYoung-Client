// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.DisplayMetrics;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.sdk.b;
import com.xxx.sdk.b.f;
import com.xxx.sdk.b.i;
import com.xxx.sdk.d;
import com.xxx.sdk.e.c;
import com.xxx.sdk.h;
import com.xxx.sdk.p;
import com.xxx.sdk.q;
import com.xxx.sdk.r;
import com.xxx.sdk.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.xxx.sdk.c:
//            c

public final class a extends d
{

    public a()
    {
        a_com_xxx_sdk_b_fld = null;
        a_java_io_File_fld = null;
    }

    private void L()
    {
        if(a_java_io_File_fld == null)
        {
            String s1 = a_com_xxx_sdk_b_fld.d();
            String s = s1;
            if(s1 == null)
            {
                com.xxx.sdk.e.c.warn("\u5916\u90E8\u5B58\u50A8\u4E0D\u80FD\u4F7F\u7528\uFF0Cbanner\u5E7F\u544A\u5B58\u50A8\u76EE\u5F55\uFF1A".concat(s1));
                s = a_com_xxx_sdk_b_fld.getContext().getApplicationInfo().dataDir.concat(File.separator);
            }
            a_java_io_File_fld = new File(s.concat(String.valueOf(com/xxx/sdk/f/c.getSimpleName().hashCode())));
            a_java_io_File_fld.mkdirs();
        }
    }

    public static int a(int j)
    {
        int l = j % 10;
        int k;
        if(l > 0 && l <= 4)
        {
            k = j - l;
        } else
        {
            k = j;
            if(l > 4)
            {
                k = j;
                if(l <= 9)
                    return j + (10 - l);
            }
        }
        return k;
    }

    public static e a(Context context)
    {
_L4:
        return new e(k, j);
_L2:
        l = Math.round(j / 6);
        k = a(j);
        j = l;
        continue; /* Loop/switch isn't completed */
        k = 320;
        int l;
        int i1;
        try
        {
            l = g.a(context).widthPixels;
            i1 = g.a(context).heightPixels;
        }
        catch(Exception exception)
        {
            return new e(g.a(context).widthPixels, g.a(context).heightPixels);
        }
        j = l;
        if(l > i1)
            j = i1;
        if(j <= 240)
        {
            k = 240;
            j = 40;
        } else
        if(j <= 320)
            j = 50;
        else
        if(j <= 480)
        {
            j = 80;
            k = 480;
        } else
        {
            if(j > 720)
                continue; /* Loop/switch isn't completed */
            j = 120;
            k = 720;
        }
        continue; /* Loop/switch isn't completed */
        if(j > 1080) goto _L2; else goto _L1
_L1:
        j = 180;
        k = 1080;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private com.xxx.sdk.f.a a(int j, Map map, p p1)
    {
        switch(j)
        {
        default:
            return null;

        case 0: // '\0'
            try
            {
                if(a_com_xxx_sdk_b_fld != null && a_com_xxx_sdk_b_fld.a() != null && a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_r_fld != null)
                    a(a_com_xxx_sdk_b_fld.getContext(), a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_r_fld.clearCookies);
                map = a(p1, map);
            }
            // Misplaced declaration of an exception variable
            catch(Map map)
            {
                return null;
            }
            return map;

        case 2: // '\002'
            return com.xxx.sdk.c.a.b.a().a(com/xxx/sdk/f/c, map);

        case 1: // '\001'
            p1 = a_com_xxx_sdk_b_fld.a();
            break;
        }
        if(p1 != null)
        {
            map = (com.xxx.sdk.f.c)p1.a(com/xxx/sdk/f/c, map);
            if(map != null)
            {
                map.w(a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_w_fld.M);
                map.sysClickUrl = null;
                map.sysShowUrl = null;
                map.eSysClickUrl = null;
                com.xxx.sdk.e.c.info((new StringBuilder("\u83B7\u53D6APP\u63A8\u5E7Fbanner\u5E7F\u544A\u5176\u5185\u5BB9\u4E3A\uFF1A")).append(map).toString());
                return map;
            }
            com.xxx.sdk.e.c.info("\u6CA1\u6709\u627E\u5230\u5408\u9002APP\u63A8\u5E7Fbanner\u63A8\u5E7F\u5E7F\u544A\uFF0C\u7EE7\u7EED\u5411adServer\u8BF7\u6C42\u5E7F\u544A\u3002");
        }
        return null;
    }

    private com.xxx.sdk.f.a a(ArrayList arraylist, Map map, p p1)
    {
        Stack stack = com.xxx.sdk.c.a(arraylist);
        for(arraylist = null; !stack.empty() && arraylist == null; arraylist = a(((Integer)stack.pop()).intValue(), map, p1));
        return arraylist;
    }

    private com.xxx.sdk.f.c a(p p1, Map map)
    {
        if(com.xxx.sdk.e.b.f(p1.a_com_xxx_sdk_q_fld.U))
            com.xxx.sdk.e.c.warn("banner\u5E7F\u544A\u8BF7\u6C42\u5730\u5740\u6CA1\u6709\u8BBE\u7F6E\u3002");
        p1 = p1.a_com_xxx_sdk_q_fld.U;
        Object obj = a(com.xxx.sdk.b.a().getContext());
        p1 = a(a(((String) (p1)), com.xxx.sdk.c.a.b.a(map, ((e) (obj)).width, ((e) (obj)).height)));
        if(com.xxx.sdk.e.b.f(p1))
            return null;
        p1 = new JSONObject(p1);
        com.xxx.sdk.e.e.a.a(p1);
        obj = p1.getJSONObject("creative");
        if(obj != null)
        {
            p1 = new com.xxx.sdk.f.c();
            a(((com.xxx.sdk.f.a) (p1)), "exch");
            p1.resource = new f();
            ((com.xxx.sdk.f.c) (p1)).resource.a = com.xxx.sdk.b.g.image;
            p1.resource = f.b(((JSONObject) (obj)).getString("material"));
            if(((com.xxx.sdk.f.c) (p1)).resource.a != com.xxx.sdk.b.g.h5)
                ((com.xxx.sdk.f.c) (p1)).resource.ba = a(((com.xxx.sdk.f.c) (p1)).resource.ba, a_java_io_File_fld);
            else
                com.xxx.sdk.e.c.info("banner\u5E7F\u544A\u662Fhtml5\u7D20\u6750\u76F4\u63A5\u6253\u5F00\u5C31\u597D\uFF0C\u4E0D\u9700\u8981\u4E0B\u8F7D");
            map = ((JSONObject) (obj)).optString("click");
            p1.target = com.xxx.sdk.b.h.b(map);
            p1.showUrl = ((JSONObject) (obj)).optString("third_show_url");
            p1.clickUrl = ((JSONObject) (obj)).optString("third_click_url");
            if(((com.xxx.sdk.f.c) (p1)).target != null && ((com.xxx.sdk.f.c) (p1)).target.a == i.app)
            {
                com.xxx.sdk.f.e e1 = ((com.xxx.sdk.c.c)a_com_xxx_sdk_b_fld.a(com/xxx/sdk/c/c)).c(((com.xxx.sdk.f.c) (p1)).target.protocol);
                if(e1 == null)
                {
                    com.xxx.sdk.e.c.info("banner\u5E7F\u544A\u843D\u5730\u9875\u63A8\u5E7F\u7684\u5E94\u7528\u7F13\u5B58\u4E2D\u4E0D\u5B58\u5728\uFF0C\u5219\u8FD4\u56DE\u7A7A\u5E7F\u544A");
                    return null;
                }
                ((com.xxx.sdk.f.c) (p1)).target.protocol = e1.installer;
                if(com.xxx.sdk.e.b.f(((com.xxx.sdk.f.c) (p1)).clickUrl))
                {
                    p1.clickUrl = map;
                } else
                {
                    p1.clickUrl = (new StringBuilder()).append(((com.xxx.sdk.f.c) (p1)).clickUrl).append(";").toString();
                    p1.clickUrl = (new StringBuilder()).append(((com.xxx.sdk.f.c) (p1)).clickUrl).append(map).toString();
                }
            }
            if(com.xxx.sdk.e.b.f(((com.xxx.sdk.f.c) (p1)).resource.ba))
            {
                com.xxx.sdk.e.c.warn("\u7D20\u6750\u8D44\u6E90\u6CA1\u6709\u4E0B\u8F7D\u6210\u529F\uFF0C\u5219\u4E0D\u663E\u793A\u5E7F\u544A\u3002");
                return null;
            } else
            {
                p1.w(a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_r_fld.b.M);
                com.xxx.sdk.e.c.info((new StringBuilder("\u8BF7\u6C42\u5230banner\u5E7F\u544A\uFF0C\u5176\u5185\u5BB9\uFF1A")).append(p1).toString());
                return p1;
            }
        } else
        {
            com.xxx.sdk.e.c.info("\u65E0banner\u5E7F\u544A\uFF0C\u5E7F\u544A\u4E32\u4E2D\u4E0D\u5305\u542Bcreative\u8282\u70B9\u3002");
            return null;
        }
    }

    private static Map a(Map map)
    {
        e e1 = a(com.xxx.sdk.b.a().getContext());
        return com.xxx.sdk.c.a.b.a(map, e1.width, e1.height);
    }

    private com.xxx.sdk.f.c b(Map map)
    {
        int j;
        boolean flag;
        flag = false;
        j = ((flag) ? 1 : 0);
        if(a_com_xxx_sdk_b_fld == null)
        {
            j = ((flag) ? 1 : 0);
            boolean flag1;
            String s;
            String s1;
            p p1;
            try
            {
                a_com_xxx_sdk_b_fld = com.xxx.sdk.b.a();
            }
            // Misplaced declaration of an exception variable
            catch(Map map)
            {
                if(j != 0)
                    com.xxx.sdk.f.a.n();
                int k;
                int l;
                if(map instanceof com.xxx.sdk.f.b)
                {
                    throw (com.xxx.sdk.f.b)map;
                } else
                {
                    com.xxx.sdk.e.c.a("\u8BF7\u6C42banner\u5E7F\u544A\u4E2D\u6216\u8005\u89E3\u6790\u5B83\u5F02\u5E38\u3002", map);
                    return null;
                }
            }
        }
        j = ((flag) ? 1 : 0);
        flag1 = a(map);
        j = ((flag) ? 1 : 0);
        p1 = a_com_xxx_sdk_b_fld.a();
        j = ((flag) ? 1 : 0);
        if(p1.a_com_xxx_sdk_q_fld.k)
            break MISSING_BLOCK_LABEL_62;
        j = ((flag) ? 1 : 0);
        com.xxx.sdk.e.c.warn("banner\u5E7F\u544A\u88AB\u7CFB\u7EDF\u5173\u95ED\u3002");
        return null;
        if(flag1)
            break MISSING_BLOCK_LABEL_73;
        j = ((flag) ? 1 : 0);
        com.xxx.sdk.f.a.m();
        flag = true;
        j = ((flag) ? 1 : 0);
        if(a_java_io_File_fld != null)
            break MISSING_BLOCK_LABEL_178;
        j = ((flag) ? 1 : 0);
        s1 = a_com_xxx_sdk_b_fld.d();
        s = s1;
        if(s1 != null)
            break MISSING_BLOCK_LABEL_139;
        j = ((flag) ? 1 : 0);
        com.xxx.sdk.e.c.warn("\u5916\u90E8\u5B58\u50A8\u4E0D\u80FD\u4F7F\u7528\uFF0Cbanner\u5E7F\u544A\u5B58\u50A8\u76EE\u5F55\uFF1A".concat(s1));
        j = ((flag) ? 1 : 0);
        s = a_com_xxx_sdk_b_fld.getContext().getApplicationInfo().dataDir.concat(File.separator);
        j = ((flag) ? 1 : 0);
        a_java_io_File_fld = new File(s.concat(String.valueOf(com/xxx/sdk/f/c.getSimpleName().hashCode())));
        j = ((flag) ? 1 : 0);
        a_java_io_File_fld.mkdirs();
        j = ((flag) ? 1 : 0);
        if(!d.a(map)) goto _L2; else goto _L1
_L1:
        j = ((flag) ? 1 : 0);
        if(!"exch".contentEquals(d.a(map))) goto _L4; else goto _L3
_L3:
        j = ((flag) ? 1 : 0);
        map = a(p1, map);
_L10:
        if(map != null)
            break; /* Loop/switch isn't completed */
        j = ((flag) ? 1 : 0);
        com.xxx.sdk.f.a.n();
        return map;
_L4:
        j = ((flag) ? 1 : 0);
        map = (com.xxx.sdk.f.c)com.xxx.sdk.c.a.b.a().a(com/xxx/sdk/f/c, map);
        continue; /* Loop/switch isn't completed */
_L2:
        j = ((flag) ? 1 : 0);
        k = com.xxx.e.a.a(a_com_xxx_sdk_b_fld.getContext(), "bannerStock");
        if(k != 0x80000000) goto _L6; else goto _L5
_L5:
        j = ((flag) ? 1 : 0);
        k = com.xxx.sdk.b.a().a().a_com_xxx_sdk_q_fld.E;
        j = k;
_L8:
        if(j <= 0)
            break; /* Loop/switch isn't completed */
        j = ((flag) ? 1 : 0);
        map = (com.xxx.sdk.f.c)a(p1.c, map, p1);
        continue; /* Loop/switch isn't completed */
_L6:
        j = ((flag) ? 1 : 0);
        l = com.xxx.sdk.b.a().a().a_com_xxx_sdk_q_fld.E;
        j = l - k;
        if(true) goto _L8; else goto _L7
_L7:
        map = null;
        if(true) goto _L10; else goto _L9
_L9:
        return map;
    }

    private com.xxx.sdk.f.c c(Map map)
    {
        h h1 = a_com_xxx_sdk_b_fld.a();
        if(h1 != null)
        {
            map = (com.xxx.sdk.f.c)h1.a(com/xxx/sdk/f/c, map);
            if(map != null)
            {
                map.w(a_com_xxx_sdk_b_fld.a().a_com_xxx_sdk_w_fld.M);
                map.sysClickUrl = null;
                map.sysShowUrl = null;
                map.eSysClickUrl = null;
                com.xxx.sdk.e.c.info((new StringBuilder("\u83B7\u53D6APP\u63A8\u5E7Fbanner\u5E7F\u544A\u5176\u5185\u5BB9\u4E3A\uFF1A")).append(map).toString());
                return map;
            }
            com.xxx.sdk.e.c.info("\u6CA1\u6709\u627E\u5230\u5408\u9002APP\u63A8\u5E7Fbanner\u63A8\u5E7F\u5E7F\u544A\uFF0C\u7EE7\u7EED\u5411adServer\u8BF7\u6C42\u5E7F\u544A\u3002");
        }
        return null;
    }

    public final com.xxx.sdk.f.a a(Map map)
    {
        return b(map);
    }

    private b a_com_xxx_sdk_b_fld;
    private File a_java_io_File_fld;
}
