// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e.a;

import java.io.Writer;

// Referenced classes of package com.xxx.sdk.e.a.a.e.a:
//            b

abstract class c extends b
{

    c()
    {
    }

    public final int a(CharSequence charsequence, int i, Writer writer)
    {
        return !a(Character.codePointAt(charsequence, i), writer) ? 0 : 1;
    }

    public abstract boolean a(int i, Writer writer);
}
