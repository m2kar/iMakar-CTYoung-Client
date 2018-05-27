// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.transport;

import java.io.IOException;

// Referenced classes of package org.ksoap2.transport:
//            HttpsTransportSE, HttpsServiceConnectionSEIgnoringConnectionClose, ServiceConnection

public class KeepAliveHttpsTransportSE extends HttpsTransportSE
{

    public KeepAliveHttpsTransportSE(String s, int i, String s1, int j)
    {
        super(s, i, s1, j);
    }

    public ServiceConnection getServiceConnection()
        throws IOException
    {
        HttpsServiceConnectionSEIgnoringConnectionClose httpsserviceconnectionseignoringconnectionclose = new HttpsServiceConnectionSEIgnoringConnectionClose(host, port, file, timeout);
        httpsserviceconnectionseignoringconnectionclose.setRequestProperty("Connection", "keep-alive");
        return httpsserviceconnectionseignoringconnectionclose;
    }
}
