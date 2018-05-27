// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;


public final class q
{

    public q()
    {
        D = 0x44aa200;
    }

    public final String toString()
    {
        return (new StringBuilder("BannerAd{enable=")).append(k).append(", adSpaceId='").append(T).append('\'').append(", cacheUrl='").append(cacheUrl).append('\'').append(", requestUrl='").append(U).append('\'').append(", freq=").append(D).append(", times=").append(E).append(", duration=0, showDuration=").append(F).append(", clickDuration=").append(G).append('}').toString();
    }

    public int D;
    public int E;
    public int F;
    public int G;
    public String T;
    public String U;
    public String cacheUrl;
    private int duration;
    public boolean k;
}
