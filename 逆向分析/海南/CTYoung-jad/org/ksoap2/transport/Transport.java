// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.transport;

import java.io.*;
import java.net.*;
import java.util.List;
import org.ksoap2.SoapEnvelope;
import org.kxml2.io.KXmlParser;
import org.kxml2.io.KXmlSerializer;
import org.xmlpull.v1.*;

// Referenced classes of package org.ksoap2.transport:
//            ServiceConnection

public abstract class Transport
{

    public Transport()
    {
        timeout = 20000;
        xmlVersionTag = "";
        bufferLength = 0x40000;
    }

    public Transport(String s)
    {
        this(((Proxy) (null)), s);
    }

    public Transport(String s, int i)
    {
        timeout = 20000;
        xmlVersionTag = "";
        bufferLength = 0x40000;
        url = s;
        timeout = i;
    }

    public Transport(String s, int i, int j)
    {
        timeout = 20000;
        xmlVersionTag = "";
        bufferLength = 0x40000;
        url = s;
        timeout = i;
        bufferLength = j;
    }

    public Transport(Proxy proxy1, String s)
    {
        timeout = 20000;
        xmlVersionTag = "";
        bufferLength = 0x40000;
        proxy = proxy1;
        url = s;
    }

    public Transport(Proxy proxy1, String s, int i)
    {
        timeout = 20000;
        xmlVersionTag = "";
        bufferLength = 0x40000;
        proxy = proxy1;
        url = s;
        timeout = i;
    }

    public Transport(Proxy proxy1, String s, int i, int j)
    {
        timeout = 20000;
        xmlVersionTag = "";
        bufferLength = 0x40000;
        proxy = proxy1;
        url = s;
        timeout = i;
        bufferLength = j;
    }

    public abstract List call(String s, SoapEnvelope soapenvelope, List list)
        throws IOException, XmlPullParserException;

    public abstract List call(String s, SoapEnvelope soapenvelope, List list, File file)
        throws IOException, XmlPullParserException;

    public void call(String s, SoapEnvelope soapenvelope)
        throws IOException, XmlPullParserException
    {
        call(s, soapenvelope, null);
    }

    protected byte[] createRequestData(SoapEnvelope soapenvelope)
        throws IOException
    {
        return createRequestData(soapenvelope, null);
    }

    protected byte[] createRequestData(SoapEnvelope soapenvelope, String s)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(bufferLength);
        bytearrayoutputstream.write(xmlVersionTag.getBytes());
        KXmlSerializer kxmlserializer = new KXmlSerializer();
        kxmlserializer.setOutput(bytearrayoutputstream, s);
        soapenvelope.write(kxmlserializer);
        kxmlserializer.flush();
        bytearrayoutputstream.write(13);
        bytearrayoutputstream.write(10);
        bytearrayoutputstream.flush();
        return bytearrayoutputstream.toByteArray();
    }

    public String getHost()
        throws MalformedURLException
    {
        return (new URL(url)).getHost();
    }

    public String getPath()
        throws MalformedURLException
    {
        return (new URL(url)).getPath();
    }

    public int getPort()
        throws MalformedURLException
    {
        return (new URL(url)).getPort();
    }

    public abstract ServiceConnection getServiceConnection()
        throws IOException;

    protected void parseResponse(SoapEnvelope soapenvelope, InputStream inputstream)
        throws XmlPullParserException, IOException
    {
        KXmlParser kxmlparser = new KXmlParser();
        kxmlparser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        kxmlparser.setInput(inputstream, null);
        soapenvelope.parse(kxmlparser);
        inputstream.close();
    }

    public void reset()
    {
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void setXmlVersionTag(String s)
    {
        xmlVersionTag = s;
    }

    protected static final String CONTENT_TYPE_SOAP_XML_CHARSET_UTF_8 = "application/soap+xml;charset=utf-8";
    protected static final String CONTENT_TYPE_XML_CHARSET_UTF_8 = "text/xml;charset=utf-8";
    protected static final String USER_AGENT = "ksoap2-android/2.6.0+";
    private int bufferLength;
    public boolean debug;
    protected Proxy proxy;
    public String requestDump;
    public String responseDump;
    protected int timeout;
    protected String url;
    private String xmlVersionTag;
}
