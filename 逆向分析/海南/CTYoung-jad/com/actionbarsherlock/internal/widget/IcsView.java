// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.actionbarsherlock.internal.widget;

import android.view.View;

final class IcsView
{

    private IcsView()
    {
    }

    public static int getMeasuredStateInt(View view)
    {
        return view.getMeasuredWidth() & 0xff000000 | view.getMeasuredHeight() >> 16 & 0xffffff00;
    }
}
