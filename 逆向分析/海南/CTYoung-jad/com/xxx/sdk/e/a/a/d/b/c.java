// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.b;


// Referenced classes of package com.xxx.sdk.e.a.a.d.b:
//            a

public final class c
{

    public c()
    {
    }

    public c(int i)
    {
        a = new a[i];
    }

    private static void Y()
    {
    }

    private Integer a(String s)
    {
        s = get(s);
        if(s == null)
            return null;
        else
            return Integer.valueOf(s);
    }

    private void a(int i, a a1)
    {
        a[i] = a1;
    }

    private a[] a()
    {
        return a;
    }

    private Long getLong(String s)
    {
        s = get(s);
        if(s == null)
            return null;
        else
            return Long.valueOf(s);
    }

    private int size()
    {
        return a.length;
    }

    public final String get(String s)
    {
        a aa[] = a;
        int j = aa.length;
        for(int i = 0; i < j; i++)
        {
            a a1 = aa[i];
            if(a1.name.equals(s))
                return a1.value;
        }

        return null;
    }

    public final boolean h(String s)
    {
        s = get(s);
        if(s == null)
            return false;
        else
            return Boolean.parseBoolean(s);
    }

    public final a a[];
}
