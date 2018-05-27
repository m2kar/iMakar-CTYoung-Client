// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;


// Referenced classes of package com.realtech_inc.andproject.chinanet.utils:
//            MultiSim

public class MtkDoubleInfo extends MultiSim
{

    public MtkDoubleInfo()
    {
    }

    public String getDefaultImsi()
    {
        return defaultImsi;
    }

    public int getPhoneType_1()
    {
        return phoneType_1;
    }

    public int getPhoneType_2()
    {
        return phoneType_2;
    }

    public boolean isMtkDoubleSim()
    {
        return mtkDoubleSim;
    }

    public void setDefaultImsi(String s)
    {
        defaultImsi = s;
    }

    public void setMtkDoubleSim(boolean flag)
    {
        mtkDoubleSim = flag;
    }

    public void setPhoneType_1(int i)
    {
        phoneType_1 = i;
    }

    public void setPhoneType_2(int i)
    {
        phoneType_2 = i;
    }

    private String defaultImsi;
    private boolean mtkDoubleSim;
    private int phoneType_1;
    private int phoneType_2;
}
