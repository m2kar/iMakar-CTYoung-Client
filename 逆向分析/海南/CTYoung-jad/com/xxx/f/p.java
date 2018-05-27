// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import com.xxx.e.e;
import com.xxx.sdk.b.a;
import com.xxx.sdk.b.f;
import com.xxx.sdk.b.g;
import com.xxx.sdk.e.a.a.a.b;
import com.xxx.sdk.f.d;
import com.xxx.sdk.i;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.xxx.f:
//            g, q, b, r, 
//            s, K, o, u

public final class p extends com.xxx.f.g
{

    public p(Context context, d d1, Observer observer, boolean flag, int j, boolean flag1)
    {
        super(context);
        z = false;
        B = false;
        b = new q(this);
        G = false;
        bY = 0;
        C = false;
        E_boolean_fld = false;
        handler = new Handler();
        F = false;
        f = d1;
        a_android_content_Context_fld = context;
        C = flag;
        bZ = j;
        if(!flag1)
        {
            F = f.p();
            Context context1;
            byte abyte0[];
            if(F)
                j = 8;
            else
                j = 0;
            super.ca = j;
        }
        super.a = observer;
        if(f == null)
            f = new d();
        setFocusable(true);
        d1 = f.resource.ba;
        observer = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        observer.addRule(13);
        context = f.resource.a;
        context1 = a_android_content_Context_fld;
        abyte0 = i.a();
        r();
        a_android_view_View_fld = com.xxx.f.b.a(context1, abyte0);
        a_android_view_View_fld.setOnClickListener(new r(this));
        a_android_view_View_fld.setVisibility(8);
        if(context != g.h5) goto _L2; else goto _L1
_L1:
        a_android_webkit_WebView_fld = new s(this, a_android_content_Context_fld);
        context = (K)a_android_webkit_WebView_fld;
        flag = C;
        context.ax();
        ((K)a_android_webkit_WebView_fld).a(new b(this));
        context = d1.toLowerCase();
        if(context.startsWith("https:") || context.startsWith("http:"))
        {
            a_android_webkit_WebView_fld.loadUrl(d1);
        } else
        {
            if(d1.startsWith("/"))
                context = (new StringBuilder("file://")).append(d1).toString();
            else
                context = "file:///";
            if(f.resource.n)
                a_android_webkit_WebView_fld.loadUrl((new StringBuilder()).append(context).append(d1).toString());
            else
                a_android_webkit_WebView_fld.loadDataWithBaseURL(context, d1, "text/html", "UTF-8", null);
        }
        a_android_webkit_WebView_fld.setLayoutParams(observer);
        addView(a_android_webkit_WebView_fld);
_L4:
        addView(a_android_view_View_fld);
        B = true;
        context = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        context.addRule(13);
        setLayoutParams(context);
        setBackgroundColor(0x50000000);
        return;
_L2:
        if(context == g.image)
        {
            e = new ImageView(a_android_content_Context_fld);
            e.setLayoutParams(observer);
            e.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            context = BitmapFactory.decodeFile(d1);
            e.setImageBitmap(context);
            addView(e);
            update(a.FIRST_URL_LOADED);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static long a(p p1)
    {
        return p1.E_long_fld;
    }

    public static long a(p p1, long l)
    {
        p1.E_long_fld = l;
        return l;
    }

    public static Context a(p p1)
    {
        return p1.a_android_content_Context_fld;
    }

    public static View a(p p1)
    {
        return p1.a_android_view_View_fld;
    }

    public static WebView a(p p1)
    {
        return p1.a_android_webkit_WebView_fld;
    }

    public static d a(p p1)
    {
        return p1.f;
    }

    public static Runnable a(p p1)
    {
        return p1.b;
    }

    private void a(Canvas canvas, Rect rect)
    {
        Paint paint = new Paint();
        Path path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(0xffee7f27);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(0.0F);
        paint.setPathEffect(new CornerPathEffect(1.0F));
        path.addRoundRect(new RectF(rect), 1.0F, 1.0F, android.graphics.Path.Direction.CW);
        if(!z)
            path.reset();
        canvas.drawPath(path, paint);
    }

    static boolean a(p p1)
    {
        return p1.G;
    }

    private void au()
    {
        if(f != null && r())
            setOnClickListener(new o(a_android_content_Context_fld, f));
    }

    private void ax()
    {
        com.xxx.e.e.a((K)a_android_webkit_WebView_fld);
    }

    static boolean b(p p1)
    {
        p1.G = true;
        return true;
    }

    private void init()
    {
        Object obj;
        String s1;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if(f == null)
            f = new d();
        setFocusable(true);
        s1 = f.resource.ba;
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(13);
        obj = f.resource.a;
        Context context = a_android_content_Context_fld;
        byte abyte0[] = i.a();
        r();
        a_android_view_View_fld = com.xxx.f.b.a(context, abyte0);
        a_android_view_View_fld.setOnClickListener(new r(this));
        a_android_view_View_fld.setVisibility(8);
        if(obj != g.h5) goto _L2; else goto _L1
_L1:
        a_android_webkit_WebView_fld = new s(this, a_android_content_Context_fld);
        obj = (K)a_android_webkit_WebView_fld;
        boolean flag = C;
        ((K) (obj)).ax();
        ((K)a_android_webkit_WebView_fld).a(new b(this));
        obj = s1.toLowerCase();
        if(((String) (obj)).startsWith("https:") || ((String) (obj)).startsWith("http:"))
        {
            a_android_webkit_WebView_fld.loadUrl(s1);
        } else
        {
            if(s1.startsWith("/"))
                obj = (new StringBuilder("file://")).append(s1).toString();
            else
                obj = "file:///";
            if(f.resource.n)
                a_android_webkit_WebView_fld.loadUrl((new StringBuilder()).append(((String) (obj))).append(s1).toString());
            else
                a_android_webkit_WebView_fld.loadDataWithBaseURL(((String) (obj)), s1, "text/html", "UTF-8", null);
        }
        a_android_webkit_WebView_fld.setLayoutParams(layoutparams);
        addView(a_android_webkit_WebView_fld);
_L4:
        addView(a_android_view_View_fld);
        B = true;
        return;
_L2:
        if(obj == g.image)
        {
            e = new ImageView(a_android_content_Context_fld);
            e.setLayoutParams(layoutparams);
            e.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            android.graphics.Bitmap bitmap = BitmapFactory.decodeFile(s1);
            e.setImageBitmap(bitmap);
            addView(e);
            update(a.FIRST_URL_LOADED);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private long s()
    {
        return E_long_fld;
    }

    private boolean s()
    {
        return B;
    }

    private boolean t()
    {
        Object obj;
        String s1;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        s1 = f.resource.ba;
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(13);
        obj = f.resource.a;
        Context context = a_android_content_Context_fld;
        byte abyte0[] = i.a();
        r();
        a_android_view_View_fld = com.xxx.f.b.a(context, abyte0);
        a_android_view_View_fld.setOnClickListener(new r(this));
        a_android_view_View_fld.setVisibility(8);
        if(obj != g.h5) goto _L2; else goto _L1
_L1:
        a_android_webkit_WebView_fld = new s(this, a_android_content_Context_fld);
        obj = (K)a_android_webkit_WebView_fld;
        boolean flag = C;
        ((K) (obj)).ax();
        ((K)a_android_webkit_WebView_fld).a(new b(this));
        obj = s1.toLowerCase();
        if(((String) (obj)).startsWith("https:") || ((String) (obj)).startsWith("http:"))
        {
            a_android_webkit_WebView_fld.loadUrl(s1);
        } else
        {
            if(s1.startsWith("/"))
                obj = (new StringBuilder("file://")).append(s1).toString();
            else
                obj = "file:///";
            if(f.resource.n)
                a_android_webkit_WebView_fld.loadUrl((new StringBuilder()).append(((String) (obj))).append(s1).toString());
            else
                a_android_webkit_WebView_fld.loadDataWithBaseURL(((String) (obj)), s1, "text/html", "UTF-8", null);
        }
        a_android_webkit_WebView_fld.setLayoutParams(layoutparams);
        addView(a_android_webkit_WebView_fld);
_L4:
        addView(a_android_view_View_fld);
        return true;
_L2:
        if(obj == g.image)
        {
            e = new ImageView(a_android_content_Context_fld);
            e.setLayoutParams(layoutparams);
            e.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            android.graphics.Bitmap bitmap = BitmapFactory.decodeFile(s1);
            e.setImageBitmap(bitmap);
            addView(e);
            update(a.FIRST_URL_LOADED);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final void av()
    {
        if(a_android_webkit_WebView_fld != null)
            a_android_webkit_WebView_fld.destroy();
        super.av();
    }

    protected final void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingLeft() - getPaddingRight(), getHeight() - getPaddingTop() - getPaddingBottom());
        Paint paint = new Paint();
        Path path = new Path();
        paint.setAntiAlias(true);
        paint.setColor(0xffee7f27);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(0.0F);
        paint.setPathEffect(new CornerPathEffect(1.0F));
        path.addRoundRect(new RectF(rect), 1.0F, 1.0F, android.graphics.Path.Direction.CW);
        if(!z)
            path.reset();
        canvas.drawPath(path, paint);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        keyevent.getKeyCode();
        JVM INSTR tableswitch 4 4: default 24
    //                   4 30;
           goto _L1 _L2
_L1:
        return super.dispatchKeyEvent(keyevent);
_L2:
        if(keyevent.getAction() == 0)
            if(a_android_webkit_WebView_fld != null && a_android_webkit_WebView_fld.canGoBack())
            {
                update(a.STAY);
                a_android_webkit_WebView_fld.goBack();
            } else
            {
                Context context = a_android_content_Context_fld;
                com.xxx.sdk.api.d.F();
            }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
    }

    protected final void onFocusChanged(boolean flag, int j, Rect rect)
    {
        super.onFocusChanged(flag, j, rect);
        if(r())
            z = flag;
    }

    public final boolean r()
    {
        return f.target != null;
    }

    public final void update(Observable observable, Object obj)
    {
        super.update(observable, obj);
        if(!E_boolean_fld && bZ > 0)
        {
            E_boolean_fld = true;
            if(F)
                handler.postDelayed(new u(this), bZ);
            else
            if(getVisibility() == 0)
            {
                handler.postDelayed(b, bZ);
                return;
            }
        }
    }

    private boolean A;
    private boolean B;
    private boolean C;
    public long E_long_fld;
    private boolean E_boolean_fld;
    public boolean F;
    private boolean G;
    public Context a_android_content_Context_fld;
    private View a_android_view_View_fld;
    private WebView a_android_webkit_WebView_fld;
    private Runnable b;
    public int bY;
    private int bZ;
    private int bx;
    private int by;
    private ImageView e;
    public d f;
    public Handler handler;
    private boolean z;
}
