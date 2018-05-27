// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.networks;

import android.os.AsyncTask;
import android.util.Log;
import com.realtech_inc.andproject.chinanet.utils.DebugLog;
import java.io.*;
import java.util.*;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.HttpTransportSE;

public abstract class BaseNetworkAsyncTask extends AsyncTask
{

    public BaseNetworkAsyncTask()
    {
        status = false;
    }

    protected String doHttpGet(String s)
    {
        DefaultHttpClient defaulthttpclient;
        DebugLog.i(TAG, "START HTTP GET REQUEST...");
        defaulthttpclient = getHttpClient();
        s = new HttpGet(s);
        s.addHeader("User-Agent", "China Telecom Client");
        Header aheader[];
        Object obj;
        s = defaulthttpclient.execute(s);
        aheader = s.getAllHeaders();
        obj = new HashMap();
        int i = 0;
_L2:
        if(i >= aheader.length)
            break; /* Loop/switch isn't completed */
        ((HashMap) (obj)).put(aheader[i].getName(), aheader[i].getValue());
        i++;
        if(true) goto _L2; else goto _L1
_L1:
        StringBuffer stringbuffer;
        s = new BufferedReader(new InputStreamReader(s.getEntity().getContent()));
        stringbuffer = new StringBuffer("");
_L3:
        obj = s.readLine();
        if(obj == null)
            break MISSING_BLOCK_LABEL_175;
        stringbuffer.append(((String) (obj)));
          goto _L3
        s;
        DebugLog.e(TAG, s.toString(), s);
        defaulthttpclient.getConnectionManager().shutdown();
        return null;
        status = true;
        s = stringbuffer.toString();
        defaulthttpclient.getConnectionManager().shutdown();
        return s;
        s;
        DebugLog.e(TAG, s.toString(), s);
        defaulthttpclient.getConnectionManager().shutdown();
        return null;
        s;
        DebugLog.e(TAG, s.toString(), s);
        defaulthttpclient.getConnectionManager().shutdown();
        return null;
        s;
        defaulthttpclient.getConnectionManager().shutdown();
        throw s;
    }

    protected String doHttpPost(String s)
    {
        return doHttpPost(s, null);
    }

    protected String doHttpPost(String s, List list)
    {
        DefaultHttpClient defaulthttpclient;
        DebugLog.i(TAG, "START HTTP POST REQUEST...");
        defaulthttpclient = getHttpClient();
        defaulthttpclient.getParams().setParameter("http.connection.timeout", Integer.valueOf(10000));
        defaulthttpclient.getParams().setParameter("http.socket.timeout", Integer.valueOf(10000));
        s = new HttpPost(s);
        s.addHeader("User-Agent", "China Telecom Client");
        if(list != null && !list.isEmpty())
            try
            {
                s.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            }
            // Misplaced declaration of an exception variable
            catch(List list)
            {
                DebugLog.e(TAG, (new StringBuilder()).append("UnsupportedEncodingException: ").append(list.toString()).toString(), list);
            }
        try
        {
            s = defaulthttpclient.execute(s);
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            DebugLog.e(TAG, (new StringBuilder()).append("ClientProtocolException: ").append(s.toString()).toString(), s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            DebugLog.e(TAG, (new StringBuilder()).append("HttpHostConnectException: ").append(s.toString()).toString(), s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            DebugLog.e(TAG, (new StringBuilder()).append("Exception: ").append(s.toString()).toString(), s);
            return null;
        }
        s = EntityUtils.toString(s.getEntity());
        defaulthttpclient.getConnectionManager().shutdown();
        status = true;
        return s;
        s;
        DebugLog.e(TAG, (new StringBuilder()).append("IOException: ").append(s.toString()).toString(), s);
        defaulthttpclient.getConnectionManager().shutdown();
        return null;
        s;
        defaulthttpclient.getConnectionManager().shutdown();
        throw s;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient abstract String doInBackground(String as[]);

    protected String doWSPost(String s, String s1, String s2, Map map)
    {
        String s3;
        String s4;
        s3 = "";
        try
        {
            s4 = (new StringBuilder()).append(s1).append(s2).toString();
            s1 = new SoapObject(s1, s2);
            String s5;
            for(s2 = map.keySet().iterator(); s2.hasNext(); s1.addProperty(s5, map.get(s5)))
                s5 = (String)s2.next();

        }
        // Misplaced declaration of an exception variable
        catch(String s)
        {
            DebugLog.e(TAG, (new StringBuilder()).append("IOException: ").append(s.toString()).toString(), s);
            return null;
        }
        s2 = new SoapSerializationEnvelope(100);
        s2.dotNet = false;
        s2.bodyOut = s1;
        s2.setOutputSoapObject(s1);
        (new HttpTransportSE(s)).call(s4, s2);
        s1 = (SoapPrimitive)s2.getResponse();
        Log.i(TAG, (new StringBuilder()).append("Result Fahrenheit: ").append(s1).toString());
        s = s3;
        if(s1 == null)
            break MISSING_BLOCK_LABEL_204;
        s = s1.toString();
        status = true;
        return s;
    }

    protected DefaultHttpClient getHttpClient()
    {
        httpParams = new BasicHttpParams();
        return new DefaultHttpClient(httpParams);
    }

    public boolean isSuccess()
    {
        return status;
    }

    protected void onCancelled()
    {
        super.onCancelled();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected abstract void onPostExecute(String s);

    protected void onPreExecute()
    {
        super.onPreExecute();
        status = false;
    }

    protected transient void onProgressUpdate(Object aobj[])
    {
        super.onProgressUpdate(aobj);
    }

    private static final String TAG = com/realtech_inc/andproject/chinanet/networks/BaseNetworkAsyncTask.getSimpleName();
    private BasicHttpParams httpParams;
    private boolean status;

}
