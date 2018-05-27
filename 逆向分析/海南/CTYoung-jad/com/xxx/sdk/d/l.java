// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.content.Context;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import com.xxx.c.m;
import com.xxx.e.g;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.f.b;
import com.xxx.sdk.f.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.xxx.sdk.d:
//            i

public final class l extends AsyncTask
{

    public l(m m1, Context context, String s)
    {
        e = null;
        b = m1;
        a = context;
        packageName = s;
    }

    private transient Void a(Map amap[])
    {
        Context context = a;
        HashMap hashmap = new HashMap();
        int j = g.a(context).widthPixels;
        int k = g.a(context).heightPixels;
        hashmap.put("img_w", String.valueOf(j));
        hashmap.put("img_h", String.valueOf(k));
        hashmap.put("pk", packageName);
        if(!com.xxx.sdk.e.e.a.a(a, packageName))
            hashmap.put("AppName", com.xxx.sdk.e.e.a.c(a, packageName));
        if(amap != null && amap.length > 0)
            hashmap.putAll(amap[0]);
        try
        {
            e = (d)com.xxx.sdk.b.a(a).a(com/xxx/sdk/f/d, hashmap);
        }
        // Misplaced declaration of an exception variable
        catch(Map amap[])
        {
            com.xxx.sdk.api.a.a.a = 0L;
            c.error("reset system ad request time immediately", amap);
        }
        // Misplaced declaration of an exception variable
        catch(Map amap[])
        {
            c.error("request system ad error", amap);
        }
        return null;
    }

    private void a(Void void1)
    {
        super.onPostExecute(void1);
        if(isCancelled())
            e = null;
        b.a(e);
        com.xxx.sdk.api.a.c.set(false);
        e = null;
        b = null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a((Map[])aobj);
    }

    protected final void onCancelled()
    {
        super.onCancelled();
        com.xxx.sdk.f.a.n();
        com.xxx.sdk.api.a.c.set(false);
        com.xxx.sdk.api.a.A();
        com.xxx.sdk.d.i.a().a(88, i.f);
        b = null;
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        if(isCancelled())
            e = null;
        b.a(e);
        com.xxx.sdk.api.a.c.set(false);
        e = null;
        b = null;
    }

    private Context a;
    private m b;
    private d e;
    private String packageName;
}
