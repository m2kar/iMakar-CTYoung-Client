// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.xxx.e.k;
import com.xxx.sdk.a.e;
import com.xxx.sdk.b.f;
import com.xxx.sdk.b.g;
import com.xxx.sdk.b.h;
import com.xxx.sdk.b.i;
import com.xxx.sdk.c.a.d;
import com.xxx.sdk.e.c;
import com.xxx.sdk.f.a;
import com.xxx.sdk.w;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xxx.sdk.c.a.a:
//            e, c, h, d

public class b
    implements com.xxx.sdk.b.b
{

    public b(Context context)
    {
        httpClient = null;
        a_com_xxx_sdk_c_a_c_fld = null;
        a_android_content_Context_fld = context;
    }

    private void L()
    {
        if(a_java_io_File_fld == null)
        {
            String s1 = com.xxx.sdk.b.a().d();
            String s = s1;
            if(s1 == null)
            {
                c.warn("\u5916\u90E8\u5B58\u50A8\u4E0D\u80FD\u4F7F\u7528\uFF0Cbanner\u5E7F\u544A\u5B58\u50A8\u76EE\u5F55\uFF1A".concat(s1));
                s = a_android_content_Context_fld.getApplicationInfo().dataDir.concat(File.separator);
            }
            a_java_io_File_fld = new File(s.concat(String.valueOf(com/xxx/sdk/c/a/a/b.getSimpleName().hashCode())));
            a_java_io_File_fld.mkdirs();
        }
    }

    private static f a(com.xxx.sdk.c.a.a.e e1)
    {
        if(e1 != null && (e1.at == 4 || e1.at == 1))
        {
            f f1 = new f();
            if(e1.at == 4)
            {
                f1.a = g.h5;
                f1.ba = null;
                f1.n = true;
                return f1;
            } else
            {
                f1.a = g.image;
                return f1;
            }
        } else
        {
            return null;
        }
    }

    private static h a(com.xxx.sdk.c.a.a.e e1)
    {
        h h1 = new h();
        if(e1.au == 1)
        {
            h1.a = i.browser;
            h1.protocol = e1.br;
            return h1;
        }
        if(e1.au == 2)
        {
            h1.a = i.download;
            h1.protocol = e1.br;
            return h1;
        } else
        {
            return h.b(e1.br);
        }
    }

    private com.xxx.sdk.c.a.a.c a(com.xxx.sdk.c.a.a.c c1, Map map)
    {
        map = k.a().a(map, a_com_xxx_sdk_c_a_c_fld.a);
        if(map != null)
        {
            if(!com.xxx.sdk.e.b.f(((d) (map)).bh))
                c1.a.bh = ((d) (map)).bh;
            if(!com.xxx.sdk.e.b.f(((d) (map)).bj))
                c1.a.bw = ((d) (map)).bj;
            if(!com.xxx.sdk.e.b.f(((d) (map)).bi))
                c1.a.bi = ((d) (map)).bi;
        }
        if(c1.a.bh != null && !c1.a.bh.contains(":"))
            c1.a.bh = e.c(c1.a.bh);
        return c1;
    }

    private com.xxx.sdk.c.a.a.d a(com.xxx.sdk.c.a.a.c c1)
    {
        int j;
        if(a_com_xxx_sdk_c_a_c_fld.clearCookies)
            com.xxx.sdk.d.a(a_android_content_Context_fld, true);
        j = 0;
_L2:
        if(j >= com.xxx.sdk.k.RETRY_TIME)
            break MISSING_BLOCK_LABEL_191;
        Object obj;
        byte abyte0[];
        if(httpClient == null)
            httpClient = com.xxx.sdk.k.a(a_android_content_Context_fld);
        obj = httpClient.c("http://bid.adview.cn/agent/sspReqAd").a("x-adviewssp-version", "2.3");
        abyte0 = c1.toString().getBytes();
        obj.content = abyte0;
        obj.contentType = "application/json";
        if(abyte0 == null)
            break MISSING_BLOCK_LABEL_93;
        obj.w = true;
        obj = ((com.xxx.sdk.e.b.d) (obj)).a(new int[] {
            200, 204
        }).a();
        if(204 == ((com.xxx.sdk.e.b.f) (obj)).statusCode)
            return null;
        StringBuilder stringbuilder = new StringBuilder();
        ((com.xxx.sdk.e.b.f) (obj)).a(stringbuilder);
        obj = com.xxx.sdk.c.a.a.d.a(stringbuilder.toString());
        return ((com.xxx.sdk.c.a.a.d) (obj));
        Exception exception;
        exception;
        exception.printStackTrace();
        if(!com.xxx.sdk.k.a(exception.getCause()))
            break; /* Loop/switch isn't completed */
        c.info("\u4E0B\u8F7D\u6587\u4EF6\u8D85\u65F6\uFF0C\u91CD\u8BD5\u4E00\u6B21");
        com.xxx.sdk.e.b.U();
        j++;
        if(true) goto _L2; else goto _L1
_L1:
        c.info("\u975E\u8D85\u65F6\u539F\u56E0\u5BFC\u81F4\u5F02\u5E38\uFF0C\u672C\u6B21\u4E0B\u8F7D\u7ED3\u675F\u3002");
        return null;
    }

    private a a(com.xxx.sdk.c.a.a.d d1, boolean flag)
    {
        if(a_java_io_File_fld == null)
        {
            String s1 = com.xxx.sdk.b.a().d();
            String s = s1;
            if(s1 == null)
            {
                c.warn("\u5916\u90E8\u5B58\u50A8\u4E0D\u80FD\u4F7F\u7528\uFF0Cbanner\u5E7F\u544A\u5B58\u50A8\u76EE\u5F55\uFF1A".concat(s1));
                s = a_android_content_Context_fld.getApplicationInfo().dataDir.concat(File.separator);
            }
            a_java_io_File_fld = new File(s.concat(String.valueOf(com/xxx/sdk/c/a/a/b.getSimpleName().hashCode())));
            a_java_io_File_fld.mkdirs();
        }
        if(d1 == null || d1.l == null || d1.l.size() <= 0) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = d1.l.iterator();
        d1 = null;
_L6:
        if(!((Iterator) (obj1)).hasNext()) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = (com.xxx.sdk.c.a.a.e)((Iterator) (obj1)).next();
        if(obj != null && (((com.xxx.sdk.c.a.a.e) (obj)).at == 4 || ((com.xxx.sdk.c.a.a.e) (obj)).at == 1))
        {
            d1 = new f();
            if(((com.xxx.sdk.c.a.a.e) (obj)).at == 4)
            {
                d1.a = g.h5;
                d1.ba = null;
                d1.n = true;
            } else
            {
                d1.a = g.image;
            }
        } else
        {
            d1 = null;
        }
        if(d1 == null) goto _L6; else goto _L5
_L5:
        if(d1 != null && obj != null && (((com.xxx.sdk.c.a.a.e) (obj)).at == 4 || ((com.xxx.sdk.c.a.a.e) (obj)).at == 1)) goto _L7; else goto _L2
_L2:
        return null;
_L7:
        if(!flag) goto _L9; else goto _L8
_L8:
        obj1 = new com.xxx.sdk.f.c();
        ((com.xxx.sdk.f.c)obj1).resource = d1;
        ((com.xxx.sdk.f.c)obj1).target = a(((com.xxx.sdk.c.a.a.e) (obj)));
_L10:
        obj1.id = a_com_xxx_sdk_c_a_c_fld.V;
        obj1.clickUrl = ((com.xxx.sdk.c.a.a.e) (obj)).bs;
        obj1.showUrl = ((com.xxx.sdk.c.a.a.e) (obj)).bt;
        String s2 = ((com.xxx.sdk.c.a.a.e) (obj)).bq;
        File file = a_java_io_File_fld;
        File file1 = a_java_io_File_fld;
        String s3 = ((com.xxx.sdk.c.a.a.e) (obj)).bq;
        obj = ((com.xxx.sdk.c.a.a.e) (obj)).bu;
        d1.ba = ((a) (obj1)).a(s2, file, a(file1, s3));
        return ((a) (obj1));
_L9:
        com.xxx.sdk.f.d d2 = new com.xxx.sdk.f.d();
        ((com.xxx.sdk.f.d)d2).resource = d1;
        ((com.xxx.sdk.f.d)d2).target = a(((com.xxx.sdk.c.a.a.e) (obj)));
        obj1 = d2;
        if(((com.xxx.sdk.c.a.a.e) (obj)).at == 1)
        {
            ((com.xxx.sdk.f.d)d2).imageW = ((com.xxx.sdk.c.a.a.e) (obj)).av;
            ((com.xxx.sdk.f.d)d2).imageH = ((com.xxx.sdk.c.a.a.e) (obj)).aw;
            obj1 = d2;
        }
        if(true) goto _L10; else goto _L4
_L4:
        obj = null;
        if(true) goto _L5; else goto _L11
_L11:
    }

    private static String a(File file, String s)
    {
        String s1 = com.xxx.sdk.e.b.f(s);
        int j = s1.hashCode();
        int l = s1.lastIndexOf(".");
        s = s1;
        if(l > 0)
            s = s1.substring(0, l);
        int j1 = s.lastIndexOf("/");
        if(l > 0)
            s = s.substring(j1 + 1);
        else
            s = String.valueOf(j);
        s = (new StringBuilder()).append(s).append(".jpg").toString();
        if(file != null && file.isDirectory())
        {
            file = file.list();
            if(file != null)
            {
                int i1 = file.length;
                for(j = 0; j < i1; j++)
                {
                    String s2 = file[j];
                    if(s2.endsWith((new StringBuilder("_")).append(s).toString()))
                        return s2;
                }

            }
        }
        return String.valueOf(System.currentTimeMillis() + 0x337f9800L).concat("_").concat(s);
    }

    public final void K()
    {
    }

    public final com.xxx.sdk.c.a.c a()
    {
        return a_com_xxx_sdk_c_a_c_fld;
    }

    public final com.xxx.sdk.f.c a(Map map)
    {
        map = (com.xxx.sdk.f.c)a(a(a(com.xxx.sdk.c.a.a.c.a(a_android_content_Context_fld, a_com_xxx_sdk_c_a_c_fld, true), map)), true);
        if(map != null)
        {
            map.w(a_com_xxx_sdk_c_a_c_fld.b.M);
            map.clearCookies = a_com_xxx_sdk_c_a_c_fld.clearCookies;
        }
        return map;
    }

    public final com.xxx.sdk.f.d a(Map map)
    {
        map = (com.xxx.sdk.f.d)a(a(a(com.xxx.sdk.c.a.a.c.a(a_android_content_Context_fld, a_com_xxx_sdk_c_a_c_fld, false), map)), false);
        if(map != null)
        {
            map.w(a_com_xxx_sdk_c_a_c_fld.b.L);
            map.clearCookies = a_com_xxx_sdk_c_a_c_fld.clearCookies;
        }
        return map;
    }

    public final void a(com.xxx.sdk.c.a.c c1)
    {
        a_com_xxx_sdk_c_a_c_fld = c1;
    }

    public final String getAlias()
    {
        return "adview";
    }

    private static String bk = "http://bid.adview.cn/agent/sspReqAd";
    private Context a_android_content_Context_fld;
    private com.xxx.sdk.c.a.c a_com_xxx_sdk_c_a_c_fld;
    private File a_java_io_File_fld;
    private d a_com_xxx_sdk_c_a_d_array1d_fld[];
    private com.xxx.sdk.e.b.b httpClient;
}
