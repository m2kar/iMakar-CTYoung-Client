// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.xxx.sdk.a;
import com.xxx.sdk.a.i;
import com.xxx.sdk.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.j;
import com.xxx.sdk.k;
import com.xxx.sdk.p;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f extends k
    implements a
{

    public f()
    {
        a_java_lang_String_array1d_fld = b.a.a;
        a_com_xxx_sdk_p_fld = null;
        a_com_xxx_sdk_a_i_fld = null;
        a_com_xxx_sdk_a_j_fld = null;
        l = new AtomicBoolean(false);
    }

    private boolean f()
    {
        if(l.getAndSet(true))
            return true;
        Context context = b.a().getContext();
        a_com_xxx_sdk_a_i_fld = new i(context);
        if(a_com_xxx_sdk_a_j_fld == null)
            a_com_xxx_sdk_a_j_fld = a_com_xxx_sdk_a_i_fld.a("settings");
        com.xxx.sdk.e.e.a.g(context);
        com.xxx.sdk.e.e.a.h(context);
        return true;
    }

    public final p a()
    {
        f();
        if(a_com_xxx_sdk_p_fld == null && a_com_xxx_sdk_a_j_fld != null && !com.xxx.sdk.e.b.f(a_com_xxx_sdk_a_j_fld.value))
        {
            a_com_xxx_sdk_p_fld = p.a(a_com_xxx_sdk_a_j_fld.value);
            c.info((new StringBuilder("\u4ECE\u6570\u636E\u5E93\u4E2D\u6062\u590Dsettings\uFF0C")).append(a_com_xxx_sdk_p_fld).toString());
        }
        if(a_com_xxx_sdk_p_fld == null)
        {
            a_com_xxx_sdk_p_fld = new p();
            c.info((new StringBuilder("\u4F7F\u7528settings\u4F7F\u7528\u9ED8\u8BA4\u914D\u7F6E\uFF0C")).append(a_com_xxx_sdk_p_fld).toString());
        }
        return a_com_xxx_sdk_p_fld;
    }

    protected final boolean d()
    {
        return super.d() && com.xxx.sdk.e.e.a.f(b.a().getContext());
    }

    public final void onDestroy()
    {
    }

    public final void r()
    {
        f();
        if(com.xxx.sdk.e.b.f(a_com_xxx_sdk_a_j_fld.value))
        {
            if(a_java_lang_String_array1d_fld != null)
            {
                int i1 = 0;
                do
                {
                    if(i1 >= a_java_lang_String_array1d_fld.length)
                        break;
                    a_com_xxx_sdk_a_j_fld.value = b(a_java_lang_String_array1d_fld[i1]);
                    if(!com.xxx.sdk.e.b.f(a_com_xxx_sdk_a_j_fld.value))
                        break;
                    i1++;
                } while(true);
            }
            if(com.xxx.sdk.e.b.f(a_com_xxx_sdk_a_j_fld.value))
            {
                c.warn("\u6CA1\u6709\u4ECE\u670D\u52A1\u5668\u7AEF\u8BF7\u6C42\u5230settings");
            } else
            {
                a_com_xxx_sdk_a_j_fld.updated = System.currentTimeMillis();
                com.xxx.sdk.e.e.a.x(a_com_xxx_sdk_a_j_fld.value);
                a_com_xxx_sdk_p_fld = p.a(a_com_xxx_sdk_a_j_fld.value);
                a_com_xxx_sdk_a_i_fld.a(a_com_xxx_sdk_a_j_fld);
            }
        } else
        {
            a_com_xxx_sdk_p_fld = p.a(a_com_xxx_sdk_a_j_fld.value);
        }
        s();
    }

    public final void s()
    {
        String s2;
label0:
        {
            f();
            if(System.currentTimeMillis() - a_com_xxx_sdk_a_j_fld.updated > a().b)
            {
                Object obj = new com.xxx.sdk.d.b();
                com.xxx.sdk.c.a.b b1 = com.xxx.sdk.c.a.b.a();
                if(b1.b == null && b1.b == null)
                {
                    String s3 = b.a().d();
                    String s1 = s3;
                    if(s3 == null)
                    {
                        c.warn("\u5916\u90E8\u5B58\u50A8\u4E0D\u80FD\u4F7F\u7528\uFF0Cbanner\u5E7F\u544A\u5B58\u50A8\u76EE\u5F55\uFF1A".concat(s3));
                        s1 = b1.a.getApplicationInfo().dataDir.concat(File.separator);
                    }
                    b1.b = new File(s1.concat(String.valueOf(com/xxx/sdk/c/a/a/b.getSimpleName().hashCode())));
                    b1.b.mkdirs();
                }
                ((com.xxx.sdk.d.b) (obj)).execute(new File[] {
                    b1.b
                });
                obj = new HashMap();
                ((HashMap) (obj)).put("v", (new StringBuilder()).append(a().version).toString());
                if(a_java_lang_String_array1d_fld != null)
                {
                    int i1 = 0;
                    s2 = null;
                    do
                    {
                        if(i1 >= a_java_lang_String_array1d_fld.length)
                            break;
                        String s4 = c(a_java_lang_String_array1d_fld[i1], ((java.util.Map) (obj)));
                        s2 = s4;
                        if(!com.xxx.sdk.e.b.f(s4))
                            break;
                        i1++;
                        s2 = s4;
                    } while(true);
                } else
                {
                    s2 = null;
                }
                if(!com.xxx.sdk.e.b.f(s2))
                    break label0;
                c.warn("\u6CA1\u6709\u4ECE\u670D\u52A1\u5668\u7AEF\u8BF7\u6C42\u5230settings");
            }
            return;
        }
        com.xxx.sdk.e.e.a.x(s2);
        a_com_xxx_sdk_a_j_fld.updated = System.currentTimeMillis();
        if((com.xxx.sdk.e.b.f(a_com_xxx_sdk_a_j_fld.value) || a_com_xxx_sdk_a_j_fld.value.compareTo(s2) != 0) && p.a(s2) != a_com_xxx_sdk_p_fld.version)
        {
            a_com_xxx_sdk_a_j_fld.value = s2;
            a_com_xxx_sdk_p_fld = p.a(a_com_xxx_sdk_a_j_fld.value);
        }
        a_com_xxx_sdk_a_i_fld.a(a_com_xxx_sdk_a_j_fld);
    }

    private i a_com_xxx_sdk_a_i_fld;
    private com.xxx.sdk.a.j a_com_xxx_sdk_a_j_fld;
    private p a_com_xxx_sdk_p_fld;
    private String a_java_lang_String_array1d_fld[];
    private AtomicBoolean l;
}
