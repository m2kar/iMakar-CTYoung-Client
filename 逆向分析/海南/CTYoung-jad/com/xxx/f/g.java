// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.f;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

// Referenced classes of package com.xxx.f:
//            A

final class G
    implements DownloadListener
{

    G(A a)
    {
        b = a;
        super();
    }

    public final void onDownloadStart(String s, String s1, String s2, String s3, long l)
    {
        s = new Intent("android.intent.action.VIEW", Uri.parse(s));
        s.addFlags(0x10000000);
        b.a.startActivity(s);
    }

    private A b;
}
