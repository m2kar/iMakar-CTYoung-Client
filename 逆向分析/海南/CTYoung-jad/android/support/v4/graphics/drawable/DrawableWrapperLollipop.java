// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.graphics.drawable;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v4.graphics.drawable:
//            DrawableWrapperKitKat

class DrawableWrapperLollipop extends DrawableWrapperKitKat
{

    DrawableWrapperLollipop(Drawable drawable)
    {
        super(drawable);
    }

    public void applyTheme(android.content.res.Resources.Theme theme)
    {
        mDrawable.applyTheme(theme);
    }

    public boolean canApplyTheme()
    {
        return mDrawable.canApplyTheme();
    }

    public Rect getDirtyBounds()
    {
        return mDrawable.getDirtyBounds();
    }

    public void getOutline(Outline outline)
    {
        mDrawable.getOutline(outline);
    }

    public void setHotspot(float f, float f1)
    {
        mDrawable.setHotspot(f, f1);
    }

    public void setHotspotBounds(int i, int j, int k, int l)
    {
        mDrawable.setHotspotBounds(i, j, k, l);
    }
}
