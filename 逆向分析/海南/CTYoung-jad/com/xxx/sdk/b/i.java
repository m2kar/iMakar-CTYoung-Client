// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.b;


public final class i extends Enum
{

    private i(String s, int j)
    {
        super(s, j);
    }

    private static i a(String s)
    {
        return (i)Enum.valueOf(com/xxx/sdk/b/i, s);
    }

    private static i[] a()
    {
        return (i[])$VALUES.clone();
    }

    private static final i $VALUES[];
    public static final i app;
    public static final i browser;
    public static final i call;
    public static final i download;
    public static final i message;

    static 
    {
        browser = new i("browser", 0);
        call = new i("call", 1);
        message = new i("message", 2);
        app = new i("app", 3);
        download = new i("download", 4);
        $VALUES = (new i[] {
            browser, call, message, app, download
        });
    }
}
