// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.xxx.sdk.e.c;
import java.io.File;

// Referenced classes of package com.xxx.sdk:
//            b, g

public final class f
{

    private f()
    {
    }

    public static f a()
    {
        com/xxx/sdk/f;
        JVM INSTR monitorenter ;
        f f1;
        if(a == null)
            a = new f();
        f1 = a;
        com/xxx/sdk/f;
        JVM INSTR monitorexit ;
        return f1;
        Exception exception;
        exception;
        throw exception;
    }

    private static boolean a(Context context)
    {
        return context.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads") != 2;
    }

    public final void a(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        c.info((new StringBuilder("\u5E94\u7528\u4E0B\u8F7D\u7F51\u7EDC\u5730\u5740\uFF1A")).append(s).append("\uFF0C\u672C\u5730\u5730\u5740\uFF1A").append(s1).toString());
        obj = b.a().getContext();
        boolean flag;
        if(((Context) (obj)).getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads") != 2)
            flag = true;
        else
            flag = false;
        if(flag) goto _L2; else goto _L1
_L1:
        c.warn("\u7CFB\u7EDF\u5E94\u7528\u4E0B\u8F7D\u7BA1\u7406\u5668\u4E0D\u53EF\u7528\uFF0C\u7528\u6237\u53EF\u80FD\u7981\u7528\u6B64\u529F\u80FD\u6216\u8005\u88AB\u5378\u8F7D\uFF01");
_L13:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        DownloadManager downloadmanager;
        SharedPreferences sharedpreferences;
        Object obj1;
        Cursor cursor;
        downloadmanager = (DownloadManager)((Context) (obj)).getSystemService("download");
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(((Context) (obj)));
        g.h(((Context) (obj)));
        obj1 = Uri.parse(s);
        obj = Uri.fromFile(new File(s1));
        cursor = downloadmanager.query(new android.app.DownloadManager.Query());
        if(cursor == null) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        int k;
        int l;
        i = cursor.getColumnIndex("_id");
        j = cursor.getColumnIndex("status");
        k = cursor.getColumnIndex("uri");
        l = cursor.getColumnIndex("local_uri");
_L8:
        if(!cursor.moveToNext()) goto _L6; else goto _L5
_L5:
        if(!((Uri) (obj1)).toString().equals(cursor.getString(k)) || !((Uri) (obj)).toString().equals(cursor.getString(l))) goto _L8; else goto _L7
_L7:
        cursor.getInt(j);
        JVM INSTR lookupswitch 5: default 552
    //                   1: 284
    //                   2: 284
    //                   4: 375
    //                   8: 325
    //                   16: 375;
           goto _L8 _L9 _L9 _L10 _L11 _L10
_L9:
        c.warn((new StringBuilder("\u7F51\u7EDC\u5730\u5740\uFF1A")).append(s).append("\uFF0C\u672C\u5730\u5730\u5740\uFF1A").append(s1).append("\uFF0C\u6B63\u5728\u4E0B\u8F7D\u4E2D\u3002").toString());
          goto _L8
        s;
        throw s;
_L11:
        if(!(new File(s1)).exists()) goto _L10; else goto _L12
_L12:
        c.warn((new StringBuilder("\u7F51\u7EDC\u5730\u5740\uFF1A")).append(s).append("\uFF0C\u672C\u5730\u5730\u5740\uFF1A").append(s1).append(" \u5DF2\u7ECF\u5B8C\u6210\u3002").toString());
          goto _L13
_L10:
        c.warn((new StringBuilder("\u7F51\u7EDC\u5730\u5740\uFF1A")).append(s).append("\uFF0C\u672C\u5730\u5730\u5740\uFF1A").append(s1).append("\uFF0C\u66FE\u7ECF\u4E0B\u8F7D\u5931\u8D25\u3002").toString());
        downloadmanager.remove(new long[] {
            cursor.getLong(i)
        });
          goto _L8
_L6:
        cursor.close();
_L4:
        obj1 = new android.app.DownloadManager.Request(((Uri) (obj1)));
        ((android.app.DownloadManager.Request) (obj1)).setAllowedNetworkTypes(3);
        ((android.app.DownloadManager.Request) (obj1)).setAllowedOverRoaming(false);
        ((android.app.DownloadManager.Request) (obj1)).setNotificationVisibility(0);
        ((android.app.DownloadManager.Request) (obj1)).setDestinationUri(((Uri) (obj)));
        long l1 = downloadmanager.enqueue(((android.app.DownloadManager.Request) (obj1)));
        sharedpreferences.edit().putString(String.valueOf(l1), s1).commit();
        c.info((new StringBuilder("\u63D0\u4EA4\u4E0B\u8F7D\u4EFB\u52A1\uFF0C\u7F51\u7EDC\u5730\u5740\uFF1A")).append(s).append("\uFF0C\u672C\u5730\u5730\u5740\uFF1A").append(s1).append(", \u4EFB\u52A1ID\uFF1A").append(l1).toString());
          goto _L13
    }

    private static String K = "com.android.providers.downloads";
    private static f a = null;

}
