// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.f;

import com.xxx.sdk.b.f;
import com.xxx.sdk.b.h;

// Referenced classes of package com.xxx.sdk.f:
//            a

public class c extends a
{

    public c()
    {
    }

    public final String getAlias()
    {
        return "1";
    }

    public String toString()
    {
        return (new StringBuilder("BannerAd [resource=")).append(resource).append(", target=").append(target).append(", id=").append(id).append(", sysShowUrl=").append(sysShowUrl).append(", sysClickUrl=").append(sysClickUrl).append(", showUrl=").append(showUrl).append(", clickUrl=").append(clickUrl).append(", installUrl=").append(installUrl).append(", activateUrl=").append(activateUrl).append(", reactivateUrl=").append(reactivateUrl).append(", cacheUrl=").append(cacheUrl).append(", downloadUrl=").append(downloadUrl).append(", getAlias()=1]").toString();
    }

    private static final long serialVersionUID = 0x624998b04aa2eeadL;
    public f resource;
    public h target;
}
