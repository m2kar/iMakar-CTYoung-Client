// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.animation;


// Referenced classes of package android.support.v4.animation:
//            HoneycombMr1AnimatorCompatProvider, DonutAnimatorCompatProvider, AnimatorProvider, ValueAnimatorCompat

public abstract class AnimatorCompatHelper
{

    AnimatorCompatHelper()
    {
    }

    public static ValueAnimatorCompat emptyValueAnimator()
    {
        return IMPL.emptyValueAnimator();
    }

    static AnimatorProvider IMPL;

    static 
    {
        if(android.os.Build.VERSION.SDK_INT >= 12)
            IMPL = new HoneycombMr1AnimatorCompatProvider();
        else
            IMPL = new DonutAnimatorCompatProvider();
    }
}
