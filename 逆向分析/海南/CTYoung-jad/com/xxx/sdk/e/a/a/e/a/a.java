// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e.a;

import java.io.Writer;

// Referenced classes of package com.xxx.sdk.e.a.a.e.a:
//            b

final class a extends b
{

    public transient a(b ab[])
    {
        a = ab;
    }

    public final int a(CharSequence charsequence, int i, Writer writer)
    {
        b ab[] = a;
        int k = ab.length;
        for(int j = 0; j < k; j++)
        {
            int l = ab[j].a(charsequence, i, writer);
            if(l != 0)
                return l;
        }

        return 0;
    }

    private final b a[];
}
