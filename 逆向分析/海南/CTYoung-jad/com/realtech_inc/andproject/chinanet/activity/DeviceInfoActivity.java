// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.realtech_inc.andproject.chinanet.utils.PhoneManageUtils;

public class DeviceInfoActivity extends Activity
{

    public DeviceInfoActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001b);
        tv_DeviceName = (TextView)findViewById(0x7f08005c);
        tv_IMEI = (TextView)findViewById(0x7f08005d);
        tv_IMSI = (TextView)findViewById(0x7f08005e);
        tv_MAC = (TextView)findViewById(0x7f08005f);
        PhoneManageUtils.getInstence().initDeviceInfo(getApplicationContext());
        tv_DeviceName.setText(PhoneManageUtils.MODEL);
        tv_IMEI.setText(PhoneManageUtils.IMEI);
        tv_IMSI.setText(PhoneManageUtils.IMSI);
        tv_MAC.setText(PhoneManageUtils.MAC);
    }

    private TextView tv_DeviceName;
    private TextView tv_IMEI;
    private TextView tv_IMSI;
    private TextView tv_MAC;
}
