// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.transport;

import java.io.*;
import java.net.Proxy;
import java.net.URL;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.ksoap2.HeaderProperty;

// Referenced classes of package org.ksoap2.transport:
//            ServiceConnection

public class HttpsServiceConnectionSE
    implements ServiceConnection
{

    public HttpsServiceConnectionSE(String s, int i, String s1, int j)
        throws IOException
    {
        this(null, s, i, s1, j);
    }

    public HttpsServiceConnectionSE(Proxy proxy, String s, int i, String s1, int j)
        throws IOException
    {
        if(proxy == null)
            connection = (HttpsURLConnection)(new URL("https", s, i, s1)).openConnection();
        else
            connection = (HttpsURLConnection)(new URL("https", s, i, s1)).openConnection(proxy);
        connection = (HttpsURLConnection)(new URL("https", s, i, s1)).openConnection();
        updateConnectionParameters(j);
    }

    private void updateConnectionParameters(int i)
    {
        connection.setConnectTimeout(i);
        connection.setReadTimeout(i);
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
    }

    public void connect()
        throws IOException
    {
        connection.connect();
    }

    public void disconnect()
    {
        connection.disconnect();
    }

    public InputStream getErrorStream()
    {
        return connection.getErrorStream();
    }

    public String getHost()
    {
        return connection.getURL().getHost();
    }

    public String getPath()
    {
        return connection.getURL().getPath();
    }

    public int getPort()
    {
        return connection.getURL().getPort();
    }

    public int getResponseCode()
        throws IOException
    {
        return connection.getResponseCode();
    }

    public List getResponseProperties()
    {
        Map map = connection.getHeaderFields();
        Object obj = map.keySet();
        LinkedList linkedlist = new LinkedList();
        for(obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            String s = (String)((Iterator) (obj)).next();
            List list = (List)map.get(s);
            int i = 0;
            while(i < list.size()) 
            {
                linkedlist.add(new HeaderProperty(s, (String)list.get(i)));
                i++;
            }
        }

        return linkedlist;
    }

    public InputStream openInputStream()
        throws IOException
    {
        return connection.getInputStream();
    }

    public OutputStream openOutputStream()
        throws IOException
    {
        return connection.getOutputStream();
    }

    public void setFixedLengthStreamingMode(int i)
    {
        connection.setFixedLengthStreamingMode(i);
    }

    public void setRequestMethod(String s)
        throws IOException
    {
        connection.setRequestMethod(s);
    }

    public void setRequestProperty(String s, String s1)
    {
        connection.setRequestProperty(s, s1);
    }

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        connection.setSSLSocketFactory(sslsocketfactory);
    }

    private HttpsURLConnection connection;
}
