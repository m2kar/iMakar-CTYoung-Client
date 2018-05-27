// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.widget.RemoteViews;
import com.xxx.c.a;
import com.xxx.sdk.b.i;
import com.xxx.sdk.d.h;
import com.xxx.sdk.e.c;
import com.xxx.sdk.f.f;

public final class b
    implements a
{

    public b()
    {
    }

    public b(Context context, Class class1, int j, int k)
    {
        a_android_content_Context_fld = context;
        a_java_lang_Class_fld = class1;
        d = j;
        e = k;
    }

    private void f()
    {
        a_com_xxx_sdk_d_h_fld = new h(this, a_android_content_Context_fld);
        a_com_xxx_sdk_d_h_fld.execute(new Void[0]);
    }

    public final void a(Context context, f f1)
    {
        while(a_java_lang_Class_fld == null || d == 0 || e == 0) 
            return;
        Notification notification = new Notification();
        notification.icon = 0x108008f;
        notification.tickerText = f1.title;
        notification.when = System.currentTimeMillis();
        notification.flags = notification.flags | 0x10;
        Object obj = new Intent(context, a_java_lang_Class_fld);
        ((Intent) (obj)).putExtra("adType", "Push");
        ((Intent) (obj)).putExtra("targetMethod", f1.target.a.ordinal());
        ((Intent) (obj)).putExtra("targetProtocal", f1.target.protocol);
        notification.contentIntent = PendingIntent.getService(context, 0, ((Intent) (obj)), 0);
        obj = new RemoteViews(context.getPackageName(), d);
        android.graphics.Bitmap bitmap = BitmapFactory.decodeFile(f1.resource.ba);
        ((RemoteViews) (obj)).setImageViewBitmap(e, bitmap);
        notification.contentView = ((RemoteViews) (obj));
        ((NotificationManager)context.getSystemService("notification")).notify(f1.pushId, notification);
        f1.show();
        com.xxx.sdk.api.a.a(f1);
    }

    public final void a(com.xxx.sdk.f.a a1)
    {
        if(a1 == null)
            return;
        try
        {
            a(a_android_content_Context_fld, (f)a1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(com.xxx.sdk.f.a a1)
        {
            c.error("create push view error: ");
        }
        a1.printStackTrace();
    }

    private static String m = "adType";
    private static String n = "adViewObject";
    private static String o = "localApkPath";
    private static String p = "Push";
    private static String q = "VirtualFrame";
    private static String r = "targetMethod";
    private static String s = "targetProtocal";
    public Context a_android_content_Context_fld;
    public h a_com_xxx_sdk_d_h_fld;
    public Class a_java_lang_Class_fld;
    public int d;
    public int e;
}
