// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.networks.interfaces;


public interface HttpRequestListener
{

    public abstract void onResponseSuccess();

    public abstract void onResponseWithError(int i);
}
