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
//            e, BatteryService

public class NetworkService extends Service
{

    public NetworkService()
    {
    }

    private void I()
    {
        if(b == null || !b.isAlive())
        {
            Thread thread = new Thread(new e(this));
            b = thread;
            thread.start();
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
        startService(new Intent(this, com/xxx/sdk/api/BatteryService));
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        c.debug("NetworkService: onStartCommand");
        if(b == null || !b.isAlive())
        {
            intent = new Thread(new e(this));
            b = intent;
            intent.start();
        }
        return 1;
    }

    private static Thread b;
}
