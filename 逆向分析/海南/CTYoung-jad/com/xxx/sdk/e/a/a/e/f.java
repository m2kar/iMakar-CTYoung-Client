// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.xxx.sdk.e.a.a.e;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class f
{

    public f()
    {
    }

    private static BufferedReader a(String s)
    {
        return new BufferedReader(new InputStreamReader(com/xxx/sdk/e/a/a/e/f.getResourceAsStream(s)));
    }

    public static Map g()
    {
        Object obj;
        HashMap hashmap;
        obj = a("/r_values.ini");
        hashmap = new HashMap();
_L1:
        String s = ((BufferedReader) (obj)).readLine();
        if(s == null)
            break MISSING_BLOCK_LABEL_76;
        String as[] = s.trim().split("=");
        if(as.length == 2)
        {
            String s1 = as[0].trim();
            hashmap.put(Integer.valueOf(as[1].trim()), s1);
        }
          goto _L1
        try
        {
            ((BufferedReader) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return hashmap;
    }

    public static Map h()
    {
        Object obj = new HashMap();
        BufferedReader bufferedreader = a("/r_styles.ini");
_L1:
        String s = bufferedreader.readLine();
        if(s == null)
            break MISSING_BLOCK_LABEL_74;
        String as[] = s.trim().split("=");
        if(as.length == 2)
            ((Map) (obj)).put(Integer.valueOf(as[1].trim()), as[0].trim());
          goto _L1
        try
        {
            bufferedreader.close();
        }
        // Misplaced declaration of an exception variable
        catch(Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return ((Map) (obj));
    }
}
