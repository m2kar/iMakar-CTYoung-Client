// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.xxx.e.b;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.f.H;
import com.xxx.f.J;
import com.xxx.f.j;
import com.xxx.f.k;
import com.xxx.f.l;
import com.xxx.f.m;
import com.xxx.f.z;
import com.xxx.sdk.b.c;
import com.xxx.sdk.b.h;
import com.xxx.sdk.b.i;
import com.xxx.sdk.f.d;
import com.xxx.sdk.p;
import com.xxx.sdk.q;
import com.xxx.sdk.s;

public class a
    implements z
{

    public a()
    {
    }

    private a(Context context)
    {
        super(context, null);
    }

    private a(Context context, z z1)
    {
        super.density = 1.0F;
        super.a_android_content_Context_fld = context;
        super.density = context.getResources().getDisplayMetrics().density;
        super.b_com_xxx_f_z_fld = z1;
    }

    private a(g g1, d d1)
    {
        super.a = g1;
        super.d = d1;
        super();
    }

    private a(com.xxx.sdk.f.c c1)
    {
        super.d = false;
        super.w = "";
        super.target = c1.target;
        super.x = c1.target.protocol;
        super.j = c1.target.a.ordinal();
        super.c = c1;
        super.a_com_xxx_f_z_fld = new b(this);
    }

    private ViewGroup a()
    {
        RelativeLayout relativelayout = new RelativeLayout(super.a_android_content_Context_fld);
        super.a_android_widget_ProgressBar_fld = new ProgressBar(super.a_android_content_Context_fld);
        super.a_android_widget_ProgressBar_fld.setIndeterminate(true);
        super.a_android_widget_ProgressBar_fld.setId(10);
        int i1 = Math.round(25F * super.density);
        Object obj = new android.widget.RelativeLayout.LayoutParams(i1, i1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, 0, 2, 0);
        relativelayout.addView(super.a_android_widget_ProgressBar_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        super.a_android_widget_TextView_fld = new TextView(super.a_android_content_Context_fld);
        super.a_android_widget_TextView_fld.setTextSize(1, 20F);
        super.a_android_widget_TextView_fld.setEllipsize(android.text.TextUtils.TruncateAt.END);
        super.a_android_widget_TextView_fld.setSingleLine(true);
        super.a_android_widget_TextView_fld.setGravity(17);
        super.a_android_widget_TextView_fld.setTextColor(-1);
        i1 = Math.round(super.density * 20F);
        super.a_android_widget_TextView_fld.setPadding(i1, 0, i1, 0);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        relativelayout.addView(super.a_android_widget_TextView_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = com.xxx.f.b.a(super.a_android_content_Context_fld, com.xxx.sdk.i.a());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(11);
        relativelayout.addView(((View) (obj)), layoutparams);
        ((View) (obj)).setOnClickListener(new com.xxx.f.i(this));
        return relativelayout;
    }

    private static void a(Context context, Uri uri)
    {
        e.a(context, uri);
    }

    private static void a(Context context, h h1)
    {
        e.a(context, h1);
    }

    private void a(Context context, String s1)
    {
        if(super.a_com_xxx_sdk_e_a_fld == null)
            super.a_com_xxx_sdk_e_a_fld = new com.xxx.sdk.e.a(context, super.a_com_xxx_f_z_fld);
        e.a(super.a_com_xxx_sdk_e_a_fld, context, s1, 1);
    }

    private static void a(H h1)
    {
        com.xxx.sdk.e.a.a(h1, true);
    }

    private static void a(H h1, boolean flag)
    {
        if(h1 != null && h1.isShowing())
        {
            TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
            translateanimation.setAnimationListener(new J(h1, flag));
            translateanimation.setDuration(500L);
            if(h1.a != null)
                h1.a.startAnimation(translateanimation);
            com.xxx.sdk.api.a.a = null;
        }
    }

    private ViewGroup b()
    {
        RelativeLayout relativelayout = new RelativeLayout(super.a_android_content_Context_fld);
        RelativeLayout relativelayout1 = new RelativeLayout(super.a_android_content_Context_fld);
        super.a_android_widget_ProgressBar_fld = new ProgressBar(super.a_android_content_Context_fld);
        super.a_android_widget_ProgressBar_fld.setIndeterminate(true);
        super.a_android_widget_ProgressBar_fld.setId(10);
        int i1 = Math.round(25F * super.density);
        Object obj = new android.widget.RelativeLayout.LayoutParams(i1, i1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, 0, 2, 0);
        relativelayout1.addView(super.a_android_widget_ProgressBar_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        super.a_android_widget_TextView_fld = new TextView(super.a_android_content_Context_fld);
        super.a_android_widget_TextView_fld.setTextSize(1, 20F);
        super.a_android_widget_TextView_fld.setEllipsize(android.text.TextUtils.TruncateAt.END);
        super.a_android_widget_TextView_fld.setSingleLine(true);
        super.a_android_widget_TextView_fld.setGravity(17);
        super.a_android_widget_TextView_fld.setTextColor(-1);
        i1 = Math.round(super.density * 20F);
        super.a_android_widget_TextView_fld.setPadding(i1, 0, i1, 0);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        relativelayout1.addView(super.a_android_widget_TextView_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = com.xxx.f.b.a(super.a_android_content_Context_fld, com.xxx.sdk.i.a());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(11);
        relativelayout1.addView(((View) (obj)), layoutparams);
        ((View) (obj)).setOnClickListener(new com.xxx.f.i(this));
        relativelayout1.setId(1);
        obj = super.a_android_content_Context_fld.getResources().getDrawable(0x10800a5);
        relativelayout1.setBackgroundDrawable(((Drawable) (obj)));
        if(obj != null)
        {
            obj = new android.widget.RelativeLayout.LayoutParams(-1, Math.round(((float)((Drawable) (obj)).getIntrinsicHeight() / 1.5F) * super.density));
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            relativelayout.addView(relativelayout1, ((android.view.ViewGroup.LayoutParams) (obj)));
        }
        super.a_android_webkit_WebView_fld = new WebView(super.a_android_content_Context_fld);
        super.a_android_webkit_WebView_fld.setWebViewClient(new j(this));
        super.a_android_webkit_WebView_fld.getSettings().setJavaScriptEnabled(true);
        super.a_android_webkit_WebView_fld.getSettings().setSupportZoom(true);
        super.a_android_webkit_WebView_fld.getSettings().setBuiltInZoomControls(true);
        super.a_android_webkit_WebView_fld.getSettings().setUseWideViewPort(true);
        e.a(super.a_android_webkit_WebView_fld);
        super.a_android_webkit_WebView_fld.setWebChromeClient(new k(this));
        super.a_android_webkit_WebView_fld.setDownloadListener(new l(this));
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(3, relativelayout1.getId());
        relativelayout.addView(super.a_android_webkit_WebView_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        return relativelayout;
    }

    private static void b(H h1)
    {
        com.xxx.sdk.api.a.a = null;
        h1.dismiss();
    }

    private void i(String s1)
    {
        super.a_android_webkit_WebView_fld.loadUrl(s1);
    }

    private void j()
    {
        if(super.c != null)
            super.c.click();
    }

    public void T()
    {
        com.xxx.sdk.e.a.a(super.b_com_xxx_f_H_fld, false);
    }

    public void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if(context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(super.x == null || "".equals(super.x)) goto _L1; else goto _L3
_L3:
        Object obj;
        obj = e.b(super.x);
        if(!com.xxx.sdk.e.b.a(((Object []) (obj))))
        {
            String s1 = super.w;
            j();
            if(super.j != i.browser.ordinal())
                break MISSING_BLOCK_LABEL_152;
            if(!g.b(super.x))
                break MISSING_BLOCK_LABEL_140;
            super.c.am();
            e.a(context, Uri.parse(super.x));
        }
          goto _L1
        obj;
        Toast.makeText(context, "\u672A\u77E5\u5F02\u5E38\uFF01", 0).show();
        com.xxx.sdk.e.c.error((new StringBuilder("Ad click error:")).append(super.x).toString(), ((Throwable) (obj)));
          goto _L1
        context;
        throw context;
        a(context, super.x);
          goto _L1
        if(super.j != i.app.ordinal()) goto _L5; else goto _L4
_L4:
        e.a(context, super.target);
          goto _L1
_L5:
        if(super.j == i.call.ordinal() || super.j == i.message.ordinal() || super.j != i.download.ordinal()) goto _L1; else goto _L6
_L6:
        super.c.am();
        e.a(context, Uri.parse(obj[0]));
          goto _L1
    }

    public void a(String s1, int i1)
    {
        if(com.xxx.sdk.api.a.a != null)
        {
            H h1 = com.xxx.sdk.api.a.a;
            com.xxx.sdk.api.a.a = null;
            h1.dismiss();
        }
        if(super.b_com_xxx_f_H_fld != null) goto _L2; else goto _L1
_L1:
        super.b_com_xxx_f_H_fld = new H(super.a_android_content_Context_fld, (byte)0);
        super.b_com_xxx_f_H_fld.getWindow().getAttributes().dimAmount = 0.5F;
        super.b_com_xxx_f_H_fld.getWindow().setFlags(2, 2);
        int j1;
        H h2;
        Object obj;
        RelativeLayout relativelayout;
        Object obj1;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if(android.os.Build.VERSION.SDK_INT >= 19)
            super.b_com_xxx_f_H_fld.getWindow().setType(2005);
        else
            super.b_com_xxx_f_H_fld.getWindow().setType(2002);
        h2 = super.b_com_xxx_f_H_fld;
        obj = new RelativeLayout(super.a_android_content_Context_fld);
        relativelayout = new RelativeLayout(super.a_android_content_Context_fld);
        super.a_android_widget_ProgressBar_fld = new ProgressBar(super.a_android_content_Context_fld);
        super.a_android_widget_ProgressBar_fld.setIndeterminate(true);
        super.a_android_widget_ProgressBar_fld.setId(10);
        j1 = Math.round(25F * super.density);
        obj1 = new android.widget.RelativeLayout.LayoutParams(j1, j1);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(0, 0, 2, 0);
        relativelayout.addView(super.a_android_widget_ProgressBar_fld, ((android.view.ViewGroup.LayoutParams) (obj1)));
        super.a_android_widget_TextView_fld = new TextView(super.a_android_content_Context_fld);
        super.a_android_widget_TextView_fld.setTextSize(1, 20F);
        super.a_android_widget_TextView_fld.setEllipsize(android.text.TextUtils.TruncateAt.END);
        super.a_android_widget_TextView_fld.setSingleLine(true);
        super.a_android_widget_TextView_fld.setGravity(17);
        super.a_android_widget_TextView_fld.setTextColor(-1);
        j1 = Math.round(20F * super.density);
        super.a_android_widget_TextView_fld.setPadding(j1, 0, j1, 0);
        obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(13);
        relativelayout.addView(super.a_android_widget_TextView_fld, ((android.view.ViewGroup.LayoutParams) (obj1)));
        obj1 = com.xxx.f.b.a(super.a_android_content_Context_fld, com.xxx.sdk.i.a());
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(11);
        relativelayout.addView(((View) (obj1)), layoutparams);
        ((View) (obj1)).setOnClickListener(new com.xxx.f.i(this));
        relativelayout.setId(1);
        obj1 = super.a_android_content_Context_fld.getResources().getDrawable(0x10800a5);
        relativelayout.setBackgroundDrawable(((Drawable) (obj1)));
        if(obj1 != null)
        {
            obj1 = new android.widget.RelativeLayout.LayoutParams(-1, Math.round(((float)((Drawable) (obj1)).getIntrinsicHeight() / 1.5F) * super.density));
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
            ((RelativeLayout) (obj)).addView(relativelayout, ((android.view.ViewGroup.LayoutParams) (obj1)));
        }
        super.a_android_webkit_WebView_fld = new WebView(super.a_android_content_Context_fld);
        super.a_android_webkit_WebView_fld.setWebViewClient(new j(this));
        super.a_android_webkit_WebView_fld.getSettings().setJavaScriptEnabled(true);
        super.a_android_webkit_WebView_fld.getSettings().setSupportZoom(true);
        super.a_android_webkit_WebView_fld.getSettings().setBuiltInZoomControls(true);
        super.a_android_webkit_WebView_fld.getSettings().setUseWideViewPort(true);
        e.a(super.a_android_webkit_WebView_fld);
        super.a_android_webkit_WebView_fld.setWebChromeClient(new k(this));
        super.a_android_webkit_WebView_fld.setDownloadListener(new l(this));
        obj1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, relativelayout.getId());
        ((RelativeLayout) (obj)).addView(super.a_android_webkit_WebView_fld, ((android.view.ViewGroup.LayoutParams) (obj1)));
        h2.a = ((ViewGroup) (obj));
        if(i1 != 1) goto _L4; else goto _L3
_L3:
        super.b_com_xxx_f_H_fld.G = com.xxx.sdk.b.a().a().a_com_xxx_sdk_q_fld.G;
_L6:
        h2 = super.b_com_xxx_f_H_fld;
        obj = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        ((TranslateAnimation) (obj)).setDuration(500L);
        h2.a.startAnimation(((android.view.animation.Animation) (obj)));
        h2.setContentView(h2.a);
        super.b_com_xxx_f_H_fld.setOnKeyListener(new m(this));
_L2:
        com.xxx.sdk.api.a.a = super.b_com_xxx_f_H_fld;
        if(super.b_com_xxx_f_H_fld.isShowing())
        {
            return;
        } else
        {
            super.b_com_xxx_f_H_fld.show();
            super.a_android_webkit_WebView_fld.loadUrl(s1);
            return;
        }
_L4:
        if(i1 == 2)
            super.b_com_xxx_f_H_fld.G = com.xxx.sdk.b.a().a().a_com_xxx_sdk_s_fld.G;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean a(String s1)
    {
        if(g.b(s1))
        {
            e.a(com.xxx.sdk.b.a().getContext(), Uri.parse(s1));
            super.a.a.T();
            return true;
        } else
        {
            return false;
        }
    }

    public WebView getWebView()
    {
        return super.a_android_webkit_WebView_fld;
    }

    public void k()
    {
        if(!super.a.d && !e.a(super.a.a.a_android_webkit_WebView_fld))
        {
            super.d.am();
            super.a.d = true;
        }
    }

    public void l()
    {
    }

    public void m()
    {
    }

    private static String aP = "resources.arsc";
    private static String aQ = "AndroidManifest.xml";
    private static String aR = "classes.dex";
    private static String aS = "res/";
    private static String aT = "assets/";
    private static String aU = "lib/";
    private static String aV = "META-INF/";
    private static String aW = "";
    private static int ai = 0x1010000;
    private static int aj = 0x1030000;
    private static int ak = 0x1031000;
    private Context a_android_content_Context_fld;
    private WebView a_android_webkit_WebView_fld;
    private ImageView a_android_widget_ImageView_fld;
    private ProgressBar a_android_widget_ProgressBar_fld;
    private TextView a_android_widget_TextView_fld;
    private g a_com_xxx_e_g_fld;
    private z a_com_xxx_f_z_fld;
    private com.xxx.sdk.e.a a_com_xxx_sdk_e_a_fld;
    private ImageView b_android_widget_ImageView_fld;
    private H b_com_xxx_f_H_fld;
    private z b_com_xxx_f_z_fld;
    private String bC;
    private ImageView c_android_widget_ImageView_fld;
    private com.xxx.sdk.f.c c_com_xxx_sdk_f_c_fld;
    private ImageView d_android_widget_ImageView_fld;
    private d d_com_xxx_sdk_f_d_fld;
    private boolean d_boolean_fld;
    private float density;
    private int j;
    private boolean o;
    private h target;
    private String w;
    private String x;
}
