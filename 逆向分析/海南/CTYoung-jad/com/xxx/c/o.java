// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.*;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.xxx.sdk.d.n;
import com.xxx.sdk.e.c;
import com.xxx.sdk.f.a;
import com.xxx.sdk.f.e;
import java.util.List;

// Referenced classes of package com.xxx.c:
//            a

public final class o
    implements com.xxx.c.a
{

    public o()
    {
    }

    public o(Context context)
    {
        a_android_content_Context_fld = context;
    }

    private static String a(Context context, String s)
    {
        context = context.getPackageManager().getInstalledPackages(0);
        for(int i = 0; i < context.size(); i++)
        {
            PackageInfo packageinfo = (PackageInfo)context.get(i);
            if(packageinfo.packageName.equals(s))
                return packageinfo.applicationInfo.name;
        }

        return null;
    }

    private static void a(Context context, e e1)
    {
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", e1.title);
        intent.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeFile(e1.icon));
        intent.putExtra("duplicate", false);
        Intent intent1 = new Intent("android.intent.action.VIEW");
        intent1.addFlags(0x10000000);
        intent1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(e1.installer).toString()), "application/vnd.android.package-archive");
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent1);
        context.sendBroadcast(intent);
        e1.show();
    }

    private static void b(Context context, e e1)
    {
        Intent intent = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", e1.title);
        intent.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeFile(e1.icon));
        intent.putExtra("duplicate", false);
        Intent intent1 = new Intent("android.intent.action.VIEW");
        intent1.addFlags(0x10000000);
        intent1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(e1.installer).toString()), "application/vnd.android.package-archive");
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent1);
        context.sendBroadcast(intent);
    }

    private void f()
    {
        a_com_xxx_sdk_d_n_fld = new n(this, a_android_content_Context_fld);
        a_com_xxx_sdk_d_n_fld.execute(new Void[0]);
    }

    public final void a(a a1)
    {
        if(a1 == null)
            return;
        a1 = (e)a1;
        try
        {
            Context context = a_android_content_Context_fld;
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", ((e) (a1)).title);
            intent.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeFile(((e) (a1)).icon));
            intent.putExtra("duplicate", false);
            Intent intent1 = new Intent("android.intent.action.VIEW");
            intent1.addFlags(0x10000000);
            intent1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(((e) (a1)).installer).toString()), "application/vnd.android.package-archive");
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent1);
            context.sendBroadcast(intent);
            a1.show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(a a1)
        {
            c.error("createAdWindow error.");
        }
    }

    private static String A = "optimizedAdClick";
    private static String B = "optimizedAdShowDuration";
    private static String C = "has_optimized_ad";
    private static String D = "optimized_platform_name";
    private static String E = "optimizedAdImei";
    private static String F = "optimizedAdMac";
    private static String z = "optimizedAdShow";
    public Context a_android_content_Context_fld;
    public n a_com_xxx_sdk_d_n_fld;
}
