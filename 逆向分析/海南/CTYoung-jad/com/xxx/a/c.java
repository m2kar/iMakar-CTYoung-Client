// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.a;


public final class c extends Enum
{

    private c(String s, int i)
    {
        super(s, i);
    }

    private static int[] a()
    {
        return (int[])$VALUES$66527b6c.clone();
    }

    private static final int $VALUES$66527b6c[];
    public static final int INTERNAL_ERROR$e930771;
    public static final int NETWORK_ERROR$e930771;
    public static final int NO_FILL$e930771;
    public static final int SUCCESS$e930771;

    static 
    {
        INTERNAL_ERROR$e930771 = 1;
        NETWORK_ERROR$e930771 = 2;
        NO_FILL$e930771 = 3;
        SUCCESS$e930771 = 4;
        $VALUES$66527b6c = (new int[] {
            INTERNAL_ERROR$e930771, NETWORK_ERROR$e930771, NO_FILL$e930771, SUCCESS$e930771
        });
    }
}
