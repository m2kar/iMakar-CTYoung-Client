// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.xxx.sdk.e.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.f.e;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.xxx.sdk:
//            b

final class g extends BroadcastReceiver
{

    g()
    {
    }

    static void h(Context context)
    {
        if(!b.getAndSet(true))
        {
            IntentFilter intentfilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
            context.registerReceiver(new g(), intentfilter);
        }
    }

    public final void onReceive(Context context, Intent intent)
    {
        long l = intent.getLongExtra("extra_download_id", -1L);
        intent = String.valueOf(l);
        Object obj = (DownloadManager)context.getSystemService("download");
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        obj = ((DownloadManager) (obj)).getUriForDownloadedFile(l);
        c.info((new StringBuilder("\u4E0B\u8F7D\u4EFB\u52A1\uFF1A")).append(intent).append("\u5DF2\u7ECF\u5B8C\u6210\uFF0C\u672C\u5730\u5730\u5740\uFF1A").append(obj).toString());
        if(sharedpreferences.contains(intent))
        {
            if(obj != null)
            {
                c.info((new StringBuilder("\u4E0B\u8F7D\u4EFB\u52A1\uFF1A")).append(intent).append("\u6210\u529F\uFF0C\u5B89\u88C5\u5E94\u7528\u3002").toString());
                String s = sharedpreferences.getString(intent, null);
                String s1 = a.p(s);
                e e1 = com.xxx.sdk.b.a(context).a(s1);
                if(e1 == null || !com.xxx.sdk.e.b.b(s, e1.checksum))
                {
                    c.warn((new StringBuilder("\u5E94\u7528[")).append(s1).append("]\u4E0B\u8F7D\u5185\u5BB9\u4E0D\u5168\u6216\u8005\u8FD0\u8425\u641E\u9519\u4E0D\u662F\u8981\u63A8\u5E7F\u7684\u5E94\u7528\u3002").toString());
                    com.xxx.sdk.e.b.b(new String[] {
                        s
                    });
                } else
                {
                    com.xxx.sdk.f.a.b(((com.xxx.sdk.f.a) (e1)).downloadUrl, null);
                    a.b(context, ((android.net.Uri) (obj)));
                }
            } else
            {
                c.info((new StringBuilder("\u4E0B\u8F7D\u4EFB\u52A1\uFF1A")).append(intent).append("\u5931\u8D25\u3002").toString());
            }
            sharedpreferences.edit().remove(intent).commit();
        }
    }

    private static AtomicBoolean b = new AtomicBoolean();

}
