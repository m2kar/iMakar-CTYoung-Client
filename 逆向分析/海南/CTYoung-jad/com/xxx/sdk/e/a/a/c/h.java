// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.c;


public final class h
{

    private h(String s, String s1)
    {
        prefix = s;
        uri = s1;
    }

    h(String s, String s1, byte byte0)
    {
        this(s, s1);
    }

    private static String a(h h1)
    {
        return h1.uri;
    }

    private static String b(h h1)
    {
        return h1.prefix;
    }

    private String getPrefix()
    {
        return prefix;
    }

    private String getUri()
    {
        return uri;
    }

    public final boolean equals(Object obj)
    {
        if(this != obj)
        {
            if(obj == null || getClass() != obj.getClass())
                return false;
            obj = (h)obj;
            if(prefix == null && ((h) (obj)).prefix != null)
                return false;
            if(uri == null && ((h) (obj)).uri != null)
                return false;
            if(prefix != null && !prefix.equals(((h) (obj)).prefix))
                return false;
            if(uri != null && !uri.equals(((h) (obj)).uri))
                return false;
        }
        return true;
    }

    public final int hashCode()
    {
        return prefix.hashCode() * 31 + uri.hashCode();
    }

    String prefix;
    String uri;
}
