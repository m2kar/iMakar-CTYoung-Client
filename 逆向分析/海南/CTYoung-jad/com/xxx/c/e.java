// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.os.*;

// Referenced classes of package com.xxx.c:
//            d

final class e extends Handler
{

    e(d d1, Looper looper)
    {
        b = d1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        com.xxx.f.b b1;
        b1 = null;
        if(message.what != 99)
            b1 = b.b;
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
        b.f();
        continue; /* Loop/switch isn't completed */
_L3:
        d.a(b, b1);
        continue; /* Loop/switch isn't completed */
_L2:
        d.b(b, b1);
        if(true) goto _L1; else goto _L5
_L5:
    }

    private d b;
}
