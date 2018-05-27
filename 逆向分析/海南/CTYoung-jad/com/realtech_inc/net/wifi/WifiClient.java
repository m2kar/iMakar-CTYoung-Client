// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.net.wifi;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.realtech_inc.net.wifi.interfaces.WifiConnectListener;

// Referenced classes of package com.realtech_inc.net.wifi:
//            WifiAdmin

public class WifiClient
{

    public WifiClient(Context context, WifiConnectListener wificonnectlistener)
    {
        mHandler = new Handler() {

            public void handleMessage(Message message)
            {
                if(message.what == 1)
                {
                    message = (String)message.obj;
                    if(!WifiAdmin.getInstance(mContext).checkWifiConnected(message))
                        mListener.OnError(Constants.AddNetworkState.CONNECTING_TIMEOUT);
                }
            }

            final WifiClient this$0;

            
            {
                this$0 = WifiClient.this;
                super();
            }
        }
;
        mListener = wificonnectlistener;
        mContext = context;
    }

    public void addNetwork(String s, String s1)
    {
        s1 = WifiAdmin.getInstance(mContext).addNetwork(s, s1);
        static class _cls2
        {

            static final int $SwitchMap$com$realtech_inc$net$wifi$Constants$AddNetworkState[];

            static 
            {
                $SwitchMap$com$realtech_inc$net$wifi$Constants$AddNetworkState = new int[Constants.AddNetworkState.values().length];
                try
                {
                    $SwitchMap$com$realtech_inc$net$wifi$Constants$AddNetworkState[Constants.AddNetworkState.SUCCESS.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch(_cls2..SwitchMap.com.realtech_inc.net.wifi.Constants.AddNetworkState[s1.ordinal()])
        {
        default:
            mListener.OnError(s1);
            return;

        case 1: // '\001'
            s1 = mHandler.obtainMessage(1);
            break;
        }
        s1.obj = s;
        mHandler.sendMessageDelayed(s1, 5000L);
    }

    private static final int CHECK_ADD = 1;
    private Context mContext;
    private Handler mHandler;
    private WifiConnectListener mListener;


}
