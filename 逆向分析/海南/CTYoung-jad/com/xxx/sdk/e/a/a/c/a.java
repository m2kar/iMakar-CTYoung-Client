// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.c;

import com.xxx.sdk.e.a.a.a.f;
import com.xxx.sdk.e.a.a.a.g;
import com.xxx.sdk.e.a.a.d.b.c;
import com.xxx.sdk.e.a.a.d.b.d;
import com.xxx.sdk.e.a.a.d.b.h;
import com.xxx.sdk.e.a.a.d.b.j;
import java.util.List;

// Referenced classes of package com.xxx.sdk.e.a.a.c:
//            i

public final class a
    implements i
{

    public a()
    {
        c = new String[100];
        depth = 0;
        a = new com.xxx.sdk.e.a.a.a.a();
    }

    private com.xxx.sdk.e.a.a.a.a a()
    {
        return a;
    }

    private transient boolean a(String as[])
    {
        boolean flag1 = true;
        if(depth == as.length + 1) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        int k = 1;
        do
        {
            flag = flag1;
            if(k >= depth)
                continue;
            if(!c[k].equals(as[k - 1]))
                return false;
            k++;
        } while(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean g(String s)
    {
        return c[depth - 1].endsWith(s);
    }

    public final void a(d d)
    {
    }

    public final void a(com.xxx.sdk.e.a.a.d.b.f f1)
    {
    }

    public final void a(com.xxx.sdk.e.a.a.d.b.g g1)
    {
    }

    public final void a(h h)
    {
        depth = depth - 1;
    }

    public final void a(j j1)
    {
        Object obj;
        Object obj2;
        c c1;
        String s3;
        obj2 = null;
        obj = null;
        c1 = j1.a;
        s3 = j1.name;
        if(!"application".equals(s3)) goto _L2; else goto _L1
_L1:
        a.label = c1.get("label");
        a.icon = c1.get("icon");
_L4:
        obj = c;
        int k = depth;
        depth = k + 1;
        obj[k] = j1.name;
        return;
_L2:
        if("manifest".equals(s3))
        {
            a.packageName = c1.get("package");
            a.versionName = c1.get("versionName");
            obj2 = a;
            s3 = c1.get("versionCode");
            if(s3 != null)
                obj = Long.valueOf(s3);
            obj2.a_java_lang_Long_fld = ((Long) (obj));
            obj = c1.get("installLocation");
            if(obj != null)
                a.bF = ((String) (obj));
        } else
        if("uses-sdk".equals(s3))
        {
            a.bG = c1.get("minSdkVersion");
            a.bH = c1.get("targetSdkVersion");
            a.bI = c1.get("maxSdkVersion");
        } else
        if("supports-screens".equals(s3))
        {
            a.q = c1.h("anyDensity");
            a.r = c1.h("smallScreens");
            a.s = c1.h("normalScreens");
            a.t = c1.h("largeScreens");
        } else
        if("uses-feature".equals(s3))
        {
            String s = c1.get("name");
            boolean flag = c1.h("required");
            if(s != null)
            {
                obj2 = new g();
                obj2.name = s;
                obj2.required = flag;
                a.o.add(obj2);
            } else
            {
                Object obj1 = c1.get("glEsVersion");
                if(obj1 == null)
                    obj1 = obj2;
                else
                    obj1 = Integer.valueOf(((String) (obj1)));
                if(obj1 != null)
                {
                    int l = ((Integer) (obj1)).intValue();
                    obj1 = new com.xxx.sdk.e.a.a.a.c();
                    obj1.major = l >> 16;
                    obj1.minor = l & 0xffff;
                    obj1.required = flag;
                    a.a_com_xxx_sdk_e_a_a_a_c_fld = ((com.xxx.sdk.e.a.a.a.c) (obj1));
                }
            }
        } else
        if("uses-permission".equals(s3))
        {
            com.xxx.sdk.e.a.a.a.a a1 = a;
            String s1 = c1.get("name");
            a1.n.add(s1);
        } else
        if("permission".equals(s3))
        {
            f f1 = new f();
            f1.name = c1.get("name");
            f1.label = c1.get("label");
            f1.icon = c1.get("icon");
            f1.group = c1.get("group");
            f1.description = c1.get("description");
            String s2 = c1.get("android:protectionLevel");
            if(s2 != null)
                f1.bJ = s2;
            a.p.add(f1);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public com.xxx.sdk.e.a.a.a.a a;
    private String c[];
    private int depth;
}
