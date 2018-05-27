// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xxx.f.H;
import com.xxx.f.b;
import com.xxx.f.p;
import com.xxx.sdk.d.d;
import com.xxx.sdk.d.i;
import com.xxx.sdk.f.c;
import com.xxx.sdk.f.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{

    public a()
    {
    }

    public static void A()
    {
        d_java_util_List_static_fld.clear();
        e_java_util_concurrent_atomic_AtomicBoolean_static_fld.set(false);
    }

    public static void B()
    {
        e_java_util_List_static_fld.clear();
        j.set(false);
    }

    public static void C()
    {
        com.xxx.sdk.d.d.a().sendEmptyMessage(97);
        com.xxx.sdk.d.i.a().sendEmptyMessage(86);
    }

    public static b a()
    {
        com/xxx/sdk/api/a;
        JVM INSTR monitorenter ;
        boolean flag = e_java_util_List_static_fld.isEmpty();
        if(!flag) goto _L2; else goto _L1
_L1:
        b b1 = null;
_L4:
        com/xxx/sdk/api/a;
        JVM INSTR monitorexit ;
        return b1;
_L2:
        b1 = (b)e_java_util_List_static_fld.get(0);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static p a()
    {
        com/xxx/sdk/api/a;
        JVM INSTR monitorenter ;
        boolean flag = d_java_util_List_static_fld.isEmpty();
        if(!flag) goto _L2; else goto _L1
_L1:
        p p1 = null;
_L4:
        com/xxx/sdk/api/a;
        JVM INSTR monitorexit ;
        return p1;
_L2:
        p1 = (p)d_java_util_List_static_fld.get(0);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static c a()
    {
        return c_com_xxx_sdk_f_c_static_fld;
    }

    public static com.xxx.sdk.f.d a()
    {
        return b_com_xxx_sdk_f_d_static_fld;
    }

    private static f a()
    {
        return a_com_xxx_sdk_f_f_static_fld;
    }

    private static String a(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            context.printStackTrace();
            return "";
        }
        return context;
    }

    private static List a()
    {
        com/xxx/sdk/api/a;
        JVM INSTR monitorenter ;
        List list = d_java_util_List_static_fld;
        com/xxx/sdk/api/a;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public static void a(c c1)
    {
        c_com_xxx_sdk_f_c_static_fld = c1;
    }

    public static void a(com.xxx.sdk.f.d d1)
    {
        b_com_xxx_sdk_f_d_static_fld = d1;
    }

    public static void a(f f1)
    {
        a_com_xxx_sdk_f_f_static_fld = f1;
    }

    private static List b()
    {
        com/xxx/sdk/api/a;
        JVM INSTR monitorenter ;
        List list = e_java_util_List_static_fld;
        com/xxx/sdk/api/a;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public static void b(boolean flag)
    {
        g_java_util_concurrent_atomic_AtomicBoolean_static_fld.set(flag);
    }

    public static void c(boolean flag)
    {
        f_java_util_concurrent_atomic_AtomicBoolean_static_fld.set(flag);
    }

    private static int d()
    {
        com/xxx/sdk/api/a;
        JVM INSTR monitorenter ;
        int k = d_java_util_List_static_fld.size();
        com/xxx/sdk/api/a;
        JVM INSTR monitorexit ;
        return k;
        Exception exception;
        exception;
        throw exception;
    }

    private static int e()
    {
        com/xxx/sdk/api/a;
        JVM INSTR monitorenter ;
        int k = e_java_util_List_static_fld.size();
        com/xxx/sdk/api/a;
        JVM INSTR monitorexit ;
        return k;
        Exception exception;
        exception;
        throw exception;
    }

    public static void e(b b1)
    {
        com/xxx/sdk/api/a;
        JVM INSTR monitorenter ;
        e_java_util_List_static_fld.add(b1);
        com/xxx/sdk/api/a;
        JVM INSTR monitorexit ;
        return;
        b1;
        throw b1;
    }

    public static void e(p p1)
    {
        com/xxx/sdk/api/a;
        JVM INSTR monitorenter ;
        d_java_util_List_static_fld.add(p1);
        com/xxx/sdk/api/a;
        JVM INSTR monitorexit ;
        return;
        p1;
        throw p1;
    }

    public static com.xxx.d.a a_com_xxx_d_a_static_fld = new com.xxx.d.a();
    public static H a_com_xxx_f_H_static_fld = null;
    private static f a_com_xxx_sdk_f_f_static_fld;
    public static com.xxx.d.a b_com_xxx_d_a_static_fld = new com.xxx.d.a();
    private static com.xxx.sdk.f.d b_com_xxx_sdk_f_d_static_fld;
    private static HashMap b_java_util_HashMap_static_fld;
    private static ExecutorService b_java_util_concurrent_ExecutorService_static_fld;
    private static c c_com_xxx_sdk_f_c_static_fld;
    public static AtomicBoolean c_java_util_concurrent_atomic_AtomicBoolean_static_fld = new AtomicBoolean(false);
    private static List d_java_util_List_static_fld = new ArrayList();
    public static AtomicBoolean d_java_util_concurrent_atomic_AtomicBoolean_static_fld = new AtomicBoolean(false);
    public static long e_long_static_fld = 0L;
    private static List e_java_util_List_static_fld = new ArrayList();
    public static AtomicBoolean e_java_util_concurrent_atomic_AtomicBoolean_static_fld = new AtomicBoolean(false);
    private static long f_long_static_fld;
    public static List f_java_util_List_static_fld = new ArrayList();
    public static AtomicBoolean f_java_util_concurrent_atomic_AtomicBoolean_static_fld = new AtomicBoolean(false);
    public static long g_long_static_fld = 0L;
    public static AtomicBoolean g_java_util_concurrent_atomic_AtomicBoolean_static_fld = new AtomicBoolean(false);
    public static long h_long_static_fld = 0L;
    private static AtomicBoolean h_java_util_concurrent_atomic_AtomicBoolean_static_fld;
    public static AtomicBoolean i = new AtomicBoolean(false);
    public static AtomicBoolean j = new AtomicBoolean(false);
    private static volatile boolean l = true;

    static 
    {
        new HashMap();
        new AtomicBoolean(false);
        Executors.newSingleThreadExecutor();
    }
}
