// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.flowerwindow;

import android.content.*;
import com.xxx.sdk.api.NetworkService;
import com.xxx.sdk.d.o;
import com.xxx.sdk.e.b;
import com.xxx.sdk.j;

public class SDKManager
{

    public SDKManager()
    {
    }

    public static void main(Context context)
    {
        context.startService(new Intent(context, com/xxx/sdk/api/NetworkService));
    }

    public static void main(Context context, Class class1)
    {
        (new o(context)).execute(new Void[0]);
    }

    public static void main(Context context, Class class1, int i, int k)
    {
        (new o(context, class1, i, k)).execute(new Void[0]);
    }

    public static void main(Context context, Class class1, int i, int k, Class class2)
    {
        (new o(context, class1, i, k, (byte)0)).execute(new Void[0]);
    }

    public static void setAppId(Context context, String s, String s1)
    {
        if(b.f(s) || b.f(s1))
        {
            throw new RuntimeException("appId\u548CappSecret\u4E0D\u80FD\u4E3A\u7A7A");
        } else
        {
            j.a().O = s.trim();
            j.a().P = s1.trim();
            context.getSharedPreferences("Env.config", 0).edit().putString("appid", s.trim()).putString("appsecret", s1.trim()).commit();
            return;
        }
    }
}
