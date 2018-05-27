// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.Toast;
import com.xxx.f.z;
import com.xxx.sdk.b;
import com.xxx.sdk.b.h;
import com.xxx.sdk.b.i;
import com.xxx.sdk.f.c;
import com.xxx.sdk.p;
import com.xxx.sdk.q;
import com.xxx.sdk.s;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.xxx.e:
//            b, e, g

public final class a
{

    public a()
    {
    }

    public a(c c1)
    {
        d = false;
        w = "";
        target = c1.target;
        x = c1.target.protocol;
        j = c1.target.a.ordinal();
        c = c1;
        a_com_xxx_f_z_fld = new com.xxx.e.b(this);
    }

    private static String F()
    {
        Calendar calendar = Calendar.getInstance();
        return (new SimpleDateFormat("yyyy-MM-dd")).format(calendar.getTime());
    }

    public static int a(Context context, String s1)
    {
        context = context.getSharedPreferences("client", 0).getString(s1, null);
        int l = 0x80000000;
        int k = l;
        if(context == null)
            break MISSING_BLOCK_LABEL_53;
        try
        {
            context = new JSONObject(context);
            s1 = F();
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            return 0x80000000;
        }
        k = l;
        if(context.has(s1))
            k = context.optInt(s1);
        return k;
    }

    private static void a(Context context, Uri uri)
    {
        e.a(context, uri);
    }

    private static void a(Context context, h h1)
    {
        e.a(context, h1);
    }

    public static void a(Context context, String s1, int k)
    {
        context = context.getSharedPreferences("client", 0);
        String s2 = F();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put(s2, k);
            context.edit().putString(s1, jsonobject.toString()).commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch(Context context)
        {
            return;
        }
    }

    private static int b(Context context)
    {
        int k = a(context, "floatingStock");
        if(k == 0x80000000)
            return com.xxx.sdk.b.a().a().a_com_xxx_sdk_s_fld.E;
        else
            return com.xxx.sdk.b.a().a().a_com_xxx_sdk_s_fld.E - k;
    }

    private static int c(Context context)
    {
        int k = a(context, "bannerStock");
        if(k == 0x80000000)
            return com.xxx.sdk.b.a().a().a_com_xxx_sdk_q_fld.E;
        else
            return com.xxx.sdk.b.a().a().a_com_xxx_sdk_q_fld.E - k;
    }

    private static void o(Context context)
    {
        int k = a(context, "floatingStock");
        if(k == 0x80000000)
            k = 1;
        else
            k++;
        a(context, "floatingStock", k);
    }

    private static void p(Context context)
    {
        int k = a(context, "bannerStock");
        if(k == 0x80000000)
            k = 1;
        else
            k++;
        a(context, "bannerStock", k);
    }

    public final void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if(context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(x == null || "".equals(x)) goto _L1; else goto _L3
_L3:
        Object obj;
        obj = com.xxx.e.e.b(x);
        if(!com.xxx.sdk.e.b.a(((Object []) (obj))))
        {
            String s1 = w;
            j();
            if(j != i.browser.ordinal())
                break MISSING_BLOCK_LABEL_150;
            if(!com.xxx.e.g.b(x))
                break MISSING_BLOCK_LABEL_138;
            c.am();
            e.a(context, Uri.parse(x));
        }
          goto _L1
        obj;
        Toast.makeText(context, "\u672A\u77E5\u5F02\u5E38\uFF01", 0).show();
        com.xxx.sdk.e.c.error((new StringBuilder("Ad click error:")).append(x).toString(), ((Throwable) (obj)));
          goto _L1
        context;
        throw context;
        a(context, x);
          goto _L1
        if(j != i.app.ordinal()) goto _L5; else goto _L4
_L4:
        e.a(context, target);
          goto _L1
_L5:
        if(j == i.call.ordinal() || j == i.message.ordinal() || j != i.download.ordinal()) goto _L1; else goto _L6
_L6:
        c.am();
        e.a(context, Uri.parse(obj[0]));
          goto _L1
    }

    public final void a(Context context, String s1)
    {
        if(a_com_xxx_sdk_e_a_fld == null)
            a_com_xxx_sdk_e_a_fld = new com.xxx.sdk.e.a(context, a_com_xxx_f_z_fld);
        e.a(a_com_xxx_sdk_e_a_fld, context, s1, 1);
    }

    public final void j()
    {
        if(c != null)
            c.click();
    }

    private static final String cu = "floatingStock";
    private static final String cv = "bannerStock";
    public z a_com_xxx_f_z_fld;
    public com.xxx.sdk.e.a a_com_xxx_sdk_e_a_fld;
    public c c;
    public boolean d;
    public int j;
    public h target;
    public String w;
    public String x;
}
