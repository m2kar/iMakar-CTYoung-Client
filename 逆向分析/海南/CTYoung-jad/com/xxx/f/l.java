// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xxx.e.e;

// Referenced classes of package com.xxx.f:
//            K, z

final class L extends WebViewClient
{

    L(K k)
    {
        a = k;
        super();
    }

    public final void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if(a.b != null)
            a.b.k();
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        if(a.b != null)
            webview = a.b;
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        if(a.b != null)
            a.b.l();
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if(e.b(webview))
            return super.shouldOverrideUrlLoading(webview, s);
        if(a.b == null || !a.b.a(s))
        {
            webview = new Intent("android.intent.action.VIEW");
            webview.setData(Uri.parse(s));
            webview.setFlags(0x30000000);
            K.a(a).startActivity(webview);
        }
        return true;
    }

    private K a;
}
