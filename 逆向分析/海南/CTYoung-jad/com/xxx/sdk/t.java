// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;


// Referenced classes of package com.xxx.sdk:
//            w

public final class t
{

    public t()
    {
        D = 0x44aa200;
        I = 0x44aa200;
        J = 0x44aa200;
        new w();
    }

    public final String toString()
    {
        return (new StringBuilder("LauncherAd [enable=")).append(k).append(", adSpaceId=").append(T).append(", cacheUrl=").append(cacheUrl).append(", requestUrl=").append(U).append(", freq=").append(D).append(", unlockFreq=").append(I).append(", backHomeFreq=").append(J).append(", maxApps=").append(K).append(", adTypes=").append(W).append("]").toString();
    }

    public int D;
    public int I;
    public int J;
    public int K;
    public String T;
    public String U;
    public String W;
    private w b;
    public String cacheUrl;
    public boolean k;
}
