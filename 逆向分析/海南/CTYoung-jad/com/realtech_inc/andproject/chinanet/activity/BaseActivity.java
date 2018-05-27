// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.activity;

import android.app.Activity;
import android.os.Bundle;
import com.realtech_inc.andproject.chinanet.utils.PhoneManageUtils;

// Referenced classes of package com.realtech_inc.andproject.chinanet.activity:
//            ReceiveHandler

public abstract class BaseActivity extends Activity
{

    public BaseActivity()
    {
    }

    public ReceiveHandler getReceiveUpdate()
    {
        return hanlder;
    }

    abstract void notifyView(int i, Bundle bundle);

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        hanlder = ReceiveHandler.getInstence(this);
        PhoneManageUtils.getInstence().initDeviceInfo(this);
    }

    private ReceiveHandler hanlder;
}
