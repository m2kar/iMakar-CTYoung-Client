// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

class ShareCompatICS
{

    ShareCompatICS()
    {
    }

    public static void configureMenuItem(MenuItem menuitem, Activity activity, Intent intent)
    {
        Object obj = menuitem.getActionProvider();
        if(!(obj instanceof ShareActionProvider))
            obj = new ShareActionProvider(activity);
        else
            obj = (ShareActionProvider)obj;
        ((ShareActionProvider) (obj)).setShareHistoryFileName((new StringBuilder()).append(".sharecompat_").append(activity.getClass().getName()).toString());
        ((ShareActionProvider) (obj)).setShareIntent(intent);
        menuitem.setActionProvider(((android.view.ActionProvider) (obj)));
    }

    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";
}
