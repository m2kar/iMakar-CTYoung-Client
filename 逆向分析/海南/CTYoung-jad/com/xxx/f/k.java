// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.webkit.*;
import com.xxx.e.e;

// Referenced classes of package com.xxx.f:
//            L, z

public class K extends WebView
{

    public K(Context context)
    {
        super(context);
        a_android_webkit_WebViewClient_fld = new L(this);
        a_android_content_Context_fld = context;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDefaultTextEncodingName("utf-8");
        ax();
        setBackgroundColor(0);
        setWebViewClient(a_android_webkit_WebViewClient_fld);
    }

    static Context a(K k)
    {
        return k.a_android_content_Context_fld;
    }

    public final void a(z z)
    {
        b = z;
    }

    public final void ax()
    {
        e.a(this);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return super.onKeyDown(i, keyevent);
    }

    private Context a_android_content_Context_fld;
    private WebViewClient a_android_webkit_WebViewClient_fld;
    protected z b;
}
