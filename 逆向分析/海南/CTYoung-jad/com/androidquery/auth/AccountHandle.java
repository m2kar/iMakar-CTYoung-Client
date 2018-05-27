// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.auth;

import android.content.Context;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.apache.http.HttpRequest;

public abstract class AccountHandle
{

    public AccountHandle()
    {
    }

    public void applyToken(AbstractAjaxCallback abstractajaxcallback, HttpURLConnection httpurlconnection)
    {
    }

    public void applyToken(AbstractAjaxCallback abstractajaxcallback, HttpRequest httprequest)
    {
    }

    protected abstract void auth();

    public void auth(AbstractAjaxCallback abstractajaxcallback)
    {
        this;
        JVM INSTR monitorenter ;
        if(callbacks != null)
            break MISSING_BLOCK_LABEL_36;
        callbacks = new LinkedHashSet();
        callbacks.add(abstractajaxcallback);
        auth();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        callbacks.add(abstractajaxcallback);
          goto _L1
        abstractajaxcallback;
        throw abstractajaxcallback;
    }

    public abstract boolean authenticated();

    public abstract boolean expired(AbstractAjaxCallback abstractajaxcallback, AjaxStatus ajaxstatus);

    protected void failure(Context context, int i, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if(callbacks == null)
            break MISSING_BLOCK_LABEL_53;
        for(context = callbacks.iterator(); context.hasNext(); ((AbstractAjaxCallback)context.next()).failure(i, s));
        break MISSING_BLOCK_LABEL_48;
        context;
        throw context;
        callbacks = null;
        this;
        JVM INSTR monitorexit ;
    }

    public String getCacheUrl(String s)
    {
        return s;
    }

    public String getNetworkUrl(String s)
    {
        return s;
    }

    public abstract boolean reauth(AbstractAjaxCallback abstractajaxcallback);

    protected void success(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if(callbacks == null)
            break MISSING_BLOCK_LABEL_52;
        for(Iterator iterator = callbacks.iterator(); iterator.hasNext(); ((AbstractAjaxCallback)iterator.next()).async(context));
        break MISSING_BLOCK_LABEL_47;
        context;
        throw context;
        callbacks = null;
        this;
        JVM INSTR monitorexit ;
    }

    public void unauth()
    {
    }

    private LinkedHashSet callbacks;
}
