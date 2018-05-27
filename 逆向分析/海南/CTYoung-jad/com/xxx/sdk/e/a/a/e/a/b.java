// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e.a;

import java.io.*;
import java.util.Locale;

// Referenced classes of package com.xxx.sdk.e.a.a.e.a:
//            a

abstract class b
{

    b()
    {
    }

    private transient b a(b ab[])
    {
        b ab1[] = new b[ab.length + 1];
        ab1[0] = this;
        System.arraycopy(ab, 0, ab1, 1, ab.length);
        return new a(ab1);
    }

    private void a(CharSequence charsequence, Writer writer)
    {
        if(charsequence != null)
        {
            int k = charsequence.length();
            int i = 0;
            while(i < k) 
            {
                int l = a(charsequence, i, writer);
                if(l == 0)
                {
                    char ac[] = Character.toChars(Character.codePointAt(charsequence, i));
                    writer.write(ac);
                    i += ac.length;
                } else
                {
                    int j = 0;
                    while(j < l) 
                    {
                        i += Character.charCount(Character.codePointAt(charsequence, i));
                        j++;
                    }
                }
            }
        }
    }

    private static String h(int i)
    {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }

    public abstract int a(CharSequence charsequence, int i, Writer writer);

    public final String a(CharSequence charsequence)
    {
        if(charsequence == null)
            return null;
        try
        {
            StringWriter stringwriter = new StringWriter(charsequence.length() << 1);
            a(charsequence, ((Writer) (stringwriter)));
            charsequence = stringwriter.toString();
        }
        // Misplaced declaration of an exception variable
        catch(CharSequence charsequence)
        {
            throw new RuntimeException(charsequence);
        }
        return charsequence;
    }
}
