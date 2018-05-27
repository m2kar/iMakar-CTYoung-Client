// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.c;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.xxx.b.b;
import com.xxx.e.e;
import com.xxx.e.g;
import com.xxx.f.z;
import com.xxx.sdk.api.a;
import com.xxx.sdk.b.h;
import com.xxx.sdk.b.i;
import com.xxx.sdk.d.p;
import com.xxx.sdk.e.d.c;
import com.xxx.sdk.f.d;
import com.xxx.sdk.f.f;

// Referenced classes of package com.xxx.c:
//            a

public class l
    implements com.xxx.c.a, z
{

    public l()
    {
    }

    private l(int i1, int j1)
    {
        super.width = 0;
        super.height = 0;
        super.width = i1;
        super.height = j1;
    }

    private l(long l1, long l2)
    {
        super.u = String.valueOf(l1);
        super.v = String.valueOf(l2);
    }

    private l(Context context, Class class1, int i1, int j1)
    {
        super.a_android_content_Context_fld = context;
        super.a_java_lang_Class_fld = class1;
        super.d = i1;
        super.e = j1;
    }

    private l(com.xxx.e.a a1)
    {
        super.a = a1;
        super();
    }

    private l(d d1)
    {
        super.d = false;
        super.w = "";
        super.target = d1.target;
        super.x = d1.target.protocol;
        super.j = d1.target.a.ordinal();
        super.b = d1;
        super.a_com_xxx_f_z_fld = new com.xxx.sdk.b.c(this, d1);
    }

    private static void a(Context context, Intent intent)
    {
        com.xxx.sdk.api.c.a(context, intent);
    }

    private static void a(Context context, Uri uri)
    {
        com.xxx.e.e.a(context, uri);
    }

    private static void a(Context context, h h1)
    {
        com.xxx.e.e.a(context, h1);
    }

    private void a(Context context, f f1)
    {
        while(super.a_java_lang_Class_fld == null || super.d == 0 || super.e == 0) 
            return;
        Notification notification = new Notification();
        notification.icon = 0x108008f;
        notification.tickerText = f1.title;
        notification.when = System.currentTimeMillis();
        notification.flags = notification.flags | 0x10;
        Object obj = new Intent(context, super.a_java_lang_Class_fld);
        ((Intent) (obj)).putExtra("adType", "Push");
        ((Intent) (obj)).putExtra("targetMethod", f1.target.a.ordinal());
        ((Intent) (obj)).putExtra("targetProtocal", f1.target.protocol);
        notification.contentIntent = PendingIntent.getService(context, 0, ((Intent) (obj)), 0);
        obj = new RemoteViews(context.getPackageName(), super.d);
        android.graphics.Bitmap bitmap = BitmapFactory.decodeFile(f1.resource.ba);
        ((RemoteViews) (obj)).setImageViewBitmap(super.e, bitmap);
        notification.contentView = ((RemoteViews) (obj));
        ((NotificationManager)context.getSystemService("notification")).notify(f1.pushId, notification);
        f1.show();
        com.xxx.sdk.api.a.a(f1);
    }

    private static void a(Context context, Class class1, int i1, int j1)
    {
        com.xxx.sdk.api.d.k(context);
        (new p(context, class1, i1, j1)).execute(new Void[0]);
    }

    private void a(Context context, String s)
    {
        if(super.a_com_xxx_sdk_e_a_fld == null)
            super.a_com_xxx_sdk_e_a_fld = new com.xxx.sdk.e.a(context, super.a_com_xxx_f_z_fld);
        com.xxx.e.e.a(super.a_com_xxx_sdk_e_a_fld, context, s, 2);
    }

    private static void a(Intent intent)
    {
        intent = intent.getStringExtra("reason");
        if(intent != null && intent.equals("homekey"))
        {
            com.xxx.sdk.api.d.E();
            com.xxx.sdk.e.a.a(a.a, true);
        }
    }

    private static void b(Context context)
    {
        com.xxx.sdk.api.d.k(context);
        (new p(context)).execute(new Void[0]);
    }

    private static void b(Context context, Class class1, int i1, int j1)
    {
        (new p(context, class1, i1, j1)).execute(new Void[0]);
    }

    private static boolean b(String s)
    {
        if(s == null)
            return false;
        else
            return s.toLowerCase().contains(".apk");
    }

    private static void c(Context context)
    {
        com.xxx.sdk.api.d.D();
        context = com.xxx.sdk.b.a(context);
        com.xxx.sdk.e.c.info("AdManager\u505C\u6B62...");
        context.u();
    }

    private static void d(Context context)
    {
        com.xxx.sdk.api.d.j(context);
    }

    private static void e(Context context)
    {
        (new p(context)).execute(new Void[0]);
    }

    private void f()
    {
        super.a_com_xxx_sdk_d_h_fld = new com.xxx.sdk.d.h(this, super.a_android_content_Context_fld);
        super.a_com_xxx_sdk_d_h_fld.execute(new Void[0]);
    }

    private void j()
    {
        if(super.b != null)
            super.b.click();
    }

    private static void q()
    {
        com.xxx.sdk.api.d.D();
    }

    public void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if(context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(super.x == null || "".equals(super.x)) goto _L1; else goto _L3
_L3:
        Object obj;
        obj = com.xxx.e.e.b(super.x);
        if(!com.xxx.sdk.e.b.a(((Object []) (obj))))
        {
            String s = super.w;
            j();
            if(super.j != i.browser.ordinal())
                break MISSING_BLOCK_LABEL_152;
            if(!g.b(super.x))
                break MISSING_BLOCK_LABEL_140;
            super.b.am();
            com.xxx.e.e.a(context, Uri.parse(super.x));
        }
          goto _L1
        obj;
        Toast.makeText(context, "\u672A\u77E5\u5F02\u5E38\uFF01", 0).show();
        com.xxx.sdk.e.c.error((new StringBuilder("Ad click error:")).append(super.x).toString(), ((Throwable) (obj)));
          goto _L1
        context;
        throw context;
        a(context, super.x);
          goto _L1
        if(super.j != i.app.ordinal()) goto _L5; else goto _L4
_L4:
        com.xxx.e.e.a(context, super.target);
          goto _L1
_L5:
        if(super.j == i.call.ordinal() || super.j == i.message.ordinal() || super.j != i.download.ordinal()) goto _L1; else goto _L6
_L6:
        super.b.am();
        com.xxx.e.e.a(context, Uri.parse(obj[0]));
          goto _L1
    }

    public final void a(com.xxx.sdk.f.a a1)
    {
        if(a1 == null)
            return;
        try
        {
            a(super.a_android_content_Context_fld, (f)a1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(com.xxx.sdk.f.a a1)
        {
            com.xxx.sdk.e.c.error("create push view error: ");
        }
        a1.printStackTrace();
    }

    public boolean a(String s)
    {
        if(g.b(s))
        {
            com.xxx.e.e.a(com.xxx.sdk.b.a().getContext(), Uri.parse(s));
            super.a.a.T();
            return true;
        } else
        {
            return false;
        }
    }

    public void k()
    {
        if(!super.a.d && !com.xxx.e.e.a(super.a.a.a))
        {
            super.a.d = true;
            super.a.c.am();
        }
    }

    public void l()
    {
    }

    public void m()
    {
    }

    private Context a_android_content_Context_fld;
    private com.xxx.e.a a_com_xxx_e_a_fld;
    private z a_com_xxx_f_z_fld;
    private com.xxx.sdk.d.h a_com_xxx_sdk_d_h_fld;
    private com.xxx.sdk.e.a a_com_xxx_sdk_e_a_fld;
    private Class a_java_lang_Class_fld;
    private d b;
    private int d_int_fld;
    private boolean d_boolean_fld;
    private int e;
    private int height;
    private int j;
    private h target;
    private String u;
    private String v;
    private String w;
    private int width;
    private String x;
}
