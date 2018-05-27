// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.actionbarsherlock.internal.widget;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

public class CollapsibleActionViewWrapper extends FrameLayout
    implements CollapsibleActionView
{

    public CollapsibleActionViewWrapper(View view)
    {
        super(view.getContext());
        child = (com.actionbarsherlock.view.CollapsibleActionView)view;
        addView(view);
    }

    public void onActionViewCollapsed()
    {
        child.onActionViewCollapsed();
    }

    public void onActionViewExpanded()
    {
        child.onActionViewExpanded();
    }

    public View unwrap()
    {
        return getChildAt(0);
    }

    private final com.actionbarsherlock.view.CollapsibleActionView child;
}
