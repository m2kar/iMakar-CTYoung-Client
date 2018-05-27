// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.net.wifi;

import android.content.Context;
import android.net.wifi.*;
import java.util.*;

public class WifiAdmin
{

    private WifiAdmin(Context context)
    {
        mWifiManager = (WifiManager)context.getSystemService("wifi");
        mWifiInfo = mWifiManager.getConnectionInfo();
    }

    private WifiConfiguration CreateWifiInfo(String s, String s1, int i)
    {
        WifiConfiguration wificonfiguration = new WifiConfiguration();
        wificonfiguration.allowedAuthAlgorithms.clear();
        wificonfiguration.allowedGroupCiphers.clear();
        wificonfiguration.allowedKeyManagement.clear();
        wificonfiguration.allowedPairwiseCiphers.clear();
        wificonfiguration.allowedProtocols.clear();
        wificonfiguration.SSID = (new StringBuilder()).append("\"").append(s).append("\"").toString();
        s = IsExsits(s);
        if(s != null)
            mWifiManager.removeNetwork(((WifiConfiguration) (s)).networkId);
        if(i == 1)
        {
            wificonfiguration.wepKeys[0] = "";
            wificonfiguration.allowedKeyManagement.set(0);
            wificonfiguration.wepTxKeyIndex = 0;
        }
        if(i == 2)
        {
            wificonfiguration.hiddenSSID = true;
            wificonfiguration.wepKeys[0] = (new StringBuilder()).append("\"").append(s1).append("\"").toString();
            wificonfiguration.allowedAuthAlgorithms.set(1);
            wificonfiguration.allowedGroupCiphers.set(3);
            wificonfiguration.allowedGroupCiphers.set(2);
            wificonfiguration.allowedGroupCiphers.set(0);
            wificonfiguration.allowedGroupCiphers.set(1);
            wificonfiguration.allowedKeyManagement.set(0);
            wificonfiguration.wepTxKeyIndex = 0;
        }
        if(i == 3)
        {
            wificonfiguration.preSharedKey = (new StringBuilder()).append("\"").append(s1).append("\"").toString();
            wificonfiguration.hiddenSSID = true;
            wificonfiguration.allowedAuthAlgorithms.set(0);
            wificonfiguration.allowedGroupCiphers.set(2);
            wificonfiguration.allowedKeyManagement.set(1);
            wificonfiguration.allowedPairwiseCiphers.set(1);
            wificonfiguration.allowedGroupCiphers.set(3);
            wificonfiguration.allowedPairwiseCiphers.set(2);
            wificonfiguration.status = 2;
        }
        return wificonfiguration;
    }

    private WifiConfiguration IsExsits(String s)
    {
        for(Iterator iterator = mWifiManager.getConfiguredNetworks().iterator(); iterator.hasNext();)
        {
            WifiConfiguration wificonfiguration = (WifiConfiguration)iterator.next();
            if(wificonfiguration.SSID.equals((new StringBuilder()).append("\"").append(s).append("\"").toString()))
                return wificonfiguration;
        }

        return null;
    }

    private void acquireWifiLock()
    {
        mWifiLock.acquire();
    }

    private Constants.AddNetworkState addNetwork(ScanResult scanresult, String s)
    {
        WifiConfiguration wificonfiguration = new WifiConfiguration();
        wificonfiguration.SSID = (new StringBuilder()).append('"').append(scanresult.SSID).append('"').toString();
        if(s == null)
        {
            wificonfiguration.wepKeys[0] = "";
            wificonfiguration.allowedKeyManagement.set(0);
            wificonfiguration.wepTxKeyIndex = 0;
        } else
        {
            wificonfiguration.preSharedKey = (new StringBuilder()).append("\"").append(s).append("\"").toString();
            wificonfiguration.hiddenSSID = true;
            wificonfiguration.status = 2;
            wificonfiguration.allowedGroupCiphers.set(2);
            wificonfiguration.allowedGroupCiphers.set(3);
            wificonfiguration.allowedKeyManagement.set(1);
            wificonfiguration.allowedPairwiseCiphers.set(1);
            wificonfiguration.allowedPairwiseCiphers.set(2);
            wificonfiguration.allowedProtocols.set(1);
        }
        if(addNetwork(wificonfiguration))
            return Constants.AddNetworkState.SUCCESS;
        else
            return Constants.AddNetworkState.SYSTEM_ERROR;
    }

