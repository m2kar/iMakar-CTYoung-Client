// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;


// Referenced classes of package com.realtech_inc.andproject.chinanet.utils:
//            SimUtility

public class MultiSim
{

    public MultiSim()
    {
    }

    public String getImei_1()
    {
        return imei_1;
    }

    public String getImei_2()
    {
        return imei_2;
    }

    public String getImsi_1()
    {
        return imsi_1;
    }

    public String getImsi_2()
    {
        return imsi_2;
    }

    public String getProvidersName1()
    {
        if(imsi_1 != null)
            return SimUtility.getProvidersName(imsi_1);
        else
            return "";
    }

    public String getProvidersName2()
    {
        if(imsi_2 != null)
            return SimUtility.getProvidersName(imsi_2);
        else
            return "";
    }

    public int getSimId_1()
    {
        return simId_1;
    }

    public int getSimId_2()
    {
        return simId_2;
    }

    public void setImei_1(String s)
    {
        imei_1 = s;
    }

    public void setImei_2(String s)
    {
        imei_2 = s;
    }

    public void setImsi_1(String s)
    {
        imsi_1 = s;
    }

    public void setImsi_2(String s)
    {
        imsi_2 = s;
    }

    public void setSimId_1(int i)
    {
        simId_1 = i;
    }

    public void setSimId_2(int i)
    {
        simId_2 = i;
    }

    private String imei_1;
    private String imei_2;
    private String imsi_1;
    private String imsi_2;
    private int simId_1;
    private int simId_2;
}
