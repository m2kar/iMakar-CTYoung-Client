// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.androidquery.callback;

import com.androidquery.util.AQUtility;
import java.io.Closeable;
import java.io.File;
import java.util.*;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class AjaxStatus
{

    public AjaxStatus()
    {
        code = 200;
        message = "OK";
        time = new Date();
        source = 1;
        start = System.currentTimeMillis();
    }

    public AjaxStatus(int i, String s)
    {
        code = 200;
        message = "OK";
        time = new Date();
        source = 1;
        start = System.currentTimeMillis();
        code = i;
        message = s;
    }

    protected AjaxStatus client(DefaultHttpClient defaulthttpclient)
    {
        client = defaulthttpclient;
        return this;
    }

    public void close()
    {
        AQUtility.close(close);
        close = null;
    }

    protected void closeLater(Closeable closeable)
    {
        close = closeable;
    }

    public AjaxStatus code(int i)
    {
        code = i;
        return this;
    }

    protected AjaxStatus context(HttpContext httpcontext)
    {
        context = httpcontext;
        return this;
    }

    protected AjaxStatus data(byte abyte0[])
    {
        data = abyte0;
        return this;
    }

    public AjaxStatus done()
    {
        duration = System.currentTimeMillis() - start;
        done = true;
        reauth = false;
        return this;
    }

    protected AjaxStatus error(String s)
    {
        error = s;
        return this;
    }

    public boolean expired(long l)
    {
        long l1 = time.getTime();
        return System.currentTimeMillis() - l1 > l && getSource() != 1;
    }

    protected AjaxStatus file(File file1)
    {
        file = file1;
        return this;
    }

    public DefaultHttpClient getClient()
    {
        return client;
    }

    public int getCode()
    {
        return code;
    }

    public List getCookies()
    {
        if(context == null)
            return Collections.emptyList();
        CookieStore cookiestore = (CookieStore)context.getAttribute("http.cookie-store");
        if(cookiestore == null)
            return Collections.emptyList();
        else
            return cookiestore.getCookies();
    }

    protected byte[] getData()
    {
        return data;
    }

    protected boolean getDone()
    {
        return done;
    }

    public long getDuration()
    {
        return duration;
    }

    public String getError()
    {
        return error;
    }

    protected File getFile()
    {
        return file;
    }

    public String getHeader(String s)
    {
        if(headers != null)
        {
            int i = 0;
            while(i < headers.length) 
            {
                if(s.equalsIgnoreCase(headers[i].getName()))
                    return headers[i].getValue();
                i++;
            }
        }
        return null;
    }

    public List getHeaders()
    {
        if(headers == null)
            return Collections.emptyList();
        else
            return Arrays.asList(headers);
    }

    protected boolean getInvalid()
    {
        return invalid;
    }

    public String getMessage()
    {
        return message;
    }

    protected boolean getReauth()
    {
        return reauth;
    }

    public String getRedirect()
    {
        return redirect;
    }

    public boolean getRefresh()
    {
        return refresh;
    }

    public int getSource()
    {
        return source;
    }

    public Date getTime()
    {
        return time;
    }

    protected AjaxStatus headers(Header aheader[])
    {
        headers = aheader;
        return this;
    }

    public AjaxStatus invalidate()
    {
        invalid = true;
        return this;
    }

    public AjaxStatus message(String s)
    {
        message = s;
        return this;
    }

    protected AjaxStatus reauth(boolean flag)
    {
        reauth = flag;
        return this;
    }

    protected AjaxStatus redirect(String s)
    {
        redirect = s;
        return this;
    }

    protected AjaxStatus refresh(boolean flag)
    {
        refresh = flag;
        return this;
    }

    protected AjaxStatus reset()
    {
        duration = System.currentTimeMillis() - start;
        done = false;
        close();
        return this;
    }

    protected AjaxStatus source(int i)
    {
        source = i;
        return this;
    }

    protected AjaxStatus time(Date date)
    {
        time = date;
        return this;
    }

    public static final int AUTH_ERROR = -102;
    public static final int DATASTORE = 2;
    public static final int DEVICE = 5;
    public static final int FILE = 3;
    public static final int MEMORY = 4;
    public static final int NETWORK = 1;
    public static final int NETWORK_ERROR = -101;
    public static final int TRANSFORM_ERROR = -103;
    private DefaultHttpClient client;
    private Closeable close;
    private int code;
    private HttpContext context;
    private byte data[];
    private boolean done;
    private long duration;
    private String error;
    private File file;
    private Header headers[];
    private boolean invalid;
    private String message;
    private boolean reauth;
    private String redirect;
    private boolean refresh;
    private int source;
    private long start;
    private Date time;
}
