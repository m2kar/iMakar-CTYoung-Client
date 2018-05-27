// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.transport;

import java.io.*;
import java.net.Proxy;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package org.ksoap2.transport:
//            Transport, HttpResponseException, ServiceConnection, ServiceConnectionSE

public class HttpTransportSE extends Transport
{

    public HttpTransportSE(String s)
    {
        super(null, s);
    }

    public HttpTransportSE(String s, int i)
    {
        super(s, i);
    }

    public HttpTransportSE(String s, int i, int j)
    {
        super(s, i);
    }

    public HttpTransportSE(Proxy proxy, String s)
    {
        super(proxy, s);
    }

    public HttpTransportSE(Proxy proxy, String s, int i)
    {
        super(proxy, s, i);
    }

    public HttpTransportSE(Proxy proxy, String s, int i, int j)
    {
        super(proxy, s, i);
    }

    private InputStream getUnZippedInputStream(InputStream inputstream)
        throws IOException
    {
        GZIPInputStream gzipinputstream;
        try
        {
            gzipinputstream = (GZIPInputStream)inputstream;
        }
        catch(ClassCastException classcastexception)
        {
            return new GZIPInputStream(inputstream);
        }
        return gzipinputstream;
    }

    private InputStream readDebug(InputStream inputstream, int i, File file)
        throws IOException
    {
        Object obj;
        byte abyte0[];
        if(file != null)
        {
            obj = new FileOutputStream(file);
        } else
        {
            if(i <= 0)
                i = 0x40000;
            obj = new ByteArrayOutputStream(i);
        }
        abyte0 = new byte[256];
        do
        {
            i = inputstream.read(abyte0, 0, 256);
            if(i == -1)
            {
                ((OutputStream) (obj)).flush();
                if(obj instanceof ByteArrayOutputStream)
                    abyte0 = ((ByteArrayOutputStream)obj).toByteArray();
                responseDump = new String(abyte0);
                inputstream.close();
                if(file != null)
                    return new FileInputStream(file);
                else
                    return new ByteArrayInputStream(abyte0);
            }
            ((OutputStream) (obj)).write(abyte0, 0, i);
        } while(true);
    }

    public List call(String s, SoapEnvelope soapenvelope, List list)
        throws HttpResponseException, IOException, XmlPullParserException
    {
        return call(s, soapenvelope, list, null);
    }

