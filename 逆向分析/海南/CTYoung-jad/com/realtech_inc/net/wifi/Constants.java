// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.net.wifi;


public class Constants
{
    public static final class AddNetworkState extends Enum
    {

        public static AddNetworkState valueOf(String s)
        {
            return (AddNetworkState)Enum.valueOf(com/realtech_inc/net/wifi/Constants$AddNetworkState, s);
        }

        public static AddNetworkState[] values()
        {
            return (AddNetworkState[])$VALUES.clone();
        }

        private static final AddNetworkState $VALUES[];
        public static final AddNetworkState CONNECTING_TIMEOUT;
        public static final AddNetworkState NOT_ALIVE_AP;
        public static final AddNetworkState SUCCESS;
        public static final AddNetworkState SYSTEM_ERROR;
        public static final AddNetworkState WIFI_IS_ENABLE;

        static 
        {
            SUCCESS = new AddNetworkState("SUCCESS", 0);
            WIFI_IS_ENABLE = new AddNetworkState("WIFI_IS_ENABLE", 1);
            NOT_ALIVE_AP = new AddNetworkState("NOT_ALIVE_AP", 2);
            SYSTEM_ERROR = new AddNetworkState("SYSTEM_ERROR", 3);
            CONNECTING_TIMEOUT = new AddNetworkState("CONNECTING_TIMEOUT", 4);
            $VALUES = (new AddNetworkState[] {
                SUCCESS, WIFI_IS_ENABLE, NOT_ALIVE_AP, SYSTEM_ERROR, CONNECTING_TIMEOUT
            });
        }

        private AddNetworkState(String s, int i)
        {
            super(s, i);
        }
    }


    public Constants()
    {
    }

    public static final int WIFI_CONNECT_TIMEOUT = 5000;
}
