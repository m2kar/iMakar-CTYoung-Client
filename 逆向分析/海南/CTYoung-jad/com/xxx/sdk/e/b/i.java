// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.b;

import com.xxx.sdk.e.c.d;
import java.io.*;

// Referenced classes of package com.xxx.sdk.e.b:
//            g, f, c

public final class i extends g
{

    public i(OutputStream outputstream)
    {
        if(outputstream == null)
        {
            throw new IllegalArgumentException("Output stream cannot be null");
        } else
        {
            out = outputstream;
            return;
        }
    }

    public final void a(f f1)
    {
        byte abyte0[];
        f1 = f1.a;
        abyte0 = new byte[1024];
_L1:
        int j = f1.read(abyte0);
        if(j == -1)
            break MISSING_BLOCK_LABEL_57;
        out.write(abyte0, 0, j);
          goto _L1
        f1;
        throw new c("Cannot write Http response to output stream", f1);
        f1;
        d.a(out);
        throw f1;
        d.a(out);
        return;
    }

    private final OutputStream out;
}
