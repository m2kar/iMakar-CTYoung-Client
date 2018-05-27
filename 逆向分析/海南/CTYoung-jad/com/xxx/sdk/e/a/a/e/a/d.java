// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e.a;


public final class d
{

    public d()
    {
    }

    public static String[][] a()
    {
        return (String[][])a.clone();
    }

    public static String[][] b()
    {
        return (String[][])b.clone();
    }

    private static final String a[][];
    private static final String b[][] = {
        {
            "'", "&apos;"
        }
    };

    static 
    {
        String as[] = {
            "&", "&amp;"
        };
        a = (new String[][] {
            new String[] {
                "\"", "&quot;"
            }, as, new String[] {
                "<", "&lt;"
            }, new String[] {
                ">", "&gt;"
            }
        });
    }
}
