// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.os.Handler;
import android.view.animation.Animation;

// Referenced classes of package com.xxx.f:
//            H, I

public final class J
    implements android.view.animation.Animation.AnimationListener
{

    public J(H h, boolean flag)
    {
        c = h;
        J = flag;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if(J)
        {
            c.dismiss();
            return;
        }
        animation = c;
        if(((H) (animation)).G > 0)
        {
            long l = System.currentTimeMillis() - (long)((H) (animation)).G - ((H) (animation)).F;
            if(l <= 0L)
            {
                Handler handler = new Handler();
                animation.hide();
                handler.postDelayed(new I(animation), -l);
                return;
            }
        }
        animation.dismiss();
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    private boolean J;
    private H c;
}
