// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.b;

import android.content.Context;
import com.xxx.sdk.e.a.a.d.b.c;
import com.xxx.sdk.e.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

// Referenced classes of package com.xxx.sdk.e.b:
//            i, c, h, b, 
//            f, g

public final class d
{

    d(com.xxx.sdk.e.b.b b1, String s, String s1)
    {
        c = new HashSet(2);
        a_com_xxx_sdk_e_b_b_fld = b1;
        uri = s;
        method = s1;
    }

    private d a(c c1)
    {
        if(c1 != null)
            t.add(c1);
        return this;
    }

    private d a(g g1)
    {
        a_com_xxx_sdk_e_b_g_fld = g1;
        return this;
    }

    private d a(File file)
    {
        a_com_xxx_sdk_e_b_g_fld = new i(new FileOutputStream(file));
        return this;
    }

    private d a(OutputStream outputstream)
    {
        a_com_xxx_sdk_e_b_g_fld = new i(outputstream);
        return this;
    }

    private d a(Map map)
    {
        n = map;
        return this;
    }

    private d a(byte abyte0[], String s)
    {
        content = abyte0;
        contentType = s;
        if(abyte0 != null)
            w = true;
        return this;
    }

    private static InputStream a(HttpURLConnection httpurlconnection)
    {
label0:
        {
            Object obj = (List)httpurlconnection.getHeaderFields().get("Content-Encoding");
            if(obj == null)
                break label0;
            obj = ((List) (obj)).iterator();
            String s;
            do
            {
                do
                {
                    if(!((Iterator) (obj)).hasNext())
                        break label0;
                    s = (String)((Iterator) (obj)).next();
                } while(s == null);
                if(s.contains("gzip"))
                    return new GZIPInputStream(httpurlconnection.getInputStream());
            } while(!s.contains("deflate"));
            return new InflaterInputStream(httpurlconnection.getInputStream(), new Inflater(true));
        }
        return httpurlconnection.getInputStream();
    }

