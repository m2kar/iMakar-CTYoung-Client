// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.transport;

import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package org.ksoap2.transport:
//            HttpTransportSE

public class KeepAliveHttpTransportSE extends HttpTransportSE
{

    public KeepAliveHttpTransportSE(String s)
    {
        super(null, s);
    }

    public KeepAliveHttpTransportSE(String s, int i)
    {
        super(s, i);
    }

    public KeepAliveHttpTransportSE(String s, int i, int j)
    {
        super(s, i);
    }

    public KeepAliveHttpTransportSE(Proxy proxy, String s)
    {
        super(proxy, s);
    }

    public KeepAliveHttpTransportSE(Proxy proxy, String s, int i)
    {
        super(proxy, s, i);
    }

    public KeepAliveHttpTransportSE(Proxy proxy, String s, int i, int j)
    {
        super(proxy, s, i);
    }

    public List call(String s, SoapEnvelope soapenvelope, List list)
        throws IOException, XmlPullParserException
    {
        Object obj = list;
        if(list == null)
            obj = new ArrayList();
        list = getHeader(((List) (obj)), "Connection");
        if(list == null)
            ((List) (obj)).add(new HeaderProperty("Connection", "keep-alive"));
        else
            list.setValue("keep-alive");
        return super.call(s, soapenvelope, ((List) (obj)));
    }

    protected HeaderProperty getHeader(List list, String s)
    {
        HeaderProperty headerproperty;
        Object obj;
        obj = null;
        headerproperty = obj;
        if(list == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        headerproperty = obj;
        if(i >= list.size()) goto _L2; else goto _L3
_L3:
        headerproperty = (HeaderProperty)list.get(i);
        if(!s.equals(headerproperty.getKey())) goto _L4; else goto _L2
_L2:
        return headerproperty;
_L4:
        i++;
        if(true) goto _L6; else goto _L5
_L5:
    }
}
