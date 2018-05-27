// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.xxx.sdk.b;
import com.xxx.sdk.b.g;
import com.xxx.sdk.b.i;
import com.xxx.sdk.d;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.f.f;
import com.xxx.sdk.h;
import com.xxx.sdk.p;
import com.xxx.sdk.u;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

public final class e extends d
{

    public e()
    {
        a_java_io_File_fld = null;
        a_com_xxx_sdk_b_fld = null;
    }

    private f a(Map map)
    {
        Object obj2;
        if(a_com_xxx_sdk_b_fld == null)
            a_com_xxx_sdk_b_fld = b.a();
        obj2 = a_com_xxx_sdk_b_fld.a();
        if(((p) (obj2)).a.k)
            break MISSING_BLOCK_LABEL_41;
        c.warn("\u63A8\u9001\u5E7F\u544A\u88AB\u7CFB\u7EDF\u5173\u95ED\u3002");
        return null;
        Object obj1;
        if(a_java_io_File_fld != null)
            break MISSING_BLOCK_LABEL_128;
        obj1 = a_com_xxx_sdk_b_fld.d();
        Object obj;
        obj = obj1;
        if(obj1 != null)
            break MISSING_BLOCK_LABEL_94;
        obj = a_com_xxx_sdk_b_fld.getContext().getApplicationInfo().dataDir.concat(File.separator);
        c.warn("\u5916\u90E8\u5B58\u50A8\u4E0D\u80FD\u4F7F\u7528\uFF0C\u63A8\u9001\u5E7F\u544A\u5B58\u50A8\u76EE\u5F55\uFF1A".concat(((String) (obj))));
        a_java_io_File_fld = new File(((String) (obj)).concat(String.valueOf(com/xxx/sdk/f/f.getSimpleName().hashCode())));
        a_java_io_File_fld.mkdirs();
        obj = a_com_xxx_sdk_b_fld.a();
        if(obj == null) goto _L2; else goto _L1
_L1:
        obj1 = (f)((h) (obj)).a(com/xxx/sdk/f/f, map);
        obj = obj1;
        c.info((new StringBuilder("\u83B7\u53D6APP\u63A8\u5E7FpushAd\u5E7F\u544A\u5176\u5185\u5BB9\u4E3A\uFF1A")).append(obj1).toString());
        if(obj1 != null) goto _L4; else goto _L3
_L3:
        obj = obj1;
        c.info("\u6CA1\u6709\u627E\u5230\u5408\u9002APP\u63A8\u5E7FpushAd\u5E7F\u544A\uFF0C\u7EE7\u7EED\u5411adServer\u8BF7\u6C42\u5E7F\u544A\u3002");
        obj = obj1;
_L11:
        if(!com.xxx.sdk.e.b.f(((p) (obj2)).a.U))
            break MISSING_BLOCK_LABEL_214;
        c.warn("\u63A8\u9001\u5E7F\u544A\u8BF7\u6C42\u5730\u5740\u6CA1\u6709\u8BBE\u7F6E\u3002");
        return null;
        map = a(a(((p) (obj2)).a.U, map));
        if(com.xxx.sdk.e.b.f(map))
            return null;
        map = new JSONObject(map);
        com.xxx.sdk.e.e.a.a(map);
        obj1 = map.getJSONObject("creative");
        if(obj1 == null) goto _L6; else goto _L5
_L5:
        map = new f();
        obj = map;
        a(((com.xxx.sdk.f.a) (map)), "exch");
        obj = map;
        map.title = ((p) (obj2)).a.X;
        obj = map;
        map.icon = ((p) (obj2)).a.Y;
        obj = map;
        map.resource = new com.xxx.sdk.b.f();
        obj = map;
        ((f) (map)).resource.a = g.image;
        obj = map;
        obj2 = ((JSONObject) (obj1)).getString("material");
        obj = map;
        ((f) (map)).resource.n = false;
        obj = map;
        ((f) (map)).resource.ba = a(((String) (obj2)), a_java_io_File_fld);
        obj = map;
        if(!com.xxx.sdk.e.b.f(((f) (map)).resource.ba))
            break MISSING_BLOCK_LABEL_398;
        obj = map;
        c.warn("\u7D20\u6750\u8D44\u6E90\u6CA1\u6709\u4E0B\u8F7D\u6210\u529F\uFF0C\u5219\u4E0D\u663E\u793A\u5E7F\u544A\u3002");
        return null;
        obj = map;
        if(!com.xxx.sdk.e.b.f(((String) (obj2)))) goto _L8; else goto _L7
_L7:
        obj = map;
        int j = ((f) (map)).pushId;
_L9:
        obj = map;
        map.pushId = j;
        obj = map;
        map.target = new com.xxx.sdk.b.h();
        obj = map;
        ((f) (map)).target.a = i.browser;
        obj = map;
        ((f) (map)).target.protocol = ((JSONObject) (obj1)).getString("click");
        obj = map;
        map.showUrl = ((JSONObject) (obj1)).getString("third_show_url");
        obj = map;
        map.clickUrl = ((JSONObject) (obj1)).getString("third_click_url");
        obj = map;
        c.info((new StringBuilder("\u8BF7\u6C42\u5230push\u5E7F\u544A\uFF0C\u5176\u5185\u5BB9\uFF1A")).append(map).toString());
        return map;
        map;
_L10:
        c.a("\u8BF7\u6C42\u63A8\u9001\u5E7F\u544A\u4E2D\u6216\u8005\u89E3\u6790\u5B83\u5F02\u5E38\u3002", map);
        return ((f) (obj));
_L8:
        obj = map;
        j = ((String) (obj2)).hashCode();
          goto _L9
_L6:
        c.info("\u65E0push\u5E7F\u544A\uFF0C\u5E7F\u544A\u4E32\u4E2D\u4E0D\u5305\u542Bcreative\u8282\u70B9\u3002");
        return ((f) (obj));
        map;
        obj = null;
          goto _L10
        map;
          goto _L10
_L2:
        obj = null;
        if(true) goto _L11; else goto _L4
_L4:
        return ((f) (obj1));
    }

    public final volatile com.xxx.sdk.f.a a(Map map)
    {
        return a(map);
    }

    private b a_com_xxx_sdk_b_fld;
    private File a_java_io_File_fld;
}
