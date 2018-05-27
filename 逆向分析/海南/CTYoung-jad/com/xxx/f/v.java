// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.xxx.c.m;
import com.xxx.sdk.e.e.e;

public final class v extends RelativeLayout
{

    private v(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, (byte)0);
    }

    private v(Context context, AttributeSet attributeset, byte byte0)
    {
        super(context, attributeset, 0);
        cw = attributeset.getAttributeValue((new StringBuilder("http://schemas.android.com/apk/res/")).append(context.getPackageName()).toString(), "adPosition");
        if(cw == null || "".equals(cw))
        {
            throw new IllegalArgumentException("\u5E7F\u544A\u4F4DID\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
        } else
        {
            d(context, cw);
            return;
        }
    }

    private v(Context context, String s)
    {
        super(context);
        if(TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("\u5E7F\u544A\u4F4DID\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
        } else
        {
            d(context, s);
            return;
        }
    }

    private void d(Context context, String s)
    {
        if(s == null)
            throw new IllegalArgumentException("\u5E7F\u544A\u4F4DID\u4E0D\u5408\u6CD5\uFF01");
        s = s.split("\\|");
        if(s.length != 4 && s.length != 6)
        {
            throw new IllegalArgumentException("\u5E7F\u544A\u4F4DID\u4E0D\u5408\u6CD5\uFF01");
        } else
        {
            context = e.a(context);
            setLayoutParams(new android.widget.RelativeLayout.LayoutParams(((e) (context)).bx, ((e) (context)).by));
            setVisibility(20);
            return;
        }
    }

    private m c;
    private String cw;
}
