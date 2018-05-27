// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.e;

import android.content.Context;
import android.os.*;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.xxx.sdk.e.e:
//            a

final class b extends Handler
{

    b(Looper looper, Context context)
    {
        c = context;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        message = new WebView(c);
        a.c(c, message.getSettings().getUserAgentString());
    }

    private Context c;
}
