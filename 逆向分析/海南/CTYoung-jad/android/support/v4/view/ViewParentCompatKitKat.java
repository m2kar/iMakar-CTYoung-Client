// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class ViewParentCompatKitKat
{

    ViewParentCompatKitKat()
    {
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewparent, View view, View view1, int i)
    {
        viewparent.notifySubtreeAccessibilityStateChanged(view, view1, i);
    }
}
