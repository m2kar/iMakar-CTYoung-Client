// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.transport;

import java.io.IOException;

// Referenced classes of package org.ksoap2.transport:
//            HttpsServiceConnectionSE

public class HttpsServiceConnectionSEIgnoringConnectionClose extends HttpsServiceConnectionSE
{

    public HttpsServiceConnectionSEIgnoringConnectionClose(String s, int i, String s1, int j)
        throws IOException
    {
        super(s, i, s1, j);
    }

    public void setRequestProperty(String s, String s1)
    {
        if(!"Connection".equalsIgnoreCase(s) || !"close".equalsIgnoreCase(s1))
            super.setRequestProperty(s, s1);
    }
}
