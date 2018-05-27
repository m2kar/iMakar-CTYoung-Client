// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.b;


public final class a extends Enum
{

    private a(String s, int i)
    {
        super(s, i);
    }

    private static a a(String s)
    {
        return (a)Enum.valueOf(com/xxx/sdk/b/a, s);
    }

    private static a[] a()
    {
        return (a[])$VALUES.clone();
    }

    private static final a $VALUES[];
    public static final a BACK_KEY_DOWN;
    public static final a FAILED;
    public static final a FIRST_URL_LOADED;
    public static final a REQUEST_CLOSE;
    public static final a STAY;
    public static final a URL_CHANGED;

    static 
    {
        FIRST_URL_LOADED = new a("FIRST_URL_LOADED", 0);
        FAILED = new a("FAILED", 1);
        STAY = new a("STAY", 2);
        BACK_KEY_DOWN = new a("BACK_KEY_DOWN", 3);
        URL_CHANGED = new a("URL_CHANGED", 4);
        REQUEST_CLOSE = new a("REQUEST_CLOSE", 5);
        $VALUES = (new a[] {
            FIRST_URL_LOADED, FAILED, STAY, BACK_KEY_DOWN, URL_CHANGED, REQUEST_CLOSE
        });
    }
}
