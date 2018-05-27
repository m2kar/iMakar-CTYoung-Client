// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d.a;

import com.xxx.sdk.e.a.a.d.g;
import java.util.Locale;

// Referenced classes of package com.xxx.sdk.e.a.a.d.a:
//            f

public class c
{

    public c()
    {
    }

    private g b()
    {
        return b;
    }

    private void b(g g1)
    {
        b = g1;
    }

    private int getFlags()
    {
        return flags;
    }

    private String getKey()
    {
        return key;
    }

    private int getSize()
    {
        return size;
    }

    private void setFlags(int i)
    {
        flags = i;
    }

    private void setKey(String s)
    {
        key = s;
    }

    private void setSize(int i)
    {
        size = i;
    }

    public String a(f f, Locale locale)
    {
        if(b != null)
            return b.a(f, locale);
        else
            return "null";
    }

    public String toString()
    {
        return (new StringBuilder("ResourceEntry{size=")).append(size).append(", flags=").append(flags).append(", key='").append(key).append('\'').append(", value=").append(b).append('}').toString();
    }

    private static int bB = 1;
    private static int bC = 2;
    public g b;
    int flags;
    public String key;
    int size;
}
