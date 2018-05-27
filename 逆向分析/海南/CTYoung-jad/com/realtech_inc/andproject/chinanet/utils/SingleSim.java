// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;


// Referenced classes of package com.realtech_inc.andproject.chinanet.utils:
//            SimUtility

public class SingleSim
{

    public SingleSim()
    {
    }

    public String getImsi()
    {
        return imsi;
    }

    public String getProvidersName()
    {
        if(imsi != null)
            return SimUtility.getProvidersName(imsi);
        else
            return "";
    }

    public void setImsi(String s)
    {
        imsi = s;
    }

    private String imsi;
}
