// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;


public final class s
{

    public s()
    {
        D = 0x44aa200;
    }

    public final String toString()
    {
        return (new StringBuilder("FloatingAd{enable=")).append(k).append(", adSpaceId='").append(T).append('\'').append(", cacheUrl='").append(cacheUrl).append('\'').append(", requestUrl='").append(U).append('\'').append(", freq=").append(D).append(", duration=0, times=").append(E).append(", maxCachedNum=").append(H).append(", showDuration=").append(F).append(", clickDuration=").append(G).append('}').toString();
    }

    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public String T;
    public String U;
    public String cacheUrl;
    private int duration;
    public boolean k;
}
