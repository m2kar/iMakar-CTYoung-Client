// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.*;
import android.util.DisplayMetrics;

// Referenced classes of package com.actionbarsherlock.internal:
//            ActionBarSherlockCompat

public final class ResourcesCompat
{

    private ResourcesCompat()
    {
    }

    public static boolean getResources_getBoolean(Context context, int i)
    {
        boolean flag = true;
        if(android.os.Build.VERSION.SDK_INT < 14) goto _L2; else goto _L1
_L1:
        flag = context.getResources().getBoolean(i);
_L4:
        return flag;
_L2:
        float f;
        float f1;
        context = context.getResources().getDisplayMetrics();
        f1 = (float)((DisplayMetrics) (context)).widthPixels / ((DisplayMetrics) (context)).density;
        f = (float)((DisplayMetrics) (context)).heightPixels / ((DisplayMetrics) (context)).density;
        if(f1 < f)
            f = f1;
        if(i != com.actionbarsherlock.R.bool.abs__action_bar_embed_tabs)
            break; /* Loop/switch isn't completed */
        if(f1 < 480F)
            return false;
        if(true) goto _L4; else goto _L3
_L3:
        if(i != com.actionbarsherlock.R.bool.abs__split_action_bar_is_narrow)
            break; /* Loop/switch isn't completed */
        if(f1 >= 480F)
            return false;
        if(true) goto _L4; else goto _L5
_L5:
        if(i != com.actionbarsherlock.R.bool.abs__action_bar_expanded_action_views_exclusive)
            break; /* Loop/switch isn't completed */
        if(f >= 600F)
            return false;
        if(true) goto _L4; else goto _L6
_L6:
        if(i == com.actionbarsherlock.R.bool.abs__config_allowActionMenuItemTextWithIcon)
        {
            if(f1 < 480F)
                return false;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown boolean resource ID ").append(i).toString());
        }
        if(true) goto _L4; else goto _L7
_L7:
    }

    public static int getResources_getInteger(Context context, int i)
    {
        if(android.os.Build.VERSION.SDK_INT >= 13)
            return context.getResources().getInteger(i);
        context = context.getResources().getDisplayMetrics();
        float f = (float)((DisplayMetrics) (context)).widthPixels / ((DisplayMetrics) (context)).density;
        if(i == com.actionbarsherlock.R.integer.abs__max_action_buttons)
        {
            if(f >= 600F)
                return 5;
            if(f >= 500F)
                return 4;
            return f < 360F ? 2 : 3;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown integer resource ID ").append(i).toString());
        }
    }

    public static int loadLogoFromManifest(Activity activity)
    {
        int i;
        int j;
        int k;
        int l;
        int i1;
        Object obj;
        k = 0;
        i = 0;
        j = k;
        boolean flag;
        String s;
        String s1;
        String s2;
        XmlResourceParser xmlresourceparser;
        String s3;
        try
        {
            s1 = activity.getClass().getName();
        }
        // Misplaced declaration of an exception variable
        catch(Activity activity)
        {
            activity.printStackTrace();
            return j;
        }
        j = k;
        s2 = activity.getApplicationInfo().packageName;
        j = k;
        xmlresourceparser = activity.createPackageContext(s2, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
        j = k;
        k = xmlresourceparser.getEventType();
        j = k;
_L10:
        k = i;
        if(j == 1) goto _L2; else goto _L1
_L1:
        k = i;
        if(j != 2) goto _L4; else goto _L3
_L3:
        j = i;
        activity = xmlresourceparser.getName();
        j = i;
        if(!"application".equals(activity)) goto _L6; else goto _L5
_L5:
        j = i;
        l = xmlresourceparser.getAttributeCount() - 1;
_L20:
        k = i;
        if(l < 0) goto _L4; else goto _L7
_L7:
        j = i;
        if(!"logo".equals(xmlresourceparser.getAttributeName(l))) goto _L9; else goto _L8
_L8:
        j = i;
        k = xmlresourceparser.getAttributeResourceValue(l, 0);
_L4:
        j = k;
        i = xmlresourceparser.nextToken();
        j = i;
        i = k;
          goto _L10
_L6:
        k = i;
        j = i;
        if(!"activity".equals(activity)) goto _L4; else goto _L11
_L11:
        activity = null;
        s = null;
        l = 0;
        j = i;
        k = xmlresourceparser.getAttributeCount() - 1;
_L21:
        if(k < 0) goto _L13; else goto _L12
_L12:
        j = i;
        s3 = xmlresourceparser.getAttributeName(k);
        j = i;
        if(!"logo".equals(s3)) goto _L15; else goto _L14
_L14:
        j = i;
        obj = Integer.valueOf(xmlresourceparser.getAttributeResourceValue(k, 0));
        i1 = l;
_L17:
        j = i;
        if(obj == null)
            break MISSING_BLOCK_LABEL_357;
        j = i;
        if(s == null)
            break MISSING_BLOCK_LABEL_357;
        j = i;
        i = ((Integer) (obj)).intValue();
        j = i;
        break MISSING_BLOCK_LABEL_357;
_L15:
        obj = activity;
        i1 = l;
        j = i;
        if(!"name".equals(s3)) goto _L17; else goto _L16
_L16:
        j = i;
        s = ActionBarSherlockCompat.cleanActivityName(s2, xmlresourceparser.getAttributeValue(k));
        j = i;
        flag = s1.equals(s);
        if(flag) goto _L18; else goto _L13
_L13:
        k = i;
        if(l == 0) goto _L4; else goto _L19
_L19:
        k = i;
_L2:
        return k;
_L18:
        i1 = 1;
        obj = activity;
          goto _L17
_L9:
        l--;
          goto _L20
        k--;
        activity = ((Activity) (obj));
        l = i1;
        i = j;
          goto _L21
    }

    private static final String TAG = "ResourcesCompat";
}
