// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.utils;

import android.content.Context;
import android.net.wifi.*;
import java.util.List;

public class WlanWifiManager
{

    public WlanWifiManager(Context context)
    {
        wiFiManager = (WifiManager)context.getSystemService("wifi");
        wiFiInfo = wiFiManager.getConnectionInfo();
        if(isOpen())
            startScan();
    }

    public void closeWifi()
    {
        if(isOpen())
            wiFiManager.setWifiEnabled(false);
    }

    public boolean connectionChinaNet()
    {
        WifiConfiguration wificonfiguration = searchChinaNetResult();
        ScanResult scanresult;
        for(scanresult = searchChinaNetConn(); wificonfiguration != null || scanresult == null;)
            return false;

        wificonfiguration = new WifiConfiguration();
        wificonfiguration.SSID = scanresult.SSID;
        wificonfiguration.BSSID = scanresult.BSSID;
        return false;
    }

    public String getConnectionSSID()
    {
        if(wiFiInfo == null)
            return null;
        else
            return wiFiInfo.getBSSID();
    }

    public int getIPAddress()
    {
        if(wiFiInfo == null)
            return 0;
        else
            return wiFiInfo.getIpAddress();
    }

    public String getMacAddress()
    {
        if(wiFiInfo == null)
            return null;
        else
            return wiFiInfo.getMacAddress();
    }

    public int getNetworkId()
    {
        if(wiFiInfo == null)
            return 0;
        else
            return wiFiInfo.getNetworkId();
    }

    public String getWifiInfo()
    {
        if(wiFiInfo == null)
            return null;
        else
            return wiFiInfo.toString();
    }

    public int getWifiState()
    {
        return wiFiManager.getWifiState();
    }

    public boolean isOpen()
    {
        return wiFiManager.isWifiEnabled();
    }

    public void openWifi()
    {
        if(!isOpen())
            wiFiManager.setWifiEnabled(true);
    }

    public ScanResult searchChinaNetConn()
    {
        Object obj = null;
        int j = listScanResult.size();
        int i = 0;
        do
        {
label0:
            {
                ScanResult scanresult = obj;
                if(i < j)
                {
                    scanresult = (ScanResult)listScanResult.get(i);
                    if(!"CHINANET".equalsIgnoreCase(scanresult.SSID))
                        break label0;
                }
                return scanresult;
            }
            i++;
        } while(true);
    }

    public WifiConfiguration searchChinaNetResult()
    {
        Object obj = null;
        int j = listWifiCon.size();
        int i = 0;
        do
        {
label0:
            {
                WifiConfiguration wificonfiguration = obj;
                if(i < j)
                {
                    wificonfiguration = (WifiConfiguration)listWifiCon.get(i);
                    if(!"CHINANET".equalsIgnoreCase(wificonfiguration.SSID))
                        break label0;
                }
                return wificonfiguration;
            }
            i++;
        } while(true);
    }

    public void startScan()
    {
        wiFiManager.startScan();
        listScanResult = wiFiManager.getScanResults();
        listWifiCon = wiFiManager.getConfiguredNetworks();
    }

    private List listScanResult;
    private List listWifiCon;
    private final WifiInfo wiFiInfo;
    private final WifiManager wiFiManager;
    private android.net.wifi.WifiManager.WifiLock wifiLock;
}
