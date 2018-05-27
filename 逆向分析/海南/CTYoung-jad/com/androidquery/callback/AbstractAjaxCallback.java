// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.callback;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Xml;
import android.view.View;
import com.androidquery.auth.AccountHandle;
import com.androidquery.auth.GoogleHandle;
import com.androidquery.util.*;
import java.io.*;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.*;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.*;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.*;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.androidquery.callback:
//            AjaxStatus, BitmapAjaxCallback, Transformer

public abstract class AbstractAjaxCallback
    implements Runnable
{

    public AbstractAjaxCallback()
    {
        policy = 0;
        timeout = 0;
        encoding = "UTF-8";
        method = 4;
        uiCallback = true;
        retry = 0;
    }

    private void afterWork()
    {
        if(url != null && memCache)
            memPut(url, result);
        callback();
        clear();
    }

    private void backgroundWork()
    {
        if(!refresh && fileCache)
            fileWork();
        if(result == null)
            datastoreWork();
        if(result == null)
            networkWork();
    }

    public static void cancel()
    {
        if(fetchExe != null)
        {
            fetchExe.shutdownNow();
            fetchExe = null;
        }
        BitmapAjaxCallback.clearTasks();
    }

    private void clear()
    {
        whandler = null;
        handler = null;
        progress = null;
        request = null;
        transformer = null;
        ah = null;
        act = null;
    }

    private void copy(InputStream inputstream, OutputStream outputstream, int i)
        throws IOException
    {
        Object obj = null;
        if(progress != null)
            obj = progress.get();
        Progress progress1 = null;
        if(obj != null)
            progress1 = new Progress(obj);
        AQUtility.copy(inputstream, outputstream, i, progress1);
    }

    private String correctEncoding(byte abyte0[], String s, AjaxStatus ajaxstatus)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if("utf-8".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        obj = obj1;
        try
        {
            return new String(abyte0, s);
        }
        // Misplaced declaration of an exception variable
        catch(byte abyte0[]) { }
          goto _L3
_L2:
        obj = obj1;
        s = parseCharset(ajaxstatus.getHeader("Content-Type"));
        obj = obj1;
        AQUtility.debug("parsing header", s);
        if(s == null) goto _L5; else goto _L4
_L4:
        obj = obj1;
        abyte0 = new String(abyte0, s);
        return abyte0;
_L3:
        AQUtility.report(abyte0);
_L6:
        return ((String) (obj));
_L5:
        obj = obj1;
        s = new String(abyte0, "utf-8");
        obj = getCharset(s);
        AQUtility.debug("parsing needed", obj);
        if(obj == null)
            break MISSING_BLOCK_LABEL_172;
        if("utf-8".equalsIgnoreCase(((String) (obj))))
            break MISSING_BLOCK_LABEL_172;
        AQUtility.debug("correction needed", obj);
        abyte0 = new String(abyte0, ((String) (obj)));
        obj = abyte0;
        ajaxstatus.data(abyte0.getBytes("utf-8"));
        obj = abyte0;
          goto _L6
        abyte0;
        obj = s;
          goto _L3
        obj = s;
          goto _L6
    }

    private void datastoreWork()
    {
        result = datastoreGet(url);
        if(result != null)
            status.source(2).done();
    }

    private HttpResponse execute(HttpUriRequest httpurirequest, DefaultHttpClient defaulthttpclient, HttpContext httpcontext)
        throws ClientProtocolException, IOException
    {
        if(httpurirequest.getURI().getAuthority().contains("_"))
        {
            Object obj = httpurirequest.getURI().toURL();
            if(((URL) (obj)).getPort() == -1)
                obj = new HttpHost(((URL) (obj)).getHost(), 80, ((URL) (obj)).getProtocol());
            else
                obj = new HttpHost(((URL) (obj)).getHost(), ((URL) (obj)).getPort(), ((URL) (obj)).getProtocol());
            return defaulthttpclient.execute(((HttpHost) (obj)), httpurirequest, httpcontext);
        } else
        {
            return defaulthttpclient.execute(httpurirequest, httpcontext);
        }
    }

    public static void execute(Runnable runnable)
    {
        if(fetchExe == null)
            fetchExe = Executors.newFixedThreadPool(NETWORK_POOL);
        fetchExe.execute(runnable);
    }

    private static Map extractParams(Uri uri)
    {
        HashMap hashmap = new HashMap();
        uri = uri.getQuery().split("&");
        int j = uri.length;
        int i = 0;
        while(i < j) 
        {
            String as[] = uri[i].split("=");
            if(as.length >= 2)
                hashmap.put(as[0], as[1]);
            else
            if(as.length == 1)
                hashmap.put(as[0], "");
            i++;
        }
        return hashmap;
    }

    private static String extractUrl(Uri uri)
    {
        String s = (new StringBuilder()).append(uri.getScheme()).append("://").append(uri.getAuthority()).append(uri.getPath()).toString();
        String s1 = uri.getFragment();
        uri = s;
        if(s1 != null)
            uri = (new StringBuilder()).append(s).append("#").append(s1).toString();
        return uri;
    }

    private void filePut()
    {
        if(result == null || !fileCache) goto _L2; else goto _L1
_L1:
        byte abyte0[] = status.getData();
        if(abyte0 == null) goto _L4; else goto _L3
_L3:
        if(status.getSource() != 1) goto _L4; else goto _L5
_L5:
        File file = getCacheFile();
        if(status.getInvalid()) goto _L7; else goto _L6
_L6:
        filePut(url, result, file, abyte0);
_L4:
        status.data(null);
_L2:
        return;
_L7:
        try
        {
            if(file.exists())
                file.delete();
        }
        catch(Exception exception)
        {
            AQUtility.debug(exception);
        }
        if(true) goto _L4; else goto _L8
_L8:
    }

    private void fileWork()
    {
        File file = accessFile(cacheDir, getCacheUrl());
        if(file != null)
        {
            status.source(3);
            result = fileGet(url, file, status);
            if(result != null)
                status.time(new Date(file.lastModified())).done();
        }
    }

    public static int getActiveCount()
    {
        int i = 0;
        if(fetchExe instanceof ThreadPoolExecutor)
            i = ((ThreadPoolExecutor)fetchExe).getActiveCount();
        return i;
    }

    private String getCacheUrl()
    {
        if(ah != null)
            return ah.getCacheUrl(url);
        else
            return url;
    }

    private String getCharset(String s)
    {
        s = Pattern.compile("<meta [^>]*http-equiv[^>]*\"Content-Type\"[^>]*>", 2).matcher(s);
        if(!s.find())
            return null;
        else
            return parseCharset(s.group());
    }

    private static DefaultHttpClient getClient()
    {
        if(client == null || !REUSE_CLIENT)
        {
            AQUtility.debug("creating http client");
            BasicHttpParams basichttpparams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basichttpparams, NET_TIMEOUT);
            HttpConnectionParams.setSoTimeout(basichttpparams, NET_TIMEOUT);
            ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(25));
            HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            Object obj;
            if(ssf == null)
                obj = SSLSocketFactory.getSocketFactory();
            else
                obj = ssf;
            schemeregistry.register(new Scheme("https", ((SocketFactory) (obj)), 443));
            client = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
        }
        return client;
    }

    private String getEncoding(HttpEntity httpentity)
    {
        if(httpentity != null)
            if((httpentity = httpentity.getContentEncoding()) != null)
                return httpentity.getValue();
        return null;
    }

    protected static int getLastStatus()
    {
        return lastStatus;
    }

    private String getNetworkUrl(String s)
    {
        if(networkUrl != null)
            s = networkUrl;
        String s1 = s;
        if(ah != null)
            s1 = ah.getNetworkUrl(s);
        return s1;
    }

    private File getPreFile()
    {
        boolean flag = isStreamingContent();
        File file = null;
        if(flag)
            if(targetFile != null)
                file = targetFile;
            else
            if(fileCache)
            {
                file = getCacheFile();
            } else
            {
                File file1 = AQUtility.getTempDir();
                file = file1;
                if(file1 == null)
                    file = cacheDir;
                file = AQUtility.getCacheFile(file, url);
            }
        if(file != null && !file.exists())
            try
            {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            catch(Exception exception)
            {
                AQUtility.report(exception);
                return null;
            }
        return file;
    }

    private void httpDelete(String s, Map map, AjaxStatus ajaxstatus)
        throws IOException
    {
        AQUtility.debug("get", s);
        s = patchUrl(s);
        httpDo(new HttpDelete(s), s, map, ajaxstatus);
    }

    private void httpDo(HttpUriRequest httpurirequest, String s, Map map, AjaxStatus ajaxstatus)
        throws ClientProtocolException, IOException
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        String s2;
        File file;
        Object obj4;
        Object obj5;
        BasicHttpContext basichttpcontext;
        HttpEntity httpentity;
        if(AGENT != null)
            httpurirequest.addHeader("User-Agent", AGENT);
        if(map != null)
        {
            String s1;
            for(Iterator iterator = map.keySet().iterator(); iterator.hasNext(); httpurirequest.addHeader(s1, (String)map.get(s1)))
                s1 = (String)iterator.next();

        }
        if(GZIP && (map == null || !map.containsKey("Accept-Encoding")))
            httpurirequest.addHeader("Accept-Encoding", "gzip");
        map = makeCookie();
        if(map != null)
            httpurirequest.addHeader("Cookie", map);
        if(ah != null)
            ah.applyToken(this, httpurirequest);
        DefaultHttpClient defaulthttpclient = getClient();
        map = httpurirequest.getParams();
        if(proxy != null)
            map.setParameter("http.route.default-proxy", proxy);
        if(timeout > 0)
        {
            map.setParameter("http.connection.timeout", Integer.valueOf(timeout));
            map.setParameter("http.socket.timeout", Integer.valueOf(timeout));
        }
        basichttpcontext = new BasicHttpContext();
        basichttpcontext.setAttribute("http.cookie-store", new BasicCookieStore());
        request = httpurirequest;
        if(abort)
            throw new IOException("Aborted");
        int i;
        HttpResponse httpresponse;
        String s3;
        try
        {
            httpresponse = execute(httpurirequest, defaulthttpclient, basichttpcontext);
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            if(proxy != null)
            {
                AQUtility.debug("proxy failed, retrying without proxy");
                map.setParameter("http.route.default-proxy", null);
                httpresponse = execute(httpurirequest, defaulthttpclient, basichttpcontext);
            } else
            {
                throw obj;
            }
        }
        obj4 = null;
        s2 = null;
        obj1 = s;
        i = httpresponse.getStatusLine().getStatusCode();
        s3 = httpresponse.getStatusLine().getReasonPhrase();
        obj3 = null;
        obj5 = null;
        httpurirequest = null;
        httpentity = httpresponse.getEntity();
        file = null;
        if(i >= 200 && i < 300) goto _L2; else goto _L1
_L1:
        obj = null;
        obj2 = null;
        map = null;
        if(httpentity == null)
            break MISSING_BLOCK_LABEL_419;
        map = ((Map) (obj2));
        httpurirequest = httpentity.getContent();
        obj = httpurirequest;
        map = httpurirequest;
        obj2 = new String(toData(getEncoding(httpentity), httpurirequest), "UTF-8");
        AQUtility.debug("error", obj2);
        map = httpurirequest;
        httpurirequest = ((HttpUriRequest) (obj2));
        AQUtility.close(map);
        map = file;
        obj2 = s2;
_L3:
        AQUtility.debug("response", Integer.valueOf(i));
        if(obj2 != null)
            AQUtility.debug(Integer.valueOf(obj2.length), s);
        ajaxstatus.code(i).message(s3).error(httpurirequest).redirect(((String) (obj1))).time(new Date()).data(((byte []) (obj2))).file(map).client(defaulthttpclient).context(basichttpcontext).headers(httpresponse.getAllHeaders());
        return;
        obj2;
        httpurirequest = ((HttpUriRequest) (obj));
        obj = obj5;
_L13:
        map = httpurirequest;
        AQUtility.debug(((Throwable) (obj2)));
        AQUtility.close(httpurirequest);
        obj2 = s2;
        httpurirequest = ((HttpUriRequest) (obj));
        map = file;
          goto _L3
        s;
        httpurirequest = map;
_L12:
        AQUtility.close(httpurirequest);
        throw s;
_L2:
        int j;
        httpurirequest = (HttpHost)basichttpcontext.getAttribute("http.target_host");
        map = (HttpUriRequest)basichttpcontext.getAttribute("http.request");
        s2 = (new StringBuilder()).append(httpurirequest.toURI()).append(map.getURI()).toString();
        j = Math.max(32, Math.min(0x10000, (int)httpentity.getContentLength()));
        httpurirequest = null;
        obj = null;
        map = ((Map) (obj));
        obj1 = httpurirequest;
        file = getPreFile();
        if(file != null) goto _L5; else goto _L4
_L4:
        map = ((Map) (obj));
        obj1 = httpurirequest;
        httpurirequest = new PredefinedBAOS(j);
_L8:
        map = ((Map) (obj));
        obj1 = httpurirequest;
        obj2 = httpentity.getContent();
        obj = obj2;
        map = ((Map) (obj2));
        obj1 = httpurirequest;
        if(!"gzip".equalsIgnoreCase(getEncoding(httpentity)))
            break MISSING_BLOCK_LABEL_775;
        map = ((Map) (obj2));
        obj1 = httpurirequest;
        obj = new GZIPInputStream(((InputStream) (obj2)));
        map = ((Map) (obj));
        obj1 = httpurirequest;
        copy(((InputStream) (obj)), httpurirequest, (int)httpentity.getContentLength());
        map = ((Map) (obj));
        obj1 = httpurirequest;
        httpurirequest.flush();
        if(file != null) goto _L7; else goto _L6
_L6:
        map = ((Map) (obj));
        obj1 = httpurirequest;
        obj2 = ((PredefinedBAOS)httpurirequest).toByteArray();
        obj1 = obj2;
        map = file;
_L11:
        AQUtility.close(((java.io.Closeable) (obj)));
        AQUtility.close(httpurirequest);
        obj2 = obj1;
        httpurirequest = obj3;
        obj1 = s2;
          goto _L3
_L5:
        map = ((Map) (obj));
        obj1 = httpurirequest;
        file.createNewFile();
        map = ((Map) (obj));
        obj1 = httpurirequest;
        httpurirequest = new BufferedOutputStream(new FileOutputStream(file));
          goto _L8
_L7:
        map = ((Map) (obj));
        obj1 = httpurirequest;
        if(!file.exists()) goto _L10; else goto _L9
_L9:
        map = ((Map) (obj));
        obj1 = httpurirequest;
        long l = file.length();
        obj1 = obj4;
        map = file;
        if(l != 0L) goto _L11; else goto _L10
_L10:
        map = null;
        obj1 = obj4;
          goto _L11
        httpurirequest;
        AQUtility.close(map);
        AQUtility.close(((java.io.Closeable) (obj1)));
        throw httpurirequest;
        s;
          goto _L12
        map;
        obj = obj2;
        obj2 = map;
          goto _L13
    }

    private void httpEntity(String s, HttpEntityEnclosingRequestBase httpentityenclosingrequestbase, Map map, Map map1, AjaxStatus ajaxstatus)
        throws ClientProtocolException, IOException
    {
        httpentityenclosingrequestbase.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        Object obj = map1.get("%entity");
        if(obj instanceof HttpEntity)
        {
            map1 = (HttpEntity)obj;
        } else
        {
            ArrayList arraylist = new ArrayList();
            map1 = map1.entrySet().iterator();
            do
            {
                if(!map1.hasNext())
                    break;
                java.util.Map.Entry entry = (java.util.Map.Entry)map1.next();
                Object obj1 = entry.getValue();
                if(obj1 != null)
                    arraylist.add(new BasicNameValuePair((String)entry.getKey(), obj1.toString()));
            } while(true);
            map1 = new UrlEncodedFormEntity(arraylist, "UTF-8");
        }
        if(map != null && !map.containsKey("Content-Type"))
            map.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        httpentityenclosingrequestbase.setEntity(map1);
        httpDo(httpentityenclosingrequestbase, s, map, ajaxstatus);
    }

    private void httpGet(String s, Map map, AjaxStatus ajaxstatus)
        throws IOException
    {
        AQUtility.debug("get", s);
        s = patchUrl(s);
        httpDo(new HttpGet(s), s, map, ajaxstatus);
    }

    private void httpMulti(String s, Map map, Map map1, AjaxStatus ajaxstatus)
        throws IOException
    {
        AQUtility.debug("multipart", s);
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        httpurlconnection.setInstanceFollowRedirects(false);
        httpurlconnection.setConnectTimeout(NET_TIMEOUT * 4);
        httpurlconnection.setDoInput(true);
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection.setRequestProperty("Connection", "Keep-Alive");
        httpurlconnection.setRequestProperty("Content-Type", "multipart/form-data;charset=utf-8;boundary=*****");
        if(map != null)
        {
            String s2;
            for(Iterator iterator = map.keySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty(s2, (String)map.get(s2)))
                s2 = (String)iterator.next();

        }
        map = makeCookie();
        if(map != null)
            httpurlconnection.setRequestProperty("Cookie", map);
        if(ah != null)
            ah.applyToken(this, httpurlconnection);
        map = new DataOutputStream(httpurlconnection.getOutputStream());
        java.util.Map.Entry entry;
        for(map1 = map1.entrySet().iterator(); map1.hasNext(); writeObject(map, (String)entry.getKey(), entry.getValue()))
            entry = (java.util.Map.Entry)map1.next();

        map.writeBytes("--*****--\r\n");
        map.flush();
        map.close();
        httpurlconnection.connect();
        int i = httpurlconnection.getResponseCode();
        String s1 = httpurlconnection.getResponseMessage();
        map = null;
        String s3 = httpurlconnection.getContentEncoding();
        map1 = null;
        if(i < 200 || i >= 300)
        {
            map1 = new String(toData(s3, httpurlconnection.getErrorStream()), "UTF-8");
            AQUtility.debug("error", map1);
        } else
        {
            map = toData(s3, httpurlconnection.getInputStream());
        }
        AQUtility.debug("response", Integer.valueOf(i));
        if(map != null)
            AQUtility.debug(Integer.valueOf(map.length), s);
        ajaxstatus.code(i).message(s1).redirect(s).time(new Date()).data(map).error(map1).client(null);
    }

    private void httpPost(String s, Map map, Map map1, AjaxStatus ajaxstatus)
        throws ClientProtocolException, IOException
    {
        AQUtility.debug("post", s);
        httpEntity(s, new HttpPost(s), map, map1, ajaxstatus);
    }

    private void httpPut(String s, Map map, Map map1, AjaxStatus ajaxstatus)
        throws ClientProtocolException, IOException
    {
        AQUtility.debug("put", s);
        httpEntity(s, new HttpPut(s), map, map1, ajaxstatus);
    }

    private boolean isActive()
    {
        Activity activity;
        if(act != null)
            if((activity = (Activity)act.get()) == null || activity.isFinishing())
                return false;
        return true;
    }

    private static boolean isMultiPart(Map map)
    {
        for(map = map.entrySet().iterator(); map.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            Object obj = entry.getValue();
            AQUtility.debug(entry.getKey(), obj);
            if((obj instanceof File) || (obj instanceof byte[]) || (obj instanceof InputStream))
                return true;
        }

        return false;
    }

    private String makeCookie()
    {
        if(cookies == null || cookies.size() == 0)
            return null;
        Iterator iterator = cookies.keySet().iterator();
        StringBuilder stringbuilder = new StringBuilder();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            String s1 = (String)cookies.get(s);
            stringbuilder.append(s);
            stringbuilder.append("=");
            stringbuilder.append(s1);
            if(iterator.hasNext())
                stringbuilder.append("; ");
        } while(true);
        return stringbuilder.toString();
    }

    private void network()
        throws IOException
    {
        String s = url;
        Map map = params;
        Object obj = map;
        Object obj1 = s;
        if(map == null)
        {
            obj = map;
            obj1 = s;
            if(s.length() > 2000)
            {
                obj = Uri.parse(s);
                obj1 = extractUrl(((Uri) (obj)));
                obj = extractParams(((Uri) (obj)));
            }
        }
        s = getNetworkUrl(((String) (obj1)));
        if(2 == method)
        {
            httpDelete(s, headers, status);
            return;
        }
        if(3 == method)
        {
            httpPut(s, headers, ((Map) (obj)), status);
            return;
        }
        obj1 = obj;
        if(1 == method)
        {
            obj1 = obj;
            if(obj == null)
                obj1 = new HashMap();
        }
        if(obj1 == null)
        {
            httpGet(s, headers, status);
            return;
        }
        if(isMultiPart(((Map) (obj1))))
        {
            httpMulti(s, headers, ((Map) (obj1)), status);
            return;
        } else
        {
            httpPost(s, headers, ((Map) (obj1)), status);
            return;
        }
    }

    private void network(int i)
        throws IOException
    {
        if(i <= 1)
        {
            network();
        } else
        {
            int j = 0;
            while(j < i) 
            {
                try
                {
                    network();
                    return;
                }
                catch(IOException ioexception)
                {
                    if(j == i - 1)
                        throw ioexception;
                }
                j++;
            }
        }
    }

    private void networkWork()
    {
        byte abyte0[];
        if(url == null)
        {
            status.code(-101).done();
            return;
        }
        abyte0 = null;
        byte abyte1[];
        network(retry + 1);
        if(ah != null && ah.expired(this, status) && !reauth)
        {
            AQUtility.debug("reauth needed", status.getMessage());
            reauth = true;
            if(!ah.reauth(this))
                break MISSING_BLOCK_LABEL_168;
            network();
        }
        abyte1 = status.getData();
        abyte0 = abyte1;
_L1:
        Exception exception;
        try
        {
            result = transform(url, abyte0, status);
        }
        catch(Exception exception1)
        {
            AQUtility.debug(exception1);
        }
        if(result == null && abyte0 != null)
            status.code(-103).message("transform error");
        lastStatus = status.getCode();
        status.done();
        return;
        try
        {
            status.reauth(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(Exception exception)
        {
            AQUtility.debug(exception);
        }
        status.code(-101).message("network error");
          goto _L1
    }

    private String parseCharset(String s)
    {
        int k;
        if(s != null)
            if((k = s.indexOf("charset")) != -1)
            {
                int j = s.indexOf(";", k);
                int i = j;
                if(j == -1)
                    i = s.length();
                return s.substring(k + 7, i).replaceAll("[^\\w-]", "");
            }
        return null;
    }

    private static String patchUrl(String s)
    {
        return s.replaceAll(" ", "%20").replaceAll("\\|", "%7C");
    }

    private Object self()
    {
        return this;
    }

    public static void setAgent(String s)
    {
        AGENT = s;
    }

    public static void setGZip(boolean flag)
    {
        GZIP = flag;
    }

    public static void setNetworkLimit(int i)
    {
        NETWORK_POOL = Math.max(1, Math.min(25, i));
        fetchExe = null;
        AQUtility.debug("setting network limit", Integer.valueOf(NETWORK_POOL));
    }

    public static void setReuseHttpClient(boolean flag)
    {
        REUSE_CLIENT = flag;
        client = null;
    }

    public static void setSSF(SocketFactory socketfactory)
    {
        ssf = socketfactory;
        client = null;
    }

    public static void setTimeout(int i)
    {
        NET_TIMEOUT = i;
    }

    public static void setTransformer(Transformer transformer1)
    {
        st = transformer1;
    }

    private byte[] toData(String s, InputStream inputstream)
        throws IOException
    {
        Object obj = inputstream;
        if("gzip".equalsIgnoreCase(s))
            obj = new GZIPInputStream(inputstream);
        return AQUtility.toBytes(((InputStream) (obj)));
    }

    private void wake()
    {
        if(!blocked)
            return;
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        try
        {
            notifyAll();
        }
        catch(Exception exception1) { }
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void work(Context context)
    {
        Object obj = memGet(url);
        if(obj != null)
        {
            result = obj;
            status.source(4).done();
            callback();
            return;
        } else
        {
            cacheDir = AQUtility.getCacheDir(context, policy);
            execute(this);
            return;
        }
    }

    private static void writeData(DataOutputStream dataoutputstream, String s, String s1, InputStream inputstream)
        throws IOException
    {
        dataoutputstream.writeBytes("--*****\r\n");
        dataoutputstream.writeBytes((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\";").append(" filename=\"").append(s1).append("\"").append("\r\n").toString());
        dataoutputstream.writeBytes("Content-Type: application/octet-stream");
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.writeBytes("Content-Transfer-Encoding: binary");
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.writeBytes("\r\n");
        AQUtility.copy(inputstream, dataoutputstream);
        dataoutputstream.writeBytes("\r\n");
    }

    private static void writeField(DataOutputStream dataoutputstream, String s, String s1)
        throws IOException
    {
        dataoutputstream.writeBytes("--*****\r\n");
        dataoutputstream.writeBytes((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"").toString());
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.write(s1.getBytes("UTF-8"));
        dataoutputstream.writeBytes("\r\n");
    }

    private static void writeObject(DataOutputStream dataoutputstream, String s, Object obj)
        throws IOException
    {
        if(obj == null)
            return;
        if(obj instanceof File)
        {
            obj = (File)obj;
            writeData(dataoutputstream, s, ((File) (obj)).getName(), new FileInputStream(((File) (obj))));
            return;
        }
        if(obj instanceof byte[])
        {
            writeData(dataoutputstream, s, s, new ByteArrayInputStream((byte[])(byte[])obj));
            return;
        }
        if(obj instanceof InputStream)
        {
            writeData(dataoutputstream, s, s, (InputStream)obj);
            return;
        } else
        {
            writeField(dataoutputstream, s, obj.toString());
            return;
        }
    }

    public void abort()
    {
        abort = true;
        if(request != null && !request.isAborted())
            request.abort();
    }

    protected File accessFile(File file, String s)
    {
        if(expire < 0L)
        {
            file = null;
        } else
        {
            s = AQUtility.getExistedCacheByUrl(file, s);
            file = s;
            if(s != null)
            {
                file = s;
                if(expire != 0L)
                {
                    file = s;
                    if(System.currentTimeMillis() - s.lastModified() > expire)
                        return null;
                }
            }
        }
        return file;
    }

    public void async(Activity activity)
    {
        if(activity.isFinishing())
            AQUtility.warn("Warning", "Possible memory leak. Calling ajax with a terminated activity.");
        if(type == null)
        {
            AQUtility.warn("Warning", "type() is not called with response type.");
            return;
        } else
        {
            act = new WeakReference(activity);
            async(((Context) (activity)));
            return;
        }
    }

    public void async(Context context)
    {
        if(status == null)
        {
            status = new AjaxStatus();
            status.redirect(url).refresh(refresh);
        } else
        if(status.getDone())
        {
            status.reset();
            result = null;
        }
        showProgress(true);
        if(ah != null && !ah.authenticated())
        {
            AQUtility.debug("auth needed", url);
            ah.auth(this);
            return;
        } else
        {
            work(context);
            return;
        }
    }

    public Object auth(Activity activity, String s, String s1)
    {
        if(android.os.Build.VERSION.SDK_INT >= 5 && s.startsWith("g."))
            ah = new GoogleHandle(activity, s, s1);
        return self();
    }

    public Object auth(AccountHandle accounthandle)
    {
        ah = accounthandle;
        return self();
    }

    public void block()
    {
        if(AQUtility.isUIThread())
            throw new IllegalStateException("Cannot block UI thread.");
        if(completed)
            return;
        this;
        JVM INSTR monitorenter ;
        blocked = true;
        wait(NET_TIMEOUT + 5000);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch(Exception exception1)
        {
            return;
        }
    }

    protected boolean cacheAvailable(Context context)
    {
        return fileCache && AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(context, policy), url) != null;
    }

    void callback()
    {
        showProgress(false);
        completed = true;
        if(isActive())
        {
            if(callback != null)
            {
                Object obj = getHandler();
                Class class1 = type;
                String s = callback;
                Class aclass[] = DEFAULT_SIG;
                String s1 = url;
                Object obj1 = result;
                AjaxStatus ajaxstatus = status;
                AQUtility.invokeHandler(obj, s, true, true, new Class[] {
                    java/lang/String, class1, com/androidquery/callback/AjaxStatus
                }, aclass, new Object[] {
                    s1, obj1, ajaxstatus
                });
            } else
            {
                try
                {
                    callback(url, result, status);
                }
                catch(Exception exception)
                {
                    AQUtility.report(exception);
                }
            }
        } else
        {
            skip(url, result, status);
        }
        filePut();
        if(!blocked)
            status.close();
        wake();
        AQUtility.debugNotify();
    }

    public void callback(String s, Object obj, AjaxStatus ajaxstatus)
    {
    }

    public Object cookie(String s, String s1)
    {
        if(cookies == null)
            cookies = new HashMap();
        cookies.put(s, s1);
        return self();
    }

    protected Object datastoreGet(String s)
    {
        return null;
    }

    public Object encoding(String s)
    {
        encoding = s;
        return self();
    }

    public Object expire(long l)
    {
        expire = l;
        return self();
    }

    public void failure(int i, String s)
    {
        if(status != null)
        {
            status.code(i).message(s);
            callback();
        }
    }

    public Object fileCache(boolean flag)
    {
        fileCache = flag;
        return self();
    }

    protected Object fileGet(String s, File file, AjaxStatus ajaxstatus)
    {
        Object obj = null;
        if(!isStreamingContent()) goto _L2; else goto _L1
_L1:
        ajaxstatus.file(file);
        file = obj;
_L4:
        return transform(s, file, ajaxstatus);
_L2:
        file = AQUtility.toBytes(new FileInputStream(file));
        if(true) goto _L4; else goto _L3
_L3:
        s;
        AQUtility.debug(s);
        return null;
    }

    protected void filePut(String s, Object obj, File file, byte abyte0[])
    {
        if(file == null || abyte0 == null)
        {
            return;
        } else
        {
            AQUtility.storeAsync(file, abyte0, 0L);
            return;
        }
    }

    protected File getCacheFile()
    {
        return AQUtility.getCacheFile(cacheDir, getCacheUrl());
    }

    public String getCallback()
    {
        return callback;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public Object getHandler()
    {
        if(handler != null)
            return handler;
        if(whandler == null)
            return null;
        else
            return whandler.get();
    }

    public Object getResult()
    {
        return result;
    }

    public AjaxStatus getStatus()
    {
        return status;
    }

    public Class getType()
    {
        return type;
    }

    public String getUrl()
    {
        return url;
    }

    public Object handler(Object obj, String s)
    {
        handler = obj;
        callback = s;
        whandler = null;
        return self();
    }

    public Object header(String s, String s1)
    {
        if(headers == null)
            headers = new HashMap();
        headers.put(s, s1);
        return self();
    }

    protected boolean isStreamingContent()
    {
        return java/io/File.equals(type) || org/xmlpull/v1/XmlPullParser.equals(type) || java/io/InputStream.equals(type) || com/androidquery/util/XmlDom.equals(type);
    }

    public Object memCache(boolean flag)
    {
        memCache = flag;
        return self();
    }

    protected Object memGet(String s)
    {
        return null;
    }

    protected void memPut(String s, Object obj)
    {
    }

    public Object method(int i)
    {
        method = i;
        return self();
    }

    public Object networkUrl(String s)
    {
        networkUrl = s;
        return self();
    }

    public Object param(String s, Object obj)
    {
        if(params == null)
            params = new HashMap();
        params.put(s, obj);
        return self();
    }

    public Object params(Map map)
    {
        params = map;
        return self();
    }

    public Object policy(int i)
    {
        policy = i;
        return self();
    }

    public Object progress(Dialog dialog)
    {
        return progress(dialog);
    }

    public Object progress(View view)
    {
        return progress(view);
    }

    public Object progress(Object obj)
    {
        if(obj != null)
            progress = new WeakReference(obj);
        return self();
    }

    public Object proxy(String s, int i)
    {
        proxy = new HttpHost(s, i);
        return self();
    }

    public Object refresh(boolean flag)
    {
        refresh = flag;
        return self();
    }

    public Object retry(int i)
    {
        retry = i;
        return self();
    }

    public void run()
    {
label0:
        {
label1:
            {
                if(status.getDone())
                    break label0;
                try
                {
                    backgroundWork();
                }
                catch(Throwable throwable)
                {
                    AQUtility.debug(throwable);
                    status.code(-101).done();
                }
                if(!status.getReauth())
                {
                    if(!uiCallback)
                        break label1;
                    AQUtility.post(this);
                }
                return;
            }
            afterWork();
            return;
        }
        afterWork();
    }

    protected void showProgress(final boolean show)
    {
        final Object p;
label0:
        {
            if(progress == null)
                p = null;
            else
                p = progress.get();
            if(p != null)
            {
                if(!AQUtility.isUIThread())
                    break label0;
                Common.showProgress(p, url, show);
            }
            return;
        }
        AQUtility.post(new Runnable() {

            public void run()
            {
                Common.showProgress(p, url, show);
            }

            final AbstractAjaxCallback this$0;
            final Object val$p;
            final boolean val$show;

            
            {
                this$0 = AbstractAjaxCallback.this;
                p = obj;
                show = flag;
                super();
            }
        }
);
    }

    protected void skip(String s, Object obj, AjaxStatus ajaxstatus)
    {
    }

    public Object targetFile(File file)
    {
        targetFile = file;
        return self();
    }

    public Object timeout(int i)
    {
        timeout = i;
        return self();
    }

    protected Object transform(String s, byte abyte0[], AjaxStatus ajaxstatus)
    {
        File file;
        if(type == null)
            return null;
        file = ajaxstatus.getFile();
        if(abyte0 == null) goto _L2; else goto _L1
_L1:
        if(type.equals(android/graphics/Bitmap))
            return BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
        if(!type.equals(org/json/JSONObject)) goto _L4; else goto _L3
_L3:
        s = null;
        abyte0 = new String(abyte0, encoding);
        s = (JSONObject)(new JSONTokener(abyte0)).nextValue();
        return s;
        ajaxstatus;
        abyte0 = s;
        s = ajaxstatus;
_L12:
        AQUtility.debug(s);
        AQUtility.debug(abyte0);
        return null;
_L4:
        if(type.equals(org/json/JSONArray))
        {
            try
            {
                s = (JSONArray)(new JSONTokener(new String(abyte0, encoding))).nextValue();
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                AQUtility.debug(s);
                return null;
            }
            return s;
        }
        if(type.equals(java/lang/String))
        {
            if(ajaxstatus.getSource() == 1)
            {
                AQUtility.debug("network");
                return correctEncoding(abyte0, encoding, ajaxstatus);
            }
            AQUtility.debug("file");
            try
            {
                s = new String(abyte0, encoding);
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                AQUtility.debug(s);
                return null;
            }
            return s;
        }
        if(type.equals([B))
            return abyte0;
        if(transformer != null)
            return transformer.transform(s, type, encoding, abyte0, ajaxstatus);
        if(st != null)
            return st.transform(s, type, encoding, abyte0, ajaxstatus);
          goto _L5
_L2:
        if(file == null) goto _L5; else goto _L6
_L6:
        if(type.equals(java/io/File))
            return file;
        if(!type.equals(com/androidquery/util/XmlDom)) goto _L8; else goto _L7
_L7:
        s = new FileInputStream(file);
        abyte0 = new XmlDom(s);
        ajaxstatus.closeLater(s);
        return abyte0;
        s;
_L10:
        AQUtility.report(s);
        return null;
_L8:
        if(type.equals(org/xmlpull/v1/XmlPullParser))
        {
            s = Xml.newPullParser();
            try
            {
                abyte0 = new FileInputStream(file);
                s.setInput(abyte0, encoding);
                ajaxstatus.closeLater(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                AQUtility.report(s);
                return null;
            }
            return s;
        }
        if(type.equals(java/io/InputStream))
        {
            try
            {
                s = new FileInputStream(file);
                ajaxstatus.closeLater(s);
            }
            // Misplaced declaration of an exception variable
            catch(String s)
            {
                AQUtility.report(s);
                return null;
            }
            return s;
        }
_L5:
        return null;
        s;
        if(true) goto _L10; else goto _L9
_L9:
        s;
        if(true) goto _L12; else goto _L11
_L11:
    }

    public Object transformer(Transformer transformer1)
    {
        transformer = transformer1;
        return self();
    }

    public Object type(Class class1)
    {
        type = class1;
        return self();
    }

    public Object uiCallback(boolean flag)
    {
        uiCallback = flag;
        return self();
    }

    public Object url(String s)
    {
        url = s;
        return self();
    }

    public Object weakHandler(Object obj, String s)
    {
        whandler = new WeakReference(obj);
        callback = s;
        handler = null;
        return self();
    }

    private static String AGENT = null;
    private static final Class DEFAULT_SIG[] = {
        java/lang/String, java/lang/Object, com/androidquery/callback/AjaxStatus
    };
    private static boolean GZIP = false;
    private static int NETWORK_POOL = 0;
    private static int NET_TIMEOUT = 0;
    private static boolean REUSE_CLIENT = false;
    private static final String boundary = "*****";
    private static DefaultHttpClient client;
    private static ExecutorService fetchExe;
    private static int lastStatus = 0;
    private static final String lineEnd = "\r\n";
    private static SocketFactory ssf;
    private static Transformer st;
    private static final String twoHyphens = "--";
    private boolean abort;
    private WeakReference act;
    private AccountHandle ah;
    private boolean blocked;
    private File cacheDir;
    private String callback;
    private boolean completed;
    private Map cookies;
    private String encoding;
    private long expire;
    protected boolean fileCache;
    private Object handler;
    private Map headers;
    protected boolean memCache;
    private int method;
    private String networkUrl;
    private Map params;
    private int policy;
    private WeakReference progress;
    private HttpHost proxy;
    private boolean reauth;
    private boolean refresh;
    private HttpUriRequest request;
    protected Object result;
    private int retry;
    protected AjaxStatus status;
    private File targetFile;
    private int timeout;
    private Transformer transformer;
    private Class type;
    private boolean uiCallback;
    private String url;
    private Reference whandler;

    static 
    {
        NET_TIMEOUT = 30000;
        NETWORK_POOL = 4;
        GZIP = true;
        REUSE_CLIENT = true;
        lastStatus = 200;
    }

}
