// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.api;

import com.xxx.sdk.d.o;
import com.xxx.sdk.e.e.a;

// Referenced classes of package com.xxx.sdk.api:
//            NetworkService

final class e
    implements Runnable
{

    e(NetworkService networkservice)
    {
        a = networkservice;
        super();
    }

    public final void run()
    {
        do
        {
            if(!com.xxx.sdk.e.e.a.h(a))
                (new o(a, (byte)0)).execute(new Void[0]);
            try
            {
                Thread.sleep(3000L);
            }
            catch(InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        } while(true);
    }

    private NetworkService a;
}
