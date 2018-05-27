// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.e;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.xxx.f.H;
import com.xxx.f.b;
import com.xxx.f.j;
import com.xxx.f.k;
import com.xxx.f.l;
import com.xxx.f.m;
import com.xxx.sdk.b.h;
import com.xxx.sdk.e.a;
import com.xxx.sdk.e.c;
import com.xxx.sdk.f;
import com.xxx.sdk.i;
import com.xxx.sdk.p;
import com.xxx.sdk.q;
import com.xxx.sdk.s;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e
{

    public e()
    {
    }

    public e(int i1, int j1)
    {
        width = 0;
        height = 0;
        width = i1;
        height = j1;
    }

    public static void a(Context context, Uri uri)
    {
        try
        {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.addFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
        catch(ActivityNotFoundException activitynotfoundexception)
        {
            Toast.makeText(context, "\u672A\u5B89\u88C5\u5E94\u7528\u5E02\u573A\uFF01", 0).show();
            c.error((new StringBuilder("ActivityNotFoundException:")).append(uri.getAuthority()).toString(), activitynotfoundexception);
            return;
        }
    }

    public static void a(Context context, h h1)
    {
        String s1 = h1.protocol;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(0x10000000);
        if(s1.contains("market://"))
        {
            intent.setData(Uri.parse(s1));
            h1 = intent;
        } else
        if(s1.contains(".apk"))
        {
            if((new File(s1)).exists())
            {
                intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(s1).toString()), "application/vnd.android.package-archive");
                h1 = intent;
            } else
            {
                f.a().a(h1.bb, h1.protocol);
                return;
            }
        } else
        {
            h1 = context.getPackageManager().getLaunchIntentForPackage(s1);
        }
        if(h1 != null)
        {
            context.startActivity(h1);
            return;
        } else
        {
            c.error("intent is null");
            return;
        }
    }

    public static void a(WebView webview)
    {
        int i1 = 0;
        if(android.os.Build.VERSION.SDK_INT < 17) goto _L2; else goto _L1
_L1:
        Method amethod[] = webview.getSettings().getClass().getMethods();
_L3:
        if(i1 < amethod.length)
        {
            if(!"setMediaPlaybackRequiresUserGesture".equals(amethod[i1].getName()))
                break MISSING_BLOCK_LABEL_64;
            amethod[i1].invoke(webview.getSettings(), new Object[] {
                Boolean.valueOf(true)
            });
        }
_L2:
        return;
        i1++;
          goto _L3
        webview;
        webview.printStackTrace();
        return;
        webview;
        webview.printStackTrace();
        return;
    }

    public static void a(a a1, Context context, String s1, int i1)
    {
        a a2;
        a2 = a1;
        if(a1 == null)
            a2 = new a(context);
        if(com.xxx.sdk.api.a.a != null)
        {
            a1 = com.xxx.sdk.api.a.a;
            com.xxx.sdk.api.a.a = null;
            a1.dismiss();
        }
        if(a2.b != null) goto _L2; else goto _L1
_L1:
        a2.b = new H(a2.a_android_content_Context_fld, (byte)0);
        a2.b.getWindow().getAttributes().dimAmount = 0.5F;
        a2.b.getWindow().setFlags(2, 2);
        int j1;
        RelativeLayout relativelayout;
        Object obj;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if(android.os.Build.VERSION.SDK_INT >= 19)
            a2.b.getWindow().setType(2005);
        else
            a2.b.getWindow().setType(2002);
        a1 = a2.b;
        context = new RelativeLayout(a2.a_android_content_Context_fld);
        relativelayout = new RelativeLayout(a2.a_android_content_Context_fld);
        a2.a_android_widget_ProgressBar_fld = new ProgressBar(a2.a_android_content_Context_fld);
        a2.a_android_widget_ProgressBar_fld.setIndeterminate(true);
        a2.a_android_widget_ProgressBar_fld.setId(10);
        j1 = Math.round(25F * a2.density);
        obj = new android.widget.RelativeLayout.LayoutParams(j1, j1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, 0, 2, 0);
        relativelayout.addView(a2.a_android_widget_ProgressBar_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        a2.a_android_widget_TextView_fld = new TextView(a2.a_android_content_Context_fld);
        a2.a_android_widget_TextView_fld.setTextSize(1, 20F);
        a2.a_android_widget_TextView_fld.setEllipsize(android.text.TextUtils.TruncateAt.END);
        a2.a_android_widget_TextView_fld.setSingleLine(true);
        a2.a_android_widget_TextView_fld.setGravity(17);
        a2.a_android_widget_TextView_fld.setTextColor(-1);
        j1 = Math.round(20F * a2.density);
        a2.a_android_widget_TextView_fld.setPadding(j1, 0, j1, 0);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        relativelayout.addView(a2.a_android_widget_TextView_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = com.xxx.f.b.a(a2.a_android_content_Context_fld, i.a());
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(11);
        relativelayout.addView(((View) (obj)), layoutparams);
        ((View) (obj)).setOnClickListener(new com.xxx.f.i(a2));
        relativelayout.setId(1);
        obj = a2.a_android_content_Context_fld.getResources().getDrawable(0x10800a5);
        relativelayout.setBackgroundDrawable(((Drawable) (obj)));
        if(obj != null)
        {
            obj = new android.widget.RelativeLayout.LayoutParams(-1, Math.round(((float)((Drawable) (obj)).getIntrinsicHeight() / 1.5F) * a2.density));
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            context.addView(relativelayout, ((android.view.ViewGroup.LayoutParams) (obj)));
        }
        a2.a_android_webkit_WebView_fld = new WebView(a2.a_android_content_Context_fld);
        a2.a_android_webkit_WebView_fld.setWebViewClient(new j(a2));
        a2.a_android_webkit_WebView_fld.getSettings().setJavaScriptEnabled(true);
        a2.a_android_webkit_WebView_fld.getSettings().setSupportZoom(true);
        a2.a_android_webkit_WebView_fld.getSettings().setBuiltInZoomControls(true);
        a2.a_android_webkit_WebView_fld.getSettings().setUseWideViewPort(true);
        a(a2.a_android_webkit_WebView_fld);
        a2.a_android_webkit_WebView_fld.setWebChromeClient(new k(a2));
        a2.a_android_webkit_WebView_fld.setDownloadListener(new l(a2));
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(3, relativelayout.getId());
        context.addView(a2.a_android_webkit_WebView_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        a1.a = context;
        if(i1 != 1) goto _L4; else goto _L3
_L3:
        a2.b.G = com.xxx.sdk.b.a().a().a_com_xxx_sdk_q_fld.G;
_L6:
        a1 = a2.b;
        context = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        context.setDuration(500L);
        ((H) (a1)).a.startAnimation(context);
        a1.setContentView(((H) (a1)).a);
        a2.b.setOnKeyListener(new m(a2));
_L2:
        com.xxx.sdk.api.a.a = a2.b;
        if(!a2.b.isShowing())
        {
            a2.b.show();
            a2.a_android_webkit_WebView_fld.loadUrl(s1);
        }
        return;
_L4:
        if(i1 == 2)
            a2.b.G = com.xxx.sdk.b.a().a().a_com_xxx_sdk_s_fld.G;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static boolean a(WebView webview)
    {
        webview = webview.getTitle();
        return webview != null && (webview.equals("\u627E\u4E0D\u5230\u7F51\u9875") || webview.equals("null"));
    }

    public static boolean b(WebView webview)
    {
        for(webview = webview.getHitTestResult(); webview == null || webview.getType() == 0;)
            return true;

        return false;
    }

    public static String[] b(String s1)
    {
        if(s1.startsWith("sms://"))
        {
            s1 = s1.substring(6).replaceAll("%2D", " ").split("/");
            s1[0] = (new StringBuilder("smsto:")).append(s1[0]).toString();
            return s1;
        }
        if(s1.startsWith("call://"))
        {
            s1 = s1.substring(7).split("/");
            s1[0] = (new StringBuilder("tel:")).append(s1[0]).toString();
            return s1;
        }
        if(s1.startsWith("gps://"))
        {
            s1 = s1.substring(6).split("/");
            s1[0] = (new StringBuilder("geo:")).append(s1[0]).toString();
            return s1;
        }
        if(s1.startsWith("email://"))
        {
            s1 = s1.substring(8).split("/");
            s1[0] = (new StringBuilder("mailto:")).append(s1[0]).toString();
            return s1;
        } else
        {
            return (new String[] {
                s1
            });
        }
    }

    public int height;
    public int width;
}
