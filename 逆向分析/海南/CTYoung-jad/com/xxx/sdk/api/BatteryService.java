// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.api;

import android.app.ActivityManager;
import android.app.Service;
import android.content.*;
import android.os.IBinder;
import com.xxx.sdk.e.c;
import java.util.List;

// Referenced classes of package com.xxx.sdk.api:
//            b, NetworkService

public class BatteryService extends Service
{

    public BatteryService()
    {
    }

    private void a(Class class1)
    {
        if(a == null || !a.isAlive())
        {
            a = new Thread(new b(this, class1));
            a.start();
        }
    }

    public static boolean isServiceAlive(Context context, String s)
    {
        boolean flag1 = false;
        context = ((ActivityManager)context.getSystemService("activity")).getRunningServices(30);
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if(i < context.size())
                {
                    if(!s.equals(((android.app.ActivityManager.RunningServiceInfo)context.get(i)).service.getClassName()))
                        break label0;
                    flag = true;
                }
                return flag;
            }
            i++;
        } while(true);
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onDestroy()
    {
        c.debug("BatteryService onDestory");
        startService(new Intent(this, com/xxx/sdk/api/NetworkService));
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if(a == null || !a.isAlive())
        {
            a = new Thread(new b(this, com/xxx/sdk/api/NetworkService));
            a.start();
        }
        return 1;
    }

    private Thread a;
}
