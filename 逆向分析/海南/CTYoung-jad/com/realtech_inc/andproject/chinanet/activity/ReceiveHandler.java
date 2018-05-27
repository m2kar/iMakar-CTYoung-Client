// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.realtech_inc.andproject.chinanet.activity;

import android.os.*;

// Referenced classes of package com.realtech_inc.andproject.chinanet.activity:
//            BaseActivity

public final class ReceiveHandler extends Handler
{

    private ReceiveHandler()
    {
    }

    public static ReceiveHandler getInstence(BaseActivity baseactivity)
    {
        activity = baseactivity;
        if(hanlder == null)
        {
            baseactivity = new ReceiveHandler();
            hanlder = baseactivity;
            return baseactivity;
        } else
        {
            return hanlder;
        }
    }

    public void handleMessage(Message message)
    {
        int i = message.what;
        Bundle bundle = message.getData();
        switch(message.what)
        {
        default:
            return;

        case 100: // 'd'
            activity.notifyView(i, bundle);
            break;
        }
    }

    public void sendUIMessage(int i, Bundle bundle)
    {
        Message message = Message.obtain();
        message.what = i;
        message.setData(bundle);
        Looper.prepare();
        handleMessage(message);
    }

    private static BaseActivity activity;
    private static ReceiveHandler hanlder;
}
