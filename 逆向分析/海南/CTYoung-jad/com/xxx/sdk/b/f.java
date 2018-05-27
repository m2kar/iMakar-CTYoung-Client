// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.b;

import com.xxx.sdk.e.b;
import com.xxx.sdk.e.c;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.xxx.sdk.b:
//            g

public final class f
{

    public f()
    {
        a = g.image;
        n = false;
    }

    private static f a()
    {
        return new f();
    }

    private f a(g g1)
    {
        a = g1;
        return this;
    }

    private f a(String s)
    {
        ba = s;
        return this;
    }

    private f a(boolean flag)
    {
        n = flag;
        return this;
    }

    public static f b(String s)
    {
        if(!com.xxx.sdk.e.b.f(s))
        {
            String s1 = com.xxx.sdk.e.b.f(s);
            int i = s1.lastIndexOf(".");
            if(i >= 0)
            {
                f f1 = new f();
                f1.n = true;
                f1.ba = s;
                s1 = s1.substring(i + 1).toLowerCase();
                if(g.contains(s1))
                {
                    f1.a = g.h5;
                    return f1;
                }
                if(h.contains(s1))
                {
                    f1.a = g.image;
                    return f1;
                }
                if(s.toLowerCase().startsWith("http:") || s.toLowerCase().startsWith("https:"))
                {
                    f1.a = g.h5;
                    return f1;
                } else
                {
                    c.warn((new StringBuilder("\u8D44\u6E90\u5730\u5740\uFF1A")).append(s).append("\uFF0C\u5B83\u4E0D\u662Fh5\u548Cimg\u8FD9\u4E24\u79CD\uFF0C\u6682\u4E0D\u652F\u6301").toString());
                    return null;
                }
            }
            if(s.toLowerCase().startsWith("http:") || s.toLowerCase().startsWith("https:"))
            {
                f f2 = new f();
                f2.n = true;
                f2.ba = s;
                f2.a = g.h5;
                return f2;
            }
        }
        return null;
    }

    public static boolean d(String s)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if(com.xxx.sdk.e.b.f(s))
                break label0;
            s = com.xxx.sdk.e.b.f(s);
            int i = s.lastIndexOf(".");
            flag = flag1;
            if(i < 0)
                break label0;
            s = s.substring(i + 1);
            if(!g.contains(s))
            {
                flag = flag1;
                if(!"css".equals(s))
                    break label0;
            }
            flag = true;
        }
        return flag;
    }

    public final String toString()
    {
        return (new StringBuilder("Resource [type=")).append(a).append(", isFilepath=").append(n).append(", content=").append(ba).append("]").toString();
    }

    private static List g = Arrays.asList(new String[] {
        "html", "htm", "shtml", "shtm"
    });
    private static List h = Arrays.asList(new String[] {
        "jpg", "jpeg", "png", "gif", "bmp", "ico"
    });
    public g a;
    public String ba;
    public boolean n;

}
