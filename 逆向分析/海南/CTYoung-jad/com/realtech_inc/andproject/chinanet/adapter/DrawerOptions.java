// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.adapter;

import android.widget.ImageView;

public final class DrawerOptions
{
    public final class ViewHolder
    {

        public ImageView imageView;
        final DrawerOptions this$0;

        public ViewHolder()
        {
            this$0 = DrawerOptions.this;
            super();
        }
    }


    public DrawerOptions()
    {
    }

    public ViewHolder getNewHolder()
    {
        return new ViewHolder();
    }

    public static final int RESID[] = {
        0x7f02007a, 0x7f02007b, 0x7f02007c
    };
    public static final String TITLES[] = {
        "About", "Change User", "Logoff"
    };

}
