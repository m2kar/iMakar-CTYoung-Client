// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.xxx.c.o;
import com.xxx.sdk.b;
import com.xxx.sdk.f.a;
import com.xxx.sdk.f.e;

public final class c extends BroadcastReceiver
{

    public c()
    {
    }

    public static void a(Context context, Intent intent)
    {
        intent = intent.getDataString().split(":")[1];
        e e1 = b.a(context).a(intent);
        if(e1 != null)
        {
            e1.install();
            new o(context);
            Intent intent1 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
            intent1.putExtra("android.intent.extra.shortcut.NAME", e1.title);
            intent1.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeFile(e1.icon));
            intent1.putExtra("duplicate", false);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.addFlags(0x10000000);
            intent2.setDataAndType(Uri.parse((new StringBuilder("file://")).append(e1.installer).toString()), "application/vnd.android.package-archive");
            intent1.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            context.sendBroadcast(intent1);
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(intent));
            com.xxx.sdk.f.a.b(((a) (e1)).activateUrl, null);
            com.xxx.sdk.e.b.b(new String[] {
                e1.installer
            });
        }
    }

    public final void onReceive(Context context, Intent intent)
    {
        if(intent.getAction().equals("android.intent.action.PACKAGE_ADDED"))
            a(context, intent);
    }
}
