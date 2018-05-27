// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.xxx.sdk.e.a;

public final class m
    implements android.content.DialogInterface.OnKeyListener
{

    public m(a a1)
    {
        b = a1;
        super();
    }

    public final boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if(i == 4)
        {
            a.a(b.b, false);
            flag = true;
        }
        return flag;
    }

    private a b;
}
