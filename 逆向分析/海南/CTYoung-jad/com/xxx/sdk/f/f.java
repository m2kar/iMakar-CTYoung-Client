// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.f;

import com.xxx.sdk.b.h;
import java.io.File;

// Referenced classes of package com.xxx.sdk.f:
//            a

public class f extends a
{

    public f()
    {
        pushId = 0;
    }

    private int x()
    {
        return pushId;
    }

    public final void show()
    {
        super.show();
        File file = new File(resource.ba);
        if(file.exists())
            file.delete();
    }

    public String toString()
    {
        return (new StringBuilder("PushAd [pushId=")).append(pushId).append(", title=").append(title).append(", icon=").append(icon).append(", resource=").append(resource).append(", target=").append(target).append(", id=").append(id).append(", sysShowUrl=").append(sysShowUrl).append(", sysClickUrl=").append(sysClickUrl).append(", showUrl=").append(showUrl).append(", clickUrl=").append(clickUrl).append(", installUrl=").append(installUrl).append(", activateUrl=").append(activateUrl).append(", reactivateUrl=").append(reactivateUrl).append(", cacheUrl=").append(cacheUrl).append(", downloadUrl=").append(downloadUrl).append(", getPushId()=").append(pushId).append("]").toString();
    }

    private static final long serialVersionUID = 0xf14b1dadff21cd61L;
    public String icon;
    public int pushId;
    public com.xxx.sdk.b.f resource;
    public h target;
    public String title;
}
