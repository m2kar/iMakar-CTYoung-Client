// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.f;

import com.xxx.sdk.b.f;
import com.xxx.sdk.b.h;

// Referenced classes of package com.xxx.sdk.f:
//            a

public class d extends a
{

    public d()
    {
    }

    private int v()
    {
        return imageW;
    }

    private int w()
    {
        return imageH;
    }

    private void x(int i)
    {
        imageW = i;
    }

    private void y(int i)
    {
        imageH = i;
    }

    public final String getAlias()
    {
        return "2";
    }

    public String toString()
    {
        return (new StringBuilder("FloatingAd [resource=")).append(resource).append(", target=").append(target).append(", id=").append(id).append(", sysShowUrl=").append(sysShowUrl).append(", sysClickUrl=").append(sysClickUrl).append(", showUrl=").append(showUrl).append(", clickUrl=").append(clickUrl).append(", installUrl=").append(installUrl).append(", activateUrl=").append(activateUrl).append(", reactivateUrl=").append(reactivateUrl).append(", cacheUrl=").append(cacheUrl).append(", downloadUrl=").append(downloadUrl).append(", getAlias()=2]").toString();
    }

    private static final long serialVersionUID = 0x182328f0f13b8205L;
    public int imageH;
    public int imageW;
    public f resource;
    public h target;
}
