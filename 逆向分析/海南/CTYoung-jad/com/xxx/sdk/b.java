// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import com.xxx.sdk.c.a;
import com.xxx.sdk.c.c;
import com.xxx.sdk.c.f;
import com.xxx.sdk.c.g;
import com.xxx.sdk.e.e;
import com.xxx.sdk.f.d;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.xxx.sdk:
//            j, d, a, h, 
//            p

public final class b
{

    b()
    {
        a_android_content_Context_fld = null;
        a_com_xxx_sdk_e_e_f_fld = null;
        a_com_xxx_sdk_c_f_fld = null;
        a_com_xxx_sdk_c_g_fld = null;
        f = false;
        J = null;
        a_com_xxx_sdk_c_f_fld = new f();
        a_com_xxx_sdk_c_g_fld = new g();
        c = e.a(java/util/HashMap).a(Integer.valueOf(com/xxx/sdk/f/f.hashCode()), new com.xxx.sdk.c.e()).a(Integer.valueOf(com/xxx/sdk/f/d.hashCode()), new com.xxx.sdk.c.b()).a(Integer.valueOf(com/xxx/sdk/f/e.hashCode()), new c()).a(Integer.valueOf(com/xxx/sdk/f/c.hashCode()), new a()).f;
        a_java_util_Collection_fld = c.values();
        com.xxx.sdk.c.a.b.a(a_android_content_Context_fld);
    }

