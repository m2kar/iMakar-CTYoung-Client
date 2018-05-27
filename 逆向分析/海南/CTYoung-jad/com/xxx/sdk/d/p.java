// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.content.Context;
import android.os.AsyncTask;
import com.xxx.sdk.a;
import com.xxx.sdk.b;
import com.xxx.sdk.c.f;
import com.xxx.sdk.d;
import com.xxx.sdk.e.c;
import com.xxx.sdk.t;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.xxx.sdk.d:
//            g, m

public final class p extends AsyncTask
{

    public p(Context context)
    {
        a_android_content_Context_fld = context;
        a_java_lang_Class_fld = null;
        d = 0;
        e = 0;
    }

    public p(Context context, Class class1, int i, int j)
    {
        a_android_content_Context_fld = context;
        a_java_lang_Class_fld = class1;
        d = i;
        e = j;
    }

    private transient Void a()
    {
        Object obj = b.a(a_android_content_Context_fld);
        c.info("AdManager\u66F4\u65B0...");
        ((b) (obj)).u();
        try
        {
            ((b) (obj)).a_com_xxx_sdk_c_f_fld.s();
        }
        catch(Exception exception)
        {
            c.a((new StringBuilder("\u66F4\u65B0[")).append(((b) (obj)).a_com_xxx_sdk_c_f_fld.getClass().getSimpleName()).append("]\u4E2D\u5F02\u5E38").toString(), exception);
        }
        obj = ((b) (obj)).a_java_util_Collection_fld.iterator();
        do
        {
            if(!((Iterator) (obj)).hasNext())
                break;
            d d1 = (d)((Iterator) (obj)).next();
            if(d1 instanceof a)
                try
                {
                    ((a)d1).s();
                }
                catch(Exception exception1)
                {
                    c.a((new StringBuilder("\u66F4\u65B0[")).append(d1.getClass().getSimpleName()).append("]\u4E2D\u5F02\u5E38").toString(), exception1);
                }
        } while(true);
        return null;
    }

    private void a(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            void1 = b.a(a_android_content_Context_fld).a();
        }
        // Misplaced declaration of an exception variable
        catch(Void void1)
        {
            c.error((new StringBuilder("update message error:")).append(void1).toString());
            void1.printStackTrace();
            return;
        }
        if(void1 == null) goto _L2; else goto _L1
_L1:
        if(((com.xxx.sdk.p) (void1)).a_com_xxx_sdk_u_fld == null) goto _L2; else goto _L3
_L3:
        if(((com.xxx.sdk.p) (void1)).a_com_xxx_sdk_t_fld == null)
            return;
        if(com.xxx.sdk.d.g.a() != null) goto _L5; else goto _L4
_L4:
        com.xxx.sdk.api.d.c(a_android_content_Context_fld, a_java_lang_Class_fld, d, e);
_L10:
        if(com.xxx.sdk.d.m.a() != null) goto _L7; else goto _L6
_L6:
        com.xxx.sdk.api.d.l(a_android_content_Context_fld);
_L8:
        com.xxx.e.f.r(a_android_content_Context_fld);
        return;
_L5:
        g.h(((com.xxx.sdk.p) (void1)).a_com_xxx_sdk_t_fld.D);
        continue; /* Loop/switch isn't completed */
_L7:
        m.h(((com.xxx.sdk.p) (void1)).a_com_xxx_sdk_t_fld.D);
          goto _L8
_L2:
        return;
        if(true) goto _L10; else goto _L9
_L9:
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onCancelled()
    {
        super.onCancelled();
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        try
        {
            obj = b.a(a_android_content_Context_fld).a();
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            c.error((new StringBuilder("update message error:")).append(obj).toString());
            ((Exception) (obj)).printStackTrace();
            return;
        }
        if(obj == null) goto _L2; else goto _L1
_L1:
        if(((com.xxx.sdk.p) (obj)).a_com_xxx_sdk_u_fld == null) goto _L2; else goto _L3
_L3:
        if(((com.xxx.sdk.p) (obj)).a_com_xxx_sdk_t_fld == null)
            return;
        if(com.xxx.sdk.d.g.a() != null) goto _L5; else goto _L4
_L4:
        com.xxx.sdk.api.d.c(a_android_content_Context_fld, a_java_lang_Class_fld, d, e);
_L10:
        if(com.xxx.sdk.d.m.a() != null) goto _L7; else goto _L6
_L6:
        com.xxx.sdk.api.d.l(a_android_content_Context_fld);
_L8:
        com.xxx.e.f.r(a_android_content_Context_fld);
        return;
_L5:
        g.h(((com.xxx.sdk.p) (obj)).a_com_xxx_sdk_t_fld.D);
        continue; /* Loop/switch isn't completed */
_L7:
        m.h(((com.xxx.sdk.p) (obj)).a_com_xxx_sdk_t_fld.D);
          goto _L8
_L2:
        return;
        if(true) goto _L10; else goto _L9
_L9:
    }

    private Context a_android_content_Context_fld;
    private Class a_java_lang_Class_fld;
    private int d;
    private int e;
}
