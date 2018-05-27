// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package org.ksoap2.transport;

import java.io.*;
import java.util.List;

public interface ServiceConnection
{

    public abstract void connect()
        throws IOException;

    public abstract void disconnect()
        throws IOException;

    public abstract InputStream getErrorStream();

    public abstract String getHost();

    public abstract String getPath();

    public abstract int getPort();

    public abstract int getResponseCode()
        throws IOException;

    public abstract List getResponseProperties()
        throws IOException;

    public abstract InputStream openInputStream()
        throws IOException;

    public abstract OutputStream openOutputStream()
        throws IOException;

    public abstract void setFixedLengthStreamingMode(int i);

    public abstract void setRequestMethod(String s)
        throws IOException;

    public abstract void setRequestProperty(String s, String s1)
        throws IOException;

    public static final int DEFAULT_BUFFER_SIZE = 0x40000;
    public static final int DEFAULT_TIMEOUT = 20000;
}
