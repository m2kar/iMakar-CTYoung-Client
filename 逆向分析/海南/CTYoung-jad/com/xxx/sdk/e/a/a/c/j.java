// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.c;

import com.xxx.sdk.e.a.a.d.b.a;
import com.xxx.sdk.e.a.a.d.b.c;
import com.xxx.sdk.e.a.a.d.b.d;
import com.xxx.sdk.e.a.a.d.b.f;
import com.xxx.sdk.e.a.a.d.b.g;
import com.xxx.sdk.e.a.a.e.a.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xxx.sdk.e.a.a.c:
//            i, f, h

public final class j
    implements i
{

    public j()
    {
        bt = 0;
        a_java_lang_StringBuilder_fld = new StringBuilder();
        a_java_lang_StringBuilder_fld.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        a_com_xxx_sdk_e_a_a_c_f_fld = new com.xxx.sdk.e.a.a.c.f();
    }

    private void a(a a1)
    {
        a_java_lang_StringBuilder_fld.append(" ");
        String s1 = a_com_xxx_sdk_e_a_a_c_f_fld.h(a1.bP);
        String s = s1;
        if(s1 == null)
            s = a1.bP;
        if(s != null && !s.isEmpty())
            a_java_lang_StringBuilder_fld.append(s).append(':');
        s = h.k(a1.value);
        a_java_lang_StringBuilder_fld.append(a1.name).append('=').append('"').append(s).append('"');
    }

    private void k(int l)
    {
        for(int i1 = 0; i1 < l; i1++)
            a_java_lang_StringBuilder_fld.append("\t");

    }

    private String w()
    {
        return a_java_lang_StringBuilder_fld.toString();
    }

    public final void a(d d1)
    {
        k(bt);
        a_java_lang_StringBuilder_fld.append(d1.value).append('\n');
        u = false;
    }

    public final void a(f f1)
    {
        com.xxx.sdk.e.a.a.c.f f2 = a_com_xxx_sdk_e_a_a_c_f_fld;
        f1 = new com.xxx.sdk.e.a.a.c.h(f1.prefix, f1.uri, (byte)0);
        f2.q.remove(f1);
        f2.r.remove(f1);
    }

    public final void a(g g1)
    {
        com.xxx.sdk.e.a.a.c.f f1 = a_com_xxx_sdk_e_a_a_c_f_fld;
        g1 = new com.xxx.sdk.e.a.a.c.h(g1.prefix, g1.uri, (byte)0);
        f1.q.add(g1);
        f1.r.add(g1);
    }

    public final void a(com.xxx.sdk.e.a.a.d.b.h h1)
    {
        bt = bt - 1;
        if(u)
        {
            a_java_lang_StringBuilder_fld.append(" />\n");
        } else
        {
            k(bt);
            a_java_lang_StringBuilder_fld.append("</");
            if(h1.bP != null)
                a_java_lang_StringBuilder_fld.append(h1.bP).append(":");
            a_java_lang_StringBuilder_fld.append(h1.name);
            a_java_lang_StringBuilder_fld.append(">\n");
        }
        u = false;
    }

    public final void a(com.xxx.sdk.e.a.a.d.b.j j1)
    {
        if(u)
            a_java_lang_StringBuilder_fld.append(">\n");
        int l = bt;
        bt = l + 1;
        k(l);
        a_java_lang_StringBuilder_fld.append('<');
        Object obj;
        if(j1.bP != null)
        {
            obj = a_com_xxx_sdk_e_a_a_c_f_fld.h(j1.bP);
            Object obj1;
            if(obj != null)
                a_java_lang_StringBuilder_fld.append(((String) (obj))).append(":");
            else
                a_java_lang_StringBuilder_fld.append(j1.bP).append(":");
        }
        a_java_lang_StringBuilder_fld.append(j1.name);
        obj1 = a_com_xxx_sdk_e_a_a_c_f_fld;
        if(!((com.xxx.sdk.e.a.a.c.f) (obj1)).r.isEmpty())
        {
            obj = new ArrayList();
            ((List) (obj)).addAll(((com.xxx.sdk.e.a.a.c.f) (obj1)).r);
            ((com.xxx.sdk.e.a.a.c.f) (obj1)).r.clear();
        } else
        {
            obj = Collections.emptyList();
        }
        if(!((List) (obj)).isEmpty())
            for(obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a_java_lang_StringBuilder_fld.append(" xmlns:").append(((com.xxx.sdk.e.a.a.c.h) (obj1)).prefix).append("=\"").append(((com.xxx.sdk.e.a.a.c.h) (obj1)).uri).append("\""))
                obj1 = (com.xxx.sdk.e.a.a.c.h)((Iterator) (obj)).next();

        u = true;
        a aa[] = j1.a.a;
        int k1 = aa.length;
        for(int i1 = 0; i1 < k1; i1++)
        {
            a a1 = aa[i1];
            a_java_lang_StringBuilder_fld.append(" ");
            String s = a_com_xxx_sdk_e_a_a_c_f_fld.h(a1.bP);
            j1 = s;
            if(s == null)
                j1 = a1.bP;
            if(j1 != null && !j1.isEmpty())
                a_java_lang_StringBuilder_fld.append(j1).append(':');
            j1 = h.k(a1.value);
            a_java_lang_StringBuilder_fld.append(a1.name).append('=').append('"').append(j1).append('"');
        }

    }

    private com.xxx.sdk.e.a.a.c.f a_com_xxx_sdk_e_a_a_c_f_fld;
    public StringBuilder a_java_lang_StringBuilder_fld;
    private int bt;
    private boolean u;
}
