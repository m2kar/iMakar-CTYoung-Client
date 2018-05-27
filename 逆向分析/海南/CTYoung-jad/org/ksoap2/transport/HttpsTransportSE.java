// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.transport;

import java.io.IOException;
import java.net.Proxy;

// Referenced classes of package org.ksoap2.transport:
//            HttpTransportSE, HttpsServiceConnectionSE, ServiceConnection

public class HttpsTransportSE extends HttpTransportSE
{

    public HttpsTransportSE(String s, int i, String s1, int j)
    {
        super("https://" + s + ":" + i + s1, j);
        host = s;
        port = i;
        file = s1;
    }

    public HttpsTransportSE(Proxy proxy, String s, int i, String s1, int j)
    {
        super(proxy, "https://" + s + ":" + i + s1);
        host = s;
        port = i;
        file = s1;
        timeout = j;
    }

    public ServiceConnection getServiceConnection()
        throws IOException
    {
        if(connection != null)
        {
            return connection;
        } else
        {
            connection = new HttpsServiceConnectionSE(proxy, host, port, file, timeout);
            return connection;
        }
    }

    static final String PROTOCOL = "https";
    private static final String PROTOCOL_FULL = "https://";
    private HttpsServiceConnectionSE connection;
    protected final String file;
    protected final String host;
    protected final int port;
}
