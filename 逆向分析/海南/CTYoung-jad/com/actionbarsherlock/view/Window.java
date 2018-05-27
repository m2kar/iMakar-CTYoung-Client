// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.actionbarsherlock.view;

import android.content.Context;

// Referenced classes of package com.actionbarsherlock.view:
//            MenuItem

public abstract class Window extends android.view.Window
{
    public static interface Callback
    {

        public abstract boolean onMenuItemSelected(int i, MenuItem menuitem);
    }


    private Window(Context context)
    {
        super(context);
    }

    public static final long FEATURE_ACTION_BAR = 8L;
    public static final long FEATURE_ACTION_BAR_OVERLAY = 9L;
    public static final long FEATURE_ACTION_MODE_OVERLAY = 10L;
    public static final long FEATURE_INDETERMINATE_PROGRESS = 5L;
    public static final long FEATURE_NO_TITLE = 1L;
    public static final long FEATURE_PROGRESS = 2L;
}
