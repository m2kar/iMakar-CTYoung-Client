// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package android.support.v4.animation;


// Referenced classes of package android.support.v4.animation:
//            ValueAnimatorCompat

public interface AnimatorListenerCompat
{

    public abstract void onAnimationCancel(ValueAnimatorCompat valueanimatorcompat);

    public abstract void onAnimationEnd(ValueAnimatorCompat valueanimatorcompat);

    public abstract void onAnimationRepeat(ValueAnimatorCompat valueanimatorcompat);

    public abstract void onAnimationStart(ValueAnimatorCompat valueanimatorcompat);
}
