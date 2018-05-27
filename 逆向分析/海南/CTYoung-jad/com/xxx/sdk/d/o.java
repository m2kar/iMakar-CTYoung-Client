// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.xxx.sdk.a.g;
import com.xxx.sdk.b;
import com.xxx.sdk.c.f;
import com.xxx.sdk.d;
import com.xxx.sdk.e.c;
import com.xxx.sdk.e.e.a;
import com.xxx.sdk.j;
import java.util.Collection;
import java.util.Iterator;

public final class o extends AsyncTask
{

    public o(Context context)
    {
        a_android_content_Context_fld = context;
        a_java_lang_Class_fld = null;
        d = 0;
        e = 0;
    }

    public o(Context context, byte byte0)
    {
        a_android_content_Context_fld = context;
        a_java_lang_Class_fld = null;
        d = 0;
        e = 0;
    }

    public o(Context context, Class class1, int i, int k)
    {
        a_android_content_Context_fld = context;
        a_java_lang_Class_fld = class1;
        d = i;
        e = k;
    }

    public o(Context context, Class class1, int i, int k, byte byte0)
    {
        a_android_content_Context_fld = context;
        a_java_lang_Class_fld = class1;
        d = i;
        e = k;
    }

    private transient Void a()
    {
        Object obj;
        obj = b.a(a_android_content_Context_fld);
        com.xxx.sdk.e.c.info("AdManager\u542F\u52A8...");
        ((b) (obj)).u();
        obj.a_com_xxx_sdk_e_e_f_fld = com.xxx.sdk.e.e.a.a(((b) (obj)).a_android_content_Context_fld);
_L9:
        int k;
        Object obj1;
        SharedPreferences sharedpreferences;
        obj1 = ((b) (obj)).a_android_content_Context_fld;
        sharedpreferences = ((Context) (obj1)).getSharedPreferences("setting", 0);
        k = sharedpreferences.getInt("version", 0);
        int i;
        boolean flag;
        Exception exception;
        Exception exception1;
        try
        {
            i = Integer.parseInt(j.a.N);
        }
        catch(Exception exception2)
        {
            i = 0;
        }
        if(i == k) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 16 16: default 96
    //                   16 261;
           goto _L3 _L4
_L3:
        sharedpreferences.edit().putInt("version", i).commit();
_L2:
        ((b) (obj)).a_com_xxx_sdk_c_f_fld.r();
_L12:
        obj = ((b) (obj)).a_java_util_Collection_fld.iterator();
_L8:
        if(!((Iterator) (obj)).hasNext()) goto _L6; else goto _L5
_L5:
        obj1 = (d)((Iterator) (obj)).next();
        flag = obj1 instanceof com.xxx.sdk.a;
        if(!flag) goto _L8; else goto _L7
_L7:
        ((com.xxx.sdk.a)obj1).r();
          goto _L8
        exception1;
        com.xxx.sdk.e.c.a((new StringBuilder("\u52A0\u8F7D[")).append(obj1.getClass().getSimpleName()).append("]\u4E2D\u5F02\u5E38").toString(), exception1);
          goto _L8
        obj;
        com.xxx.sdk.e.c.error((new StringBuilder(" doInBackground:")).append(obj).toString());
        ((Exception) (obj)).printStackTrace();
_L6:
        return null;
        obj1;
        com.xxx.sdk.e.c.a("\u672A\u77E5\u9519\u8BEF", ((Throwable) (obj1)));
          goto _L9
_L4:
        k = (new g(((Context) (obj1)))).i();
        if(k <= 0) goto _L3; else goto _L10
_L10:
        if(((b) (obj)).a_com_xxx_sdk_e_e_f_fld == null) goto _L3; else goto _L11
_L11:
        ((b) (obj)).a_com_xxx_sdk_e_e_f_fld.bW = k;
          goto _L3
        exception;
        com.xxx.sdk.e.c.a((new StringBuilder("\u52A0\u8F7D[")).append(((b) (obj)).a_com_xxx_sdk_c_f_fld.getClass().getSimpleName()).append("]\u4E2D\u5F02\u5E38").toString(), exception);
          goto _L12
    }

    private void a(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            if(a_android_content_Context_fld != null)
            {
                com.xxx.sdk.api.d.c(a_android_content_Context_fld, a_java_lang_Class_fld, d, e);
                com.xxx.sdk.api.d.k(a_android_content_Context_fld);
                com.xxx.sdk.api.d.l(a_android_content_Context_fld);
            }
            com.xxx.e.f.r(a_android_content_Context_fld);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(Void void1)
        {
            com.xxx.sdk.e.c.error((new StringBuilder("onPostExecute:")).append(void1).toString());
        }
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
            if(a_android_content_Context_fld != null)
            {
                com.xxx.sdk.api.d.c(a_android_content_Context_fld, a_java_lang_Class_fld, d, e);
                com.xxx.sdk.api.d.k(a_android_content_Context_fld);
                com.xxx.sdk.api.d.l(a_android_content_Context_fld);
            }
            com.xxx.e.f.r(a_android_content_Context_fld);
            return;
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            com.xxx.sdk.e.c.error((new StringBuilder("onPostExecute:")).append(obj).toString());
        }
    }

    private Context a_android_content_Context_fld;
    private Class a_java_lang_Class_fld;
    private Class c;
    private int d;
    private int e;
}
