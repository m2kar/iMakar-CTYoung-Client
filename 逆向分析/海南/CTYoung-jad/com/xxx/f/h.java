// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.xxx.sdk.api.a;

// Referenced classes of package com.xxx.f:
//            J, I

public final class H extends Dialog
{

    private H(Context context)
    {
        super(context);
        F = System.currentTimeMillis();
    }

    public H(Context context, byte byte0)
    {
        super(context, 0x1030010);
        F = System.currentTimeMillis();
    }

    private H(Context context, boolean flag, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        super(context, flag, oncancellistener);
        F = System.currentTimeMillis();
    }

    private void A(int j)
    {
        G = j;
    }

    private void a(ViewGroup viewgroup)
    {
        a = viewgroup;
    }

    private void aB()
    {
        TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        translateanimation.setDuration(500L);
        a.startAnimation(translateanimation);
        setContentView(a);
    }

    private void clearViews()
    {
        if(a != null)
        {
            a.removeAllViews();
            a = null;
        }
    }

    private void i(boolean flag)
    {
        if(isShowing())
        {
            TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
            translateanimation.setAnimationListener(new J(this, flag));
            translateanimation.setDuration(500L);
            if(a != null)
                a.startAnimation(translateanimation);
            a.a = null;
        }
    }

    private long t()
    {
        return F;
    }

    private boolean u()
    {
        if(G > 0)
        {
            long l = System.currentTimeMillis() - (long)G - F;
            if(l > 0L)
            {
                dismiss();
                return true;
            } else
            {
                Handler handler = new Handler();
                hide();
                handler.postDelayed(new I(this), -l);
                return false;
            }
        } else
        {
            dismiss();
            return true;
        }
    }

    private int y()
    {
        return G;
    }

    public final void dismiss()
    {
        if(a != null)
        {
            a.removeAllViews();
            a = null;
        }
        super.dismiss();
    }

    long F;
    public int G;
    public ViewGroup a;
}