    public List call(String s, SoapEnvelope soapenvelope, List list, File file)
        throws HttpResponseException, IOException, XmlPullParserException
    {
        int k;
        int l;
        char c;
        boolean flag;
        char c1;
        boolean flag1;
        int k1;
        Object obj;
        Object obj1;
        ServiceConnection serviceconnection;
        obj = s;
        if(s == null)
            obj = "\"\"";
        byte abyte0[] = createRequestData(soapenvelope, "UTF-8");
        if(debug)
            s = new String(abyte0);
        else
            s = null;
        requestDump = s;
        responseDump = null;
        serviceconnection = getServiceConnection();
        serviceconnection.setRequestProperty("User-Agent", "ksoap2-android/2.6.0+");
        if(soapenvelope.version != 120)
            serviceconnection.setRequestProperty("SOAPAction", ((String) (obj)));
        if(soapenvelope.version == 120)
            serviceconnection.setRequestProperty("Content-Type", "application/soap+xml;charset=utf-8");
        else
            serviceconnection.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
        serviceconnection.setRequestProperty("Accept-Encoding", "gzip");
        serviceconnection.setRequestProperty("Content-Length", "" + abyte0.length);
        serviceconnection.setFixedLengthStreamingMode(abyte0.length);
        if(list != null)
        {
            for(int i = 0; i < list.size(); i++)
            {
                s = (HeaderProperty)list.get(i);
                serviceconnection.setRequestProperty(s.getKey(), s.getValue());
            }

        }
        serviceconnection.setRequestMethod("POST");
        s = serviceconnection.openOutputStream();
        s.write(abyte0, 0, abyte0.length);
        s.flush();
        s.close();
        s = null;
        obj1 = null;
        obj = null;
        k = 8192;
        flag1 = false;
        flag = false;
        c1 = '\0';
        c = '\0';
        k1 = serviceconnection.getResponseCode();
        l = k;
        list = serviceconnection.getResponseProperties();
        int i1 = 0;
_L13:
        l = k;
        flag1 = flag;
        obj = list;
        c1 = c;
        if(i1 >= list.size()) goto _L2; else goto _L1
_L1:
        l = k;
        flag1 = flag;
        obj = list;
        c1 = c;
        HeaderProperty headerproperty = (HeaderProperty)list.get(i1);
        l = k;
        flag1 = flag;
        obj = list;
        c1 = c;
        if(headerproperty.getKey() != null) goto _L4; else goto _L3
_L3:
        int j1;
        boolean flag2;
        j1 = k;
        flag2 = flag;
          goto _L5
_L4:
        int j;
        j = k;
        l = k;
        flag1 = flag;
        obj = list;
        c1 = c;
        if(!headerproperty.getKey().equalsIgnoreCase("content-length"))
            break MISSING_BLOCK_LABEL_488;
        l = k;
        flag1 = flag;
        obj = list;
        c1 = c;
        String s1 = headerproperty.getValue();
        j = k;
        if(s1 == null)
            break MISSING_BLOCK_LABEL_488;
        l = k;
        flag1 = flag;
        obj = list;
        c1 = c;
        j = Integer.parseInt(headerproperty.getValue());
_L14:
        k = c;
        l = j;
        flag1 = flag;
        obj = list;
        c1 = c;
        if(!headerproperty.getKey().equalsIgnoreCase("Content-Type"))
            break MISSING_BLOCK_LABEL_555;
        k = c;
        l = j;
        flag1 = flag;
        obj = list;
        c1 = c;
        if(headerproperty.getValue().contains("xml"))
            k = 1;
        l = j;
        flag1 = flag;
        obj = list;
        c1 = k;
        j1 = j;
        flag2 = flag;
        c = k;
        if(!headerproperty.getKey().equalsIgnoreCase("Content-Encoding")) goto _L5; else goto _L6
_L6:
        l = j;
        flag1 = flag;
        obj = list;
        c1 = k;
        j1 = j;
        flag2 = flag;
        c = k;
        if(headerproperty.getValue().equalsIgnoreCase("gzip"))
        {
            flag2 = true;
            j1 = j;
            c = k;
        }
          goto _L5
_L2:
        if(k1 == 200) goto _L8; else goto _L7
_L7:
        l = k;
        flag1 = flag;
        obj = list;
        c1 = c;
        try
        {
            throw new HttpResponseException("HTTP request failed, HTTP status: " + k1, k1);
        }
        catch(IOException ioexception)
        {
            list = obj1;
            List list1;
            if(l > 0)
                if(flag1 && l > 0)
                    list = getUnZippedInputStream(new BufferedInputStream(serviceconnection.getErrorStream(), l));
                else
                    list = new BufferedInputStream(serviceconnection.getErrorStream(), l);
            j = l;
            s = list;
            list1 = ((List) (obj));
        }
        if(ioexception instanceof HttpResponseException)
        {
            j = l;
            s = list;
            list1 = ((List) (obj));
            if(c1 == 0)
            {
                if(debug && list != null)
                    readDebug(list, l, file);
                serviceconnection.disconnect();
                throw ioexception;
            }
        }
          goto _L9
_L8:
        j = k;
        list1 = list;
        if(k <= 0) goto _L9; else goto _L10
_L10:
        if(!flag) goto _L12; else goto _L11
_L11:
        l = k;
        flag1 = flag;
        obj = list;
        c1 = c;
        s = getUnZippedInputStream(new BufferedInputStream(serviceconnection.openInputStream(), k));
        list1 = list;
        j = k;
_L9:
        list = s;
        if(debug)
            list = readDebug(s, j, file);
        parseResponse(soapenvelope, list);
        serviceconnection.disconnect();
        return list1;
_L12:
        l = k;
        flag1 = flag;
        obj = list;
        c1 = c;
        s = new BufferedInputStream(serviceconnection.openInputStream(), k);
        j = k;
        list1 = list;
        if(true) goto _L9; else goto _L5
_L5:
        i1++;
        k = j1;
        flag = flag2;
          goto _L13
        NumberFormatException numberformatexception;
        numberformatexception;
        j = 8192;
          goto _L14
    }

    public void call(String s, SoapEnvelope soapenvelope)
        throws HttpResponseException, IOException, XmlPullParserException
    {
        call(s, soapenvelope, null);
    }

    public ServiceConnection getServiceConnection()
        throws IOException
    {
        return new ServiceConnectionSE(proxy, url, timeout);
    }
}
