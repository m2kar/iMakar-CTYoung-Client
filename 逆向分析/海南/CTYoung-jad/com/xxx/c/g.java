// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.os.*;

// Referenced classes of package com.xxx.c:
//            f

final class g extends Handler
{

    g(f f1, Looper looper)
    {
        a = f1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        com.xxx.f.p p;
        p = null;
        if(message.what != 99)
            p = a.a;
        message.what;
        JVM INSTR tableswitch 97 99: default 48
    //                   97 75
    //                   98 64
    //                   99 54;
           goto _L1 _L2 _L3 _L4
_L1:
        super.handleMessage(message);
        return;
_L4:
        a.f();
        continue; /* Loop/switch isn't completed */
_L3:
        f.a(a, p);
        continue; /* Loop/switch isn't completed */
_L2:
        f.b(a, p);
        if(true) goto _L1; else goto _L5
_L5:
    }

    private f a;
}