    private boolean addNetwork(WifiConfiguration wificonfiguration)
    {
        int i = mWifiManager.addNetwork(wificonfiguration);
        boolean flag = mWifiManager.enableNetwork(i, true);
        return i != -1 && flag;
    }

    private boolean checkSSIDAlive(String s)
    {
        startScan();
        for(Iterator iterator = getWifiList().iterator(); iterator.hasNext();)
            if(((ScanResult)iterator.next()).SSID.equals((new StringBuilder()).append("\"").append(s).append("\"").toString()))
                return true;

        return false;
    }

    private boolean connectConfiguration(int i)
    {
        if(i > mWifiConfiguration.size())
            return false;
        else
            return mWifiManager.enableNetwork(((WifiConfiguration)mWifiConfiguration.get(i)).networkId, true);
    }

    private void creatWifiLock()
    {
        mWifiLock = mWifiManager.createWifiLock("Test");
    }

    private void disconnectWifi(int i)
    {
        mWifiManager.disableNetwork(i);
        mWifiManager.disconnect();
    }

    private List getConfiguration()
    {
        return mWifiConfiguration;
    }

    public static WifiAdmin getInstance(Context context)
    {
        if(mInstance == null)
            mInstance = new WifiAdmin(context);
        return mInstance;
    }

    private int getNetworkId()
    {
        if(mWifiInfo == null)
            return 0;
        else
            return mWifiInfo.getNetworkId();
    }

    private String getWifiInfo()
    {
        if(mWifiInfo == null)
            return "NULL";
        else
            return mWifiInfo.toString();
    }

    private StringBuilder lookUpScan()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = 0; i < mWifiList.size(); i++)
        {
            stringbuilder.append((new StringBuilder()).append("Index_").append((new Integer(i + 1)).toString()).append(":").toString());
            stringbuilder.append(((ScanResult)mWifiList.get(i)).toString());
            stringbuilder.append("/n");
        }

        return stringbuilder;
    }

    private void releaseWifiLock()
    {
        if(mWifiLock.isHeld())
            mWifiLock.acquire();
    }

    public Constants.AddNetworkState addNetwork(String s)
    {
        return addNetwork(s, null);
    }

    public Constants.AddNetworkState addNetwork(String s, String s1)
    {
        ScanResult scanresult = null;
        if(3 != checkState())
            return Constants.AddNetworkState.WIFI_IS_ENABLE;
        startScan();
        Iterator iterator = getWifiList().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            ScanResult scanresult1 = (ScanResult)iterator.next();
            if(scanresult1.SSID.equals(s))
                scanresult = scanresult1;
        } while(true);
        if(scanresult == null)
            return Constants.AddNetworkState.NOT_ALIVE_AP;
        else
            return addNetwork(scanresult, s1);
    }

    public int checkState()
    {
        return mWifiManager.getWifiState();
    }

    public boolean checkWifiConnected(String s)
    {
        return mWifiManager.getConnectionInfo().getSSID().equals((new StringBuilder()).append("\"").append(s).append("\"").toString());
    }

    public void closeWifi()
    {
        if(mWifiManager.isWifiEnabled())
            mWifiManager.setWifiEnabled(false);
    }

    public String getBSSID()
    {
        if(mWifiInfo == null)
            return "NULL";
        else
            return mWifiInfo.getBSSID();
    }

    public int getIPAddress()
    {
        if(mWifiInfo == null)
            return 0;
        else
            return mWifiInfo.getIpAddress();
    }

    public String getMacAddress()
    {
        if(mWifiInfo == null)
            return "NULL";
        else
            return mWifiInfo.getMacAddress();
    }

    List getWifiList()
    {
        return mWifiList;
    }

    public void openWifi()
    {
        if(!mWifiManager.isWifiEnabled())
            mWifiManager.setWifiEnabled(true);
    }

    void startScan()
    {
        if(mWifiManager != null)
        {
            mWifiManager.startScan();
            mWifiList = mWifiManager.getScanResults();
            mWifiConfiguration = mWifiManager.getConfiguredNetworks();
        }
    }

    private static WifiAdmin mInstance;
    private List mWifiConfiguration;
    private WifiInfo mWifiInfo;
    private List mWifiList;
    android.net.wifi.WifiManager.WifiLock mWifiLock;
    private WifiManager mWifiManager;
}
