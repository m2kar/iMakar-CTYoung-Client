// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.transport;

import java.io.IOException;

public class HttpResponseException extends IOException
{

    public HttpResponseException(int i)
    {
        statusCode = i;
    }

    public HttpResponseException(String s, int i)
    {
        super(s);
        statusCode = i;
    }

    public HttpResponseException(String s, Throwable throwable, int i)
    {
        super(s, throwable);
        statusCode = i;
    }

    public HttpResponseException(Throwable throwable, int i)
    {
        super(throwable);
        statusCode = i;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    private int statusCode;
}
