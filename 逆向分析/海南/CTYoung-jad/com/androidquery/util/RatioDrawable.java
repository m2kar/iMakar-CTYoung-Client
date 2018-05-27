// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.util;

import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

public class RatioDrawable extends BitmapDrawable
{

    public RatioDrawable(Resources resources, Bitmap bitmap, ImageView imageview, float f, float f1)
    {
        super(resources, bitmap);
        ref = new WeakReference(imageview);
        ratio = f;
        anchor = f1;
        imageview.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        imageview.setImageMatrix(new Matrix());
        adjust(imageview, bitmap, false);
    }

    private void adjust(ImageView imageview, Bitmap bitmap, boolean flag)
    {
        int i = getWidth(imageview);
        if(i > 0)
        {
            i = targetHeight(bitmap.getWidth(), bitmap.getHeight(), i) + imageview.getPaddingTop() + imageview.getPaddingBottom();
            bitmap = imageview.getLayoutParams();
            if(bitmap != null)
            {
                if(i != ((android.view.ViewGroup.LayoutParams) (bitmap)).height)
                {
                    bitmap.height = i;
                    imageview.setLayoutParams(bitmap);
                }
                if(flag)
                {
                    adjusted = true;
                    return;
                }
            }
        }
    }

    private void draw(Canvas canvas, ImageView imageview, Bitmap bitmap)
    {
        Matrix matrix = getMatrix(imageview, bitmap);
        if(matrix != null)
        {
            int i = imageview.getPaddingTop() + imageview.getPaddingBottom();
            int j = imageview.getPaddingLeft() + imageview.getPaddingRight();
            if(i > 0 || j > 0)
                canvas.clipRect(0, 0, imageview.getWidth() - j, imageview.getHeight() - i);
            canvas.drawBitmap(bitmap, matrix, getPaint());
        }
        if(!adjusted)
            adjust(imageview, bitmap, true);
    }

    private Matrix getMatrix(ImageView imageview, Bitmap bitmap)
    {
        int i = bitmap.getWidth();
        if(m != null && i == w)
            return m;
        int j = bitmap.getHeight();
        int k = getWidth(imageview);
        int l = targetHeight(i, j, k);
        if(i <= 0 || j <= 0 || k <= 0 || l <= 0)
            return null;
        if(m == null || i != w)
        {
            float f = 0.0F;
            float f1 = 0.0F;
            m = new Matrix();
            float f2;
            if(i * l >= k * j)
            {
                f2 = (float)l / (float)j;
                f = ((float)k - (float)i * f2) * 0.5F;
            } else
            {
                f2 = (float)k / (float)i;
                f1 = getYOffset(i, j);
                f1 = ((float)l - (float)j * f2) * f1;
            }
            m.setScale(f2, f2);
            m.postTranslate(f, f1);
            w = i;
        }
        return m;
    }

    private int getWidth(ImageView imageview)
    {
        int j = 0;
        android.view.ViewGroup.LayoutParams layoutparams = imageview.getLayoutParams();
        if(layoutparams != null)
            j = layoutparams.width;
        int i = j;
        if(j <= 0)
            i = imageview.getWidth();
        j = i;
        if(i > 0)
            j = i - imageview.getPaddingLeft() - imageview.getPaddingRight();
        return j;
    }

    private float getYOffset(int i, int j)
    {
        if(anchor != 3.402823E+038F)
            return (1.0F - anchor) / 2.0F;
        else
            return 0.25F + (1.5F - Math.max(1.0F, Math.min(1.5F, (float)j / (float)i))) / 2.0F;
    }

    private int targetHeight(int i, int j, int k)
    {
        float f = ratio;
        if(ratio == 3.402823E+038F)
            f = (float)j / (float)i;
        return (int)((float)k * f);
    }

    public void draw(Canvas canvas)
    {
        ImageView imageview = null;
        if(ref != null)
            imageview = (ImageView)ref.get();
        if(ratio == 0.0F || imageview == null)
        {
            super.draw(canvas);
            return;
        } else
        {
            draw(canvas, imageview, getBitmap());
            return;
        }
    }

    private boolean adjusted;
    private float anchor;
    private Matrix m;
    private float ratio;
    private WeakReference ref;
    private int w;
}
