// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.content.Context;
import android.os.AsyncTask;
import com.xxx.c.a;
import com.xxx.c.c;
import com.xxx.sdk.b;
import com.xxx.sdk.f.e;

public final class n extends AsyncTask
{

    public n(a a1, Context context)
    {
        b = null;
        a_com_xxx_sdk_f_e_fld = null;
        b = a1;
        a_android_content_Context_fld = context;
    }

    private transient Void a()
    {
        b b1 = com.xxx.sdk.b.a(a_android_content_Context_fld);
        java.util.Map map;
        if(b instanceof c)
            map = ((c)b).a;
        else
            map = null;
        a_com_xxx_sdk_f_e_fld = (e)b1.a(com/xxx/sdk/f/e, map);
        return null;
    }

    private void a(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            b.a(a_com_xxx_sdk_f_e_fld);
        }
        // Misplaced declaration of an exception variable
        catch(Void void1)
        {
            com.xxx.sdk.e.c.error(String.valueOf(void1));
        }
        a_com_xxx_sdk_f_e_fld = null;
        b = null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        b b1 = com.xxx.sdk.b.a(a_android_content_Context_fld);
        if(b instanceof c)
            aobj = ((c)b).a;
        else
            aobj = null;
        a_com_xxx_sdk_f_e_fld = (e)b1.a(com/xxx/sdk/f/e, ((java.util.Map) (aobj)));
        return null;
    }

    protected final void onCancelled()
    {
        super.onCancelled();
        b = null;
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        try
        {
            b.a(a_com_xxx_sdk_f_e_fld);
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            com.xxx.sdk.e.c.error(String.valueOf(obj));
        }
        a_com_xxx_sdk_f_e_fld = null;
        b = null;
    }

    private Context a_android_content_Context_fld;
    private e a_com_xxx_sdk_f_e_fld;
    private a b;
}
