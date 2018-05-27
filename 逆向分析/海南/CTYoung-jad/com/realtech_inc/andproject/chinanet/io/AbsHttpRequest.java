// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.io;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.realtech_inc.andproject.chinanet.activity.BaseActivity;
import com.realtech_inc.andproject.chinanet.activity.ReceiveHandler;
import com.realtech_inc.andproject.chinanet.utils.DebugLog;
import com.realtech_inc.andproject.chinanet.utils.NetWorkUtils;
import java.net.URI;
import java.util.*;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.realtech_inc.andproject.chinanet.io:
//            HTTP_Type, Task

public abstract class AbsHttpRequest
{

    public AbsHttpRequest(BaseActivity baseactivity, HTTP_Type http_type)
    {
        type = HTTP_Type.POST;
        activit = baseactivity;
        httpClient = new DefaultHttpClient();
        NetWorkUtils.getCurrentNetType(baseactivity);
        baseactivity = NetWorkUtils.getNetworkProxyUrl();
        if(!TextUtils.isEmpty(baseactivity))
        {
            baseactivity = new HttpHost(baseactivity, NetWorkUtils.getNetworkProxyPort());
            httpClient.getParams().setParameter("http.route.default-proxy", baseactivity);
        }
        type = http_type;
    }

    private void onDestroy()
    {
        activit = null;
        url = null;
        httpClient = null;
    }

    void HandlerException(Exception exception)
    {
        while((exception instanceof NullPointerException) || !(exception instanceof TimeoutException)) 
            return;
    }

    HttpResponse execute(HashMap hashmap)
        throws Exception
    {
        Object obj = null;
        if(type.getValue() != HTTP_Type.POST.getValue()) goto _L2; else goto _L1
_L1:
        HttpPost httppost = new HttpPost(url);
        obj = httppost;
        if(hashmap != null)
        {
            obj = new ArrayList();
            String s1;
            for(Iterator iterator1 = hashmap.keySet().iterator(); iterator1.hasNext(); ((List) (obj)).add(new BasicNameValuePair(s1, (String)hashmap.get(s1))))
                s1 = (String)iterator1.next();

            hashmap = new UrlEncodedFormEntity(((List) (obj)), "UTF-8");
            ((HttpPost)httppost).setEntity(hashmap);
            obj = httppost;
        }
_L4:
        DebugLog.i("outPage", ((HttpUriRequest) (obj)).getParams().toString());
        return httpClient.execute(((HttpUriRequest) (obj)));
_L2:
        if(type.getValue() == HTTP_Type.GET.getValue())
        {
            obj = new StringBuffer(url.getPath());
            if(hashmap != null)
            {
                String s;
                for(Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); ((StringBuffer) (obj)).append(String.format("?%d=%d", new Object[] {
    s, hashmap.get(s)
})))
                    s = (String)iterator.next();

                setUri(((StringBuffer) (obj)).toString().trim());
            }
            obj = new HttpGet(url);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    abstract void onResponse(byte abyte0[], HashMap hashmap);

    void request(Task task)
    {
        task.start();
    }

    public void setUri(String s)
    {
        url = URI.create(s);
    }

    public abstract void start(Bundle bundle);

    void updateUI(int i, Bundle bundle)
    {
        activit.getReceiveUpdate().sendUIMessage(i, bundle);
        Looper.loop();
        onDestroy();
    }

    private BaseActivity activit;
    private HttpClient httpClient;
    private HTTP_Type type;
    private URI url;
}
