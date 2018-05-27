// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.transport;

import java.io.*;
import java.net.*;
import java.util.*;
import org.ksoap2.HeaderProperty;

// Referenced classes of package org.ksoap2.transport:
//            ServiceConnection

public class ServiceConnectionSE
    implements ServiceConnection
{

    public ServiceConnectionSE(String s)
        throws IOException
    {
        this(null, s, 20000);
    }

    public ServiceConnectionSE(String s, int i)
        throws IOException
    {
        this(null, s, i);
    }

    public ServiceConnectionSE(Proxy proxy, String s)
        throws IOException
    {
        this(proxy, s, 20000);
    }

    public ServiceConnectionSE(Proxy proxy, String s, int i)
        throws IOException
    {
        if(proxy == null)
            proxy = (HttpURLConnection)(new URL(s)).openConnection();
        else
            proxy = (HttpURLConnection)(new URL(s)).openConnection(proxy);
        connection = proxy;
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setConnectTimeout(i);
        connection.setReadTimeout(i);
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
        throws IOException
    {
        LinkedList linkedlist = new LinkedList();
        Map map = connection.getHeaderFields();
        if(map != null)
        {
            for(Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                List list = (List)map.get(s);
                int i = 0;
                while(i < list.size()) 
                {
                    linkedlist.add(new HeaderProperty(s, (String)list.get(i)));
                    i++;
                }
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

    private HttpURLConnection connection;
}
