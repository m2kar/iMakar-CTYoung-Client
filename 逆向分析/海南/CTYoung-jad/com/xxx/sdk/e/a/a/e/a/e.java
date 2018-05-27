// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e.a;

import java.io.Writer;
import java.util.HashMap;

// Referenced classes of package com.xxx.sdk.e.a.a.e.a:
//            b

final class e extends b
{

    public transient e(CharSequence acharsequence[][])
    {
        int j = 0x7fffffff;
        int i;
        if(acharsequence != null)
        {
            int j1 = acharsequence.length;
            int k = 0;
            i = 0;
            int l;
            for(j = 0x7fffffff; k < j1; j = l)
            {
                CharSequence acharsequence1[] = acharsequence[k];
                c.put(acharsequence1[0].toString(), acharsequence1[1]);
                int i1 = acharsequence1[0].length();
                l = j;
                if(i1 < j)
                    l = i1;
                if(i1 > i)
                    i = i1;
                k++;
            }

        } else
        {
            i = 0;
        }
        bG = j;
        bH = i;
    }

    public final int a(CharSequence charsequence, int i, Writer writer)
    {
        int j = bH;
        if(bH + i > charsequence.length())
            j = charsequence.length() - i;
        for(; j >= bG; j--)
        {
            CharSequence charsequence1 = charsequence.subSequence(i, i + j);
            charsequence1 = (CharSequence)c.get(charsequence1.toString());
            if(charsequence1 != null)
            {
                writer.write(charsequence1.toString());
                return j;
            }
        }

        return 0;
    }

    private final int bG;
    private final int bH;
    private final HashMap c = new HashMap();
}
