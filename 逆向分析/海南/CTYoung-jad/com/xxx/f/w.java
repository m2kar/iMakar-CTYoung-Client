// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.content.Context;
import android.widget.TextView;
import com.xxx.sdk.d.i;

// Referenced classes of package com.xxx.f:
//            y, x

public final class w extends TextView
{

    public w(Context context, x x)
    {
        super(context);
        H = false;
        b = this;
        a_com_xxx_f_x_fld = x;
        H = true;
        a_com_xxx_f_y_fld = new y(this, i.a().m());
    }

    static w a(w w1)
    {
        return w1.b;
    }

    private void restart()
    {
        if(H)
        {
            if(a_com_xxx_f_y_fld != null)
                a_com_xxx_f_y_fld.cancel();
            a_com_xxx_f_y_fld = new y(this, i.a().m());
            a_com_xxx_f_y_fld.start();
        }
    }

    private void start()
    {
        if(a_com_xxx_f_y_fld != null)
            a_com_xxx_f_y_fld.start();
    }

    public final void stop()
    {
        if(a_com_xxx_f_y_fld != null)
            a_com_xxx_f_y_fld.cancel();
        H = false;
    }

    private static final String TAG = "CountdownTextView";
    private boolean H;
    x a_com_xxx_f_x_fld;
    public y a_com_xxx_f_y_fld;
    private w b;
}
