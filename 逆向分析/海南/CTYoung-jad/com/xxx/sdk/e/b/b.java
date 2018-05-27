// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.b;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.xxx.sdk.e.b:
//            d

public final class b
{

    public b(Context context)
    {
        a = context;
    }

    private d b(String s)
    {
        if(s == null)
            throw new IllegalArgumentException("URI cannot be null");
        else
            return new d(this, s, "HEAD");
    }

    private d d(String s)
    {
        if(s == null)
            throw new IllegalArgumentException("URI cannot be null");
        else
            return new d(this, s, "PUT");
    }

    private d e(String s)
    {
        if(s == null)
            throw new IllegalArgumentException("URI cannot be null");
        else
            return new d(this, s, "DELETE");
    }

    private int getConnectTimeout()
    {
        return connectTimeout;
    }

    private Context getContext()
    {
        return a;
    }

    private int getReadTimeout()
    {
        return readTimeout;
    }

    private Map i()
    {
        return l;
    }

    private void setConnectTimeout(int j)
    {
        if(j < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid connect timeout: ")).append(j).toString());
        } else
        {
            connectTimeout = j;
            return;
        }
    }

    private void setReadTimeout(int j)
    {
        if(j < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid read timeout: ")).append(j).toString());
        } else
        {
            readTimeout = j;
            return;
        }
    }

    private void setUserAgent(String s)
    {
        userAgent = s;
    }

    private String y()
    {
        if(userAgent == null)
            return bT;
        else
            return userAgent;
    }

    private static final String z()
    {
        return (new StringBuilder("PixmobHttpClient (")).append(Build.MANUFACTURER).append(" ").append(Build.MODEL).append("; Android ").append(android.os.Build.VERSION.RELEASE).append("/").append(android.os.Build.VERSION.SDK_INT).append(")").toString();
    }

    private void z()
    {
        l.clear();
    }

    public final d a(String s)
    {
        if(s == null)
            throw new IllegalArgumentException("URI cannot be null");
        else
            return new d(this, s, "GET");
    }

    public final d c(String s)
    {
        if(s == null)
            throw new IllegalArgumentException("URI cannot be null");
        else
            return new d(this, s, "POST");
    }

    static final String bT;
    final Context a;
    public int connectTimeout;
    public final Map l = new HashMap(8);
    int readTimeout;
    String userAgent;

    static 
    {
        if(android.os.Build.VERSION.SDK_INT <= 8)
            System.setProperty("http.keepAlive", "false");
        bT = (new StringBuilder("PixmobHttpClient (")).append(Build.MANUFACTURER).append(" ").append(Build.MODEL).append("; Android ").append(android.os.Build.VERSION.RELEASE).append("/").append(android.os.Build.VERSION.SDK_INT).append(")").toString();
    }
}
