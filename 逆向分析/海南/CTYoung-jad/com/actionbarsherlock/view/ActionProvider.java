// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.actionbarsherlock.view;

import android.content.Context;
import android.view.View;

// Referenced classes of package com.actionbarsherlock.view:
//            SubMenu

public abstract class ActionProvider
{
    public static interface SubUiVisibilityListener
    {

        public abstract void onSubUiVisibilityChanged(boolean flag);
    }


    public ActionProvider(Context context)
    {
    }

    public boolean hasSubMenu()
    {
        return false;
    }

    public abstract View onCreateActionView();

    public boolean onPerformDefaultAction()
    {
        return false;
    }

    public void onPrepareSubMenu(SubMenu submenu)
    {
    }

    public void setSubUiVisibilityListener(SubUiVisibilityListener subuivisibilitylistener)
    {
        mSubUiVisibilityListener = subuivisibilitylistener;
    }

    public void subUiVisibilityChanged(boolean flag)
    {
        if(mSubUiVisibilityListener != null)
            mSubUiVisibilityListener.onSubUiVisibilityChanged(flag);
    }

    private SubUiVisibilityListener mSubUiVisibilityListener;
}
