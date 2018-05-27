// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Picture;
import android.webkit.*;

// Referenced classes of package com.androidquery.util:
//            AQUtility, Common

public class WebImage extends WebViewClient
{

    public WebImage(WebView webview, String s, Object obj, boolean flag, boolean flag1, int i)
    {
        wv = webview;
        url = s;
        progress = obj;
        zoom = flag;
        control = flag1;
        color = i;
    }

    private void delaySetup()
    {
        wv.setPictureListener(new android.webkit.WebView.PictureListener() {

            public void onNewPicture(WebView webview, Picture picture)
            {
                wv.setPictureListener(null);
                setup();
            }

            final WebImage this$0;

            
            {
                this$0 = WebImage.this;
                super();
            }
        }
);
        wv.loadData("<html></html>", "text/html", "utf-8");
        wv.setBackgroundColor(color);
    }

    private static void disableZoomControl(WebView webview)
    {
        if(android.os.Build.VERSION.SDK_INT < 11)
        {
            return;
        } else
        {
            AQUtility.invokeHandler(webview.getSettings(), "setDisplayZoomControls", false, false, new Class[] {
                Boolean.TYPE
            }, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
    }

    private void done(WebView webview)
    {
        if(progress != null)
        {
            webview.setVisibility(0);
            Common.showProgress(progress, url, false);
        }
        webview.setWebViewClient(null);
    }

    private static void fixWebviewTip(Context context)
    {
        context = context.getSharedPreferences("WebViewSettings", 0);
        if(context.getInt("double_tap_toast_count", 1) > 0)
            context.edit().putInt("double_tap_toast_count", 0).commit();
    }

    private static String getSource(Context context)
    {
        if(template == null)
            try
            {
                template = new String(AQUtility.toBytes(context.getClassLoader().getResourceAsStream("com/androidquery/util/web_image.html")));
            }
            // Misplaced declaration of an exception variable
            catch(Context context)
            {
                AQUtility.debug(context);
            }
        return template;
    }

    private void setup()
    {
        String s = getSource(wv.getContext()).replace("@src", url).replace("@color", Integer.toHexString(color));
        wv.setWebViewClient(this);
        wv.loadDataWithBaseURL(null, s, "text/html", "utf-8", null);
        wv.setBackgroundColor(color);
    }

    public void load()
    {
        if(url.equals(wv.getTag(0x40ff0001)))
            return;
        wv.setTag(0x40ff0001, url);
        if(android.os.Build.VERSION.SDK_INT <= 10)
            wv.setDrawingCacheEnabled(true);
        fixWebviewTip(wv.getContext());
        WebSettings websettings = wv.getSettings();
        websettings.setSupportZoom(zoom);
        websettings.setBuiltInZoomControls(zoom);
        if(!control)
            disableZoomControl(wv);
        websettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(color);
        if(progress != null)
            Common.showProgress(progress, url, true);
        if(wv.getWidth() > 0)
        {
            setup();
            return;
        } else
        {
            delaySetup();
            return;
        }
    }

    public void onPageFinished(WebView webview, String s)
    {
        done(webview);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        done(webview);
    }

    public void onScaleChanged(WebView webview, float f, float f1)
    {
    }

    private static final String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
    private static final String PREF_FILE = "WebViewSettings";
    private static String template;
    private int color;
    private boolean control;
    private Object progress;
    private String url;
    private WebView wv;
    private boolean zoom;


}