    private static void a(Map map, StringBuilder stringbuilder)
    {
        if(map != null)
        {
            java.util.Map.Entry entry;
            for(map = map.entrySet().iterator(); map.hasNext(); stringbuilder.append((String)entry.getKey()).append("=").append((String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
                if(stringbuilder.length() != 0)
                    stringbuilder.append("; ");
            }

        }
    }

    private d b(String s, String s1)
    {
        if(s == null)
            throw new IllegalArgumentException("Parameter name cannot be null");
        if(s1 == null)
            throw new IllegalArgumentException("Parameter value cannot be null");
        if(p == null)
            p = new HashMap(4);
        p.put(s, s1);
        return this;
    }

    private d b(Map map)
    {
        o = map;
        return this;
    }

    private static InputStream b(HttpURLConnection httpurlconnection)
    {
label0:
        {
            Object obj = (List)httpurlconnection.getHeaderFields().get("Content-Encoding");
            if(obj == null)
                break label0;
            obj = ((List) (obj)).iterator();
            String s;
            do
            {
                do
                {
                    if(!((Iterator) (obj)).hasNext())
                        break label0;
                    s = (String)((Iterator) (obj)).next();
                } while(s == null);
                if(s.contains("gzip"))
                    return new GZIPInputStream(httpurlconnection.getErrorStream());
            } while(!s.contains("deflate"));
            return new InflaterInputStream(httpurlconnection.getErrorStream(), new Inflater(true));
        }
        return httpurlconnection.getErrorStream();
    }

    private static boolean b(int j)
    {
        j /= 100;
        return j == 4 || j == 5;
    }

    private d c(String s, String s1)
    {
        if(s == null)
            throw new IllegalArgumentException("Cookie name cannot be null");
        if(s1 == null)
            throw new IllegalArgumentException("Cookie value cannot be null");
        if(n == null)
            n = new HashMap(2);
        n.put(s, s1);
        return this;
    }

    private d c(Map map)
    {
        p = map;
        return this;
    }

    public final d a(String s, String s1)
    {
        if(s1 == null)
            throw new IllegalArgumentException("Header value cannot be null");
        if(o == null)
            o = new HashMap(2);
        List list = (List)o.get(s);
        Object obj = list;
        if(list == null)
        {
            obj = new ArrayList(1);
            o.put(s, obj);
        }
        ((List) (obj)).add(s1);
        return this;
    }

    public final transient d a(int ai[])
    {
        int k = ai.length;
        for(int j = 0; j < k; j++)
        {
            int l = ai[j];
            if(l <= 0)
                throw new IllegalArgumentException((new StringBuilder("Invalid status code: ")).append(l).toString());
            c.add(Integer.valueOf(l));
        }

        return this;
    }

    public final f a()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        obj6 = null;
        obj = null;
        obj5 = null;
        obj4 = null;
        obj7 = null;
        obj3 = null;
        obj1 = obj;
        obj2 = obj7;
        if(p == null) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        obj2 = obj7;
        if(p.isEmpty()) goto _L2; else goto _L3
_L3:
        obj1 = obj;
        obj2 = obj7;
        StringBuilder stringbuilder = new StringBuilder(256);
        obj1 = obj;
        obj2 = obj7;
        if("GET".equals(method)) goto _L5; else goto _L4
_L4:
        obj1 = obj;
        obj2 = obj7;
        if(!"HEAD".equals(method)) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        obj2 = obj7;
        if(uri.indexOf('?') != -1) goto _L8; else goto _L7
_L7:
        obj1 = obj;
        obj2 = obj7;
        stringbuilder.append('?');
_L6:
        obj1 = obj;
        obj2 = obj7;
        Iterator iterator = p.entrySet().iterator();
        int j = 0;
_L10:
        obj1 = obj;
        obj2 = obj7;
        if(!iterator.hasNext())
            break; /* Loop/switch isn't completed */
        obj1 = obj;
        obj2 = obj7;
        Object obj8 = (java.util.Map.Entry)iterator.next();
        obj1 = obj;
        obj2 = obj7;
        String s1 = com.xxx.sdk.e.b.d((String)((java.util.Map.Entry) (obj8)).getKey());
        obj1 = obj;
        obj2 = obj7;
        obj8 = com.xxx.sdk.e.b.d((String)((java.util.Map.Entry) (obj8)).getValue());
        obj1 = obj;
        obj2 = obj7;
        if(com.xxx.sdk.e.b.f(s1))
            continue; /* Loop/switch isn't completed */
        if(j == 0)
            break MISSING_BLOCK_LABEL_297;
        obj1 = obj;
        obj2 = obj7;
        stringbuilder.append("&");
        obj1 = obj;
        obj2 = obj7;
        stringbuilder.append(URLEncoder.encode(s1, "UTF-8")).append("=").append(URLEncoder.encode(((String) (obj8)), "UTF-8"));
        j++;
        if(true) goto _L10; else goto _L9
_L8:
        obj1 = obj;
        obj2 = obj7;
        stringbuilder.append('&');
          goto _L6
        obj2;
        obj1 = null;
        obj = obj5;
_L27:
        obj3 = a_com_xxx_sdk_e_b_g_fld;
        if(obj3 == null) goto _L12; else goto _L11
_L11:
        obj2 = a_com_xxx_sdk_e_b_g_fld;
        throw new com.xxx.sdk.e.b.c("Timeout");
        obj2;
        throw obj2;
        obj3;
        obj2 = obj1;
        obj1 = obj;
        obj = obj3;
_L28:
        if(obj1 == null) goto _L14; else goto _L13
_L13:
        if(obj2 == null) goto _L16; else goto _L15
_L15:
        do
            j = ((h) (obj2)).read(buffer);
        while(j != -1);
_L49:
        com.xxx.sdk.e.c.d.a(((h) (obj2)).c);
_L16:
        ((HttpURLConnection) (obj1)).disconnect();
_L14:
        throw obj;
_L9:
        obj1 = obj;
        obj2 = obj7;
        if(w) goto _L18; else goto _L17
_L17:
        obj1 = obj;
        obj2 = obj7;
        if("POST".equals(method)) goto _L20; else goto _L19
_L19:
        obj1 = obj;
        obj2 = obj7;
        if("DELETE".equals(method)) goto _L20; else goto _L21
_L21:
        obj1 = obj;
        obj2 = obj7;
        boolean flag = "PUT".equals(method);
        if(!flag) goto _L18; else goto _L20
_L20:
        obj1 = obj;
        obj2 = obj7;
        content = stringbuilder.toString().getBytes("UTF-8");
_L2:
        obj1 = obj;
        obj2 = obj7;
        obj = (HttpURLConnection)(new URL(uri)).openConnection();
        ((HttpURLConnection) (obj)).setConnectTimeout(a_com_xxx_sdk_e_b_b_fld.connectTimeout);
        ((HttpURLConnection) (obj)).setReadTimeout(a_com_xxx_sdk_e_b_b_fld.readTimeout);
        ((HttpURLConnection) (obj)).setAllowUserInteraction(false);
        ((HttpURLConnection) (obj)).setInstanceFollowRedirects(false);
        ((HttpURLConnection) (obj)).setRequestMethod(method);
        ((HttpURLConnection) (obj)).setUseCaches(false);
        ((HttpURLConnection) (obj)).setDoInput(true);
        if(o == null || o.isEmpty()) goto _L23; else goto _L22
_L22:
        obj1 = o.entrySet().iterator();
_L26:
        if(!((Iterator) (obj1)).hasNext()) goto _L23; else goto _L24
_L24:
        obj5 = (java.util.Map.Entry)((Iterator) (obj1)).next();
        obj2 = (List)((java.util.Map.Entry) (obj5)).getValue();
        if(obj2 == null) goto _L26; else goto _L25
_L25:
        obj5 = (String)((java.util.Map.Entry) (obj5)).getKey();
        obj2 = ((List) (obj2)).iterator();
        while(((Iterator) (obj2)).hasNext()) 
            ((HttpURLConnection) (obj)).addRequestProperty(((String) (obj5)), (String)((Iterator) (obj2)).next());
          goto _L26
        obj2;
        obj1 = null;
          goto _L27
        obj3;
        obj1 = obj;
        obj2 = obj7;
        throw new com.xxx.sdk.e.b.c("Encoding error", ((Throwable) (obj3)));
        obj3;
        obj2 = obj4;
        obj = obj6;
_L51:
        obj1 = obj;
        throw new com.xxx.sdk.e.b.c((new StringBuilder("Connection failed to ")).append(uri).toString(), ((Throwable) (obj3)));
        obj;
          goto _L28
_L18:
        obj1 = obj;
        obj2 = obj7;
        uri = (new StringBuilder()).append(uri).append(stringbuilder).toString();
          goto _L2
_L23:
label0:
        {
            if(n == null || n.isEmpty())
            {
                obj1 = a_com_xxx_sdk_e_b_b_fld.l;
                if(a_com_xxx_sdk_e_b_b_fld.l.isEmpty())
                    break label0;
            }
            obj1 = new StringBuilder(256);
            a(n, ((StringBuilder) (obj1)));
            a(a_com_xxx_sdk_e_b_b_fld.l, ((StringBuilder) (obj1)));
            ((HttpURLConnection) (obj)).setRequestProperty("Cookie", ((StringBuilder) (obj1)).toString());
        }
        obj1 = a_com_xxx_sdk_e_b_b_fld;
        if(((com.xxx.sdk.e.b.b) (obj1)).userAgent != null) goto _L30; else goto _L29
_L29:
        obj1 = b.bT;
_L35:
        if(obj1 == null)
            break MISSING_BLOCK_LABEL_1007;
        ((HttpURLConnection) (obj)).setRequestProperty("User-Agent", ((String) (obj1)));
        ((HttpURLConnection) (obj)).setRequestProperty("Connection", "close");
        ((HttpURLConnection) (obj)).setRequestProperty("Location", uri);
        ((HttpURLConnection) (obj)).setRequestProperty("Referrer", uri);
        ((HttpURLConnection) (obj)).setRequestProperty("Accept-Encoding", "gzip,deflate");
        ((HttpURLConnection) (obj)).setRequestProperty("Accept-Charset", "UTF-8");
        if(!"POST".equals(method) && !"DELETE".equals(method) && !"PUT".equals(method)) goto _L32; else goto _L31
_L31:
        if(content == null)
            break MISSING_BLOCK_LABEL_1228;
        ((HttpURLConnection) (obj)).setDoOutput(true);
        if(w) goto _L34; else goto _L33
_L33:
        ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
_L37:
        ((HttpURLConnection) (obj)).setFixedLengthStreamingMode(content.length);
        obj1 = ((HttpURLConnection) (obj)).getOutputStream();
        ((OutputStream) (obj1)).write(content);
        ((OutputStream) (obj1)).flush();
_L32:
        for(obj1 = t.iterator(); ((Iterator) (obj1)).hasNext(); ((Iterator) (obj1)).next());
        break MISSING_BLOCK_LABEL_1237;
_L30:
        obj1 = ((com.xxx.sdk.e.b.b) (obj1)).userAgent;
          goto _L35
_L34:
        if(contentType == null) goto _L37; else goto _L36
_L36:
        ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", contentType);
          goto _L37
        ((HttpURLConnection) (obj)).setFixedLengthStreamingMode(0);
          goto _L32
        int k;
        ((HttpURLConnection) (obj)).connect();
        k = ((HttpURLConnection) (obj)).getResponseCode();
        if(k != -1)
            break MISSING_BLOCK_LABEL_1281;
        throw new com.xxx.sdk.e.b.c((new StringBuilder("Invalid response from ")).append(uri).toString());
        if(!c.isEmpty() && !c.contains(Integer.valueOf(k)))
            throw new com.xxx.sdk.e.b.c((new StringBuilder("Expected status code ")).append(c).append(", got ").append(k).toString());
        if(c.isEmpty() && k / 100 != 2)
            throw new com.xxx.sdk.e.b.c((new StringBuilder("Expected status code 2xx, got ")).append(k).toString());
        obj2 = ((HttpURLConnection) (obj)).getHeaderFields();
        obj5 = a_com_xxx_sdk_e_b_b_fld.l;
        if(obj2 == null)
            break MISSING_BLOCK_LABEL_1507;
        obj1 = (List)((Map) (obj2)).get("Set-Cookie");
        if(obj1 == null)
            break MISSING_BLOCK_LABEL_1507;
        String s;
        for(obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((Map) (obj5)).put(s.substring(0, j), s.substring(j + 1)))
        {
            s = ((String)((Iterator) (obj1)).next()).split(";", 2)[0];
            j = s.indexOf('=');
        }

        j = k / 100;
        Exception exception;
        if(j != 4 && j != 5)
            j = 0;
        else
            j = 1;
        if(j == 0) goto _L39; else goto _L38
_L38:
        obj1 = new h(b(((HttpURLConnection) (obj))));
_L44:
        if(obj2 != null)
            break MISSING_BLOCK_LABEL_1553;
        obj2 = m;
        obj3 = new f(k, ((InputStream) (obj1)), ((Map) (obj2)), ((Map) (obj5)));
        obj2 = a_com_xxx_sdk_e_b_g_fld;
        if(obj2 == null) goto _L41; else goto _L40
_L40:
        a_com_xxx_sdk_e_b_g_fld.a(((f) (obj3)));
_L47:
        if(obj == null) goto _L43; else goto _L42
_L42:
        do
            j = ((h) (obj1)).read(buffer);
        while(j != -1);
_L50:
        com.xxx.sdk.e.c.d.a(((h) (obj1)).c);
        ((HttpURLConnection) (obj)).disconnect();
_L43:
        return ((f) (obj3));
_L39:
        obj1 = new h(a(((HttpURLConnection) (obj))));
          goto _L44
        obj2;
        throw obj2;
        obj2;
        throw new com.xxx.sdk.e.b.c("Error in response handler", ((Throwable) (obj2)));
_L41:
        if(a_com_xxx_sdk_e_b_b_fld.a == null) goto _L46; else goto _L45
_L45:
        obj2 = a_com_xxx_sdk_e_b_b_fld.a.getCacheDir();
_L48:
        obj2 = File.createTempFile("httpclient-req-", ".cache", ((File) (obj2)));
        ((f) (obj3)).a(((File) (obj2)));
        ((File) (obj2)).delete();
          goto _L47
_L46:
        obj2 = new File(".");
          goto _L48
        obj2;
        throw new com.xxx.sdk.e.b.c("Error in response handler", ((Throwable) (obj2)));
_L12:
        throw new com.xxx.sdk.e.b.c((new StringBuilder("Response timeout from ")).append(uri).toString(), ((Throwable) (obj2)));
        obj3;
          goto _L49
        obj2;
          goto _L50
        obj3;
        obj2 = obj4;
          goto _L51
        exception;
        obj1 = obj;
        obj = exception;
        exception = ((Exception) (obj3));
          goto _L28
        exception;
          goto _L27
        obj3;
        exception = ((Exception) (obj1));
          goto _L51
        Exception exception1;
        exception1;
        exception = ((Exception) (obj1));
        obj1 = obj;
        obj = exception1;
          goto _L28
    }

    private static final String bU = "UTF-8";
    private static final Map m = new HashMap(0);
    private final com.xxx.sdk.e.b.b a_com_xxx_sdk_e_b_b_fld;
    public g a_com_xxx_sdk_e_b_g_fld;
    private final byte buffer[] = new byte[1024];
    private Set c;
    public byte content[];
    public String contentType;
    private String method;
    private Map n;
    private Map o;
    public Map p;
    private final List t = new ArrayList(2);
    private String uri;
    public boolean w;

}
