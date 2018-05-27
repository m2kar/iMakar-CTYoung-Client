// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e;

import java.util.Map;

public final class e
{

    public e()
    {
    }

    private e(Class class1)
    {
        f_java_util_Map_fld = (Map)newInstance(class1);
    }

    public static e a(Class class1)
    {
        return new e(class1);
    }

    private e a(Map map)
    {
        f_java_util_Map_fld.putAll(map);
        return this;
    }

    private Map d()
    {
        return f_java_util_Map_fld;
    }

    private static Object newInstance(Class class1)
    {
        try
        {
            class1 = ((Class) (class1.newInstance()));
        }
        // Misplaced declaration of an exception variable
        catch(Class class1)
        {
            throw new RuntimeException(class1);
        }
        return class1;
    }

    public final e a(Object obj, Object obj1)
    {
        f_java_util_Map_fld.put(obj, obj1);
        return this;
    }

    private static short a = 0;
    private static short b = 15;
    private static int be = 0xffffff;
    private static short c = 0;
    private static short d = 1;
    private static short e = 2;
    private static short f_short_static_fld = 3;
    private static short g = 4;
    private static short h = 5;
    private static short i = 0;
    private static short j = 1;
    private static short k = 4;
    private static short l = 3;
    private static short m = 0;
    private static short n = 1;
    private static short o = 2;
    private static short p = 3;
    private static short q = 8;
    public Map f_java_util_Map_fld;
}
