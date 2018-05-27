// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.a;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.xxx.sdk.e.a.a.a:
//            c, f, g

public final class a
{

    public a()
    {
        n = new ArrayList();
        o = new ArrayList();
        p = new ArrayList();
    }

    private c a()
    {
        return a_com_xxx_sdk_e_a_a_a_c_fld;
    }

    private Long a()
    {
        return a_java_lang_Long_fld;
    }

    private void a(c c)
    {
        a_com_xxx_sdk_e_a_a_a_c_fld = c;
    }

    private void a(f f1)
    {
        p.add(f1);
    }

    private void a(g g1)
    {
        o.add(g1);
    }

    private void a(Long long1)
    {
        a_java_lang_Long_fld = long1;
    }

    private void d(boolean flag)
    {
        q = flag;
    }

    private List e()
    {
        return n;
    }

    private void e(boolean flag)
    {
        r = flag;
    }

    private List f()
    {
        return o;
    }

    private void f(boolean flag)
    {
        s = flag;
    }

    private List g()
    {
        return p;
    }

    private void g(boolean flag)
    {
        t = flag;
    }

    private boolean g()
    {
        return q;
    }

    private String getLabel()
    {
        return label;
    }

    private String getName()
    {
        return label;
    }

    private String getPackageName()
    {
        return packageName;
    }

    private boolean h()
    {
        return r;
    }

    private boolean i()
    {
        return s;
    }

    private void j(String s1)
    {
        versionName = s1;
    }

    private boolean j()
    {
        return t;
    }

    private void k(String s1)
    {
        bG = s1;
    }

    private void l(String s1)
    {
        bH = s1;
    }

    private void m(String s1)
    {
        bI = s1;
    }

    private void n(String s1)
    {
        n.add(s1);
    }

    private void o(String s1)
    {
        icon = s1;
    }

    private String p()
    {
        return versionName;
    }

    private void p(String s1)
    {
        bF = s1;
    }

    private String q()
    {
        return bG;
    }

    private String r()
    {
        return bH;
    }

    private String s()
    {
        return bI;
    }

    private void setLabel(String s1)
    {
        label = s1;
    }

    private void setPackageName(String s1)
    {
        packageName = s1;
    }

    private String t()
    {
        return icon;
    }

    private String u()
    {
        return bF;
    }

    public final String toString()
    {
        return (new StringBuilder("packageName: \t")).append(packageName).append("\nlabel: \t").append(label).append("\nicon: \t").append(icon).append("\nversionName: \t").append(versionName).append("\nversionCode: \t").append(a_java_lang_Long_fld).append("\nminSdkVersion: \t").append(bG).append("\ntargetSdkVersion: \t").append(bH).append("\nmaxSdkVersion: \t").append(bI).toString();
    }

    public c a_com_xxx_sdk_e_a_a_a_c_fld;
    public Long a_java_lang_Long_fld;
    public String bF;
    public String bG;
    public String bH;
    public String bI;
    public String icon;
    public String label;
    public List n;
    public List o;
    public List p;
    public String packageName;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public String versionName;
}
