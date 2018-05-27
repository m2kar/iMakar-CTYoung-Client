// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xxx.c.k;
import com.xxx.e.e;
import com.xxx.sdk.b.a;
import com.xxx.sdk.e.b;

// Referenced classes of package com.xxx.f:
//            A

final class E extends WebViewClient
{

    E(A a1)
    {
        b = a1;
        super();
    }

    public final void doUpdateVisitedHistory(WebView webview, String s, boolean flag)
    {
        super.doUpdateVisitedHistory(webview, s, flag);
    }

    public final void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        b.I = true;
        b.a_android_os_Handler_fld.sendEmptyMessage(0);
        if(e.a(b.a_android_webkit_WebView_fld))
        {
            b.update(a.FAILED);
            return;
        } else
        {
            b.update(a.FIRST_URL_LOADED);
            return;
        }
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        b.I = false;
        if(s.equalsIgnoreCase(b.a_com_xxx_c_k_fld.url))
            com.xxx.sdk.e.b.f(b.a_com_xxx_c_k_fld.y);
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        b.update(a.FAILED);
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if(e.b(webview))
            return super.shouldOverrideUrlLoading(webview, s);
        else
            return false;
    }

    private A b;
}
