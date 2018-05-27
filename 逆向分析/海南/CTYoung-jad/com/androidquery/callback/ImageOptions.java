// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.callback;

import android.graphics.Bitmap;

public class ImageOptions
{

    public ImageOptions()
    {
        memCache = true;
        fileCache = true;
        anchor = 3.402823E+038F;
    }

    public float anchor;
    public int animation;
    public int fallback;
    public boolean fileCache;
    public boolean memCache;
    public int policy;
    public Bitmap preset;
    public float ratio;
    public int round;
    public int targetWidth;
}
