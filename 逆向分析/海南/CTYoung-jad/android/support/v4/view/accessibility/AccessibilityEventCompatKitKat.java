// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

class AccessibilityEventCompatKitKat
{

    AccessibilityEventCompatKitKat()
    {
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityevent)
    {
        return accessibilityevent.getContentChangeTypes();
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityevent, int i)
    {
        accessibilityevent.setContentChangeTypes(i);
    }
}
