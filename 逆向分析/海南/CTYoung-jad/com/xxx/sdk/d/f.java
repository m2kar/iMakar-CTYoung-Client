// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.content.Context;
import android.os.AsyncTask;
import com.xxx.e.g;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.f.b;
import com.xxx.sdk.f.c;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.xxx.sdk.d:
//            d, a

public final class f extends AsyncTask
{

    public f(com.xxx.c.a a1, Context context, String s)
    {
        d = null;
        a_com_xxx_c_a_fld = a1;
        a_android_content_Context_fld = context;
        packageName = s;
    }

    private transient Void a(Map amap[])
    {
        Map map = g.b(a_android_content_Context_fld);
        map.put("pk", packageName);
        if(!com.xxx.sdk.e.e.a.a(a_android_content_Context_fld, packageName))
            map.put("AppName", com.xxx.sdk.e.e.a.c(a_android_content_Context_fld, packageName));
        if(amap != null && amap.length > 0)
            map.putAll(amap[0]);
        try
        {
            d = (c)com.xxx.sdk.b.a(a_android_content_Context_fld).a(com/xxx/sdk/f/c, map);
        }
        // Misplaced declaration of an exception variable
        catch(Map amap[])
        {
            com.xxx.sdk.api.a.b.a = 0L;
            com.xxx.sdk.e.c.error("reset banner ad request time immediately", amap);
        }
        // Misplaced declaration of an exception variable
        catch(Map amap[])
        {
            com.xxx.sdk.e.c.error("request banner ad error", amap);
        }
        return null;
    }

    private void a(Void void1)
    {
        super.onPostExecute(void1);
        if(isCancelled())
            d = null;
        a_com_xxx_c_a_fld.a(d);
        com.xxx.sdk.api.a.c.set(false);
        d = null;
        a_com_xxx_c_a_fld = null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a((Map[])aobj);
    }

    protected final void onCancelled()
    {
        super.onCancelled();
        com.xxx.sdk.f.a.n();
        com.xxx.sdk.api.a.B();
        com.xxx.sdk.d.d.a().a(98, d.f);
        com.xxx.sdk.api.a.c.set(false);
        a_com_xxx_c_a_fld = null;
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        if(isCancelled())
            d = null;
        a_com_xxx_c_a_fld.a(d);
        com.xxx.sdk.api.a.c.set(false);
        d = null;
        a_com_xxx_c_a_fld = null;
    }

    private Context a_android_content_Context_fld;
    private com.xxx.c.a a_com_xxx_c_a_fld;
    private c d;
    private String packageName;
}
