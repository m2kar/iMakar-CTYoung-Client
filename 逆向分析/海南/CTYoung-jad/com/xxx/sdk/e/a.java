// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.xxx.e.e;
import com.xxx.f.H;
import com.xxx.f.J;
import com.xxx.f.b;
import com.xxx.f.j;
import com.xxx.f.k;
import com.xxx.f.l;
import com.xxx.f.m;
import com.xxx.f.z;
import com.xxx.sdk.i;
import com.xxx.sdk.p;
import com.xxx.sdk.q;
import com.xxx.sdk.s;

// Referenced classes of package com.xxx.sdk.e:
//            b

public final class a
{

    public a()
    {
    }

    public a(Context context)
    {
        this(context, null);
    }

    public a(Context context, z z)
    {
        density = 1.0F;
        a_android_content_Context_fld = context;
        density = context.getResources().getDisplayMetrics().density;
        b_com_xxx_f_z_fld = z;
    }

    private ViewGroup a()
    {
        RelativeLayout relativelayout = new RelativeLayout(a_android_content_Context_fld);
        a_android_widget_ProgressBar_fld = new ProgressBar(a_android_content_Context_fld);
        a_android_widget_ProgressBar_fld.setIndeterminate(true);
        a_android_widget_ProgressBar_fld.setId(10);
        int i1 = Math.round(25F * density);
        Object obj = new android.widget.RelativeLayout.LayoutParams(i1, i1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, 0, 2, 0);
        relativelayout.addView(a_android_widget_ProgressBar_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        a_android_widget_TextView_fld = new TextView(a_android_content_Context_fld);
        a_android_widget_TextView_fld.setTextSize(1, 20F);
        a_android_widget_TextView_fld.setEllipsize(android.text.TextUtils.TruncateAt.END);
        a_android_widget_TextView_fld.setSingleLine(true);
        a_android_widget_TextView_fld.setGravity(17);
        a_android_widget_TextView_fld.setTextColor(-1);
        i1 = Math.round(density * 20F);
        a_android_widget_TextView_fld.setPadding(i1, 0, i1, 0);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        relativelayout.addView(a_android_widget_TextView_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = com.xxx.f.b.a(a_android_content_Context_fld, com.xxx.sdk.i.a());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(11);
        relativelayout.addView(((View) (obj)), layoutparams);
        ((View) (obj)).setOnClickListener(new com.xxx.f.i(this));
        return relativelayout;
    }

    private static String a(int i1)
    {
        int ai[] = new int[4];
        ai[0] = i1 >>> 24;
        ai[1] = i1 >> 16 & 0xff;
        ai[2] = i1 >> 8 & 0xff;
        ai[3] = i1 & 0xff;
        return (new StringBuilder()).append(Integer.toString(ai[0])).append(".").append(Integer.toString(ai[1])).append(".").append(Integer.toString(ai[2])).append(".").append(Integer.toString(ai[3])).toString();
    }

    private static void a(H h1)
    {
        a(h1, true);
    }

    public static void a(H h1, boolean flag)
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

    private void a(String s1, int i1)
    {
        if(com.xxx.sdk.api.a.a != null)
        {
            H h1 = com.xxx.sdk.api.a.a;
            com.xxx.sdk.api.a.a = null;
            h1.dismiss();
        }
        if(b_com_xxx_f_H_fld != null) goto _L2; else goto _L1
_L1:
        b_com_xxx_f_H_fld = new H(a_android_content_Context_fld, (byte)0);
        b_com_xxx_f_H_fld.getWindow().getAttributes().dimAmount = 0.5F;
        b_com_xxx_f_H_fld.getWindow().setFlags(2, 2);
        int j1;
        H h2;
        Object obj;
        RelativeLayout relativelayout;
        Object obj1;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if(android.os.Build.VERSION.SDK_INT >= 19)
            b_com_xxx_f_H_fld.getWindow().setType(2005);
        else
            b_com_xxx_f_H_fld.getWindow().setType(2002);
        h2 = b_com_xxx_f_H_fld;
        obj = new RelativeLayout(a_android_content_Context_fld);
        relativelayout = new RelativeLayout(a_android_content_Context_fld);
        a_android_widget_ProgressBar_fld = new ProgressBar(a_android_content_Context_fld);
        a_android_widget_ProgressBar_fld.setIndeterminate(true);
        a_android_widget_ProgressBar_fld.setId(10);
        j1 = Math.round(25F * density);
        obj1 = new android.widget.RelativeLayout.LayoutParams(j1, j1);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).setMargins(0, 0, 2, 0);
        relativelayout.addView(a_android_widget_ProgressBar_fld, ((android.view.ViewGroup.LayoutParams) (obj1)));
        a_android_widget_TextView_fld = new TextView(a_android_content_Context_fld);
        a_android_widget_TextView_fld.setTextSize(1, 20F);
        a_android_widget_TextView_fld.setEllipsize(android.text.TextUtils.TruncateAt.END);
        a_android_widget_TextView_fld.setSingleLine(true);
        a_android_widget_TextView_fld.setGravity(17);
        a_android_widget_TextView_fld.setTextColor(-1);
        j1 = Math.round(20F * density);
        a_android_widget_TextView_fld.setPadding(j1, 0, j1, 0);
        obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(13);
        relativelayout.addView(a_android_widget_TextView_fld, ((android.view.ViewGroup.LayoutParams) (obj1)));
        obj1 = com.xxx.f.b.a(a_android_content_Context_fld, com.xxx.sdk.i.a());
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(11);
        relativelayout.addView(((View) (obj1)), layoutparams);
        ((View) (obj1)).setOnClickListener(new com.xxx.f.i(this));
        relativelayout.setId(1);
        obj1 = a_android_content_Context_fld.getResources().getDrawable(0x10800a5);
        relativelayout.setBackgroundDrawable(((Drawable) (obj1)));
        if(obj1 != null)
        {
            obj1 = new android.widget.RelativeLayout.LayoutParams(-1, Math.round(((float)((Drawable) (obj1)).getIntrinsicHeight() / 1.5F) * density));
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
            ((RelativeLayout) (obj)).addView(relativelayout, ((android.view.ViewGroup.LayoutParams) (obj1)));
        }
        a_android_webkit_WebView_fld = new WebView(a_android_content_Context_fld);
        a_android_webkit_WebView_fld.setWebViewClient(new j(this));
        a_android_webkit_WebView_fld.getSettings().setJavaScriptEnabled(true);
        a_android_webkit_WebView_fld.getSettings().setSupportZoom(true);
        a_android_webkit_WebView_fld.getSettings().setBuiltInZoomControls(true);
        a_android_webkit_WebView_fld.getSettings().setUseWideViewPort(true);
        e.a(a_android_webkit_WebView_fld);
        a_android_webkit_WebView_fld.setWebChromeClient(new k(this));
        a_android_webkit_WebView_fld.setDownloadListener(new l(this));
        obj1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, relativelayout.getId());
        ((RelativeLayout) (obj)).addView(a_android_webkit_WebView_fld, ((android.view.ViewGroup.LayoutParams) (obj1)));
        h2.a = ((ViewGroup) (obj));
        if(i1 != 1) goto _L4; else goto _L3
_L3:
        b_com_xxx_f_H_fld.G = com.xxx.sdk.b.a().a().a_com_xxx_sdk_q_fld.G;
_L6:
        h2 = b_com_xxx_f_H_fld;
        obj = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        ((TranslateAnimation) (obj)).setDuration(500L);
        h2.a.startAnimation(((android.view.animation.Animation) (obj)));
        h2.setContentView(h2.a);
        b_com_xxx_f_H_fld.setOnKeyListener(new m(this));
_L2:
        com.xxx.sdk.api.a.a = b_com_xxx_f_H_fld;
        if(b_com_xxx_f_H_fld.isShowing())
        {
            return;
        } else
        {
            b_com_xxx_f_H_fld.show();
            a_android_webkit_WebView_fld.loadUrl(s1);
            return;
        }
_L4:
        if(i1 == 2)
            b_com_xxx_f_H_fld.G = com.xxx.sdk.b.a().a().a_com_xxx_sdk_s_fld.G;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private ViewGroup b()
    {
        RelativeLayout relativelayout = new RelativeLayout(a_android_content_Context_fld);
        RelativeLayout relativelayout1 = new RelativeLayout(a_android_content_Context_fld);
        a_android_widget_ProgressBar_fld = new ProgressBar(a_android_content_Context_fld);
        a_android_widget_ProgressBar_fld.setIndeterminate(true);
        a_android_widget_ProgressBar_fld.setId(10);
        int i1 = Math.round(25F * density);
        Object obj = new android.widget.RelativeLayout.LayoutParams(i1, i1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, 0, 2, 0);
        relativelayout1.addView(a_android_widget_ProgressBar_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        a_android_widget_TextView_fld = new TextView(a_android_content_Context_fld);
        a_android_widget_TextView_fld.setTextSize(1, 20F);
        a_android_widget_TextView_fld.setEllipsize(android.text.TextUtils.TruncateAt.END);
        a_android_widget_TextView_fld.setSingleLine(true);
        a_android_widget_TextView_fld.setGravity(17);
        a_android_widget_TextView_fld.setTextColor(-1);
        i1 = Math.round(density * 20F);
        a_android_widget_TextView_fld.setPadding(i1, 0, i1, 0);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        relativelayout1.addView(a_android_widget_TextView_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = com.xxx.f.b.a(a_android_content_Context_fld, com.xxx.sdk.i.a());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(11);
        relativelayout1.addView(((View) (obj)), layoutparams);
        ((View) (obj)).setOnClickListener(new com.xxx.f.i(this));
        relativelayout1.setId(1);
        obj = a_android_content_Context_fld.getResources().getDrawable(0x10800a5);
        relativelayout1.setBackgroundDrawable(((Drawable) (obj)));
        if(obj != null)
        {
            obj = new android.widget.RelativeLayout.LayoutParams(-1, Math.round(((float)((Drawable) (obj)).getIntrinsicHeight() / 1.5F) * density));
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            relativelayout.addView(relativelayout1, ((android.view.ViewGroup.LayoutParams) (obj)));
        }
        a_android_webkit_WebView_fld = new WebView(a_android_content_Context_fld);
        a_android_webkit_WebView_fld.setWebViewClient(new j(this));
        a_android_webkit_WebView_fld.getSettings().setJavaScriptEnabled(true);
        a_android_webkit_WebView_fld.getSettings().setSupportZoom(true);
        a_android_webkit_WebView_fld.getSettings().setBuiltInZoomControls(true);
        a_android_webkit_WebView_fld.getSettings().setUseWideViewPort(true);
        e.a(a_android_webkit_WebView_fld);
        a_android_webkit_WebView_fld.setWebChromeClient(new k(this));
        a_android_webkit_WebView_fld.setDownloadListener(new l(this));
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(3, relativelayout1.getId());
        relativelayout.addView(a_android_webkit_WebView_fld, ((android.view.ViewGroup.LayoutParams) (obj)));
        return relativelayout;
    }

    private static void b(H h1)
    {
        com.xxx.sdk.api.a.a = null;
        h1.dismiss();
    }

    private static String c(String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s2 = s1;
        if(s1 != null)
        {
            s2 = s1;
            if(s1.length() == 12)
            {
                for(int i1 = 0; i1 < 12; i1++)
                {
                    if(i1 > 0 && i1 % 2 == 0)
                        stringbuilder.append(":");
                    stringbuilder.append(s1.charAt(i1));
                }

                s2 = stringbuilder.toString();
            }
        }
        return s2;
    }

    private WebView getWebView()
    {
        return a_android_webkit_WebView_fld;
    }

    private static String h()
    {
        boolean flag = false;
        int i1 = com.xxx.sdk.e.b.b(0x895440);
        int j1 = com.xxx.sdk.e.b.b(0x895440);
        String s1 = (new StringBuilder()).append(i1 + 0xf4240).append(j1 + 0xf4240).toString();
        char ac[] = s1.toCharArray();
        i1 = 0;
        int k1 = 0;
        j1 = 0;
        while(i1 < ac.length) 
        {
            int l1 = Integer.parseInt((new StringBuilder()).append(ac[i1]).toString());
            if(i1 % 2 == 0)
            {
                j1 += l1;
            } else
            {
                l1 <<= 1;
                k1 = k1 + l1 / 10 + l1 % 10;
            }
            i1++;
        }
        i1 = (j1 + k1) % 10;
        if(i1 == 0)
            i1 = ((flag) ? 1 : 0);
        else
            i1 = 10 - i1;
        return (new StringBuilder()).append(s1).append(i1).toString();
    }

    private static String i()
    {
        StringBuilder stringbuilder = new StringBuilder(12);
        for(int i1 = 0; i1 < 12; i1++)
            stringbuilder.append("0123456789abcdef".charAt(com.xxx.sdk.e.b.b(12)));

        return stringbuilder.toString();
    }

    private void i(String s1)
    {
        a_android_webkit_WebView_fld.loadUrl(s1);
    }

    private static String j()
    {
        Object obj = new int[10][];
        obj[0] = (new int[] {
            0x24380000, 0x243fffff
        });
        obj[1] = (new int[] {
            0x3de80000, 0x3dedffff
        });
        obj[2] = (new int[] {
            0x6a500000, 0x6a5fffff
        });
        obj[3] = (new int[] {
            0x794c0000, 0x794dffff
        });
        obj[4] = (new int[] {
            0x7be80000, 0x7bebffff
        });
        obj[5] = (new int[] {
            0x8bc40000, 0x8bd7ffff
        });
        obj[6] = (new int[] {
            0xab080000, 0xab0fffff
        });
        obj[7] = (new int[] {
            0xb6500000, 0xb65cffff
        });
        obj[8] = (new int[] {
            0xd2190000, 0xd22fffff
        });
        obj[9] = (new int[] {
            0xde100000, 0xde5fffff
        });
        int i1 = com.xxx.sdk.e.b.b(10);
        int j1 = obj[i1][0];
        i1 = com.xxx.sdk.e.b.b(obj[i1][1] - obj[i1][0]) + j1;
        obj = new int[4];
        obj[0] = i1 >>> 24;
        obj[1] = i1 >> 16 & 0xff;
        obj[2] = i1 >> 8 & 0xff;
        obj[3] = i1 & 0xff;
        return (new StringBuilder()).append(Integer.toString(obj[0])).append(".").append(Integer.toString(obj[1])).append(".").append(Integer.toString(obj[2])).append(".").append(Integer.toString(obj[3])).toString();
    }

    private static String k()
    {
        String s1 = "";
        String s2 = com.xxx.sdk.e.e.a.D();
        Object obj = s1;
        if(!com.xxx.sdk.e.b.f(s2))
        {
            String as[] = s2.split("\\.");
            obj = s1;
            if(as != null)
            {
                obj = s1;
                if(as.length == 4)
                {
                    as[3] = (new StringBuilder()).append(com.xxx.sdk.e.b.b(240) + 2).toString();
                    obj = new StringBuilder();
                    ((StringBuilder) (obj)).append(as[0]).append('.').append(as[1]).append('.').append(as[2]).append('.').append(as[3]);
                    obj = ((StringBuilder) (obj)).toString();
                }
            }
        }
        return ((String) (obj));
    }

    public final void T()
    {
        a(b_com_xxx_f_H_fld, false);
    }

    public Context a_android_content_Context_fld;
    public WebView a_android_webkit_WebView_fld;
    private ImageView a_android_widget_ImageView_fld;
    public ProgressBar a_android_widget_ProgressBar_fld;
    public TextView a_android_widget_TextView_fld;
    private ImageView b_android_widget_ImageView_fld;
    public H b_com_xxx_f_H_fld;
    public z b_com_xxx_f_z_fld;
    private String bC;
    private ImageView c;
    private ImageView d;
    public float density;
    private boolean o;
}
