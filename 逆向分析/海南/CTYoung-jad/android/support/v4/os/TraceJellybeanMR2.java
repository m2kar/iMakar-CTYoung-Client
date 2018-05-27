// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.os;

import android.os.Trace;

class TraceJellybeanMR2
{

    TraceJellybeanMR2()
    {
    }

    public static void beginSection(String s)
    {
        Trace.beginSection(s);
    }

    public static void endSection()
    {
        Trace.endSection();
    }
}
