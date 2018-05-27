// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;


public final class u
{

    public u()
    {
        D = 0x44aa200;
    }

    public final String toString()
    {
        return (new StringBuilder("PushAd [enable=")).append(k).append(", adSpaceId=").append(T).append(", cacheUrl=").append(cacheUrl).append(", requestUrl=").append(U).append(", times=").append(E).append(", defaultTitle=").append(X).append(", defaultIcon=").append(Y).append(", freq=").append(D).append("]").toString();
    }

    public int D;
    public int E;
    public String T;
    public String U;
    public String X;
    public String Y;
    public String cacheUrl;
    public boolean k;
}
