// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.a;

import com.xxx.sdk.e.b;
import com.xxx.sdk.f.e;

public final class d
{

    public d()
    {
    }

    public d(e e1)
    {
        an = e1.packageName;
        ao = com.xxx.sdk.e.b.b(e1);
        am = "launcher";
    }

    public d(String s, String s1, String s2)
    {
        am = s;
        an = s1;
        ao = s2;
    }

    public final String toString()
    {
        return (new StringBuilder("SdkCaches [id=")).append(id).append(", module=").append(am).append(", cacheKey=").append(an).append(", cacheValue=").append(ao).append(", cacheRaw=").append(ap).append(", status=").append(status).append("]").toString();
    }

    private static String af = "sdk_caches";
    private static String ag = "id";
    private static String ah = "module";
    private static String ai = "cache_key";
    private static String aj = "cache_value";
    private static String ak = "cache_raw";
    private static String al = "status";
    public static final String b[] = {
        "id", "cache_key", "cache_value", "cache_raw", "status"
    };
    public String am;
    public String an;
    public String ao;
    public String ap;
    public int id;
    public int status;

}