    public static b a()
    {
        com/xxx/sdk/b;
        JVM INSTR monitorenter ;
        b b1;
        if(a_com_xxx_sdk_b_static_fld == null)
            a_com_xxx_sdk_b_static_fld = new b();
        b1 = a_com_xxx_sdk_b_static_fld;
        com/xxx/sdk/b;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static b a(Context context)
    {
        b b1 = a();
        a_com_xxx_sdk_b_static_fld = b1;
        b1.a_android_content_Context_fld = context;
        b1 = a_com_xxx_sdk_b_static_fld;
        com.xxx.sdk.c.a.b.a(context);
        return a_com_xxx_sdk_b_static_fld;
    }

    private g a()
    {
        return a_com_xxx_sdk_c_g_fld;
    }

    private com.xxx.sdk.f.a a(Class class1)
    {
        return a(class1, null);
    }

    private void f(Context context)
    {
        a_android_content_Context_fld = context;
        com.xxx.sdk.c.a.b.a(context);
    }

    private void g(Context context)
    {
        int i;
        int i1;
        SharedPreferences sharedpreferences;
        i = 0;
        sharedpreferences = context.getSharedPreferences("setting", 0);
        i1 = sharedpreferences.getInt("version", 0);
        int k = Integer.parseInt(com.xxx.sdk.j.a.N);
        i = k;
_L7:
        if(i == i1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 16 16: default 60
    //                   16 82;
           goto _L3 _L4
_L3:
        sharedpreferences.edit().putInt("version", i).commit();
_L2:
        return;
_L4:
        int l = (new com.xxx.sdk.a.g(context)).i();
        if(l > 0 && a_com_xxx_sdk_e_e_f_fld != null)
            a_com_xxx_sdk_e_e_f_fld.bW = l;
        if(true) goto _L3; else goto _L5
_L5:
        Exception exception;
        exception;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private void shutdown()
    {
        com.xxx.sdk.e.c.info("AdManager\u505C\u6B62...");
        u();
    }

    private void t()
    {
        Object obj;
        com.xxx.sdk.e.c.info("AdManager\u542F\u52A8...");
        u();
        int i;
        int k;
        Object obj1;
        Exception exception1;
        try
        {
            a_com_xxx_sdk_e_e_f_fld = com.xxx.sdk.e.e.a.a(a_android_content_Context_fld);
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            com.xxx.sdk.e.c.a("\u672A\u77E5\u9519\u8BEF", ((Throwable) (obj)));
        }
        obj = a_android_content_Context_fld;
        obj1 = ((Context) (obj)).getSharedPreferences("setting", 0);
        k = ((SharedPreferences) (obj1)).getInt("version", 0);
        try
        {
            i = Integer.parseInt(com.xxx.sdk.j.a.N);
        }
        catch(Exception exception2)
        {
            i = 0;
        }
        if(i == k) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 16 16: default 80
    //                   16 214;
           goto _L3 _L4
_L3:
        ((SharedPreferences) (obj1)).edit().putInt("version", i).commit();
_L2:
        int l;
        try
        {
            a_com_xxx_sdk_c_f_fld.r();
        }
        catch(Exception exception)
        {
            com.xxx.sdk.e.c.a((new StringBuilder("\u52A0\u8F7D[")).append(a_com_xxx_sdk_c_f_fld.getClass().getSimpleName()).append("]\u4E2D\u5F02\u5E38").toString(), exception);
        }
        obj = a_java_util_Collection_fld.iterator();
        do
        {
            if(!((Iterator) (obj)).hasNext())
                break;
            obj1 = (com.xxx.sdk.d)((Iterator) (obj)).next();
            if(obj1 instanceof com.xxx.sdk.a)
                try
                {
                    ((com.xxx.sdk.a)obj1).r();
                }
                // Misplaced declaration of an exception variable
                catch(Exception exception1)
                {
                    com.xxx.sdk.e.c.a((new StringBuilder("\u52A0\u8F7D[")).append(obj1.getClass().getSimpleName()).append("]\u4E2D\u5F02\u5E38").toString(), exception1);
                }
        } while(true);
        break; /* Loop/switch isn't completed */
_L4:
        l = (new com.xxx.sdk.a.g(((Context) (obj)))).i();
        if(l > 0 && a_com_xxx_sdk_e_e_f_fld != null)
            a_com_xxx_sdk_e_e_f_fld.bW = l;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private void update()
    {
        com.xxx.sdk.e.c.info("AdManager\u66F4\u65B0...");
        u();
        Iterator iterator;
        try
        {
            a_com_xxx_sdk_c_f_fld.s();
        }
        catch(Exception exception)
        {
            com.xxx.sdk.e.c.a((new StringBuilder("\u66F4\u65B0[")).append(a_com_xxx_sdk_c_f_fld.getClass().getSimpleName()).append("]\u4E2D\u5F02\u5E38").toString(), exception);
        }
        iterator = a_java_util_Collection_fld.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            com.xxx.sdk.d d1 = (com.xxx.sdk.d)iterator.next();
            if(d1 instanceof com.xxx.sdk.a)
                try
                {
                    ((com.xxx.sdk.a)d1).s();
                }
                catch(Exception exception1)
                {
                    com.xxx.sdk.e.c.a((new StringBuilder("\u66F4\u65B0[")).append(d1.getClass().getSimpleName()).append("]\u4E2D\u5F02\u5E38").toString(), exception1);
                }
        } while(true);
    }

    public final com.xxx.sdk.d a(Class class1)
    {
        com.xxx.sdk.d d1;
        Iterator iterator = a_java_util_Collection_fld.iterator();
        do
        {
            if(!iterator.hasNext())
                break MISSING_BLOCK_LABEL_56;
            d1 = (com.xxx.sdk.d)iterator.next();
        } while(!class1.isInstance(d1));
        class1 = (com.xxx.sdk.d)class1.cast(d1);
        return class1;
        class1;
        com.xxx.sdk.e.c.a("\u672A\u77E5\u5F02\u5E38", class1);
        return null;
    }

    public final com.xxx.sdk.e.e.f a()
    {
        u();
        return a_com_xxx_sdk_e_e_f_fld;
    }

    public final com.xxx.sdk.f.a a(Class class1, Map map)
    {
        com.xxx.sdk.e.e.a.g(a_android_content_Context_fld);
        class1 = (com.xxx.sdk.f.a)class1.cast(((com.xxx.sdk.d)c.get(Integer.valueOf(class1.hashCode()))).a(map));
        if(class1 != null)
            return class1;
        else
            return null;
    }

    public final com.xxx.sdk.f.e a(String s)
    {
        com.xxx.sdk.f.e e1;
        try
        {
            e1 = ((c)c.get(Integer.valueOf(com/xxx/sdk/f/e.hashCode()))).b(s);
        }
        catch(Exception exception)
        {
            com.xxx.sdk.e.c.a((new StringBuilder("\u67E5\u8BE2\u5305\u540D\uFF1A")).append(s).append("\u5F02\u5E38").toString(), exception);
            return null;
        }
        return e1;
    }

    public final h a()
    {
        c c1 = (c)a(com/xxx/sdk/c/c);
        if(c1 instanceof h)
            return c1;
        else
            return null;
    }

    public final p a()
    {
        u();
        return a_com_xxx_sdk_c_f_fld.a();
    }

    public final String d()
    {
        u();
        if(f)
            return J;
        f = true;
        if(com.xxx.sdk.e.e.a.k() && com.xxx.sdk.e.e.a.b(a_android_content_Context_fld, "android.permission.WRITE_EXTERNAL_STORAGE"))
        {
            J = com.xxx.sdk.e.b.a(Arrays.asList(new String[] {
                com.xxx.sdk.e.e.a.B(), String.valueOf(a_android_content_Context_fld.getApplicationInfo().packageName.hashCode())
            }), File.separator).concat(File.separator);
            return J;
        } else
        {
            com.xxx.sdk.e.c.warn("\u624B\u673A\u6CA1\u6709\u5B89\u88C5\u5916\u90E8\u5B58\u50A8\u5361\uFF08\uFF33\uFF24\uFF09\u6216\u8005\u5E94\u7528\u7A0B\u5E8F\u6709\u6743\u9650\u8BFB\u5199\u5916\u90E8\u5B58\u50A8\u5361\uFF08\uFF33\uFF24\uFF09");
            return null;
        }
    }

    public final Context getContext()
    {
        u();
        return a_android_content_Context_fld;
    }

    public final void u()
    {
        if(a_android_content_Context_fld == null)
            throw new IllegalArgumentException("AdManager.context is null, it should be set before any method is invoked!");
        else
            return;
    }

    private static b a_com_xxx_sdk_b_static_fld = null;
    public static final j a_com_xxx_sdk_j_static_fld = com.xxx.sdk.j.a();
    private String J;
    public Context a_android_content_Context_fld;
    private com.xxx.sdk.c.a.b a_com_xxx_sdk_c_a_b_fld;
    public f a_com_xxx_sdk_c_f_fld;
    public g a_com_xxx_sdk_c_g_fld;
    public com.xxx.sdk.e.e.f a_com_xxx_sdk_e_e_f_fld;
    public Collection a_java_util_Collection_fld;
    private Map c;
    private boolean f;

}
