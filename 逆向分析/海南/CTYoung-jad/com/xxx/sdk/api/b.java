// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.api;

import android.content.Intent;

// Referenced classes of package com.xxx.sdk.api:
//            BatteryService

final class b
    implements Runnable
{

    b(BatteryService batteryservice, Class class1)
    {
        a = batteryservice;
        b = class1;
        super();
    }

    public final void run()
    {
        do
        {
            Intent intent = new Intent(a, b);
            a.startService(intent);
            try
            {
                Thread.sleep(5000L);
            }
            catch(InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        } while(true);
    }

    private BatteryService a;
    private Class b;
}
