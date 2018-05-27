// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.sherlock.navigationdrawer.compat;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import java.lang.reflect.Method;

public class SherlockActionBarDrawerToggleCompat
{
    private static class SetIndicatorInfo
    {

        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(Activity activity)
        {
            setHomeAsUpIndicator = com/actionbarsherlock/app/ActionBar.getDeclaredMethod("setHomeAsUpIndicator", new Class[] {
                android/graphics/drawable/Drawable
            });
            setHomeActionContentDescription = com/actionbarsherlock/app/ActionBar.getDeclaredMethod("setHomeActionContentDescription", new Class[] {
                Integer.TYPE
            });
_L1:
            return;
            NoSuchMethodException nosuchmethodexception;
            nosuchmethodexception;
            View view = activity.findViewById(0x102002c);
            Object obj = view;
            if(view == null)
            {
                obj = activity.findViewById(R.id.abs__home);
                int i = R.id.abs__home;
            }
            obj = (ViewGroup)((View) (obj)).getParent();
            if(((ViewGroup) (obj)).getChildCount() == 2)
            {
                activity = ((ViewGroup) (obj)).getChildAt(0);
                obj = ((ViewGroup) (obj)).getChildAt(1);
                if(activity.getId() == 0x102002c)
                    activity = ((Activity) (obj));
                if(activity instanceof ImageView)
                {
                    upIndicatorView = (ImageView)activity;
                    return;
                }
            }
              goto _L1
        }
    }


    public SherlockActionBarDrawerToggleCompat()
    {
    }

    public static Drawable getThemeUpIndicator(Activity activity)
    {
        activity = activity.obtainStyledAttributes(THEME_ATTRS);
        Drawable drawable = activity.getDrawable(0);
        activity.recycle();
        return drawable;
    }

    public static Object setActionBarDescription(Object obj, Activity activity, int i)
    {
        Object obj1 = obj;
        if(obj == null)
            obj1 = new SetIndicatorInfo(activity);
        obj = (SetIndicatorInfo)obj1;
        if(((SetIndicatorInfo) (obj)).setHomeAsUpIndicator != null)
            try
            {
                activity = ((SherlockFragmentActivity)activity).getSupportActionBar();
                ((SetIndicatorInfo) (obj)).setHomeActionContentDescription.invoke(activity, new Object[] {
                    Integer.valueOf(i)
                });
            }
            // Misplaced declaration of an exception variable
            catch(Object obj)
            {
                Log.w("SherlockActionBarDrawerToggleCompat", "Couldn't set content description via JB-MR2 API", ((Throwable) (obj)));
                return obj1;
            }
        return obj1;
    }

    public static Object setActionBarUpIndicator(Object obj, Activity activity, Drawable drawable, int i)
    {
        Object obj1 = obj;
        if(obj == null)
            obj1 = new SetIndicatorInfo(activity);
        obj = (SetIndicatorInfo)obj1;
        if(((SetIndicatorInfo) (obj)).setHomeAsUpIndicator != null)
        {
            try
            {
                activity = ((SherlockFragmentActivity)activity).getSupportActionBar();
                ((SetIndicatorInfo) (obj)).setHomeAsUpIndicator.invoke(activity, new Object[] {
                    drawable
                });
                ((SetIndicatorInfo) (obj)).setHomeActionContentDescription.invoke(activity, new Object[] {
                    Integer.valueOf(i)
                });
            }
            // Misplaced declaration of an exception variable
            catch(Object obj)
            {
                Log.w("SherlockActionBarDrawerToggleCompat", "Couldn't set home-as-up indicator via JB-MR2 API", ((Throwable) (obj)));
                return obj1;
            }
            return obj1;
        }
        if(((SetIndicatorInfo) (obj)).upIndicatorView != null)
        {
            ((SetIndicatorInfo) (obj)).upIndicatorView.setImageDrawable(drawable);
            return obj1;
        } else
        {
            Log.w("SherlockActionBarDrawerToggleCompat", "Couldn't set home-as-up indicator");
            return obj1;
        }
    }

    private static final String TAG = "SherlockActionBarDrawerToggleCompat";
    private static final int THEME_ATTRS[];

    static 
    {
        THEME_ATTRS = (new int[] {
            R.attr.homeAsUpIndicator
        });
    }
}
