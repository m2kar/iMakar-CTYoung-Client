// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.net.wifi.interfaces;


public interface WifiConnectListener
{

    public abstract void OnConnected();

    public abstract void OnError(com.realtech_inc.net.wifi.Constants.AddNetworkState addnetworkstate);
}
