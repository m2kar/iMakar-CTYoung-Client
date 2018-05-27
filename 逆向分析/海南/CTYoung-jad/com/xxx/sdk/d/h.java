// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.content.Context;
import android.os.AsyncTask;
import com.xxx.c.a;
import com.xxx.e.g;
import com.xxx.sdk.b;
import com.xxx.sdk.e.c;
import com.xxx.sdk.f.f;

public final class h extends AsyncTask
{

    public h(a a1, Context context)
    {
        b_com_xxx_c_a_fld = null;
        b_com_xxx_sdk_f_f_fld = null;
        b_com_xxx_c_a_fld = a1;
        a = context;
    }

    private transient Void a()
    {
        b_com_xxx_sdk_f_f_fld = (f)com.xxx.sdk.b.a(a).a(com/xxx/sdk/f/f, g.b(a));
        return null;
    }

    private void a(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            b_com_xxx_c_a_fld.a(b_com_xxx_sdk_f_f_fld);
        }
        // Misplaced declaration of an exception variable
        catch(Void void1)
        {
            c.error(String.valueOf(void1));
        }
        b_com_xxx_sdk_f_f_fld = null;
        b_com_xxx_c_a_fld = null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        b_com_xxx_sdk_f_f_fld = (f)com.xxx.sdk.b.a(a).a(com/xxx/sdk/f/f, g.b(a));
        return null;
    }

    protected final void onCancelled()
    {
        super.onCancelled();
        b_com_xxx_c_a_fld = null;
    }

    protected final void onPostExecute(Object obj)
    {
        super.onPostExecute((Void)obj);
        try
        {
            b_com_xxx_c_a_fld.a(b_com_xxx_sdk_f_f_fld);
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            c.error(String.valueOf(obj));
        }
        b_com_xxx_sdk_f_f_fld = null;
        b_com_xxx_c_a_fld = null;
    }

    private Context a;
    private a b_com_xxx_c_a_fld;
    private f b_com_xxx_sdk_f_f_fld;
}
